package NikitaIvanov.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Catalogo {
    //Attributi
    @Id
    private String isbn;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "anno_pubblicazione")
    private LocalDate annoPubblicazione;

    @Column(name = "numero_pagine")
    private int numeroPagine;


    //Costruttori
    public Catalogo() {
    }

    public Catalogo(String titolo, LocalDate annoPubblicazione, int numeroPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    //Metodi


    public String getIsbn() {
        return isbn;
    }


    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(LocalDate annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "isbn='" + isbn + '\'' +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}
