package ejb;

import java.util.Collection;
import javax.ejb.Remote;

/**
 *
 * @author OB
 */
@Remote
public interface GiocatoreEJBRemote {

    Giocatore createEntry(Giocatore giocatore);

    Giocatore getById(Long id);

    Collection<Giocatore> getByRegione(String regione);

    Collection<Giocatore> getByLega(String lega);

    Collection<Giocatore> getAll();

    Collection<Giocatore> getByLivelloGreaterOrEqualThanX(Integer x);

}
