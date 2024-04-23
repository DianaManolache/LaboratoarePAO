package lab4.CloneStudent;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> courseInformation = new HashMap<>();
        courseInformation.put("Info", 9.5);
        courseInformation.put("Mate", 10.0);

        Student student = new Student("Andrei Popescu", courseInformation);
        Student studentClone  = student.clone();

        System.out.println("Original student: " + student);
        System.out.println("Cloned student: " + studentClone);

        // verificare
        student.getCourseInformation().put("Sport", 6.3);
        System.out.println("After modifying:");
        System.out.println("Original student: " + student);
        System.out.println("Cloned student: " + studentClone + '\n');
    }
}
