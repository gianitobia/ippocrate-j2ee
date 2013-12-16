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
public class PrescrizioneMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_scadenza;

    private RefertoMedico referto;

    @OneToOne
    private Paziente paziente;

    private String medicinale;

    private int numero_confezioni = 1;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_prescrizione;

    private String consegnata;

    @OneToOne
    private Medico medico;

    /**
     * Get the value of referto
     *
     * @return the value of referto
     */
    public RefertoMedico getReferto() {
        return referto;
    }

    /**
     * Set the value of referto
     *
     * @param referto new value of referto
     */
    public void setReferto(RefertoMedico referto) {
        this.referto = referto;
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
     * Get the value of medicinale
     *
     * @return the value of medicinale
     */
    public String getMedicinale() {
        return medicinale;
    }

    /**
     * Set the value of medicinale
     *
     * @param medicinale new value of medicinale
     */
    public void setMedicinale(String medicinale) {
        this.medicinale = medicinale;
    }

    /**
     * Get the value of numero_confezioni
     *
     * @return the value of numero_confezioni
     */
    public int getNumero_confezioni() {
        return numero_confezioni;
    }

    /**
     * Set the value of numero_confezioni
     *
     * @param numero_confezioni new value of numero_confezioni
     */
    public void setNumero_confezioni(int numero_confezioni) {
        this.numero_confezioni = numero_confezioni;
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
     * Get the value of data_scadenza
     *
     * @return the value of data_scadenza
     */
    public Date getData_scadenza() {
        return data_scadenza;
    }

    /**
     * Set the value of data_scadenza
     *
     * @param data_scadenza new value of data_scadenza
     */
    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    /**
     * Get the value of data_prescrizione
     *
     * @return the value of data_prescrizione
     */
    public Date getData_prescrizione() {
        return data_prescrizione;
    }

    /**
     * Set the value of data_prescrizione
     *
     * @param data_prescrizione new value of data_prescrizione
     */
    public void setData_prescrizione(Date data_prescrizione) {
        this.data_prescrizione = data_prescrizione;
    }

    /**
     * Get the value of consegnata
     *
     * @return the value of consegnata
     */
    public String getConsegnata() {
        return consegnata;
    }

    /**
     * Set the value of consegnata
     *
     * @param consegnata new value of consegnata
     */
    public void setConsegnata(String consegnata) {
        this.consegnata = consegnata;
    }

    /**
     * Get the value of medico
     *
     * @return the value of medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Set the value of medico
     *
     * @param medico new value of medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
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
        if (!(object instanceof PrescrizioneMedica)) {
            return false;
        }
        PrescrizioneMedica other = (PrescrizioneMedica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Documenti.PrescrizioneMedica[ id=" + id + " ]";
    }

}
