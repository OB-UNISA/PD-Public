package league_webservicesclient;

import ejb.Giocatore;
import java.util.Scanner;

/**
 *
 * @author OB
 */
public class League_WebServicesClient {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.format("Id giocatore: ");
        Long id = s.nextLong();
        System.out.format("Riot points: ");
        Integer riotPoints = s.nextInt();

        updateRiotPoints(id, riotPoints);
    }

    private static Giocatore updateRiotPoints(java.lang.Long arg0, java.lang.Integer arg1) {
        ejb.GiocatoreEJBService service = new ejb.GiocatoreEJBService();
        ejb.GiocatoreEJB port = service.getGiocatoreEJBPort();
        return port.updateRiotPoints(arg0, arg1);
    }

}
