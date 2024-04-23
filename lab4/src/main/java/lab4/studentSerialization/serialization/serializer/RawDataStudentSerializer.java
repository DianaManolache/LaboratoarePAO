package lab4.studentSerialization.serialization.serializer;


import lab4.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class RawDataStudentSerializer implements StudentSerializer {
    @Override
    public void serialize(OutputStream outputStream, Student student) throws IOException {
        new ObjectOutputStream(outputStream).writeObject(student);
    }
}
