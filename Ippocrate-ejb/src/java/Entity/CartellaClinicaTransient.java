/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;

import java.util.List;

/**
 *
 * @author Marco
 */
public class CartellaClinicaTransient {
    
    private String anamnesi;
    private List<RefertoMedicoTransient> referti;

    /**
     * Get the value of referti
     *
     * @return the value of referti
     */
    public List<RefertoMedicoTransient> getReferti() {
        return referti;
    }

    /**
     * Set the value of referti
     *
     * @param referti new value of referti
     */
    public void setReferti(List<RefertoMedicoTransient> referti) {
        this.referti = referti;
    }


    /**
     * Get the value of anamnesi
     *
     * @return the value of anamnesi
     */
    public String getAnamnesi() {
        return anamnesi;
    }

    /**
     * Set the value of anamnesi
     *
     * @param anamnesi new value of anamnesi
     */
    public void setAnamnesi(String anamnesi) {
        this.anamnesi = anamnesi;
    }

}
