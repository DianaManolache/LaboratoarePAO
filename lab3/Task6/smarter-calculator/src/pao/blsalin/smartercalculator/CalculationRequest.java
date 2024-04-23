package pao.blsalin.smartercalculator;

public record CalculationRequest(Object leftOperand, Object rightOperand, String operation) {
    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }

}
