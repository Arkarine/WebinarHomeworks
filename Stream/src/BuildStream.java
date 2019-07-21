import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildStream {

    public static void createStream(){
        System.out.println("BuildStream start");
        // Создание стрима из значений
        Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
        System.out.println("streamFromValues = " + streamFromValues.collect(Collectors.toList())); // напечатает streamFromValues = [a1, a2, a3]

        // Создание стрима из массива
        String[] array = {"a1","a2","a3"};
        Stream<String> streamFromArrays = Arrays.stream(array);
        // Stream<String> streamFromArrays = Stream.of(array);
        System.out.println("streamFromArrays = " + streamFromArrays.collect(Collectors.toList())); // напечатает streamFromArrays = [a1, a2, a3]

        // Создание стрима из коллекции
        Collection<String> collection = Arrays.asList("a1", "a2", "a3");
        Stream<String> streamFromCollection = collection.stream();
        System.out.println("streamFromCollection = " + streamFromCollection.collect(Collectors.toList())); // напечатает streamFromCollection = [a1, a2, a3]


    }

}
