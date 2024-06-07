package NikitaIvanov.entities;

import jakarta.persistence.Entity;

@Entity
public class Riviste extends Catalogo {
    //Attributi
    protected String Periodicita;

    //Costruttori
    public Riviste() {
    }

    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, String periodicita) {
        super(titolo, annoPubblicazione, numeroPagine);
        Periodicita = periodicita;
    }

    //Metodi


    public String getPeriodicita() {
        return Periodicita;
    }

    public void setPeriodicita(String periodicita) {
        Periodicita = periodicita;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "Periodicita='" + Periodicita + '\'' +
                '}';
    }
}
