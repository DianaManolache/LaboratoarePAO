package lab2.Problema2;

public class CalculatorRequest {
    private Object leftOperand;
    private Object rightOperand;
    private String operation;
    public CalculatorRequest(Object leftOperand, Object rightOperand, String operation) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operation = operation;
    }
    public String getRequestType() {
        if (leftOperand.toString().equals("true") || rightOperand.toString().equals("true") ||leftOperand.toString().equals("false") ||rightOperand.toString().equals("false")) {
            return "Boolean";
        }
        if (leftOperand.toString().contains(".") || rightOperand.toString().contains(".")) {
            return "Double";
        }
        if (operation.equals("/"))
            return "Double";
        return "Integer";
    }

    @Override
    public String toString() {
        return leftOperand + " " + operation + " " + rightOperand;
    }

    public Object getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(Object leftOperand) {
        this.leftOperand = leftOperand;
    }

    public Object getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(Object rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
