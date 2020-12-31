package ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author OB
 */
@javax.interceptor.Interceptor
public class Interceptor {

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        String method = ic.getMethod().getName();
        Long invocazioni = GiocatoreEJB.stats.get(method);
        invocazioni++;
        GiocatoreEJB.stats.put(method, invocazioni);
        Logger.getGlobal().log(Level.INFO, "Invocato " + method + " " + invocazioni + " volte");
        return ic.proceed();
    }
}
