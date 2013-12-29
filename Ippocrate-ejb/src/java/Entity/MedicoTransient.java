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
public class MedicoTransient {

    /* Permette di identificare se si tratta di MedicoEsterno o MedicoOspedaliero */
    private String tipo;

    private String nome;

    private String cognome;

    private String specializzazione;

    private Date data_nascita;

    private String num_ufficio;

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
     * Get the value of num_ufficio
     *
     * @return the value of num_ufficio
     */
    public String getNum_ufficio() {
        return num_ufficio;
    }

    /**
     * Set the value of num_ufficio
     *
     * @param num_ufficio new value of num_ufficio
     */
    public void setNum_ufficio(String num_ufficio) {
        this.num_ufficio = num_ufficio;
    }

    /**
     * Get the value of data_nascita
     *
     * @return the value of data_nascita
     */
    public Date getData_nascita() {
        return data_nascita;
    }

    /**
     * Set the value of data_nascita
     *
     * @param data_nascita new value of data_nascita
     */
    public void setData_nascita(Date data_nascita) {
        this.data_nascita = data_nascita;
    }

    /**
     * Get the value of specializzazione
     *
     * @return the value of specializzazione
     */
    public String getSpecializzazione() {
        return specializzazione;
    }

    /**
     * Set the value of specializzazione
     *
     * @param specializzazione new value of specializzazione
     */
    public void setSpecializzazione(String specializzazione) {
        this.specializzazione = specializzazione;
    }

    /**
     * Get the value of cognome
     *
     * @return the value of cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Set the value of cognome
     *
     * @param cognome new value of cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set the value of nome
     *
     * @param nome new value of nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

}
