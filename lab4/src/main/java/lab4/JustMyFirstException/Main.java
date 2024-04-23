package lab4.JustMyFirstException;

public class Main {
    public static void main(String[] args) {
        try {
            throw new JustMyFirstException();
        } catch (JustMyFirstException e) {
            System.out.println(e.getMessage());
        }
    }
}
