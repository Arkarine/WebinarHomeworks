package homework;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamHW {

    public static List<Integer> returnSquareRoot(List<Integer> numbers) {
        List<Integer> collect = numbers.stream()
                .map(i -> (int)Math.sqrt(i))
                .collect(Collectors.toList());
        return collect;
    }

    public static List<Integer> getAgeFromUsers(List<User> user) {
        List<Integer> collect = user.stream()
                .map(User::getAge)
                .collect(Collectors.toList());
        return collect;
    }

    public static List<Integer> getDistinctAges(List<User> users) {
        List<Integer> collect = users.stream()
                .map(User::getAge)
                .distinct()
                .collect(Collectors.toList());
        return collect;
    }

    public static List<User> getLimitedUserList(List<User> users, int limit) {
        List<User> collect = users.stream()
                .limit(limit)
                .collect(Collectors.toList());
        return collect;
    }

    public static Integer countUsersOlderThen25(List<User> users) {
        long count = users.stream()
                .filter(user -> user.getAge() > 25)
                .count();
        return (int)count;

    }

    public static List<String> mapToUpperCase(List<String> strings) {
        List<String> collect = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        return collect;
    }

    public static Integer sum(List<Integer> integers) {
        Integer sum = integers.stream()
                .reduce(Integer::sum)
                .orElse(0);
        return sum;
    }

    public static List<Integer> skip(List<Integer> integers, Integer toSkip) {
        List<Integer> collect = integers.stream()
                .skip(toSkip)
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> getFirstNames(List<String> names) {
        List<String> collect = names.stream()
                .map(name -> Arrays.asList(name.split(" ")))
                .map(l -> l.get(0))
                .collect(Collectors.toList());
        return collect;
    }

    public static List<String> getDistinctLetters(List<String> names) {
        List<String> collect = names.stream()
                .flatMap(name -> Arrays.asList(name.split("")).stream())
                .distinct()
                .collect(Collectors.toList());
        return collect;
    }


    public static String separateNamesByComma(List<User> users) {
        String result = users.stream()
                .map(User::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
        return result;
    }

    public static double getAverageAge(List<User> users) {
        double average = users.stream()
                .mapToInt(user -> (int) user.getAge())
                .average()
                .orElse(0);
        return average;
    }

    public static Integer getMaxAge(List<User> users) {
        Integer max = users.stream()
                .map(User::getAge)
                .reduce((s1, s2) -> s1 < s2 ? s2 : s1)
                .orElse(0);
        return max;
    }

    public static Integer getMinAge(List<User> users) {
        Integer min = users.stream()
                .map(User::getAge)
                .reduce((s1, s2) -> s1 < s2 ? s1 : s2)
                .orElse(0);
        return min;
    }

    public static Map<Boolean, List<User>> partionUsersByGender(List<User> users) {
        Map<Boolean, List<User>> collect = users.stream()
                .collect(Collectors.groupingBy(User::isMale));
        return collect;
    }

    public static Map<Integer, List<User>> groupByAge(List<User> users) {
        Map<Integer, List<User>> collect = users.stream()
                .collect(Collectors.groupingBy(User::getAge));
        return collect;
    }

    public static Map<Boolean, Map<Integer, List<User>>> groupByGenderAndAge(List<User> users) {
        Map<Boolean, Map<Integer, List<User>>> collect = users.stream()
                .collect(Collectors.groupingBy(User::isMale, Collectors.groupingBy(User::getAge)));
        return collect;
    }


    public static Map<Boolean, Long> countGender(List<User> users) {
        Map<Boolean, Long> result = users.stream()
                .collect(Collectors.groupingBy(user -> user.isMale(), Collectors.counting()));
        return result;

    }


    public static boolean anyMatch(List<User> users, int age) {
        boolean anyMatch = users.stream()
                .anyMatch(user -> user.getAge().equals(age));
        return anyMatch;
    }

    public static boolean noneMatch(List<User> users, int age) {
        boolean noneMatch = users.stream()
                .noneMatch(user -> user.getAge().equals(age));
        return noneMatch;
    }

    public static Optional<User> findAny(List<User> users, String name) {

        Optional<User> any = users.stream()
                .filter(user -> user.getName().equals(name))
                .findAny();
        return any;
    }

    public static List<User> sortByAge(List<User> users) {
        List<User> sorted = users.stream()
                .sorted((user1, user2) -> Integer.compare(user1.getAge(), user2.getAge()))
                .collect(Collectors.toList());
        return sorted;
    }

    public static Stream<Integer> getBoxedStream(IntStream stream) {
        Stream<Integer> boxed = stream.boxed();
        return boxed;
    }


    public static List<Integer> generateFirst10PrimeNumbers() {
        List<Integer> list = new ArrayList<>(10);
        int count = 10;
        int number = 2;
        while(count != 0){
            if(isPrime(number)){
                list.add(number);
                count --;
            }
            number ++;
        }
        return list;
    }


    public static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }


    public static List<Integer> generate10RandomNumbers() {
        Random random = new Random();
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt());
        }
        return list;
    }

    public static User findOldest(List<User> users) {
        List<User> sorted = users.stream()
                .sorted((a, b) -> a.getAge().compareTo(b.getAge()))
                .collect(Collectors.toList());
        return sorted.get(sorted.size()-1);
    }

    public static int sumAge(List<User> users) {
        Integer sum = users.stream()
                .map(User::getAge)
                .reduce(Integer::sum)
                .orElse(0);
        return sum;
    }

    public static IntSummaryStatistics ageSummaryStatistics(List<User> users) {
        IntSummaryStatistics result = users.stream()
                .collect(Collectors.summarizingInt(User::getAge));
        return result;
    }

}
