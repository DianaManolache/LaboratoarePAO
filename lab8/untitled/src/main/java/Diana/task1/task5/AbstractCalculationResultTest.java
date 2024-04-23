package Diana.task1.task5;

import static org.junit.jupiter.api.Assertions.*;

import Diana.task1.CalculationRequest;
import Diana.task1.calculatorResult.AbstractCalculationResult;
import org.junit.jupiter.api.Test;

public class AbstractCalculationResultTest {

    @Test
    void testComputeResult_Positive() {
        CalculationRequest request = new CalculationRequest(2, 3, "+");
        AbstractCalculationResult result = new AbstractCalculationResult(request) {
            @Override
            public Object computeResult() {
                CalculationRequest request = getRequest();
                Integer leftOperand = (Integer) request.getLeftOperand();
                Integer rightOperand = (Integer) request.getRightOperand();
                return leftOperand + rightOperand;
            }
        };

        Object computedResult = result.computeResult();

        assertEquals(5, computedResult, "Computed result should be 5.");
    }

    @Test
    void testComputeResult_NullPointerException() {
        // Arrange
        CalculationRequest request = new CalculationRequest(2, null, "+");
        AbstractCalculationResult result = new AbstractCalculationResult(request) {
            @Override
            public Object computeResult() {
                CalculationRequest request = getRequest();
                Integer leftOperand = (Integer) request.getLeftOperand();
                Integer rightOperand = (Integer) request.getRightOperand();
                // Simulate NullPointerException by accessing rightOperand
                return leftOperand + rightOperand;
            }
        };

        assertThrows(NullPointerException.class, result::computeResult);
    }
}
