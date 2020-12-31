package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author OB
 */
@Startup
@Singleton
/*@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "jdbc/EsameDS",
        user = "APP",
        password = "APP",
        databaseName = "EsameDB",
        properties = {"connectionAttributes=;create=true"}
)*/
public class DatabasePopulator {

    @Inject
    GiocatoreEJB ejb;

    @PostConstruct
    public void populate() {
        ejb.createEntry(new Giocatore(10, "NA", "unranked", 2000L, 20));
        ejb.createEntry(new Giocatore(232, "KR", "challenger", 120000L, 25000));
        ejb.createEntry(new Giocatore(80, "KR", "platino", 34000L, 1600));

    }
}
