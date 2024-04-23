package Task3;

public class PlataTransferBancar implements Plata {
    @Override
    public void efectueazaPlata(double suma) {
        System.out.println("Plata prin transfer bancar pentru suma de " + suma + " RON");
    }
}
