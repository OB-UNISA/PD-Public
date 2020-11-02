package jpa_lab2;

/**
 *
 * @author OB
 */
public class BookUtility {

    public static String toString(Book book) {
        return "Book{" + "id=" + book.getId() + ", title=" + book.getTitle()
                + ", price=" + book.getPrice() + ", description=" + book.getDescription()
                + ", isbn=" + book.getIsbn() + ", nbOfPage=" + book.getNbOfPage()
                + ", illustrations=" + book.getIllustrations() + '}';
    }
}
