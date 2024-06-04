package Task6;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.*;

public class CharacterCounter {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java CharacterCounter <file-path> <character>");
            return;
        }

        String filePath = args[0];
        char characterToCount = args[1].charAt(0);

        try {
            int totalOccurrences = countCharacterOccurrences(filePath, characterToCount);
            System.out.println("Total occurrences of character '" + characterToCount + "' in file " + filePath + ": " + totalOccurrences);
        } catch (IOException | InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static int countCharacterOccurrences(String filePath, char character) throws IOException, InterruptedException, ExecutionException {
        List<Callable<Integer>> tasks = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String currentLine = line;
                tasks.add(() -> countCharacterInLine(currentLine, character));
            }
        }

        List<Future<Integer>> results = executorService.invokeAll(tasks);
        int totalOccurrences = 0;
        for (Future<Integer> result : results) {
            totalOccurrences += result.get();
        }

        executorService.shutdown();
        return totalOccurrences;
    }

    private static int countCharacterInLine(String line, char character) {
        int count = 0;
        for (char c : line.toCharArray()) {
            if (c == character) {
                count++;
            }
        }
        return count;
    }
}

