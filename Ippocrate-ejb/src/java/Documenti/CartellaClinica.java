/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Documenti;

import Persone.Paziente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author toby
 */
@Entity
public class CartellaClinica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "cartella_clinica")
    private Paziente paziente;

    private String anamnesi;

    @OneToMany
    private List<RefertoMedico> lista_referti;

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
     * Get the value of anamnesi
     *
     * @return the value of anamnesi
     */
    public String getAnamnesi() {
        return anamnesi;
    }

    /**
     * Set the value of anamnesi
     *
     * @param anamnesi new value of anamnesi
     */
    public void setAnamnesi(String anamnesi) {
        this.anamnesi = anamnesi;
    }

    /**
     * Get the value of lista_referti
     *
     * @return the value of lista_referti
     */
    public List<RefertoMedico> getLista_referti() {
        return lista_referti;
    }

    /**
     * Set the value of lista_referti
     *
     * @param lista_referti new value of lista_referti
     */
    public void setLista_referti(List<RefertoMedico> lista_referti) {
        this.lista_referti = lista_referti;
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
        if (!(object instanceof CartellaClinica)) {
            return false;
        }
        CartellaClinica other = (CartellaClinica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documenti.CartellaClinica[ id=" + id + " ]";
    }

}
