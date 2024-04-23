package lab2.Problema2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        foo(args);
    }

    public static void foo(String[] args) {
        List<CalculatorResult> calculationResults = SmarterCalculator.calculate(args);

        for (CalculatorResult result : calculationResults) {
            CalculatorRequest request = result.getRequest();
            System.out.println("Operation " + request + " has result " + result.computeResult());
        }
    }
}