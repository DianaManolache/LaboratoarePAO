package Task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;

public class MainV2 {
    public static void main(String[] args) {
        String myPathToFile = "C:\\1 Partitie D\\Facultate\\sem2\\LaboratorPAO\\lab7\\lab7\\src\\main\\java\\Task1\\fileInputStream";
        try (BufferedReader reader = new BufferedReader(new FileReader(myPathToFile))) {

            reader.readLine();

            String secondLine = reader.readLine();
            System.out.println(secondLine);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
