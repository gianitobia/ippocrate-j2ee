/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persone;

import Documenti.CartellaClinica;
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
public class Paziente implements Serializable {

    private static final long serialVersionUID = 1L;
    @OneToOne(mappedBy = "paziente")
    private CartellaClinica cartellaClinica;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;

    private String cf;

    private String sesso;

    private String indirizzo;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_nascita;

    private String luogo_nascita;

    @OneToOne
    private CartellaClinica cartella_clinica;

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

    /**
     * Get the value of cartella_clinica
     *
     * @return the value of cartella_clinica
     */
    public CartellaClinica getCartella_clinica() {
        return cartella_clinica;
    }

    /**
     * Set the value of cartella_clinica
     *
     * @param cartella_clinica new value of cartella_clinica
     */
    public void setCartella_clinica(CartellaClinica cartella_clinica) {
        this.cartella_clinica = cartella_clinica;
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
        if (!(object instanceof Paziente)) {
            return false;
        }
        Paziente other = (Paziente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persone.Paziente[ id=" + id + " ]";
    }

}
