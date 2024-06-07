package NikitaIvanov.dao;

import NikitaIvanov.entities.Utente;
import NikitaIvanov.exceptions.NotFoundUserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    //Attributi
    private final EntityManager em;

    //Costruttori
    public UtenteDAO(EntityManager em) {
        this.em = em;
    }

    //Metodi

    //aggiunta al DB
    public void save(Utente utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println(utente.getNome() + " " + utente.getCognome() + "è stato aggiunto con successo!");
    }

    //Ricerca elemento tramite ID
    public Utente findById(long tessera) {
        Utente utente = em.find(Utente.class, tessera);
        if (utente == null) throw new NotFoundUserException(tessera);
        return utente;
    }

    //Rimozione elemento tramite ISBN
    public void DeleteById(long id) {
        Utente foundUser = findById(id);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(foundUser);


    }
}
