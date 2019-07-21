import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndCount {

    // filter - возвращает stream, в котором есть только элементы, соответствующие условию фильтра
    // count - возвращает количество элементов в стриме
    // collect - преобразует stream в коллекцию или другую структуру данных
    // mapToInt - преобразовать объект в числовой стрим (стрим, содержащий числа)
    // Метод max вернет максимальный элемент, в качестве условия использует компаратор
    // Метод min вернет минимальный элемент, в качестве условия использует компаратор
    public static void showFilterAndCount() {
        System.out.println("Filter and count start");

        // ************ Работа со строками
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        // Вернуть количество вхождений объекта
        long count = collection.stream()
                .filter("a1"::equals)
                .count();
        System.out.println("count = " + count); // напечатает count = 2

        // Выбрать все элементы по шаблону
        List<String> select = collection
                .stream()
                .filter(s -> s.contains("1"))
                .collect(Collectors.toList());
        System.out.println("select = " + select); // напечатает select = [a1, a1]

        // Зададим коллекцию людей
        Collection<People> peoples = Arrays.asList(
                new People("Вася", 16, Sex.MAN),
                new People("Петя", 23, Sex.MAN),
                new People("Елена", 42, Sex.WOMEN),
                new People("Иван Иванович", 69, Sex.MAN)
        );

        // Выбрать мужчин-военообязанных
        List<People> militaryService = peoples
                .stream()
                .filter(p -> p.getAge() >= 18 && p.getAge() < 27 && p.getSex() == Sex.MAN)
                .collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService); // напечатает militaryService = [{name='Петя', age=23, sex=MAN}]

        // Найти средний возраст среди мужчин
        double manAverageAge = peoples
                .stream()
                .filter(p -> p.getSex() == Sex.MAN)
                .mapToInt(People::getAge)
                .average()
                .getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge); // напечатает manAverageAge = 36.0

        // найти человека с максимальным возрастом
        People older = peoples
                .stream()
                .max(Comparator.comparing(People::getAge))
                .get();
        System.out.println("older " + older); // напечатает {name='Иван Иванович', age=69, sex=MAN}

        // найти человека с минимальным возрастом
        People younger = peoples
                .stream()
                .min((p1, p2) -> p1.getAge().compareTo(p2.getAge()))
                .get();
        System.out.println("younger " + younger); // напечатает {name='Вася', age=16, sex=MAN}

        // Найти кол-во потенциально работоспосбных людей в выборке (т.е. от 18 лет и учитывая что женщины выходят в 55 лет, а мужчина в 60)
        long peopleHowCanWork = peoples
                .stream()
                .filter(p -> p.getAge() >= 18)
                .filter(p -> (p.getSex() == Sex.WOMEN && p.getAge() < 55) || (p.getSex() == Sex.MAN && p.getAge() < 60))
                .count();
        System.out.println("peopleHowCanWork = " + peopleHowCanWork); // напечатает manAverageAge = 2

    }
}

