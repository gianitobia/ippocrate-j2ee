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
import Entity.PazienteFacadeLocal;
import Entity.Prenotazione;
import Entity.PrenotazioneFacadeLocal;
import Entity.PrenotazioneMedico;
import Entity.PrenotazioneMedicoFacadeLocal;
import Entity.PrenotazioneSala;
import Entity.PrenotazioneSalaFacadeLocal;
import Entity.Prestazione;
import Entity.PrestazioneFacadeLocal;
import Entity.PrestazioneMedico;
import Entity.PrestazioneMedicoFacadeLocal;
import Entity.PrestazioneSala;
import Entity.PrestazioneSalaFacadeLocal;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StrutturaMedica;
import Entity.StudioMedico;
import HttpClient.HttpCalendarClient;
import Transient.PrenotazioneTransient;
import static Utility.Gestore_Date.*;
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
    private PrenotazioneMedicoFacadeLocal prenotazioneMedicoFacade;
    @EJB
    private PrenotazioneSalaFacadeLocal prenotazioneSalaFacade;
    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @EJB
    private PrestazioneSalaFacadeLocal prestazioneSalaFacade;

    @EJB
    private PrestazioneMedicoFacadeLocal prestazioneMedicoFacade;

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
        List<PrestazioneMedico> prestazioniMedico = prestazioneMedicoFacade.findAll();
        List<PrestazioneSala> prestazioniSala = prestazioneSalaFacade.findAll();

        List<Prestazione> prestazioniDisp = new ArrayList<>();

//        List<Sala> sale = salaFacade.findAll();
//        for (Sala s : sale) {
//            List<PrestazioneSala> prest = s.getLista_prestazioni();
//            for (PrestazioneSala p : prest) {
//                if (!prestazioniDisp.contains(p)) {
//                    prestazioniDisp.add(p);
//                }
//            }
//        }
        for (PrestazioneSala p : prestazioniSala) {
            if (!p.getLista_sale().isEmpty()) {
                prestazioniDisp.add(p);
            }

        }
        for (PrestazioneMedico p : prestazioniMedico) {
            if (!p.getLista_medici().isEmpty()) {
                prestazioniDisp.add(p);
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
                }
                break;
            case "Entity.PrestazioneMedico":
                List<Medico> lm = ((PrestazioneMedico) p).getLista_medici();
                for (Medico m : lm) {
                    if (m.getClass().getName().equals("Entity.MedicoEsterno") && !lsm.contains(((MedicoEsterno) m).getStudioMedico())) {
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
                }
                break;
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

    @Override
    public boolean cancellaPrenotazione(Long idPaz, Long idPre) {
        Prenotazione pr = prenotazioneFacade.find(idPre);
        if (pr != null) {
            prenotazioneFacade.remove(pr);
            return true;
        }

        //effettuare la chiamata al WS Python per la cancellazione
        //della prenotazione anche su google calendar!!!!
        return false;
    }

    @Override
    public String creaPrenotazione(Prestazione prestazione, StrutturaMedica struttura, 
                                   Medico medico, Long id_utente, String data, String ora) {
        
        //formatto la data per la creazione dellévento
        String dt_event = generateStringForReservation(data , '/', ora);
        HttpCalendarClient client = new HttpCalendarClient();
        String result = "";
        switch (prestazione.getClass().getName()) {
            case "Entity.PrestazioneSala":
                PrenotazioneSala ps = new PrenotazioneSala();
                ps.setPaziente(pazienteFacade.find(id_utente));
                ps.setStruttura_medica(struttura);
                ps.setTipo_prestazione((PrestazioneSala) prestazione);
                ps.setSala(ottieniSalePerPrestazioneEStrutturaMedica(ps.getTipo_prestazione(), struttura).get(0));
                ps.setData_prenotazione(generateReservationFromString(dt_event));
                
                try {
                    ps.setGoogleId(client.create_event(ps));
                    prenotazioneSalaFacade.create(ps);
                    result = "Creazione effettuata con successo";
                }catch(Exception e) {
                    e.printStackTrace();
                    result = "Errore creazione fallita";
                }              
                break;
            case "Entity.PrestazioneMedico":
                PrenotazioneMedico pm = new PrenotazioneMedico();
                pm.setData_prenotazione(generateReservationFromString(dt_event));
                pm.setMedico(medico);
                pm.setTipo_prestazione((PrestazioneMedico) prestazione);
                pm.setPaziente(pazienteFacade.find(id_utente));
                pm.setStruttura_medica(struttura);
                try {
                    pm.setGoogleId(client.create_event(pm));
                    prenotazioneMedicoFacade.create(pm);
                    result = "Creazione effettuata con successo";
                }catch(Exception e) {
                    e.printStackTrace();
                    result = "Errore creazione fallita";
                }              
                break;
        }
        
        return result;
    }
    
    

}
