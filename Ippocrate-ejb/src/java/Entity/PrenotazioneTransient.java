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
public class PrenotazioneTransient {

    private String tipo;

    private String nomeSM;

    private String indirizzoSM;

    private Date data;

    private String nomePr;

    private int durataPr;

    /* Se la Prenotazione e' di tipo PrenotazioneMedico */
    private String cognomeM;

    private String ufficioM;
    
    /* Se la Prenotazione e' di tipo PrenotazioneSala */
    private String tipoLaboratorioS;

    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set the value of tipo
     *
     * @param tipo new value of tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Get the value of tipoLaboratorioS
     *
     * @return the value of tipoLaboratorioS
     */
    public String getTipoLaboratorioS() {
        return tipoLaboratorioS;
    }

    /**
     * Set the value of tipoLaboratorioS
     *
     * @param tipoLaboratorioS new value of tipoLaboratorioS
     */
    public void setTipoLaboratorioS(String tipoLaboratorioS) {
        this.tipoLaboratorioS = tipoLaboratorioS;
    }

    /**
     * Get the value of ufficioM
     *
     * @return the value of ufficioM
     */
    public String getUfficioM() {
        return ufficioM;
    }

    /**
     * Set the value of ufficioM
     *
     * @param ufficioM new value of ufficioM
     */
    public void setUfficioM(String ufficioM) {
        this.ufficioM = ufficioM;
    }

    /**
     * Get the value of cognomeM
     *
     * @return the value of cognomeM
     */
    public String getCognomeM() {
        return cognomeM;
    }

    /**
     * Set the value of cognomeM
     *
     * @param cognomeM new value of cognomeM
     */
    public void setCognomeM(String cognomeM) {
        this.cognomeM = cognomeM;
    }

    /**
     * Get the value of durataPr
     *
     * @return the value of durataPr
     */
    public int getDurataPr() {
        return durataPr;
    }

    /**
     * Set the value of durataPr
     *
     * @param durataPr new value of durataPr
     */
    public void setDurataPr(int durataPr) {
        this.durataPr = durataPr;
    }

    /**
     * Get the value of nomePr
     *
     * @return the value of nomePr
     */
    public String getNomePr() {
        return nomePr;
    }

    /**
     * Set the value of nomePr
     *
     * @param nomePr new value of nomePr
     */
    public void setNomePr(String nomePr) {
        this.nomePr = nomePr;
    }

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public Date getData() {
        return data;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Get the value of indirizzoSM
     *
     * @return the value of indirizzoSM
     */
    public String getIndirizzoSM() {
        return indirizzoSM;
    }

    /**
     * Set the value of indirizzoSM
     *
     * @param indirizzoSM new value of indirizzoSM
     */
    public void setIndirizzoSM(String indirizzoSM) {
        this.indirizzoSM = indirizzoSM;
    }

    /**
     * Get the value of nomeSM
     *
     * @return the value of nomeSM
     */
    public String getNomeSM() {
        return nomeSM;
    }

    /**
     * Set the value of nomeSM
     *
     * @param nomeSM new value of nomeSM
     */
    public void setNomeSM(String nomeSM) {
        this.nomeSM = nomeSM;
    }

}
