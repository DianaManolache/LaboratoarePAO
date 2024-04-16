package Task2;

import java.io.FileReader;
import java.io.IOException;


public class MainV1 {
    public static void main(String[] args) {
        String myPathToFile = "C:\\1 Partitie D\\Facultate\\sem2\\LaboratorPAO\\lab7\\lab7\\src\\main\\java\\Task1\\fileInputStream";
        try (FileReader reader = new FileReader(myPathToFile)) {

            reader.skip(20);

            int character;
            while ((character = reader.read()) != -1) {
                System.out.print((char) character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
