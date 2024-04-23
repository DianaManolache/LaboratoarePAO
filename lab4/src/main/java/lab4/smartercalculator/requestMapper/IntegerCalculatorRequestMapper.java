package lab4.smartercalculator.requestMapper;

import lab4.smartercalculator.CalculationRequest;

import java.util.Optional;

public class IntegerCalculatorRequestMapper extends NumberCalculatorRequestMapper {
    @Override
    protected Optional<CalculationRequest> mapNumbers(String leftOperandString, String operatorString, String rightOperandString) {
        try {
            Integer leftOperand = Integer.parseInt(leftOperandString);
            Integer rightOperand = Integer.parseInt(rightOperandString);

            return Optional.of(new CalculationRequest(leftOperand, rightOperand, operatorString));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
