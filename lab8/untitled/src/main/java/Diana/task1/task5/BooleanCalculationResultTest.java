package Diana.task1.task5;

import static org.junit.jupiter.api.Assertions.*;

import Diana.task1.CalculationRequest;
import Diana.task1.calculatorResult.BooleanCalculationResult;
import org.junit.jupiter.api.Test;

public class BooleanCalculationResultTest {

    @Test
    void testComputeResult_AndOperation_Positive() {
        CalculationRequest request = new CalculationRequest(true, false, "&&");
        BooleanCalculationResult result = new BooleanCalculationResult(request);

        Object computedResult = result.computeResult();

        assertFalse((Boolean) computedResult, "Computed result should be false.");
    }

    @Test
    void testComputeResult_InvalidOperation_Negative() {
        CalculationRequest request = new CalculationRequest(true, false, "&");
        BooleanCalculationResult result = new BooleanCalculationResult(request);

        assertThrows(IllegalArgumentException.class, result::computeResult);
    }
}
