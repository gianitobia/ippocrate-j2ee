/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transient;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marco
 */
@Stateless
@LocalBean
public class RefertoMedicoTransient {

    private Long id;

    private String cognomeM;

    private String tipoVisita;

    private Date dataVisita;

    private List<PrescrizioneMedicaTransient> lista_PMTransient;

    private String diagnosi;

    private String lista_images;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCognomeM() {
        return cognomeM;
    }

    public void setCognomeM(String cognomeM) {
        this.cognomeM = cognomeM;
    }

    public String getTipoVisita() {
        return tipoVisita;
    }

    public void setTipoVisita(String tipoVisita) {
        this.tipoVisita = tipoVisita;
    }

    public Date getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(Date dataVisita) {
        this.dataVisita = dataVisita;
    }

    public List<PrescrizioneMedicaTransient> getLista_PMTransient() {
        return lista_PMTransient;
    }

    public void setLista_PMTransient(List<PrescrizioneMedicaTransient> lista_PMTransient) {
        this.lista_PMTransient = lista_PMTransient;
    }

    public String getDiagnosi() {
        return diagnosi;
    }

    public void setDiagnosi(String diagnosi) {
        this.diagnosi = diagnosi;
    }

    public String getLista_images() {
        return lista_images;
    }

    public void setLista_images(String lista_images) {
        this.lista_images = lista_images;
    }

}
