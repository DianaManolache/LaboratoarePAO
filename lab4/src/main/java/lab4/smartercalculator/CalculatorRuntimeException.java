package lab4.smartercalculator;

public abstract class CalculatorRuntimeException extends RuntimeException {
    public CalculatorRuntimeException() {
        super("Oopsie! RuntimeException!");
    }

    public CalculatorRuntimeException(String message) {
        super(message);
    }

    public CalculatorRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculatorRuntimeException(Throwable cause) {
        super(cause);
    }
}
