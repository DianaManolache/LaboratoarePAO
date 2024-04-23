package Task3;

class Client {
    private Plata metodaPlataPreferata;

    public Client(Plata metodaPlataPreferata) {
        this.metodaPlataPreferata = metodaPlataPreferata;
    }

    public void achizitioneaza(double suma) {
        metodaPlataPreferata.efectueazaPlata(suma);
    }
}
