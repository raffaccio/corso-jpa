package com.onmicrosoft.liguosworld.example.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Editore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The @Id annotation indicates that this field is the primary key of the entity.
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    // The indirizzo field represents the address of the publisher.
    @Column(name = "indirizzo", nullable = false)
    private String indirizzo;

    @OneToMany(mappedBy = "editore")
    private List<Libro> libri;

    // Default constructor is required by JPA
    public Editore() {
    }

    public Editore(String nome, String indirizzo) {
        this.nome = nome;
        this.indirizzo = indirizzo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }


    public List<Libro> getLibri() {
        return libri;
    }

    public void setLibri(List<Libro> libri) {
        this.libri = libri;
    }

    @Override
    public String toString() {
        return "Editore{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", libri=" + libri +
                '}';
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Editore)) return false;
        Editore editore = (Editore) o;
        return id != null && id.equals(editore.id);

    }
}
