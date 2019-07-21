
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Objects;


public class Array implements Iterable {


    private int[] arr;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;


    Array() {
        arr = new int[DEFAULT_CAPACITY];
    }


    Array(int capacity) {
        arr = new int[capacity];
    }


    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    public int indexOf(int number) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }


    public int lastIndexOf(int number) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i] == number) {
                return i;
            }
        }
        return -1;
    }


    public int get(int index) {
        if (index < size) {
            return arr[index];
        }
        return -1;
    }


    public int set(int index, int number) {
        int oldValue = -1;
        if (index < size) {
            oldValue = arr[index];
            arr[index] = number;
        }
        return oldValue;
    }


    public boolean add(int number) {
        ensureCapacity();
        arr[size] = number;
        size++;
        return true;
    }


    public boolean addAtPosition(int index, int number) {
        if (index >= size) {
            return false;
        }
        ensureCapacity();
        int[] oldArr = copyArray(size);
        size++;
        arr[index] = number;
        for (int i = index + 1; i < size; i++) {
            arr[i] = oldArr[i - 1];
        }
        return true;
    }


    public int remove(int number) {
        int foundIndex = indexOf(number);
        if (foundIndex == -1) {
            return -1;
        }
        int[] oldArr = copyArray(size);
        int oldValue = arr[foundIndex];
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


    private int[] copyArray(int newSize) {
        int[] newArr = new int[newSize];
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array array = (Array) o;
        return size == array.size &&
                Arrays.equals(arr, array.arr);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arr);
        return result;
    }



    //***********************************************


    public boolean addAll(int [] arrToAdd) {
        for (int i = 0; i < arrToAdd.length; i++) {
            ensureCapacity();
            arr[size] = arrToAdd[i];
            size++;
        }
        return true;
    }



    public boolean addAll(int index, int [] arrToAdd){
        if(index == size - 1){
            addAll(arrToAdd);
            return  true;
        }
        if(index >= size || index < 0){
            System.out.println("Index out of range.");
            return false;
        }

        int[] oldArr = copyArray(size);


        for (int i = 0; i < arrToAdd.length; i++) {
            ensureCapacity();
            arr[i + index] = arrToAdd[i];
            size ++;
        }

        for (int i =  0; i < oldArr.length - index; i++) {
            arr[index + arrToAdd.length + i ] = oldArr[index + i];
        }
        return true;
    }


    public boolean removeRange(int fromIndex, int toIndex){
        if(!(toIndex > fromIndex || fromIndex >= 0 || fromIndex < size || toIndex < size)){
            System.out.println("Index out of range.");
            return false;
        }
        int[] oldArr = copyArray(size);
        for (int i = 0, j=0; i < size; i++) {
            if (i< fromIndex || i >= toIndex){
                arr[j] = oldArr[i];
                j++;
            }
        }
        size = size - (toIndex - fromIndex);

        return  true;
    }

    public int removeByIndex(int index){
        if(index >= size || index < 0){
            System.out.println("Index out of range.");
            return -1;
        }
        int oldValue = arr[index];
        int[] oldArr = copyArray(size);

        for (int i = index; i < size -1; i++) {
            arr[i] = oldArr[i + 1];
        }
        size --;
        return oldValue;
    }

}
