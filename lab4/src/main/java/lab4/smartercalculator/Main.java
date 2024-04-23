package lab4.smartercalculator;

import lab4.smartercalculator.calculatorResult.AbstractCalculationResult;
import lab4.smartercalculator.calculatorResult.CalculationResult;
import lab4.smartercalculator.calculatorResult.PrintingCalculationResult;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "0",
        };

        try {
            if (args.length < 3 || args.length % 3 != 0) {
                throw new InvalidArgumentsLengthException("Invalid number of arguments");
            }
            runSmarterCalculator(args);
        } catch (InvalidArgumentsLengthException e) {
            System.err.println("Invalid number of arguments: " + e.getMessage());
        }
    }

    private static void runSmarterCalculator(String[] args) {
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .forEach(PrintingCalculationResult::computeResult);
    }
}
