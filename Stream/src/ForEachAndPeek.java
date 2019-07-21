import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ForEachAndPeek {
    // Метод ForEach применяет указанный метод к каждому элементу стрима и заканчивает работу со стримом
    public static void showForEach() {
        System.out.println("ForEach start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        // Напечатать отладочную информацию по каждому элементу стрима
        System.out.print("forEach = ");
        collection
                .stream()
                .map(String::toUpperCase)
                .forEach((e) -> System.out.print(e + ",")); // напечатает forEach = A1,A2,A3,A1,

        System.out.println(collection); // напечатает "a1", "a2", "a3", "a1"

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        list.stream().forEachOrdered((p) -> p.append("_new"));
        System.out.println("forEachOrdered = " + list); // напечатает forEachOrdered = [a1_new, a2_new, a3_new]
    }

    // Метод Peek возвращает тот же стрим, но при этом применяет указанный метод к каждому элементу стрима
    public static void showPeek() {
        System.out.println("Peek start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Напечатать отладочную информацию по каждому элементу стрима
        System.out.print("peak1 = ");
        List<String> peek = collection
                .stream()
                .map(String::toUpperCase)
                .peek((e) -> System.out.print(e + ","))
                .collect(Collectors.toList());
        System.out.println(); // напечатает peak1 = A1,A2,A3,A1,
        System.out.println("peek2 = " + peek); // напечатает peek2 = [A1, A2, A3, A1]

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        List<StringBuilder> newList = list
                .stream()
                .peek((p) -> p.append("_new"))
                .collect(Collectors.toList());
        System.out.println("newList = " + newList); // напечатает newList = [a1_new, a2_new, a3_new]
    }
}
