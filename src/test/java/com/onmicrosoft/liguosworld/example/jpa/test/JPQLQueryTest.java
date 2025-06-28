package com.onmicrosoft.liguosworld.example.jpa.test;

// This file is part of the course on JPA (Java Persistence API) using Hibernate.
// It is designed to be used with a MySQL database.
import com.onmicrosoft.liguosworld.example.jpa.model.Libro;
import com.onmicrosoft.liguosworld.example.jpa.model.Autore;
import com.onmicrosoft.liguosworld.example.jpa.model.Editore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class JPQLQueryTest {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Create an EntityManagerFactory for the persistence unit "DefaultPersistenceUnit"
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
        
        // Create an EntityManager from the EntityManagerFactory
        EntityManager em = emf.createEntityManager();
        
        // Start a transaction
        em.getTransaction().begin();

        TypedQuery<Libro> query = em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn", Libro.class);
        query.setParameter("isbn", "978-8804732532");
        // Execute the query and get the result list
        List<Libro> existing = query.getResultList();
        // Check if the result list is empty
        if (existing.isEmpty()) {
            em.persist(existing);
        }
        List<Libro> libri = query.getResultList();
        // Check if the result list is not empty

        // Print the results
        for (Libro libro : libri) {
            System.out.println("Libro: " + libro.getTitolo() + ", ISBN: " + libro.getIsbn() +
                               ", Autore: " + libro.getAutore().getNome() + " " + libro.getAutore().getCognome() +
                               ", Editore: " + libro.getEditore().getNome());
        }
        
        
        // Create instances of Autore and Editore
        Autore autore = new Autore("Agatha", "Christie");
        Editore editore = new Editore("Oscar Mondadori", "Via Arnoldo Mondadori 1");
        
        // Create a Libro instance and associate it with the Autore and Editore
        Libro libro = new Libro("Assassinio sull'Orient Express", "978-8804732532", autore, editore);
        
        // Persist the entities to the database
        em.persist(autore);
        em.persist(editore);
        em.persist(libro);
        
        // Commit the transaction
        em.getTransaction().commit();
        
        // Close the EntityManager
        em.close();
        
        // Close the EntityManagerFactory
        emf.close();
    }
    
}
