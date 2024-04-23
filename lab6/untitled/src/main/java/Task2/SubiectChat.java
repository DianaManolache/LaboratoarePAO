package Task2;

import java.util.ArrayList;
import java.util.List;

class SubiectChat implements Subiect {
    private String nume;
    private List<Utilizator> abonati;

    public SubiectChat(String nume) {
        this.nume = nume;
        this.abonati = new ArrayList<>();
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void adaugaAbonat(Utilizator utilizator) {
        abonati.add(utilizator);
    }

    @Override
    public void eliminaAbonat(Utilizator utilizator) {
        abonati.remove(utilizator);
    }

    @Override
    public void notificaAbonati(Utilizator expeditor, String mesaj) {
        for (Utilizator abonat : abonati) {
            if (!abonat.getNume().equals(expeditor.getNume())) {
                abonat.primesteMesaj("[" + abonat.getNume() + "] " + expeditor.getNume() + " @ " + nume + ": " + mesaj);
            }
        }
    }
}
