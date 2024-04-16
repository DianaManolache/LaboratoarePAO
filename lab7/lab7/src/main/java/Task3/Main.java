package Task3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            String fileName = "src/main/java/Task3/fisier_" + i + ".txt";
            String content = i + ": " + getCurrentDateTime();

            try {
                FileWriter writer = new FileWriter(fileName);
                writer.write(content);
                writer.close();
                System.out.println("Am creat fisierul " + fileName);
            } catch (IOException e) {
                System.out.println("Nu am putut crea fisierul " + fileName);
            }
        }
    }

    private static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        return now.format(formatter);
    }

}
