package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;

/**
 *
 * @author OB
 */
public class ObserverPrintConsole {

    public void printConsole(@Observes String messaggio) {
        Logger.getGlobal().log(Level.INFO, messaggio);
    }
}
