package Bonus;

class AdaugaStudentComanda implements Comanda {
    private String numeStudent;
    private String dataNastere;

    public AdaugaStudentComanda(String numeStudent, String dataNastere) {
        this.numeStudent = numeStudent;
        this.dataNastere = dataNastere;
    }

    @Override
    public void executa() {
    }
}
