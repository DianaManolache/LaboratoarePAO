package task1.thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PowerCalculator extends Thread {
    private final List<Integer> numbers;

    public PowerCalculator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int num : numbers) {
            System.out.println(num + "^2=" + (num * num));
        }
    }
}
