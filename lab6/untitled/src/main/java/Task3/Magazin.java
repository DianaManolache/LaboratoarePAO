package Task3;

import java.util.LinkedList;
import java.util.Queue;

class Magazin {
    private Queue<Tranzactie> coadaTranzactii = new LinkedList<>();

    public void adaugaTranzactie(Tranzactie tranzactie) {
        coadaTranzactii.add(tranzactie);
    }

    public void proceseazaTranzactii() {
        while (!coadaTranzactii.isEmpty()) {
            Tranzactie tranzactie = coadaTranzactii.poll();
            tranzactie.efectueazaTranzactie();
        }
    }
}
