package Diana.task1.task5;
import static org.junit.jupiter.api.Assertions.*;

import Diana.task1.CalculationRequest;
import Diana.task1.calculatorResult.DoubleCalculationResult;
import org.junit.jupiter.api.Test;
public class DoubleCalculationResultTest {

    @Test
    void testComputeResult_AdditionOperation_Positive() {
        CalculationRequest request = new CalculationRequest(2.5, 3.5, "+");
        DoubleCalculationResult result = new DoubleCalculationResult(request);

        Object computedResult = result.computeResult();

        assertEquals(6.0, (Double) computedResult, "Computed result should be 6.0.");
    }

    @Test
    void testComputeResult_InvalidOperation_Negative() {
        CalculationRequest request = new CalculationRequest(2.5, 3.5, "%");
        DoubleCalculationResult result = new DoubleCalculationResult(request);

        assertThrows(IllegalArgumentException.class, result::computeResult);
    }
}
