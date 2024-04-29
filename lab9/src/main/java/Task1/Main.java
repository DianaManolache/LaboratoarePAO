package Task1;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<String> stringComparator = Comparator.comparing(String::length).thenComparing(String::compareTo);
        SortedListSet<String> stringSet = new SortedListSet<>(stringComparator);

        stringSet.add("banana");
        stringSet.add("apple");
        stringSet.add("orange");
        stringSet.add("grape");

        System.out.println("String set: " + stringSet);
        System.out.println("First string: " + stringSet.first());
        System.out.println("Last string: " + stringSet.last());
        System.out.println("Subset from 'apple' to 'orange': " + stringSet.subSet("apple", "orange"));
        System.out.println("Head set until 'orange': " + stringSet.headSet("orange"));
        System.out.println("Tail set from 'orange': " + stringSet.tailSet("orange"));

        SortedListSet<Integer> integerSet = new SortedListSet<>();

        integerSet.add(5);
        integerSet.add(2);
        integerSet.add(8);
        integerSet.add(3);

        System.out.println("\nInteger set: " + integerSet);
        System.out.println("First integer: " + integerSet.first());
        System.out.println("Last integer: " + integerSet.last());
        System.out.println("Subset from 2 to 8: " + integerSet.subSet(2, 8));
        System.out.println("Head set until 3: " + integerSet.headSet(3));
        System.out.println("Tail set from 3: " + integerSet.tailSet(3));
    }
}
