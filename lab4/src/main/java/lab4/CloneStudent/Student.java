package lab4.CloneStudent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Student implements Cloneable, Serializable {
    private String fullName;
    private Map<String, Double> courseInformation;

    public Student(String fullName, Map<String, Double> courseInformation) {
        this.fullName = fullName;
        this.courseInformation = new HashMap<>(courseInformation);
    }

    public Student(Student student) {
        this.fullName = student.fullName;
        this.courseInformation = new HashMap<>(student.getCourseInformation());
    }

    @Override
    public Student clone() {
        return new Student(this);
    }

    @Override
    public String toString() {
        return "Student {" + "fullName = '" + fullName + '\'' + ", courseInformation = " + courseInformation + '}';
    }
    public Map<String, Double> getCourseInformation() {
        return courseInformation;
    }
}
