package Task2;

public class Main {
    public static void main(String[] args) {
        Utilizator adrian = new Utilizator("Adrian");
        Utilizator ion = new Utilizator("Ion");
        Utilizator maria = new Utilizator("Maria");
        Utilizator matei = new Utilizator("Matei");
        Utilizator diana  = new Utilizator("Diana");

        Subiect mancare = CreeazaSubiect.creeazaSubiect("mancare");
        Subiect programare = CreeazaSubiect.creeazaSubiect("programare");
        Subiect temaDeLaborator = CreeazaSubiect.creeazaSubiect("tema de laborator");

        mancare.adaugaAbonat(adrian);
        mancare.adaugaAbonat(maria);

        programare.adaugaAbonat(adrian);
        programare.adaugaAbonat(ion);
        programare.adaugaAbonat(maria);
        programare.adaugaAbonat(matei);

        temaDeLaborator.adaugaAbonat(ion);

        ion.trimiteMesaj(programare, "Salutare!");
        adrian.trimiteMesaj(mancare, "Omlette du fromage");
        diana.trimiteMesaj(temaDeLaborator, "Sunt prea talent");
    }
}
