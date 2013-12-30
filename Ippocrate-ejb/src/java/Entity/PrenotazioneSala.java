/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author toby
 */
@Entity
public class PrenotazioneSala extends Prenotazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Sala sala;

    /**
     * Get the value of sala
     *
     * @return the value of sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Set the value of sala
     *
     * @param sala new value of sala
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PrenotazioneSala [" + "id " + id + " " + "sala " + sala + " " + "getData_prenotazione " + getData_prenotazione() + " " + "getPaziente " + getPaziente() + " " + "getTipo_prestazione " + getTipo_prestazione() + "]";
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrenotazioneSala)) {
            return false;
        }
        PrenotazioneSala other = (PrenotazioneSala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
