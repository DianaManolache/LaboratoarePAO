package lab4.Foo;

public class Main {
    public static void main(String[] args) {
        foo();
    }

    public static void foo() {
        try {
            System.out.println("1");
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("2");
        }
        System.out.println("3");
    }
}