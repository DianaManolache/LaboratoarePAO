package lab1.task4;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class DummyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Scrieti operatia sau quit pt a iesi: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            String[] arguments = input.split("\\s+");
            calculate(arguments);
        }

        scanner.close();
    }

    public static void calculate(String[] args) {
        //consideram cazul cu trei argumente, operand1 + operator + operand2
        String var1 = args[0];
        String var2 = args[2];
        String op = args[1];

        // boolean
        if (isBoolean(var1)) {
            boolean varBoolean1 = Boolean.valueOf(var1);
            boolean varBoolean2 = Boolean.valueOf(var2);
            System.out.println(DummyCalculator.calcBooleanArgs(varBoolean1, varBoolean2, op));
            return;
        }

        if (isInteger(var1) && isInteger(var2)) {
            Integer varInt1 = parseInt(var1);
            Integer varInt2 = parseInt(var2);
            System.out.println(DummyCalculator.calc_int_args(varInt1, varInt2, op));
            return;
        }

        if (isDouble(var1) || isDouble(var2)) {
            Double varDouble1 = Double.parseDouble(var1);
            Double varDouble2 = Double.parseDouble(var2);
            System.out.println(DummyCalculator.calc_double_args(varDouble1, varDouble2, op));
        }
    }

    public static double calc_double_args(double a, double b, String op) {
        if (op.equals("+")) return (a + b);
        else if (op.equals("-")) return (a - b);
        else if (op.equals("*")) return (a * b);
        else return (a / b);
    }

    public static int calc_int_args(int a, int b, String op) {
        if (op.equals("+")) return (a + b);
        else if (op.equals("-")) return (a - b);
        else if (op.equals("*")) return (a * b);
        else return (a / b);
    }

    public static boolean calcBooleanArgs(Boolean a, Boolean b, String op) {
        if (op.equals("&&")) return (a && b);
        else if (op.equals("||")) return (a || b);
        else return (a != b); //pt !=
    }

    private static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    private static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isBoolean(String s) {
        return "true".equals(s.toLowerCase()) || "false".equals(s.toLowerCase());
    }
}