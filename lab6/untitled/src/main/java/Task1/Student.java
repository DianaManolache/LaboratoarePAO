package Task1;

import java.util.List;

class Student {
    String nume;
    double notaLaborator;
    double notaPartial;
    double notaExamen;

    public Student(String nume, double notaLaborator, double notaPartial, double notaExamen) {
        this.nume = nume;
        this.notaLaborator = notaLaborator;
        this.notaPartial = notaPartial;
        this.notaExamen = notaExamen;
    }

    public double getNotaTotala() {
        return notaLaborator + notaPartial + notaExamen;
    }

    public double getNotaPartial() {
        return notaPartial;
    }

    public double getNotaMedie() {
        return (notaLaborator + notaPartial + notaExamen) / 3;
    }

    @Override
    public String toString() {
        return nume + " " + notaLaborator + " " + notaPartial + " " + notaExamen;
    }
}
interface SortareStrategy {
    void sort(List<Student> studenti);
}
