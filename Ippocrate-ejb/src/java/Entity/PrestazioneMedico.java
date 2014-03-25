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
import javax.persistence.ManyToMany;

/**
 *
 * @author Marco
 */
@Entity
public class PrestazioneMedico extends Prestazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "prestazioniEffettuabili")
    private List<Medico> lista_medici;

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
        if (!(object instanceof PrestazioneMedico)) {
            return false;
        }
        PrestazioneMedico other = (PrestazioneMedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PrestazioneMedico[ id=" + id + " ]";
    }

    public void addMedico(Medico m) {
        lista_medici.add(m);
    }

}
