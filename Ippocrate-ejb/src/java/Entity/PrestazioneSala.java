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
public class PrestazioneSala extends Prestazione implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(mappedBy = "lista_prestazioni")
    private List<Sala> lista_sale;

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
        if (!(object instanceof PrestazioneSala)) {
            return false;
        }
        PrestazioneSala other = (PrestazioneSala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.PrestazioneSala[ id=" + id + " ]";
    }
    
}
