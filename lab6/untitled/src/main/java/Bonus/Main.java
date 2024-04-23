package Bonus;

public class Main {
    public static void main(String[] args) {
        InvocareComenzi invocator = new InvocareComenzi();

        invocator.executaComanda(new AdaugaStudentComanda("Diana Mano", "2003-03-27"));
        invocator.executaComanda(new AdaugaMaterieComanda("Info"));
        invocator.executaComanda(new AdaugaStudentLaMaterieComanda("Diana Mano", "Info"));
        invocator.executaComanda(new ModificaNotaComanda("Diana Mano", "Info", 10.0));
        invocator.executaComanda(new AfiseazaMateriiSiNoteStudentComanda("Diana Mano"));
        invocator.executaComanda(new StergeStudentComanda("Diana Mano"));
    }
}
