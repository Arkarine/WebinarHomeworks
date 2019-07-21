import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndSkip {
    public static void showLimitAndSkip(){
        // Метод Limit позволяет ограничить выборку определенным количеством первых элементов
            System.out.println("Limit and skip start");
            Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

            // Вернуть первые два элемента
            List<String> limit = collection
                    .stream()
                    .limit(2)
                    .collect(Collectors.toList());
            System.out.println("limit = " + limit); // напечатает limit = [a1, a2]

            // Вернуть два элемента начиная со второго
            List<String> fromTo = collection
                    .stream()
                    .skip(1)
                    .limit(2)
                    .collect(Collectors.toList());
            System.out.println("fromTo = " + fromTo); // напечатает fromTo = [a2, a3]

            // вернуть последний элемент коллекции
            String last = collection
                    .stream()
                    .skip(collection.size() - 1)
                    .findAny()
                    .orElse("1");
            System.out.println("last = " + last ); // напечатает last = a1
    }
}
