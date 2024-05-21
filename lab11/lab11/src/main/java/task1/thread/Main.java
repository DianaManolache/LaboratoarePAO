package task1.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int numCount = 10000;
        int numThreads = Runtime.getRuntime().availableProcessors();

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(numCount);
        for (int i = 0; i < numCount; i++) {
            numbers.add(random.nextInt(100));
        }

        int chunkSize = (numCount + numThreads - 1) / numThreads;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numThreads; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, numCount);
            if (fromIndex < toIndex) {
                List<Integer> sublist = numbers.subList(fromIndex, toIndex);
                Thread thread = new PowerCalculator(sublist);
                threads.add(thread);
                thread.start();
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}