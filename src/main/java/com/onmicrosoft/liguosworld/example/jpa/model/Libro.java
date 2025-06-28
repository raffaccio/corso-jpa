package com.onmicrosoft.liguosworld.example.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {

    // The @Entity annotation indicates that this class is a JPA entity.
    // An entity represents a table in the database.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // The @Id annotation indicates that this field is the primary key of the entity.
    private Long id;
    @Column(name = "titolo", nullable = false)
    private String titolo;

    // ISBN (International Standard Book Number) is a unique identifier for books.
    // The ISBN is a 13-digit number that is assigned to each book.
    @Column(name = "isbn", unique = true, nullable = false)
    private String isbn;

    // ManyToOne relationship means that many books can be written by one author.
    // In this case, each book is associated with one author.
    // This ensures that every book must have an associated author.
    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    // ManyToOne relationship means that many books can be published by one publisher.
    // In this case, each book is associated with one publisher.
    // This ensures that every book must have an associated publisher.
    @ManyToOne
    @JoinColumn(name = "editore_id", nullable = false)
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
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return id != null && id.equals(libro.id);

    }
}
