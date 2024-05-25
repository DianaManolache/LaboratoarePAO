package Library;

public class Exemplar {
    private int id;
    private int carteId;
    private boolean disponibil;

    public Exemplar(int id, int carteId, boolean disponibil) {
        this.id = id;
        this.carteId = carteId;
        this.disponibil = disponibil;
    }
    public Exemplar(int carteId, boolean disponibil) {
        this.carteId = carteId;
        this.disponibil = disponibil;
    }

    public int getCarteId() {
        return id;
    }

    public boolean isDisponibil() {
        return isDisponibil();
    }

    public int getId() {
        return id;
    }

    public void setId(int exemplarId) {
        this.id = exemplarId;
    }

    public void setDisponibil(boolean disponibilitate) {
        this.disponibil = disponibilitate;
    }
}
