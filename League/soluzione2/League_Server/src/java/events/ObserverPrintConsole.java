package events;

import ejb.PrintConsole;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

/**
 *
 * @author OB
 */
public class ObserverPrintConsole {

    @Inject
    private Logger logger;

    public void printConsole(@Observes @PrintConsole String messaggio) {
        logger.info(messaggio);
    }
}
