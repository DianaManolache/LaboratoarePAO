package lab4.studentSerialization.serialization.deserializer;

import lab4.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.InputStream;

public interface StudentDeserializer {
    Student deserializer(InputStream inputStream) throws IOException, ClassNotFoundException;
}
