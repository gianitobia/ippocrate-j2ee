/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Marco
 */
public class RefertoMedicoTransient {

    private String cognomeM;

    private String tipoVisita;

    private Date dataVisita;

    private List<PrescrizioneMedicaTransient> lista_PMTransient;

    private String diagnosi;

    private String lista_images;

    /**
     * Get the value of lista_images
     *
     * @return the value of lista_images
     */
    public String getLista_images() {
        return lista_images;
    }

    /**
     * Set the value of lista_images
     *
     * @param lista_images new value of lista_images
     */
    public void setLista_images(String lista_images) {
        this.lista_images = lista_images;
    }

    /**
     * Get the value of dataVisita
     *
     * @return the value of dataVisita
     */
    public Date getDataVisita() {
        return dataVisita;
    }

    /**
     * Set the value of dataVisita
     *
     * @param dataVisita new value of dataVisita
     */
    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
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
     * Get the value of lista_PMTransient
     *
     * @return the value of lista_PMTransient
     */
    public List<PrescrizioneMedicaTransient> getLista_PMTransient() {
        return lista_PMTransient;
    }

    /**
     * Set the value of lista_PMTransient
     *
     * @param lista_PMTransient new value of lista_PMTransient
     */
    public void setLista_PMTransient(List<PrescrizioneMedicaTransient> lista_PMTransient) {
        this.lista_PMTransient = lista_PMTransient;
    }

    /**
     * Get the value of tipoVisita
     *
     * @return the value of tipoVisita
     */
    public String getTipoVisita() {
        return tipoVisita;
    }

    /**
     * Set the value of tipoVisita
     *
     * @param tipoVisita new value of tipoVisita
     */
    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    /**
     * Get the value of cognomeM
     *
     * @return the value of cognomeM
     */
    public String getCognomeM() {
        return cognomeM;
    }

    /**
     * Set the value of cognomeM
     *
     * @param cognomeM new value of cognomeM
     */
    public void setCognomeM(String cognomeM) {
        this.cognomeM = cognomeM;
    }

}
