package task1.parallelStream;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int numCount = 10000;

        List<Integer> numbers = new Random().ints(numCount, 0, 100).boxed().collect(Collectors.toList());

        numbers.parallelStream().forEach(num -> System.out.println(num + "^2=" + (num * num)));
    }
}
