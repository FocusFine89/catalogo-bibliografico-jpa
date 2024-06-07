package NikitaIvanov.dao;

import NikitaIvanov.entities.Prestito;
import NikitaIvanov.exceptions.NotFoundUserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitoDAO {
    //Attributi
    private final EntityManager em;

    //Costruttori
    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    //Metodi

    //aggiunta al DB
    public void save(Prestito prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("Prestito per aggiunto");
    }

    //Ricerca elemento tramite ID
    public Prestito findById(long id) {
        Prestito prestito = em.find(Prestito.class, id);
        if (prestito == null) throw new NotFoundUserException(id);
        return prestito;
    }

    //Rimozione elemento tramite ID
    public void DeleteById(long id) {
        Prestito foundPrestito = findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(foundPrestito);


    }

    //Ricerca Elementi attualmente in prestito dato un numero di tessera utente
    public List<Prestito> attualmenteInPrestito(long tessera) {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.utente.tessera = :tessera AND p.dataRestituzioneEffettiva IS NULL", Prestito.class);
        query.setParameter("tessera", tessera);
        return query.getResultList();
    }


    //Ricerca di tutti i prestiti scaduti ancora non restituiti
    public List<Prestito> prestitiNonRestituiti() {
        TypedQuery<Prestito> query = em.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva  IS NULL AND p.dataRestituzionePrevista < CURRENT_DATE ", Prestito.class);
        return query.getResultList();
    }
}
