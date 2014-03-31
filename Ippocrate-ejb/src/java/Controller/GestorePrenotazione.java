/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medico;
import Entity.MedicoEsterno;
import Entity.MedicoOspedaliero;
import Entity.Ospedale;
import Entity.Prenotazione;
import Entity.PrenotazioneFacadeLocal;
import Entity.PrenotazioneMedico;
import Entity.PrenotazioneSala;
import Transient.PrenotazioneTransient;
import Entity.Prestazione;
import Entity.PrestazioneFacadeLocal;
import Entity.PrestazioneMedico;
import Entity.PrestazioneSala;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StrutturaMedica;
import Entity.StudioMedico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestorePrenotazione implements GestorePrenotazioneLocal {

    @EJB
    private RepartoFacadeLocal repartoFacade;

    @EJB
    private SalaFacadeLocal salaFacade;

    @EJB
    private PrestazioneFacadeLocal prestazioneFacade;

    @EJB
    private PrenotazioneFacadeLocal prenotazioneFacade;

    @Override
    public List<PrenotazioneTransient> ottieniPrenotazioni(Long pazienteId) {
        ArrayList l = new ArrayList();

        for (Prenotazione p : prenotazioneFacade.findAll()) {
            if (p.getPaziente().getId().equals(pazienteId)) {
                PrenotazioneTransient pt = new PrenotazioneTransient();
                pt.setId(p.getId());
                pt.setNomeSM(p.getStruttura_medica().getNome());
                pt.setIndirizzoSM(p.getStruttura_medica().getIndirizzo());
                pt.setData(p.getData_prenotazione());

                if (p.getClass().getName().equals("Entity.PrenotazioneMedico")) {
                    pt.setTipo("M");
                    pt.setNomePr(((PrenotazioneMedico) p).getTipo_prestazione().getNome());
                    pt.setDurataPr(((PrenotazioneMedico) p).getTipo_prestazione().getDurata());
                    Medico m = ((PrenotazioneMedico) p).getMedico();
                    pt.setCognomeM(m.getCognome());
                    if (m.getClass().getName().equals("Entity.MedicoOspedaliero")) {
                        pt.setUfficioM(((MedicoOspedaliero) m).getNum_ufficio());
                    }
                } else {
                    pt.setTipo("S");
                    pt.setNomePr(((PrenotazioneSala) p).getTipo_prestazione().getNome());
                    pt.setDurataPr(((PrenotazioneSala) p).getTipo_prestazione().getDurata());
                    pt.setTipoLaboratorioS(((PrenotazioneSala) p).getSala().getTipoLaboratorio());
                }
                l.add(pt);
            }
        }
        return l;
    }

    @Override
    public List<Prestazione> ottieniPrestazioniPrenotabili() {
        List<Prestazione> prestazioni = prestazioneFacade.findAll();
        List<Prestazione> prestazioniDisp = new ArrayList<>();
        for(Prestazione p : prestazioni){
            switch (p.getClass().getName()) {
                case "Entity.PrestazioneSala":
                    {
                        PrestazioneSala prest = (PrestazioneSala) p;
                        if(!prest.getLista_sale().isEmpty())
                            prestazioniDisp.add(p);
                        break;
                        
                    }
                case "Entity.PrestazioneMedico":
                    {
                       PrestazioneMedico prest = (PrestazioneMedico) p;
                        if(!prest.getLista_medici().isEmpty())
                            prestazioniDisp.add(p);
                        break;
                    }
            }
        }
        return prestazioniDisp;
    }

    @Override
    public List<StrutturaMedica> ottieniStruttureMedichePerPrestazione(Prestazione p) {
        List<StrutturaMedica> lsm = new ArrayList();
        switch (p.getClass().getName()) {
            case "Entity.PrestazioneSala":
                List<Sala> ls = ((PrestazioneSala) p).getLista_sale();
                for (Sala s : ls) {
                    if (s.getStudioMedico() != null) {
                        lsm.add(s.getStudioMedico());
                    } else if (s.getReparto() != null) {
                        lsm.add(s.getReparto().getOspedale());
                    }
                }   break;
            case "Entity.PrestazioneMedico":
                List<Medico> lm = ((PrestazioneMedico) p).getLista_medici();
                for (Medico m : lm) {
                    if (!lsm.contains(((MedicoEsterno) m).getStudioMedico()) && m.getClass().getName().equals("Entity.MedicoEsterno")) {
                        lsm.add(((MedicoEsterno) m).getStudioMedico());
                    } else if (m.getClass().getName().equals("Entity.MedicoOspedaliero")) {
                        List<Reparto> lr = repartoFacade.findAll();
                        for (Reparto r : lr) {
                            List<MedicoOspedaliero> lmo = r.getLista_medici();
                            for (MedicoOspedaliero mo : lmo) {
                                if (m.getId().equals(mo.getId()) && !lsm.contains(r.getOspedale())) {
                                    lsm.add(r.getOspedale());
                                    break;
                                }
                            }
                        }
                    }
                }   break;
        }
        return lsm;
    }

    @Override
    public List<Medico> ottieniMediciPerPrestazioneEStrutturaMedica(Prestazione p, StrutturaMedica sm) {
        List<Medico> lm = new ArrayList();

        if (sm.getClass().getName().equals("Entity.StudioMedico")) {
            List<MedicoEsterno> lme = ((StudioMedico) sm).getLista_medici();
            for (MedicoEsterno me : lme) {
                List<PrestazioneMedico> lpm = me.getPrestazioniEffettuabili();
                for (PrestazioneMedico pm : lpm) {
                    if (p.getId().equals(pm.getId())) { //e' possibile controllare il nome anziche' id
                        lm.add(me);
                        break;
                    }
                }
            }
        } else if (sm.getClass().getName().equals("Entity.Ospedale")) {
            List<Reparto> lr = ((Ospedale) sm).getLista_reparti();
            for (Reparto r : lr) {
                List<MedicoOspedaliero> lmo = r.getLista_medici();
                for (MedicoOspedaliero mo : lmo) {
                    List<PrestazioneMedico> lpm = mo.getPrestazioniEffettuabili();
                    for (PrestazioneMedico pm : lpm) {
                        if (p.getId().equals(pm.getId())) { //e' possibile controllare il nome anziche' id
                            lm.add(mo);
                            break;
                        }
                    }
                }
            }
        }
        return lm;
    }

    @Override
    public List<Sala> ottieniSalePerPrestazioneEStrutturaMedica(Prestazione p, StrutturaMedica sm) {
        List<Sala> ls = new ArrayList();

        if (sm.getClass().getName().equals("Entity.StudioMedico")) {
            List<Sala> lis = ((StudioMedico) sm).getLista_sale();
            for (Sala s : lis) {
                List<PrestazioneSala> lps = s.getLista_prestazioni();
                for (PrestazioneSala ps : lps) {
                    if (p.getId().equals(ps.getId())) { //e' possibile controllare il nome anziche' id
                        ls.add(s);
                        break;
                    }
                }
            }
        } else if (sm.getClass().getName().equals("Entity.Ospedale")) {
            List<Reparto> lr = ((Ospedale) sm).getLista_reparti();
            for (Reparto r : lr) {
                List<Sala> lis = r.getLista_sale();
                for (Sala s : lis) {
                    List<PrestazioneSala> lps = s.getLista_prestazioni();
                    for (PrestazioneSala ps : lps) {
                        if (p.getId().equals(ps.getId())) { //e' possibile controllare il nome anziche' id
                            ls.add(s);
                            break;
                        }
                    }
                }
            }
        }
        return ls;
    }

}
