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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author toby
 */
@Entity
public class Sala implements Serializable {

    private static final long serialVersionUID = 1L;
    @ManyToOne
    private StudioMedico studioMedico;
    @ManyToOne
    private Reparto reparto;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToMany
    private List<PrestazioneSala> lista_prestazioni;

    private String tipoLaboratorio;
    @OneToOne
    private Medico medico_responsabile;

    public void addListaPrestazioni(List<PrestazioneSala> prest) {
        lista_prestazioni.addAll(prest);
    }

    public StudioMedico getStudioMedico() {
        return studioMedico;
    }

    public void setStudioMedico(StudioMedico studioMedico) {
        this.studioMedico = studioMedico;
    }

    public Reparto getReparto() {
        return reparto;
    }

    public void setReparto(Reparto reparto) {
        this.reparto = reparto;
    }

    /**
     * Get the value of medico_responsabile
     *
     * @return the value of medico_responsabile
     */
    public Medico getMedico_responsabile() {
        return medico_responsabile;
    }

    /**
     * Set the value of medico_responsabile
     *
     * @param medico_responsabile new value of medico_responsabile
     */
    public void setMedico_responsabile(Medico medico_responsabile) {
        this.medico_responsabile = medico_responsabile;
    }

    /**
     * Get the value of lista_prestazioni
     *
     * @return the value of lista_prestazioni
     */
    public List<PrestazioneSala> getLista_prestazioni() {
        return lista_prestazioni;
    }

    /**
     * Set the value of lista_prestazioni
     *
     * @param lista_prestazioni new value of lista_prestazioni
     */
    public void setLista_prestazioni(List<PrestazioneSala> lista_prestazioni) {
        this.lista_prestazioni = lista_prestazioni;
    }

    /**
     * Get the value of tipoLaboratorio
     *
     * @return the value of tipoLaboratorio
     */
    public String getTipoLaboratorio() {
        return tipoLaboratorio;
    }

    /**
     * Set the value of tipoLaboratorio
     *
     * @param tipoLaboratorio new value of tipoLaboratorio
     */
    public void setTipoLaboratorio(String tipoLaboratorio) {
        this.tipoLaboratorio = tipoLaboratorio;
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
    public String toString() {
        return "Sala [" + "id " + id + " " + "lista_prestazioni " + lista_prestazioni + " " + "medico_responsabile " + medico_responsabile + " " + "tipoLaboratorio " + tipoLaboratorio + "]";
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

}
