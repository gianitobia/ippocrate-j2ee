/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author toby
 */
@Entity
public abstract class Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String cognome;

    private String specializzazione;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_nascita;

    private String username;

    private String password;

    private String pin_code;

    @OneToOne
    private Agenda visite;

    @ManyToMany
    private List<PrestazioneMedico> prestazioniEffettuabili;

    /**
     * Get the value of prestazioniEffettuabili
     *
     * @return the value of prestazioniEffettuabili
     */
    public List<PrestazioneMedico> getPrestazioniEffettuabili() {
        return prestazioniEffettuabili;
    }

    /**
     * Set the value of prestazioniEffettuabili
     *
     * @param prestazioniEffettuabili new value of prestazioniEffettuabili
     */
    public void setPrestazioniEffettuabili(List<PrestazioneMedico> prestazioniEffettuabili) {
        this.prestazioniEffettuabili = prestazioniEffettuabili;
    }

    public Agenda getVisite() {
        return visite;
    }

    public void setVisite(Agenda visite) {
        this.visite = visite;
    }

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of pin_code
     *
     * @return the value of pin_code
     */
    public String getPin_code() {
        return pin_code;
    }

    /**
     * Set the value of pin_code
     *
     * @param pin_code new value of pin_code
     */
    public void setPin_code(String pin_code) {
        this.pin_code = pin_code;
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
        if (!(object instanceof Medico)) {
            return false;
        }
        Medico other = (Medico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Medico [" + "id " + id + " " + "cognome " + cognome + " " + "data_nascita " + data_nascita + " " + "nome " + nome + " " + "password " + password + " " + "pin_code " + pin_code + " " + "specializzazione " + specializzazione + " " + "username " + username + "]";
    }

}
