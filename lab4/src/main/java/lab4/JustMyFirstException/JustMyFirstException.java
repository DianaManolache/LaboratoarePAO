package lab4.JustMyFirstException;

public class JustMyFirstException extends RuntimeException {
    public JustMyFirstException() {
        super("Oopsie! This is my first exception!");
    }

    public JustMyFirstException(String message) {
        this();
    }

    public JustMyFirstException(String message, Throwable cause) {
        super("Oopsie! This is my first exception!", cause);
    }

    public JustMyFirstException(Throwable cause) {
        super("Oopsie! This is my first exception!", cause);
    }
}

