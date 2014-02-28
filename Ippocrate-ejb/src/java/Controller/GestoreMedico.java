/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.CartellaClinica;
import Entity.CartellaClinicaFacadeLocal;
import Entity.Medico;
import Entity.MedicoEsterno;
import Entity.MedicoFacadeLocal;
import Entity.MedicoOspedaliero;
import Entity.Paziente;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreMedico implements GestoreMedicoLocal {
    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;

    @EJB
    private RepartoFacadeLocal repartoFacade;

    @EJB
    private MedicoFacadeLocal medicoFacade;

    @Override
    public List<Paziente> ottieniMieiPazienti(long medicoId) {
        Medico m = medicoFacade.find(medicoId);
        List<Paziente> lp = new ArrayList();

        if (m.getClass().getName().equals("Entity.MedicoEsterno")) {
            return ((MedicoEsterno) m).getLista_pazienti();
        } else if (m.getClass().getName().equals("Entity.MedicoOspedaliero")) {
            List<Reparto> lr = repartoFacade.findAll();
            for (Reparto r : lr) {
                List<MedicoOspedaliero> lmo = r.getLista_medici();
                for (MedicoOspedaliero mo : lmo) {
                    if (m.getId().equals(mo.getId())) {
                        lp.addAll(r.getLista_pazienti());
                        break;
                    }
                }
            }
        }

        return lp;
    }

    @Override
    public CartellaClinica modificaAnamnesi(long ccId, String nuovaAnamnesi) {
        CartellaClinica cc = cartellaClinicaFacade.find(ccId);
        cc.setAnamnesi(nuovaAnamnesi);
        return cc;
    }

}
