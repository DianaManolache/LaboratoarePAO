package Task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> studenti = new ArrayList<>();
        studenti.add(new Student("Aurel Vlaicu", 5.3, 7.8, 9.0));
        studenti.add(new Student("Liviu Teodorescu", 7.7, 5.2, 9.0));

        Sortare sortare = new Sortare(new SortareDupaNotaTotala());
        sortare.executeSortare(studenti);
        afisareStudenti("Sortare dupa cea mai mare nota totala", studenti);

        sortare.setStrategy(new SortareDupaNotaPartial());
        sortare.executeSortare(studenti);
        afisareStudenti("Sortare dupa cea mai mare nota la partial", studenti);

        sortare.setStrategy(new SortareDupaNotaMedie());
        sortare.executeSortare(studenti);
        afisareStudenti("Sortare dupa media notelor", studenti);
    }

    private static void afisareStudenti(String metoda, List<Student> studenti) {
        System.out.println(metoda);
        int pozitie = 1;
        for (Student student : studenti) {
            System.out.println(pozitie++ + ". " + student);
        }
        System.out.println();
    }
}
