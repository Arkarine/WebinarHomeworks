import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Distinct {
    public static void showDistinct() {
        System.out.println();
        System.out.println("Distinct start");
        Collection<String> ordered = Arrays.asList("a1", "b2", "a2", "c3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        // Получение коллекции без дубликатов
        List<String> distinct = nonOrdered
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinct = " + distinct); // напечатает distinct = [a1, a2, a3] - порядок не гарантируется

        List<String> distinctOrdered = ordered
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("distinctOrdered = " + distinctOrdered); // напечатает distinct = [a1, a2, a3] - порядок гарантируется
    }

}
