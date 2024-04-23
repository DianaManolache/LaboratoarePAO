package Task3;

public class PlataCard implements Plata {
    @Override
    public void efectueazaPlata(double suma) {
        System.out.println("Plata cu cardul pentru suma de " + suma + " RON");
    }
}
