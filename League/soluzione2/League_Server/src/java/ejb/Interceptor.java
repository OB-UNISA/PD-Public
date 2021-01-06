package ejb;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

/**
 *
 * @author OB
 */
@javax.interceptor.Interceptor
@Loggable
public class Interceptor {

    @Inject
    private Logger logger;

    @AroundInvoke
    public Object log(InvocationContext ic) throws Exception {
        String method = ic.getMethod().getName();
        Long invocazioni = GiocatoreEJB.stats.get(method);
        invocazioni++;
        GiocatoreEJB.stats.put(method, invocazioni);
        logger.info("Invocato " + method + " " + invocazioni + " volte");
        return ic.proceed();
    }
}
