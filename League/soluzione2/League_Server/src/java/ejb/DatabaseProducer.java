package ejb;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author OB
 */
public class DatabaseProducer {

    @Produces
    @PersistenceContext(unitName = "EsamePU")
    EntityManager em;
}
