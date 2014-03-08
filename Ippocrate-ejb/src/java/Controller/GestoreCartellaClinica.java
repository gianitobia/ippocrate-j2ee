/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.CartellaClinica;
import Transient.CartellaClinicaTransient;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.PrescrizioneMedica;
import Transient.PrescrizioneMedicaTransient;
import Entity.RefertoMedico;
import Transient.RefertoMedicoTransient;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreCartellaClinica implements GestoreCartellaClinicaLocal {

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @Override
    public CartellaClinicaTransient ottieniCC(long pazienteId) {
        CartellaClinicaTransient cct = new CartellaClinicaTransient();

        Paziente user = pazienteFacade.find(new Long(pazienteId));
        CartellaClinica cc = user.getCartella_clinica();

        cct.setId(cc.getId());
        cct.setAnamnesi(cc.getAnamnesi());
        ArrayList referti = new ArrayList();
        cct.setReferti(referti);
        for (RefertoMedico rm : cc.getLista_referti()) {
            RefertoMedicoTransient rmt = new RefertoMedicoTransient();
            rm.setId(rm.getId());
            rmt.setCognomeM(rm.getMedico().getCognome());
            rmt.setTipoVisita(rm.getTipoVisita().getNome());
            rmt.setDataVisita(rm.getDataVisita());
            rmt.setDiagnosi(rm.getDiagnosi());
            rmt.setLista_images(rm.getLista_images());

            ArrayList prescrizioni = new ArrayList();
            rmt.setLista_PMTransient(prescrizioni);

            for (PrescrizioneMedica pm : rm.getLista_prescrizioni()) {
                PrescrizioneMedicaTransient pmt = new PrescrizioneMedicaTransient();
                pmt.setId(pm.getId());
                pmt.setDataPrescrizione(pm.getData_prescrizione());
                pmt.setDataScadenza(pm.getData_scadenza());
                pmt.setMedicinale(pm.getMedicinale());
                pmt.setNumConfezioni(pm.getNumero_confezioni());
                pmt.setConsegnata(pm.getConsegnata());

                prescrizioni.add(pmt);
            }//chiusura for sulle prescrizioni mediche
            referti.add(rmt);
        }//chiusura for sui referti medici

        return cct;
    }

    @Override
    public List<PrescrizioneMedicaTransient> ottieniPM(Long pazienteId) {
        return null;
    }

}
