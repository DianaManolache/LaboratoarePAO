package Diana.task1;

import Diana.task1.calculatorResult.PrintingCalculationResult;

public class Main {
    public static void main(String[] args) {
        args = new String[]{
                "1", "+", "2",
                "2", "*", "5",
                "1", "+", "5.0",
                "1.0", "-", "2",
                "10.0", "/", "1",
        };

        runSmarterCalculator(args);
    }

    private static void runSmarterCalculator(String[] args) {
        DBConnection databaseManager = new DBConnection();
        SmarterCalculator
                .calculate(args)
                .stream()
                .map(PrintingCalculationResult::new)
                .peek(result -> databaseManager.saveCalculationResult(
                        result.getRequest().getRequestType().name(),
                        result.getRequest().getLeftOperand(),
                        result.getRequest().getRightOperand(),
                        result.getRequest().getOperation(),
                        result.computeResult()))
                .forEach(PrintingCalculationResult::computeResult);
    }
}
