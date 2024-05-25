package Library;

public class Carte {
    private int id;
    private String denumire;
    private int autorId;
    private int sectiuneId;
    private int nrTotalExemplare;

    public Carte(int id, String denumire, int autorId, int sectiuneId, int nrTotalExemplare) {
        this.id = id;
        this.denumire = denumire;
        this.autorId = autorId;
        this.sectiuneId = sectiuneId;
        this.nrTotalExemplare = nrTotalExemplare;
    }

    public Carte(int idCarte, String numeCarte) {
        this.id = idCarte;
        this.denumire = numeCarte;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getAutorId() {
        return autorId;
    }

    public int getSectiuneId() {
        return sectiuneId;
    }

    public int getNrTotalExemplare() {
        return nrTotalExemplare;
    }
}
