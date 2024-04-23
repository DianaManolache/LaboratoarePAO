package lab1.task1;

import lab1.task2.Student;
import lab1.task2.StudentAllocator;

public class Main {
    public static void main(String[] args) {
        Student[] students = StudentAllocator.createStudents(10);

        for (Student student : students) {
            System.out.println(student);
        }
    }
}