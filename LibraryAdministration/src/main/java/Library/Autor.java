package Library;

public class Autor {
    private int id;
    private String nume;

    public Autor(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }

    public void setId(int anInt) {
        this.id = anInt;
    }

    public void setNume(String numeNou) {
        this.nume = numeNou;
    }

    public int getId() {
        return id;
    }
}
