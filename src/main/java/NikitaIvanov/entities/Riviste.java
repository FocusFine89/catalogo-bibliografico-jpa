package NikitaIvanov.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Riviste extends Catalogo {
    //Attributi
    protected String Periodicita;

    //Costruttori
    public Riviste() {
    }

    public Riviste(String titolo, LocalDate annoPubblicazione, int numeroPagine, String periodicita) {
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
