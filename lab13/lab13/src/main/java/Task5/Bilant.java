package Task5;
import java.util.*;
import java.util.stream.Collectors;

class Bilant implements Comparable<Bilant> {
    private int pozitive;
    private int negative;

    public Bilant() {
        this(0, 0);
    }

    public Bilant(int pozitive, int negative) {
        this.pozitive = pozitive;
        this.negative = negative;
    }

    @Override
    public int compareTo(Bilant other) {
        return Integer.compare(other.pozitive - other.negative, this.pozitive - this.negative);
    }

    @Override
    public String toString() {
        return "Bilant{pozitive=" + pozitive + ", negative=" + negative + "}";
    }

    public static void main(String[] args) {
        List<Bilant> bilants = new ArrayList<>();
        bilants.add(new Bilant(10, 5));
        bilants.add(new Bilant(3, 2));
        bilants.add(new Bilant(7, 10));

        List<Bilant> sortedBilants = bilants.stream()
                .sorted()
                .collect(Collectors.toList());

        sortedBilants.forEach(System.out::println);
    }
}

