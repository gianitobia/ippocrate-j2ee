/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;

/**
 *
 * @author toby
 */
public class PazienteTransient {

    private String nome;

    private String cognome;

    private String cf;

    private String sesso;

    private String indirizzo;

    private Date data_nascita;

    private String luogo_nascita;

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
     * Get the value of cf
     *
     * @return the value of cf
     */
    public String getCf() {
        return cf;
    }

    /**
     * Set the value of cf
     *
     * @param cf new value of cf
     */
    public void setCf(String cf) {
        this.cf = cf;
    }

    /**
     * Get the value of sesso
     *
     * @return the value of sesso
     */
    public String getSesso() {
        return sesso;
    }

    /**
     * Set the value of sesso
     *
     * @param sesso new value of sesso
     */
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    /**
     * Get the value of indirizzo
     *
     * @return the value of indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Set the value of indirizzo
     *
     * @param indirizzo new value of indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
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
     * Get the value of luogo_nascita
     *
     * @return the value of luogo_nascita
     */
    public String getLuogo_nascita() {
        return luogo_nascita;
    }

    /**
     * Set the value of luogo_nascita
     *
     * @param luogo_nascita new value of luogo_nascita
     */
    public void setLuogo_nascita(String luogo_nascita) {
        this.luogo_nascita = luogo_nascita;
    }
}
