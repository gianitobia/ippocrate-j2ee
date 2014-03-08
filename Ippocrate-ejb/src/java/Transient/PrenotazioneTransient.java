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
public class PrenotazioneTransient {

    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNomeSM() {
        return nomeSM;
    }

    public void setNomeSM(String nomeSM) {
        this.nomeSM = nomeSM;
    }

    public String getIndirizzoSM() {
        return indirizzoSM;
    }

    public void setIndirizzoSM(String indirizzoSM) {
        this.indirizzoSM = indirizzoSM;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNomePr() {
        return nomePr;
    }

    public void setNomePr(String nomePr) {
        this.nomePr = nomePr;
    }

    public int getDurataPr() {
        return durataPr;
    }

    public void setDurataPr(int durataPr) {
        this.durataPr = durataPr;
    }

    public String getCognomeM() {
        return cognomeM;
    }

    public void setCognomeM(String cognomeM) {
        this.cognomeM = cognomeM;
    }

    public String getUfficioM() {
        return ufficioM;
    }

    public void setUfficioM(String ufficioM) {
        this.ufficioM = ufficioM;
    }

    public String getTipoLaboratorioS() {
        return tipoLaboratorioS;
    }

    public void setTipoLaboratorioS(String tipoLaboratorioS) {
        this.tipoLaboratorioS = tipoLaboratorioS;
    }

}
