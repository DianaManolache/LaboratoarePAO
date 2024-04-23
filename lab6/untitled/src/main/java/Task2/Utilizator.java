package Task2;

class Utilizator {
    private String nume;

    public Utilizator(String nume) {
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void primesteMesaj(String mesaj) {
        System.out.println(mesaj);
    }

    public void trimiteMesaj(Subiect subiect, String mesaj) {
        subiect.notificaAbonati(this, mesaj);
    }
}
