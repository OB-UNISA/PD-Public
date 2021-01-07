package ejb;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author OB
 */
@NamedQueries({
    @NamedQuery(name = Giocatore.GET_ALL, query = "SELECT g FROM Giocatore g"),
    @NamedQuery(name = Giocatore.GET_BY_ID, query = "SELECT g FROM Giocatore g WHERE g.id = ?1"),
    @NamedQuery(name = Giocatore.GET_BY_REGIONE, query = "SELECT g FROM Giocatore g WHERE g.regione = ?1"),
    @NamedQuery(name = Giocatore.GET_BY_LEGA, query = "SELECT g FROM Giocatore g WHERE g.lega = ?1"),
    @NamedQuery(name = Giocatore.GET_BY_LIVELLO_GREATER_OR_EQUAL_THAN_X, query = "SELECT g FROM Giocatore g WHERE g.livello >= ?1")
})
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Giocatore implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String GET_ALL = "Giocatore.GET_ALL";
    public static final String GET_BY_ID = "Giocatore.GET_BY_ID";
    public static final String GET_BY_REGIONE = "Giocatore.GET_BY_REGIONE";
    public static final String GET_BY_LEGA = "Giocatore.GET_BY_LEGA";
    public static final String GET_BY_LIVELLO_GREATER_OR_EQUAL_THAN_X = "Giocatore.GET_BY_LIVELLO_GREATER_OR_EQUAL_THAN_X";

    @Id
    @GeneratedValue
    @XmlAttribute
    private Long id;
    @XmlAttribute
    private Integer livello;
    @XmlAttribute
    private String regione;
    @XmlAttribute
    private String lega;
    @XmlAttribute
    private Long essenzaBlu;
    @XmlAttribute
    private Integer riotPoints;

    public Giocatore() {
    }

    public Giocatore(Integer livello, String regione, String lega, Long essenzaBlu, Integer riotPoints) {
        this.livello = livello;
        this.regione = regione;
        this.lega = lega;
        this.essenzaBlu = essenzaBlu;
        this.riotPoints = riotPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(Integer livello) {
        this.livello = livello;
    }

    public String getRegione() {
        return regione;
    }

    public void setRegione(String regione) {
        this.regione = regione;
    }

    public String getLega() {
        return lega;
    }

    public void setLega(String lega) {
        this.lega = lega;
    }

    public Long getEssenzaBlu() {
        return essenzaBlu;
    }

    public void setEssenzaBlu(Long essenzaBlu) {
        this.essenzaBlu = essenzaBlu;
    }

    public Integer getRiotPoints() {
        return riotPoints;
    }

    public void setRiotPoints(Integer riotPoints) {
        this.riotPoints = riotPoints;
    }

    @PrePersist
    public void validate() throws IllegalArgumentException {
        if (livello < 1 || (livello < 30 && !lega.equals("unranked")) || essenzaBlu < 0 || riotPoints < 0) {
            throw new IllegalArgumentException("Uno o più argomenti non validi");
        }
    }

}
