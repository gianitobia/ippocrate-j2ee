/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author toby
 */
@Entity
public class MedicoEsterno extends Medico implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private StudioMedico studioMedico;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany
    private List<Paziente> lista_pazienti;

    public StudioMedico getStudioMedico() {
        return studioMedico;
    }

    public void setStudioMedico(StudioMedico studioMedico) {
        this.studioMedico = studioMedico;
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

    @Override
    public Long getId() {
        return id;
    }

    @Override
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
        if (!(object instanceof MedicoEsterno)) {
            return false;
        }
        MedicoEsterno other = (MedicoEsterno) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MedicoEsterno [" + "id " + id + " " + "getCognome " + getCognome() + " " + "getData_nascita " + getData_nascita() + " " + "getNome " + getNome() + " " + "getPassword " + getPassword() + " " + "getPin_code " + getPin_code() + " " + "getPrenotazioni " + getPrenotazioni() + " " + "getSpecializzazione " + getSpecializzazione() + " " + "getUsername " + getUsername() + "]";
    }

}
