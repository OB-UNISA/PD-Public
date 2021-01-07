package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * https://github.com/agoncal/agoncal-book-javaee7
 */
public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "EsamePU")
    EntityManager em;
}
