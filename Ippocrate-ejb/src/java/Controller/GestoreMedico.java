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
import Entity.PazienteFacadeLocal;
import Entity.PrescrizioneMedica;
import Entity.PrescrizioneMedicaFacadeLocal;
import Entity.RefertoMedico;
import Entity.RefertoMedicoFacadeLocal;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreMedico implements GestoreMedicoLocal {

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @EJB
    private PrescrizioneMedicaFacadeLocal prescrizioneMedicaFacade;
    @EJB
    private RefertoMedicoFacadeLocal refertoMedicoFacade;
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

    @Override
    public List<RefertoMedico> aggiungiReferto(Medico m, int iPrest, String diagn,
            Paziente p, String file, String d, String medic, int numConf, String dataScadenza) {
        RefertoMedico rm = new RefertoMedico();
        rm.setMedico(m);
        rm.setTipoVisita(m.getMiePrestazioni().get(iPrest));
        rm.setDiagnosi(diagn);
        rm.setPaziente(p);
        rm.setLista_images(file);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat ndf = new SimpleDateFormat("yyyy-MM-dd");

        Date dataVisita = new Date();
        try {
            dataVisita = df.parse(d);
            String dTemp = new SimpleDateFormat("yyyy-MM-dd").format(dataVisita);
            dataVisita = ndf.parse(dTemp);
        } catch (ParseException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        rm.setDataVisita(dataVisita);

        List<PrescrizioneMedica> lpm = new ArrayList();
        PrescrizioneMedica pm = new PrescrizioneMedica();

        Date dataScad = new Date();
        try {
            dataScad = df.parse(dataScadenza);
            String dTemp = new SimpleDateFormat("yyyy-MM-dd").format(dataScad);
            dataScad = ndf.parse(dTemp);
        } catch (ParseException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        pm.setData_scadenza(dataScad);

        pm.setReferto(rm);
        pm.setPaziente(p);
        pm.setMedicinale(medic);
        pm.setNumero_confezioni(numConf);
        pm.setData_prescrizione(dataVisita);
        //pm.setConsegnata("NO");
        pm.setMedico(m);
        lpm.add(pm);

        rm.setLista_prescrizioni(lpm);

        refertoMedicoFacade.create(rm);
        prescrizioneMedicaFacade.create(pm);
        CartellaClinica cc = cartellaClinicaFacade.find(p.getCartella_clinica().getId());
        List<RefertoMedico> lrm = p.getCartella_clinica().getLista_referti();
        lrm.add(rm);
        cc.setLista_referti(lrm);

        return lrm;
    }

    @Override
    public CartellaClinica ottieniCCPaziente(long idP) {
        return pazienteFacade.find(idP).getCartella_clinica();
    }

}
