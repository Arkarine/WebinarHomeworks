import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Array array = new Array();
        array.isEmpty();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);
        array.add(8);
        array.add(9);
        array.add(10);

        int[] array1 = {11, 12, 13, 14, 15};
        int[] array2 = {16, 17, 18, 19, 20};
        array.addAll(array1);

        array.print();
        array.removeRange(4, 14);
        System.out.println("*************");
        array.print();
        System.out.println("----------------------------------------");

        Array arr1 = new Array();
        Array arr2 = new Array();
        System.out.println(arr1);
        System.out.println(arr2);
        Map<Array, String> map = new HashMap<>();
        map.put(arr1, "Array 1");
        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());
        System.out.println(map.get(arr1));
        System.out.println(map.get(arr2));
        arr1.add(1);
        System.out.println("*******************");

        System.out.println(arr1);
        System.out.println(arr2);

        System.out.println(arr1.hashCode());
        System.out.println(arr2.hashCode());
        System.out.println(map.get(arr1));
        System.out.println(map.get(arr2));

    }
}
