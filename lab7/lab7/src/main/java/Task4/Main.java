package Task4;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int N = 144;

        IntStream.rangeClosed(0, N)
                .filter(num -> num % 2 == 0)
                .mapToObj(num -> new Object() {
                    int number = num;
                    int square = num * num;

                    @Override
                    public String toString() {
                        return "{" + number + ", " + square + "}";
                    }
                })
                .forEach(System.out::println);
    }
}