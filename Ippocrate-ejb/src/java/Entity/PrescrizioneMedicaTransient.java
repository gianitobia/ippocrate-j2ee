/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author Marco
 */
public class PrescrizioneMedicaTransient {

    private Date dataPrescrizione;

    private Date dataScadenza;

    private String medicinale;

    private int numConfezioni;

    /**
     * Get the value of dataPrescrizione
     *
     * @return the value of dataPrescrizione
     */
    public Date getDataPrescrizione() {
        return dataPrescrizione;
    }

    /**
     * Set the value of dataPrescrizione
     *
     * @param dataPrescrizione new value of dataPrescrizione
     */
    public void setDataPrescrizione(Date dataPrescrizione) {
        this.dataPrescrizione = dataPrescrizione;
    }

    /**
     * Get the value of numConfezioni
     *
     * @return the value of numConfezioni
     */
    public int getNumConfezioni() {
        return numConfezioni;
    }

    /**
     * Set the value of numConfezioni
     *
     * @param numConfezioni new value of numConfezioni
     */
    public void setNumConfezioni(int numConfezioni) {
        this.numConfezioni = numConfezioni;
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
     * Get the value of dataScadenza
     *
     * @return the value of dataScadenza
     */
    public Date getDataScadenza() {
        return dataScadenza;
    }

    /**
     * Set the value of dataScadenza
     *
     * @param dataScadenza new value of dataScadenza
     */
    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

}
