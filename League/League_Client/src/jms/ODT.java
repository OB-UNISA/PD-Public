package jms;

import java.io.Serializable;

/**
 *
 * @author OB
 */
public class ODT implements Serializable{

    private Long id;
    private Integer livello;

    public ODT(Long id, Integer livello) {
        this.id = id;
        this.livello = livello;
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

}
