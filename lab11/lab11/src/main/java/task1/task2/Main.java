package task1.task2;
import task1.thread.PowerCalculator;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        measureSequential(10);
        measureSequential(1000);
        measureSequential(10000);
        measureSequential(10000000);

        measureCompletableFuture(10);
        measureCompletableFuture(1000);
        measureCompletableFuture(10000);
        measureCompletableFuture(10000000);

        measureParallelStream(10);
        measureParallelStream(1000);
        measureParallelStream(10000);
        measureParallelStream(10000000);

        measureThread(10);
        measureThread(1000);
        measureThread(10000);
        measureThread(10000000);
    }

    private static void measureSequential(int numCount) {
        long startTime = System.nanoTime();

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(numCount);
        for (int i = 0; i < numCount; i++) {
            numbers.add(random.nextInt(100));
        }

        for (int num : numbers) {
            int square = num * num;
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

    }

    private static void measureCompletableFuture(int numCount) {
        long startTime = System.nanoTime();

        int numThreads = Runtime.getRuntime().availableProcessors();

        Random random = new Random();
        List<Integer> numbers = new ArrayList<>(numCount);
        for (int i = 0; i < numCount; i++) {
            numbers.add(random.nextInt(100));
        }

        ExecutorService executor = Executors.newWorkStealingPool(numThreads);
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        int chunkSize = (numCount + numThreads - 1) / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int fromIndex = i * chunkSize;
            int toIndex = Math.min(fromIndex + chunkSize, numCount);
            if (fromIndex < toIndex) {
                List<Integer> sublist = numbers.subList(fromIndex, toIndex);
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    for (int num : sublist) {
                        int square = num * num;
                    }
                }, executor);
                futures.add(future);
            }
        }

        futures.forEach(future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        executor.shutdown();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

    }

    private static void measureParallelStream(int numCount) {
        long startTime = System.nanoTime();

        List<Integer> numbers = new Random().ints(numCount, 0, 100).boxed().toList();

        numbers.parallelStream().forEach(num -> {
            int square = num * num;
        });

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

    }

    private static void measureThread(int numCount) {
        long startTime = System.nanoTime();

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

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

    }

    private static void writeToFile(String fileName, int numCount, long duration) {
        Path currentRelativePath = Paths.get("");
        String path = currentRelativePath.toAbsolutePath().toString();
        try {
            FileWriter writer = new FileWriter(path + "/src/main/java/task1/task2/" +  fileName, true);
            writer.write("NumCount: " + numCount + ", Duration: " + duration + " ms\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
