package lab1.task2;

import java.util.Random;

public class Course {
    private String name;
    private double minimumGrade;
    private Student[] students;

    public Course() {
        name = "";
        minimumGrade = -1;
        students = null;
    }

    public Course(String name, double minimumGrade, Student[] students) {
        this.name = name;
        this.minimumGrade = minimumGrade;
        this.students = students;
    }

    public Student chooseStudentRandomly() {
        Random rand = new Random();
        int nr_rand = rand.nextInt(students.length);
        return students[nr_rand];
    }

    public Student[] showAllPassingStudents() {
        Student[] passingStudents = new Student[students.length];
        int index = 0;
        for (Student student : students) {
            if (student.getGrade() >= minimumGrade) {
                passingStudents[index++] = student;
            }
        }
        for (Student student : passingStudents) {
            System.out.println(student);
        }
        return passingStudents;
    }

    public boolean isStudentPassing(int studentIndex) {
        if (studentIndex < 0 || studentIndex >= students.length) {
            return false;
        }
        return students[studentIndex].getGrade() >= minimumGrade;
    }

    public boolean isStudentPassing(Student student) {
        for (Student s : students) {
            if (s.getGrade() == student.getGrade()
                    && s.getName() == s.getName()) {
                return s.getGrade() >= minimumGrade;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinimumGrade() {
        return minimumGrade;
    }

    public void setMinimumGrade(double minimumGrade) {
        this.minimumGrade = minimumGrade;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }
}
