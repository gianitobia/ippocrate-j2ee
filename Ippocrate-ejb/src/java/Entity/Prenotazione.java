/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author toby
 */
@Entity
public abstract class Prenotazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private StrutturaMedica struttura_medica;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_prenotazione;

    @OneToOne
    private Paziente paziente;

    private String id_google;

    /**
     * Get the value of id_google
     *
     * @return the value of id_google
     */
    public String getId_google() {
        return id_google;
    }

    /**
     * Set the value of id_google
     *
     * @param id_google new value of id_google
     */
    public void setId_google(String id_google) {
        this.id_google = id_google;
    }

    /**
     * Get the value of paziente
     *
     * @return the value of paziente
     */
    public Paziente getPaziente() {
        return paziente;
    }

    /**
     * Set the value of paziente
     *
     * @param paziente new value of paziente
     */
    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    /**
     * Get the value of struttura_medica
     *
     * @return the value of struttura_medica
     */
    public StrutturaMedica getStruttura_medica() {
        return struttura_medica;
    }

    /**
     * Set the value of struttura_medica
     *
     * @param struttura_medica new value of struttura_medica
     */
    public void setStruttura_medica(StrutturaMedica struttura_medica) {
        this.struttura_medica = struttura_medica;
    }

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public Date getData_prenotazione() {
        return data_prenotazione;
    }

    /**
     * Set the value of data
     *
     * @param data_prenotazione new value of data
     */
    public void setData_prenotazione(Date data_prenotazione) {
        this.data_prenotazione = data_prenotazione;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prenotazione)) {
            return false;
        }
        Prenotazione other = (Prenotazione) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prenotazione [" + "id " + id + " " + "data_prenotazione " + data_prenotazione + " " + "paziente " + paziente + "]";
    }

}
