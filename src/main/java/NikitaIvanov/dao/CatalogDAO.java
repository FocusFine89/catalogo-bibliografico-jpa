package NikitaIvanov.dao;

import NikitaIvanov.entities.Catalogo;
import NikitaIvanov.entities.Libri;
import NikitaIvanov.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class CatalogDAO {
    //Attributi
    private final EntityManager em;

    //Costruttori
    public CatalogDAO(EntityManager em) {
        this.em = em;
    }

    //Metodi

    //aggiunta al DB
    public void save(Catalogo catalog_element) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalog_element);
        transaction.commit();
        System.out.println(catalog_element.getTitolo() + "è stato aggiunto con successo!");
    }

    //Ricerca elemento tramite ISBN
    public Catalogo findByIsbn(String isbn) {
        Catalogo catalog_element = em.find(Catalogo.class, isbn);
        if (catalog_element == null) throw new NotFoundException(isbn);
        return catalog_element;
    }

    //Rimozione elemento tramite ISBN
    public void DeleteByIsbn(String isbn) {
        Catalogo found_catalog_element = findByIsbn(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(found_catalog_element);


    }

    //Ricerca per anno di Pubblicazione
    public List<Catalogo> ricercaAnnoPubblicazione(int anno) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno", Catalogo.class);
        query.setParameter("anno", anno);
        return query.getResultList();
    }

    //Ricerca Libro per Autore
    public List<Libri> ricercaLibroPerAutore(String autore) {
        TypedQuery<Libri> query = em.createQuery("SELECT l FROM Libri l WHERE l.autore = :autore", Libri.class);
        query.setParameter("autore", autore);
        return query.getResultList();
    }

    //Ricerca per titolo
    public List<Catalogo> ricercaPerTitolo(String titolo) {
        TypedQuery<Catalogo> query = em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo ILIKE :titolo", Catalogo.class);
        query.setParameter("titolo", "%" + titolo + "%");
        return query.getResultList();
    }

}
