package lab1.task2;

import java.util.Random;

public class StudentAllocator {

    public static Student[] createStudents(int numberOfStudents) {
        Student[] students = new Student[numberOfStudents];

        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = createRandomStudent();
        }

        return students;
    }

    private static Student createRandomStudent() {
        String[] names = {"Andreea", "Bogdan", "Nico", "Maria", "Stefan", "Ioana"};
        Random random = new Random();

        String randomName = names[random.nextInt(names.length)];
        double randomGrade = 3.0 + random.nextDouble(0, 7);

        return new Student(randomName, randomGrade);
    }
}
