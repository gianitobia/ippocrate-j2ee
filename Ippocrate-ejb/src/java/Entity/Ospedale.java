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
import javax.persistence.OneToMany;

/**
 *
 * @author toby
 */
@Entity
public class Ospedale extends StrutturaMedica implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "ospedale")
    private List<Reparto> lista_reparti;

    /**
     * Get the value of lista_reparti
     *
     * @return the value of lista_reparti
     */
    public List<Reparto> getLista_reparti() {
        return lista_reparti;
    }

    /**
     * Set the value of lista_reparti
     *
     * @param lista_reparti new value of lista_reparti
     */
    public void setLista_reparti(List<Reparto> lista_reparti) {
        this.lista_reparti = lista_reparti;
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
        if (!(object instanceof Ospedale)) {
            return false;
        }
        Ospedale other = (Ospedale) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ospedale [" + "id " + id + " " + "getIndirizzo " + getIndirizzo() + " " + "getNome " + getNome() + "]";
    }

}
