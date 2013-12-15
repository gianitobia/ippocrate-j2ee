/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StruttureMediche;

import Persone.Medico;
import Persone.Paziente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author toby
 */
@Entity
public class Reparto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Medico> lista_medici;

    @OneToMany
    private List<Sala> lista_sale;

    @OneToMany
    private List<Paziente> lista_pazienti;
    @OneToOne
    private Medico primario;

    /**
     * Get the value of primario
     *
     * @return the value of primario
     */
    public Medico getPrimario() {
        return primario;
    }

    /**
     * Set the value of primario
     *
     * @param primario new value of primario
     */
    public void setPrimario(Medico primario) {
        this.primario = primario;
    }

    /**
     * Get the value of lista_medici
     *
     * @return the value of lista_medici
     */
    public List<Medico> getLista_medici() {
        return lista_medici;
    }

    /**
     * Set the value of lista_medici
     *
     * @param lista_medici new value of lista_medici
     */
    public void setLista_medici(List<Medico> lista_medici) {
        this.lista_medici = lista_medici;
    }

    /**
     * Get the value of lista_sale
     *
     * @return the value of lista_sale
     */
    public List<Sala> getLista_sale() {
        return lista_sale;
    }

    /**
     * Set the value of lista_sale
     *
     * @param lista_sale new value of lista_sale
     */
    public void setLista_sale(List<Sala> lista_sale) {
        this.lista_sale = lista_sale;
    }

    /**
     * Get the value of lista_pazienti
     *
     * @return the value of lista_pazienti
     */
    public List<Paziente> getLista_pazienti() {
        return lista_pazienti;
    }

    /**
     * Set the value of lista_pazienti
     *
     * @param lista_pazienti new value of lista_pazienti
     */
    public void setLista_pazienti(List<Paziente> lista_pazienti) {
        this.lista_pazienti = lista_pazienti;
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
        if (!(object instanceof Reparto)) {
            return false;
        }
        Reparto other = (Reparto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "StruttureMediche.Reparto[ id=" + id + " ]";
    }

}
