package Task1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;

public class UtilityClass {
    public static <T> void printCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        System.out.println(collection);
    }

    public static <T, R> R aggregate(Collection<T> collection, R initialValue, BiFunction<R, T, R> accumulator) {
        if (collection == null || accumulator == null) {
            throw new IllegalArgumentException("Collection and accumulator cannot be null");
        }
        R result = initialValue;
        for (T element : collection) {
            result = accumulator.apply(result, element);
        }
        return result;
    }

    public static <T> Collection<T> duplicateCollection(Collection<T> collection) {
        if (collection == null) {
            throw new IllegalArgumentException("Collection cannot be null");
        }
        List<T> duplicatedList = new ArrayList<>();
        for (T element : collection) {
            duplicatedList.add(element);
            duplicatedList.add(element);
        }
        return duplicatedList;
    }

    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        UtilityClass.printCollection(integers);

        Collection<String> strings = List.of("ana", "are", "mere");
        UtilityClass.printCollection(strings);

        List<Boolean> booleans = List.of(true, false, true, false, true);
        {
            boolean result = UtilityClass.aggregate(booleans, true, (acc, v) -> acc && v);
            System.out.println(result);
        }
        {
            int result = UtilityClass.aggregate(booleans, 0, (acc, v) -> v ? acc + 1 : acc);
            System.out.println(result);
        }

        record Person(String name) {}

        List<Person> persons = List.of(
                new Person("Aurel"),
                new Person("Vali")
        );

        Collection<Person> duplicatedPersons = UtilityClass.duplicateCollection(persons);
        UtilityClass.printCollection(duplicatedPersons);
    }
}
