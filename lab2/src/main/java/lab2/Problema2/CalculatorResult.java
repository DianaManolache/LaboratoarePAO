package lab2.Problema2;

abstract class CalculatorResult {
    private CalculatorRequest calculatorRequest;
    public CalculatorRequest getRequest() {
        return calculatorRequest;
    }
    public abstract  Object computeResult();
    protected CalculatorResult(CalculatorRequest calculatorRequest) {
        this.calculatorRequest = calculatorRequest;
    }
}

class IntegerCalculatorResult extends CalculatorResult {
    protected IntegerCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Integer computeResult() {
        Integer leftOperand = Integer.parseInt(getRequest().getLeftOperand().toString());
        Integer rightOperand = Integer.parseInt(getRequest().getRightOperand().toString());
        String operation = getRequest().getOperation();

        if(operation.equals("+")) {
            return leftOperand + rightOperand;
        }
        else if(operation.equals("-")) {
            return leftOperand - rightOperand;
        }
        else if(operation.equals("*")) {
            return leftOperand * rightOperand;
        }
        else if(operation.equals("/")) {
            return leftOperand / rightOperand;
        }
        else {
            return null;
        }
    }
}

class DoubleCalculatorResult extends CalculatorResult {
    protected DoubleCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Double computeResult() {
        Double leftOperand = Double.parseDouble(getRequest().getLeftOperand().toString());
        Double rightOperand = Double.parseDouble(getRequest().getRightOperand().toString());
        String operation = getRequest().getOperation();

        if (operation.equals("+")) {
            return leftOperand + rightOperand;
        } else if (operation.equals("-")) {
            return leftOperand - rightOperand;
        } else if (operation.equals("*")) {
            return leftOperand * rightOperand;
        } else if (operation.equals("/")) {
            return leftOperand / rightOperand;
        } else {
            return null;
        }
    }
}

class BooleanCalculatorResult extends CalculatorResult {
    protected BooleanCalculatorResult(CalculatorRequest calculatorRequest) {
        super(calculatorRequest);
    }

    @Override
    public Boolean computeResult() {
        Boolean leftOperand = Boolean.parseBoolean(getRequest().getLeftOperand().toString());
        Boolean rightOperand = Boolean.parseBoolean(getRequest().getRightOperand().toString());
        String operation = getRequest().getOperation();

        if (operation.equals("&&")) {
            return leftOperand && rightOperand;
        } else if (operation.equals("||")) {
            return leftOperand || rightOperand;
        } else {
            return null;
        }
    }
}
