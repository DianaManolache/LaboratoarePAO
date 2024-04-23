package Diana.task1.calculatorResult;

import Diana.task1.CalculationRequest;

public interface CalculationResult {
    Object computeResult();
    CalculationRequest getRequest();
}
