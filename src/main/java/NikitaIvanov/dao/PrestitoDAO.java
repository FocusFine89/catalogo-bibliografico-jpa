package NikitaIvanov.dao;

import NikitaIvanov.entities.Prestito;
import NikitaIvanov.exceptions.NotFoundUserException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
