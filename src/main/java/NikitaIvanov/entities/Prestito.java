package NikitaIvanov.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Prestito {
    //Atrributi
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @Column(name = "data_inizio_prestito")
    protected LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    protected LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    protected LocalDate dataRestituzioneEffettiva;

    @OneToOne
    @JoinColumn(name = "elemento_prestato", nullable = false, unique = true)
    protected Catalogo elemento_catalogo;

    @ManyToOne
    @JoinColumn(name = "tessera_utente", nullable = false, unique = true)
    protected Utente utente;

    //Costruttori
    public Prestito() {
    }

    public Prestito(LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva, Catalogo elemento_catalogo, Utente utente) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
        this.elemento_catalogo = elemento_catalogo;
        this.utente = utente;
    }


    //Metodi

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "id=" + id +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                ", elemento_catalogo=" + elemento_catalogo +
                ", utente=" + utente +
                '}';
    }


}
