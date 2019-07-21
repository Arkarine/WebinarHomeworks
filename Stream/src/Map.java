import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    // Метод Map изменяет выборку по определенному правилу, возвращает stream с новой выборкой
    public static void showMap() {
        System.out.println("Map start");

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        // Изменение всех элементов коллекции
        List<String> transform = collection
                .stream()
                .map((s) -> s + "_1")
                .collect(Collectors.toList());
        System.out.println("transform = " + transform); // напечатает transform = [a1_1, a2_1, a3_1, a1_1]

        // убрать первый символ и вернуть числа
        List<Integer> number = collection
                .stream()
                .map((s) -> Integer.parseInt(s.substring(1)))
                .collect(Collectors.toList());
        System.out.println("number = " + number); // напечатает transform = [1, 2, 3, 1]

    }

    // Метод MapToInt - изменяет выборку по определенному правилу, возвращает stream с новой числовой выборкой
    public static void showMapToInt() {
        System.out.println("MapToInt start");

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        // убрать первый символ и вернуть числа
        int[] number = collection
                .stream()
                .mapToInt((s) -> Integer.parseInt(s.substring(1)))
                .toArray();
        System.out.println("number = " + Arrays.toString(number)); // напечатает number = [1, 2, 3, 1]

    }

    // Метод FlatMap - похоже на Map - только вместо одного значения, он возвращает целый stream значений
    public static void showFlatMap() {
        System.out.println("Flat map start");

        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        // получить все числовые значения, которые хранятся через запятую в collection
        String[] number = collection
                .stream()
                .flatMap((p) -> Arrays.asList(p.split(",")).stream())
                .toArray(String[]::new);
        System.out.println("number = " + Arrays.toString(number)); // напечатает number = [1, 2, 0, 4, 5]
    }

    // Метод FlatMapToInt - похоже на MapToInt - только вместо одного значения, он возвращает целый stream значений
    public static void showFlatMapToInt() {
        System.out.println("Test flat map start");

        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        // получить сумму всех числовые значения, которые хранятся через запятую в collection
        int sum = collection
                .stream()
                .flatMapToInt((p) -> Arrays.asList(p.split(","))
                        .stream()
                        .mapToInt(Integer::parseInt))
                .sum();
        System.out.println("sum = " + sum); // напечатает sum = 12
    }
}
