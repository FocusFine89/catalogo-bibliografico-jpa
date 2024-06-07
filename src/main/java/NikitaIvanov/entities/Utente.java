package NikitaIvanov.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente")
public class Utente {
    //Attribut
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long tessera;

    @Column(name = "nome")
    protected String nome;

    @Column(name = "cognome")
    protected String cognome;

    @Column(name = "data_nascita")
    protected LocalDate data_nascita;

    @OneToMany(mappedBy = "utente")
    protected List<Prestito> prestiti;

    //Costruttori
    public Utente() {
    }

    public Utente(String nome, String cognome, LocalDate data_nascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.data_nascita = data_nascita;
    }

    //Metodi


    public long getTessera() {
        return tessera;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "tessera=" + tessera +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", data_nascita=" + data_nascita +
                ", prestiti=" + prestiti +
                '}';
    }
}
