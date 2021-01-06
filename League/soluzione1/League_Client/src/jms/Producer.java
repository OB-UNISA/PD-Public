package jms;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author OB
 */
public class Producer {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        ConnectionFactory cf = (ConnectionFactory) ctx.lookup("jms/javaee7/ConnectionFactory");
        Destination topic = (Destination) ctx.lookup("jms/javaee7/Topic");

        try (JMSContext jms = cf.createContext()) {
            System.out.println("Invio ODT con parametri validi");
            jms.createProducer().send(topic, new ODT(1L, 50));
            System.out.println("Invio ODT con parametro non valido");
            jms.createProducer().send(topic, new ODT(2L, 40));
        }
    }
}
