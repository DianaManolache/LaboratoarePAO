package lab4.Bar;

public class Main {
    public static void main(String[] args) {
        bar();
    }

    public static void bar() {
        try {
            try {
                throw new ClassCastException();
            } catch (Exception ex) {
                System.out.println("Nu mai afiseaza fail hehe");
            }
        } catch (RuntimeException e) {
            System.out.println("fail");
        }
    }
}
