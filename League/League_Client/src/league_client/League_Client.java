package league_client;

import ejb.Giocatore;
import ejb.GiocatoreEJBRemote;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author OB
 */
public class League_Client {

    public static void main(String[] args) throws NamingException {
        Context ctx = new InitialContext();
        GiocatoreEJBRemote ejb = (GiocatoreEJBRemote) ctx.lookup("java:global/League_Server/GiocatoreEJB!ejb.GiocatoreEJBRemote");

        System.out.println("Stampa tutti i giocatori");
        for (Giocatore g : ejb.getAll()) {
            System.out.println("Id giocatore: " + g.getId());
        }

        System.out.format("Stampa tutti i giocatori della regione ");
        Scanner s = new Scanner(System.in);
        for (Giocatore g : ejb.getByRegione(s.nextLine())) {
            System.out.println("Id giocatore: " + g.getId());
        }

        System.out.format("Stampa tutti i giocatorim con livello >= ");
        for (Giocatore g : ejb.getByLivelloGreaterOrEqualThanX(s.nextInt())) {
            System.out.println("Id giocatore: " + g.getId());
        }
    }

}
