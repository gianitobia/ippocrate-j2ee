/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transient;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marco
 */
@Stateless
@LocalBean
public class PrescrizioneMedicaTransient {

    private Long id;

    private Date dataPrescrizione;

    private Date dataScadenza;

    private String medicinale;

    private int numConfezioni;

    private String consegnata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataPrescrizione() {
        return dataPrescrizione;
    }

    public void setDataPrescrizione(Date dataPrescrizione) {
        this.dataPrescrizione = dataPrescrizione;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    public String getMedicinale() {
        return medicinale;
    }

    public void setMedicinale(String medicinale) {
        this.medicinale = medicinale;
    }

    public int getNumConfezioni() {
        return numConfezioni;
    }

    public void setNumConfezioni(int numConfezioni) {
        this.numConfezioni = numConfezioni;
    }

    public String getConsegnata() {
        return consegnata;
    }

    public void setConsegnata(String consegnata) {
        this.consegnata = consegnata;
    }

}
