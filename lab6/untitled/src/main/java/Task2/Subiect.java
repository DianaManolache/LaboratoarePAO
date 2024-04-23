package Task2;

interface Subiect {
    String getNume();
    void adaugaAbonat(Utilizator utilizator);
    void eliminaAbonat(Utilizator utilizator);
    void notificaAbonati(Utilizator expeditor, String mesaj);
}
