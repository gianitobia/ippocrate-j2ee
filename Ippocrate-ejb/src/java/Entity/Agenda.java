/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author toby
 */
@Entity
public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String developer_key;

    private String client_id;

    private String secret_key;

    private String id_calendario;

    private String password;

    private String nome_utente;

    /**
     * Get the value of developer_key
     *
     * @return the value of developer_key
     */
    public String getDeveloper_key() {
        return developer_key;
    }

    /**
     * Set the value of developer_key
     *
     * @param developer_key new value of developer_key
     */
    public void setDeveloper_key(String developer_key) {
        this.developer_key = developer_key;
    }

    /**
     * Get the value of client_id
     *
     * @return the value of client_id
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * Set the value of client_id
     *
     * @param client_id new value of client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * Get the value of secret_key
     *
     * @return the value of secret_key
     */
        public String getSecret_key() {
            return secret_key;
        }

    /**
     * Set the value of secret_key
     *
     * @param secret_key new value of secret_key
     */
        public void setSecret_key(String secret_key) {
            this.secret_key = secret_key;
        }

    /**
     * Get the value of id_calendario
     *
     * @return the value of id_calendario
     */
        public String getId_calendario() {
            return id_calendario;
        }

    /**
     * Set the value of id_calendario
     *
     * @param id_calendario new value of id_calendario
     */
    public void setId_calendario(String id_calendario) {
        this.id_calendario = id_calendario;
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
     * Get the value of nome_utente
     *
     * @return the value of nome_utente
     */
    public String getNome_utente() {
        return nome_utente;
    }

    /**
     * Set the value of nome_utente
     *
     * @param nome_utente new value of nome_utente
     */
    public void setNome_utente(String nome_utente) {
        this.nome_utente = nome_utente;
    }

    //Aggiungere informazioni account google calendar

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
        if (!(object instanceof Agenda)) {
            return false;
        }
        Agenda other = (Agenda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Organizzazione.Agenda[ id=" + id + " ]";
    }
    
}
