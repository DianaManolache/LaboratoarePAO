package lab4.smartercalculator.calculatorResult;

import lab4.smartercalculator.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}
