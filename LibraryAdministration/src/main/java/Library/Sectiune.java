package Library;

public class Sectiune {
    private int id;
    private String denumire;
    private String sala;
    private int rand;
    private int coloana;
    private int raft;

    public Sectiune(int id, String denumire, String sala, int rand, int coloana, int raft) {
        this.id = id;
        this.denumire = denumire;
        this.sala = sala;
        this.rand = rand;
        this.coloana = coloana;
        this.raft = raft;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getSala() {
        return sala;
    }

    public int getRand() {
        return rand;
    }

    public int getColoana() {
        return coloana;
    }

    public int getRaft() {
        return raft;
    }
}
