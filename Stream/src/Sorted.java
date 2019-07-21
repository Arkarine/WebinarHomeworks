import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Sorted {
    public static void showSorted() {
        System.out.println("Test sorted start");

        // ************ Работа со строками
        Collection<String> collection = Arrays.asList("a1", "a4", "a3", "a2", "a1", "a4");

        // отсортировать значения по алфавиту
        List<String> sorted = collection
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("sorted = " + sorted); // напечатает sorted = [a1, a1, a2, a3, a4, a4]

        // отсортировать значения по алфавиту и убрать дубликаты
        List<String> sortedDistinct = collection
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct); // напечатает sortedDistinct = [a1, a2, a3, a4]

        // отсортировать значения по алфавиту в обратном порядке
        List<String> sortedReverse = collection
                .stream()
                .sorted((o1, o2) -> -o1.compareTo(o2))
                .collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse); // напечатает sortedReverse = [a4, a4, a3, a2, a1, a1]

        // ************ Работа с объектами
        // Зададим коллекцию людей
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        // Отсортировать по имени в обратном алфавитном порядке
        Collection<People> byName = peoples
                .stream()
                .sorted((o1,o2) -> -o1.getName()
                .compareTo(o2.getName()))
                .collect(Collectors.toList());
        System.out.println("byName = " + byName); // byName = [{name='Петя', age=23, sex=MAN}, {name='Иван Иванович', age=69, sex=MAN}, {name='Елена', age=42, sex=WOMEN}, {name='Вася', age=16, sex=MAN}]

        // Отсортировать сначала по полу, а потом по возрасту
        Collection<People> bySexAndAge = peoples
                .stream()
                .sorted((o1, o2) -> o1.getSex() != o2.getSex() ?
                        o1.getSex().compareTo(o2.getSex()) : o1.getAge().compareTo(o2.getAge()))
                .collect(Collectors.toList());
        System.out.println("bySexAndAge = " + bySexAndAge); // bySexAndAge = [{name='Вася', age=16, sex=MAN}, {name='Петя', age=23, sex=MAN}, {name='Иван Иванович', age=69, sex=MAN}, {name='Елена', age=42, sex=WOMEN}]
    }

}
