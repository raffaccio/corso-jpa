package com.onmicrosoft.liguosworld.example.jpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titolo;
    private String isbn;

    @ManyToOne
    private Autore autore;

    @ManyToOne
    private Editore editore;

    public Libro() {
    }

    public Libro(String titolo, String isbn, Autore autore, Editore editore) {
        this.titolo = titolo;
        this.isbn = isbn;
        this.autore = autore;
        this.editore = editore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    public Editore getEditore() {
        return editore;
    }

    public void setEditore(Editore editore) {
        this.editore = editore;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autore=" + autore +
                ", editore=" + editore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id != null && id.equals(libro.id);

    }
}
