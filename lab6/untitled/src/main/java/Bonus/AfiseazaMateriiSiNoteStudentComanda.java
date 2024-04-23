package Bonus;

import Bonus.Comanda;

class AfiseazaMateriiSiNoteStudentComanda implements Comanda {
    private String numeStudent;

    public AfiseazaMateriiSiNoteStudentComanda(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    @Override
    public void executa() {
    }
}
