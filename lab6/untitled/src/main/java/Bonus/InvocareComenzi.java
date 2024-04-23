package Bonus;

import java.util.ArrayList;
import java.util.List;

public class InvocareComenzi {
    private List<Comanda> istoricComenzi = new ArrayList<>();

    public void executaComanda(Comanda comanda) {
        comanda.executa();
        istoricComenzi.add(comanda);
    }
}
