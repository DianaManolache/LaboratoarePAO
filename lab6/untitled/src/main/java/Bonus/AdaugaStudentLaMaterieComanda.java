package Bonus;

class AdaugaStudentLaMaterieComanda implements Comanda {
    private String numeStudent;
    private String numeMaterie;

    public AdaugaStudentLaMaterieComanda(String numeStudent, String numeMaterie) {
        this.numeStudent = numeStudent;
        this.numeMaterie = numeMaterie;
    }

    @Override
    public void executa() {
    }
}
