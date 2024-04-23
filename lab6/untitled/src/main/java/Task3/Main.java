package Task3;

public class Main {
    public static void main(String[] args) {
        Plata plataCash = new PlataCash();
        Plata plataTransferBancar = new PlataTransferBancar();
        Plata plataCard = new PlataCard();

        Client client1 = new Client(plataCash);
        Client client2 = new Client(plataTransferBancar);
        Client client3 = new Client(plataCard);

        Magazin magazin = new Magazin();

        magazin.adaugaTranzactie(new Tranzactie(100, client1::achizitioneaza));
        magazin.adaugaTranzactie(new Tranzactie(200, client2::achizitioneaza));
        magazin.adaugaTranzactie(new Tranzactie(150, client3::achizitioneaza));

        magazin.proceseazaTranzactii();
    }
}