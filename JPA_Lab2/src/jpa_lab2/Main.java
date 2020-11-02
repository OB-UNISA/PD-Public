/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa_lab2;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author OB
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Book book = new Book("H2G2", 12.5F, "The Hitchhiker's Guide to the Galaxy", "1-84023-742-2", 354, Boolean.FALSE);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Lab2PU");
        EntityManager em = emf.createEntityManager();
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();
        
        book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
        System.out.println("Query per H2G2");
        System.out.println("######### " + book.getDescription());
        
        Query all = em.createNamedQuery("findAllBooks", Book.class);
        
        List<Book> results = all.getResultList();
        System.out.println("\nQuery per tutti i libri");
        for (Book b : results) {
            System.out.println(BookUtility.toString(b));
        }
        
        em.close();
        emf.close();
    }
    
}
