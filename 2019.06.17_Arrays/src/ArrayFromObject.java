import org.omg.CORBA.Object;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class ArrayFromObject implements Iterable {
    private Object[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    ArrayFromObject() {
        arr = new Object[DEFAULT_CAPACITY];
    }


    ArrayFromObject(int capacity) { arr = new Object[capacity]; }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int indexOf(Object number) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(Object number) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(number)) {
                return i;
            }
        }
        return -1;
    }


    public Object get(int index) {
        if (index < size) {
            return arr[index];
        }
        return null;
    }


    public Object set(int index, Object number) {
        Object oldValue = null;
        if (index < size) {
            oldValue = arr[index];
            arr[index] = number;
        }
        return oldValue;
    }


    public boolean add(Object number) {
        ensureCapacity();
        arr[size] = number;
        size++;
        return true;
    }


    public boolean addAtPosition(int index, Object number) {
        if (index >= size) {
            return false;
        }
        ensureCapacity();
        Object[] oldArr = copyArray(size);
        size++;
        arr[index] = number;
        for (int i = index + 1; i < size; i++) {
            arr[i] = oldArr[i - 1];
        }
        return true;
    }


    public Object remove(Object number) {
        int foundIndex = indexOf(number);
        if (foundIndex == -1) {
            return null;
        }
        Object[] oldArr = copyArray(size);
        Object oldValue = arr[foundIndex];
        size--;
        for (int i = foundIndex; i < size; i++) {
            arr[i] = oldArr[i + 1];
        }
        return oldValue;
    }


    private void ensureCapacity() {
        if (size == arr.length) {
            int newSize = arr.length * 2;
            arr = copyArray(newSize);
        }
    }


    private Object[] copyArray(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }


    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    //***********************************************

}
