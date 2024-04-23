package lab4.studentSerialization.serialization.serializer;


import lab4.studentSerialization.domain.Student;

import java.io.IOException;
import java.io.OutputStream;

public interface StudentSerializer {
    void serialize(OutputStream outputStream, Student student) throws IOException;
}
