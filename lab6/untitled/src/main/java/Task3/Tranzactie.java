package Task3;

class Tranzactie {
    private double suma;
    private Plata metodaPlata;

    public Tranzactie(double suma, Plata metodaPlata) {
        this.suma = suma;
        this.metodaPlata = metodaPlata;
    }

    public void efectueazaTranzactie() {
        metodaPlata.efectueazaPlata(suma);
    }
}
