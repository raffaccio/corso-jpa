package com.onmicrosoft.liguosworld.example.jpa.app;

// This file is part of the course on JPA (Java Persistence API) using Hibernate.
// It is designed to be used with a MySQL database.
import com.onmicrosoft.liguosworld.example.jpa.model.Libro;
import com.onmicrosoft.liguosworld.example.jpa.model.Autore;
import com.onmicrosoft.liguosworld.example.jpa.model.Editore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        // Create an EntityManagerFactory for the persistence unit "corso_jpa"
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("DefaultPersistenceUnit");
        
        // Create an EntityManager from the EntityManagerFactory
        EntityManager em = emf.createEntityManager();
        
        // Start a transaction
        em.getTransaction().begin();
        
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
