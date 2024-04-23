package Task3;

public class PlataCash implements Plata {
    @Override
    public void efectueazaPlata(double suma) {
        System.out.println("Plata in numerar pentru suma de " + suma + " RON");
    }
}
