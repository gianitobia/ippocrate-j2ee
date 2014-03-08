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
public class MedicoTransient {

    private Long id;

    /* Permette di identificare se si tratta di MedicoEsterno o MedicoOspedaliero */
    private String tipo;

    private String nome;

    private String cognome;

    private String specializzazione;

    private Date data_nascita;

    private String num_ufficio;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getSpecializzazione() {
        return specializzazione;
    }

    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    public Date getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getNum_ufficio() {
        return num_ufficio;
    }

    public void setNum_ufficio(String num_ufficio) {
        this.num_ufficio = num_ufficio;
    }

}
