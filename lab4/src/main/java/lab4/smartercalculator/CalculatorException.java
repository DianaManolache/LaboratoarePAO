package lab4.smartercalculator;

public abstract class CalculatorException extends Exception {
    public CalculatorException() {
        super("Oopsie! Exception!");
    }

    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorException(Throwable cause) {
        super(cause);
    }
}
