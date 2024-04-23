package lab4.studentSerialization.serialization.deserializer;


import lab4.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class RawDataStudentDeserializer implements StudentDeserializer {
    @Override
    public Student deserializer(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(inputStream);
        return (Student) in.readObject();
    }
}
