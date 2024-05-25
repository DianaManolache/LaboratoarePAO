package Library;

import java.util.List;


/**
 * Interfața pentru un repository generic.
 * Acest repository oferă operații de bază pentru gestionarea entităților.
 * @param <T> Tipul entităților gestionate de repository.
 */
public interface Repository<T> {
    /**
     * Salvează o entitate în repository.
     * @param entity Entitatea de salvat.
     */
    void save(T entity);

    /**
     * Găsește o entitate în repository după id-ul său.
     * @param id Id-ul entității căutate.
     * @return Entitatea găsită sau null dacă nu există nicio entitate cu id-ul specificat.
     */
    T findById(int id);

    /**
     * Returnează toate entitățile din repository.
     * @return O listă de entități.
     */
    List<T> findAll();

    /**
     * Actualizează o entitate în repository.
     * @param entity Entitatea de actualizat.
     */
    void update(T entity);

    /**
     * Șterge o entitate din repository după id-ul său.
     * @param id Id-ul entității de șters.
     */
    void delete(int id);
}
