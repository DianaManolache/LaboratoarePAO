package Task1;

import java.io.FileInputStream;
import java.io.IOException;

public class MainV2 {
    public static void main(String[] args) {
        String myPathToFile = "C:\\1 Partitie D\\Facultate\\sem2\\LaboratorPAO\\lab7\\lab7\\src\\main\\java\\Task1\\fileInputStream";
        try (FileInputStream fileInputStream = new FileInputStream(myPathToFile)) {

            int count = 0;

            while (count < 20 && fileInputStream.available() > 0) {
                fileInputStream.read();
                count++;
            }

            while (fileInputStream.available() > 0) {
                System.out.print((char) fileInputStream.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
