package jms;

import ejb.Giocatore;
import ejb.GiocatoreEJB;
import ejb.PrintConsole;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 *
 * @author OB
 */
@MessageDriven(mappedName = "jms/javaee7/Topic")
public class ConsumerMDB implements MessageListener {

    @Inject
    @PrintConsole
    Event<String> event;

    @Inject
    GiocatoreEJB ejb;

    @Inject
    Logger logger;

    @Override
    public void onMessage(Message msg) {
        try {
            ODT odt = msg.getBody(ODT.class);
            Giocatore giocatore = ejb.getById(odt.getId());
            Integer nuovoLivello = odt.getLivello();
            if (nuovoLivello > giocatore.getLivello()) {
                giocatore.setLivello(nuovoLivello);
                event.fire("Nuovo livello del giocatore " + giocatore.getId() + " aggiornato");
            } else {
                event.fire("Nuovo livello del giocatore " + giocatore.getId() + " non aggiornato");
            }
        } catch (JMSException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }

}
