package lab4.studentSerialization.serialization;


import lab4.studentSerialization.domain.Student;
import lab4.studentSerialization.serialization.deserializer.StudentDeserializer;
import lab4.studentSerialization.serialization.serializer.StudentSerializer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public final class StudentStorage {
    private final StudentSerializer serializer;
    private final StudentDeserializer deserializer;

    public StudentStorage(StudentSerializer serializer, StudentDeserializer deserializer) {
        this.serializer = serializer;
        this.deserializer = deserializer;
    }

    public List<Student> readAllStudents(InputStream inputStream) throws IOException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        while (true) {
            Student student = deserializer.deserializer(inputStream);
            if (student == null) {
                break;
            }
            students.add(student);
        }
        return students;
    }

    public void writeAllStudents(OutputStream outputStream, List<Student> students) throws IOException {
        for (Student student : students) {
            serializer.serialize(outputStream, student);
        }

    }
}
