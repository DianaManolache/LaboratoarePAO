package Bonus;

class ModificaNotaComanda implements Comanda {
    private String numeStudent;
    private String numeMaterie;
    private double notaNoua;

    public ModificaNotaComanda(String numeStudent, String numeMaterie, double notaNoua) {
        this.numeStudent = numeStudent;
        this.numeMaterie = numeMaterie;
        this.notaNoua = notaNoua;
    }

    @Override
    public void executa() {
    }
}
