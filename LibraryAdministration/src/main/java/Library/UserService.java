package Library;

/**
 * Interfața pentru serviciul de utilizatori.
 * Acest serviciu oferă operații specifice gestionării utilizatorilor.
 */
public interface UserService {
    /**
     * Vizualizează lista cu toti cititorii inregistrati.
     */
    void vizualizareCititori();

    /**
     * Vizualizează lista de carti care trbuiau aduse inapoi si inca nu au fost inapoiate.
     */
    void vizualizareRestantieri();

    /**
     * Adauga un nou cititor.
     */
    void adaugareCititor();

    /**
     * Sterge un cititor existent.
     */
    void stergereCititor();

    /**
     * Modifica datele unui cititor.
     */
    void modificareCititor();

    /**
     * Modifica datele unei fise a unui cititor.
     */
    void modificareDateFisa();
}
