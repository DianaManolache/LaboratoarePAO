package task1.completableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int numCount = 10000;
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
                        System.out.println(num + "^2=" + (num * num));
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
    }
}
