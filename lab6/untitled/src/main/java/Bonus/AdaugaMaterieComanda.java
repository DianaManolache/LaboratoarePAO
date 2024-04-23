package Bonus;

class AdaugaMaterieComanda implements Comanda {
    private String numeMaterie;

    public AdaugaMaterieComanda(String numeMaterie) {
        this.numeMaterie = numeMaterie;
    }

    @Override
    public void executa() {
    }
}
