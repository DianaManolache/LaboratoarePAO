package Task1;

import java.io.FileInputStream;
import java.io.IOException;

public class MainV1 {
    public static void main(String[] args) {
        String myPathToFile = "C:\\1 Partitie D\\Facultate\\sem2\\LaboratorPAO\\lab7\\lab7\\src\\main\\java\\Task1\\fileInputStream";
        try (FileInputStream fileInputStream = new FileInputStream(myPathToFile)) {

            boolean skipFirstLine = true;

            while (fileInputStream.available() > 0) {
                char toPrint = (char) fileInputStream.read();

                if (skipFirstLine) {
                    if (toPrint == '\n') {
                        skipFirstLine = false;
                    }
                } else {
                    System.out.print(toPrint);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}