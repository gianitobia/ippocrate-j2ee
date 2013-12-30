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
import javax.persistence.OneToOne;

/**
 *
 * @author toby
 */
@Entity
public class RefertoMedico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Medico medico;

    @OneToOne
    private Prestazione tipoVisita;

    @OneToMany
    private List<PrescrizioneMedica> lista_prescrizioni;

    private String diagnosi;

    @OneToOne
    private Paziente paziente;

    private List<String> lista_images;

    /**
     * Get the value of lista_prescrizioni
     *
     * @return the value of lista_prescrizioni
     */
    public List<PrescrizioneMedica> getLista_prescrizioni() {
        return lista_prescrizioni;
    }

    /**
     * Set the value of lista_prescrizioni
     *
     * @param lista_prescrizioni new value of lista_prescrizioni
     */
    public void setLista_prescrizioni(List<PrescrizioneMedica> lista_prescrizioni) {
        this.lista_prescrizioni = lista_prescrizioni;
    }

    /**
     * Get the value of lista_images
     *
     * @return the value of lista_images
     */
    public List<String> getLista_images() {
        return lista_images;
    }

    /**
     * Set the value of lista_images
     *
     * @param lista_images new value of lista_images
     */
    public void setLista_images(List<String> lista_images) {
        this.lista_images = lista_images;
    }

    /**
     * Get the value of medico
     *
     * @return the value of medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Set the value of medico
     *
     * @param medico new value of medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    /**
     * Get the value of tipoVisita
     *
     * @return the value of tipoVisita
     */
    public Prestazione getTipoVisita() {
        return tipoVisita;
    }

    /**
     * Set the value of tipoVisita
     *
     * @param tipoVisita new value of tipoVisita
     */
    public void setTipoVisita(Prestazione tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    /**
     * Get the value of diagnosi
     *
     * @return the value of diagnosi
     */
    public String getDiagnosi() {
        return diagnosi;
    }

    /**
     * Set the value of diagnosi
     *
     * @param diagnosi new value of diagnosi
     */
    public void setDiagnosi(String diagnosi) {
        this.diagnosi = diagnosi;
    }

    /**
     * Get the value of paziente
     *
     * @return the value of paziente
     */
    public Paziente getPaziente() {
        return paziente;
    }

    /**
     * Set the value of paziente
     *
     * @param paziente new value of paziente
     */
    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
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
        if (!(object instanceof RefertoMedico)) {
            return false;
        }
        RefertoMedico other = (RefertoMedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RefertoMedico [" + "id " + id + " " + "diagnosi " + diagnosi + " " + "lista_prescrizioni " + lista_prescrizioni + " " + "medico " + medico + " " + "paziente " + paziente + " " + "tipoVisita " + tipoVisita + "]";
    }

}
