package ejb;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.interceptor.ExcludeClassInterceptors;
import javax.interceptor.Interceptors;
import javax.jws.WebService;
import javax.persistence.EntityManager;

/**
 *
 * @author OB
 */
@Stateless
@LocalBean
@WebService
@Interceptors(Interceptor.class)
public class GiocatoreEJB implements GiocatoreEJBRemote {

    @Inject
    EntityManager em;

    @Inject
    Event<String> event;

    public static HashMap<String, Long> stats = new HashMap<String, Long>() {
        {
            
            for (Method method : GiocatoreEJB.class.getDeclaredMethods()) {
                String methodName = method.getName();
                if (!methodName.equals("getAll")) {
                    put(methodName, 0L);
                }
            }
        }
    };

    @Override
    public Giocatore createEntry(Giocatore giocatore) {
        em.persist(giocatore);
        return giocatore;
    }

    @Override
    public Giocatore getById(Long id) {
        return em.createQuery("SELECT g FROM Giocatore g WHERE g.id = :id", Giocatore.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public Collection<Giocatore> getByRegione(String regione) {
        return em.createQuery("SELECT g FROM Giocatore g WHERE g.regione = :regione", Giocatore.class).setParameter("regione", regione).getResultList();
    }

    @Override
    public Collection<Giocatore> getByLega(String lega) {
        return em.createQuery("SELECT g FROM Giocatore g WHERE g.lega = :lega", Giocatore.class).setParameter("lega", lega).getResultList();
    }

    @Override
    @ExcludeClassInterceptors
    public Collection<Giocatore> getAll() {
        return em.createNamedQuery(Giocatore.FIND_ALL, Giocatore.class).getResultList();
    }

    @Override
    public Collection<Giocatore> getByLivelloGreaterOrEqualThanX(Integer x) {
        return em.createQuery("SELECT g FROM Giocatore g WHERE g.livello >= :livello", Giocatore.class).setParameter("livello", x).getResultList();
    }

    public Giocatore updateRiotPoints(Long id, Integer riotPoints) {
        Giocatore giocatore = getById(id);
        giocatore.setRiotPoints(riotPoints);
        event.fire("Riot points di " + giocatore.getId() + " modificati");
        return giocatore;
    }
}
