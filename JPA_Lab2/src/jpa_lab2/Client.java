package jpa_lab2;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author OB
 */
public class Client {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA_Lab2PU");
        EntityManager em = emf.createEntityManager();

        Book book = new Book();

        Scanner scan = new Scanner(System.in);
        System.out.format("Titolo= ");
        book.setTitle(scan.nextLine());
        System.out.format("Prezzo= ");
        book.setPrice(Float.parseFloat(scan.nextLine()));
        System.out.format("Descrizione= ");
        book.setDescription(scan.nextLine());
        System.out.format("Isbn= ");
        book.setIsbn(scan.nextLine());
        System.out.format("Pagine= ");
        book.setNbOfPage(Integer.parseInt(scan.nextLine()));
        System.out.format("Illustrazione= ");
        book.setIllustrations(Boolean.valueOf(scan.nextLine()));

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(book);
        tx.commit();

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
