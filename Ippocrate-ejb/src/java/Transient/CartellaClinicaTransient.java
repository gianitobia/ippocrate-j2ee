/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transient;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Marco
 */
@Stateless
@LocalBean
public class CartellaClinicaTransient {

    private Long id;

    private String anamnesi;

    private List<RefertoMedicoTransient> referti;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnamnesi() {
        return anamnesi;
    }

    public void setAnamnesi(String anamnesi) {
        this.anamnesi = anamnesi;
    }

    public List<RefertoMedicoTransient> getReferti() {
        return referti;
    }

    public void setReferti(List<RefertoMedicoTransient> referti) {
        this.referti = referti;
    }

}
