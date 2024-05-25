package Library;

import java.util.List;

/**
 * Interfața pentru serviciul de audit.
 * Acest serviciu este responsabil pentru înregistrarea și furnizarea istoricului comenzilor.
 */
public interface AuditService {
    /**
     * Înregistrează o comandă în istoricul de audit.
     * @param command Comanda de înregistrat.
     */
    void logCommand(String command);

    /**
     * Returnează întregul istoric al comenzilor.
     * @return O listă de șiruri de caractere reprezentând istoricul comenzilor.
     */
    List<String> getCommandHistory();
}
