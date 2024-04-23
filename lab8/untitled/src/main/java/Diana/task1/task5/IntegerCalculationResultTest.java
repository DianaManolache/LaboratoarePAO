package Diana.task1.task5;
import static org.junit.jupiter.api.Assertions.*;

import Diana.task1.CalculationRequest;
import Diana.task1.calculatorResult.IntegerCalculationResult;
import org.junit.jupiter.api.Test;
public class IntegerCalculationResultTest {

    @Test
    void testComputeResult_MultiplicationOperation_Positive() {
        CalculationRequest request = new CalculationRequest(5, 3, "*");
        IntegerCalculationResult result = new IntegerCalculationResult(request);

        Object computedResult = result.computeResult();

        assertEquals(15, (Integer) computedResult, "Computed result should be 15.");
    }

    @Test
    void testComputeResult_DivisionByZero_Negative() {
        CalculationRequest request = new CalculationRequest(10, 0, "/");
        IntegerCalculationResult result = new IntegerCalculationResult(request);
        assertThrows(ArithmeticException.class, result::computeResult);
    }
}
