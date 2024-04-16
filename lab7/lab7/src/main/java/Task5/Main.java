package Task5;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cator numere vreti sa li se aplice operatii? ");
        int totalNumbers = scanner.nextInt();
        scanner.nextLine();
        List<Double> numbers = new ArrayList<>();
        System.out.println("Introduceti aceste " + totalNumbers + " numere:");
        for (int i = 0; i < totalNumbers; i++) {
            String input = scanner.nextLine();
            try {
                double number = Double.parseDouble(input);
                numbers.add(number);
            } catch (NumberFormatException e) {
                System.out.println("Input invalid: " + input + ". Ignorat.");
            }
        }
        List<Function<Double, Double>> operations = Arrays.asList(
                num -> num * 2,
                num -> num + 1,
                num -> 1 / num,
                num -> Math.pow(num, 2),
                Math::sin
        );
        Random random = new Random();
        Function<Double, Double> chosenOperation = operations.get(random.nextInt(operations.size()));
        System.out.println("In urma operatiilor am obtinut:");
        numbers.stream()
                .map(chosenOperation)
                .forEach(System.out::println);
    }
}
