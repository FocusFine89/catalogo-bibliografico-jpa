package NikitaIvanov.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity


public class Libri extends Catalogo {
    //Attributi
    protected String autore;
    protected String genere;

    //Costruttori
    public Libri() {
    }

    public Libri(String titolo, LocalDate annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    //Metodi

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}
