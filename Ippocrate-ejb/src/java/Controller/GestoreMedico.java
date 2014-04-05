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
import Entity.Ospedale;
import Entity.OspedaleFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.PrescrizioneMedica;
import Entity.PrescrizioneMedicaFacadeLocal;
import Entity.RefertoMedico;
import Entity.RefertoMedicoFacadeLocal;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import HttpClient.HttpCalendarClient;
import Utility.FileUpload;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.servlet.http.Part;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreMedico implements GestoreMedicoLocal {
    @EJB
    private OspedaleFacadeLocal ospedaleFacade;

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
    public List<Paziente> ottieniMieiPazienti(Long medicoId) {
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
    public CartellaClinica modificaAnamnesi(Long ccId, String nuovaAnamnesi) {
        CartellaClinica cc = cartellaClinicaFacade.find(ccId);
        cc.setAnamnesi(nuovaAnamnesi);
        return cc;
    }

    @Override
    public List<RefertoMedico> aggiungiReferto(Medico m, int iPrest, String diagn,
            Paziente p, Part filePart, String file, String d, String medic, int numConf, String dataScadenza) {
        RefertoMedico rm = new RefertoMedico();
        rm.setMedico(m);
        rm.setTipoVisita(m.getPrestazioniEffettuabili().get(iPrest));
        rm.setDiagnosi(diagn);
        rm.setPaziente(p);

        try {
            String path = FileUpload.caricaFile(filePart, file);
            rm.setLista_images(path);
        } catch (IOException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

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
        //pm.setConsegnata("no");
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
    public CartellaClinica ottieniCCPaziente(Long idP) {
        return pazienteFacade.find(idP).getCartella_clinica();
    }

    @Override
    public RefertoMedico modificaDettagliRefMedico(Long refId, Medico m, int iPrest, String diagn, String d) {
        RefertoMedico rm = refertoMedicoFacade.find(refId);
        rm.setTipoVisita(m.getPrestazioniEffettuabili().get(iPrest));
        rm.setDiagnosi(diagn);

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

        return rm;
    }

    @Override
    public RefertoMedico aggiungiMultimediaRefMedico(Long idReferto, Part filePart, String fileName) {
        RefertoMedico rm = refertoMedicoFacade.find(idReferto);
        try {
            String newFile = FileUpload.caricaFile(filePart, fileName);
            String oldFiles = rm.getLista_images();
            if (oldFiles.equals("") == false) {
                rm.setLista_images(oldFiles + ";" + newFile);
            } else {
                rm.setLista_images(newFile);
            }
        } catch (IOException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rm;
    }

    @Override
    public PrescrizioneMedica modificaPresMedica(Long idPres, String medic, int numConf, String dataPres, String dataScad) {
        PrescrizioneMedica pm = prescrizioneMedicaFacade.find(idPres);
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat ndf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataScadenza = new Date();
        Date dataPrescrizione = new Date();
        try {
            dataPrescrizione = df.parse(dataPres);
            String dTemp1 = new SimpleDateFormat("yyyy-MM-dd").format(dataPrescrizione);
            dataPrescrizione = ndf.parse(dTemp1);
            dataScadenza = df.parse(dataScad);
            String dTemp2 = new SimpleDateFormat("yyyy-MM-dd").format(dataScadenza);
            dataScadenza = ndf.parse(dTemp2);
        } catch (ParseException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        pm.setData_prescrizione(dataPrescrizione);
        pm.setData_scadenza(dataScadenza);
        pm.setMedicinale(medic);
        pm.setNumero_confezioni(numConf);

        return pm;
    }

    @Override
    public PrescrizioneMedica aggiungiPresMedica(Long idReferto, String medic, int numConf, String dataPres, String dataScad, Paziente paziente, Medico m) {
        RefertoMedico rm = refertoMedicoFacade.find(idReferto);
        List<PrescrizioneMedica> lpm = rm.getLista_prescrizioni();

        PrescrizioneMedica pm = new PrescrizioneMedica();
        pm.setMedicinale(medic);
        pm.setNumero_confezioni(numConf);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DateFormat ndf = new SimpleDateFormat("yyyy-MM-dd");
        Date dataScadenza = new Date();
        Date dataPrescrizione = new Date();
        try {
            dataPrescrizione = df.parse(dataPres);
            String dTemp1 = new SimpleDateFormat("yyyy-MM-dd").format(dataPrescrizione);
            dataPrescrizione = ndf.parse(dTemp1);
            dataScadenza = df.parse(dataScad);
            String dTemp2 = new SimpleDateFormat("yyyy-MM-dd").format(dataScadenza);
            dataScadenza = ndf.parse(dTemp2);
        } catch (ParseException ex) {
            Logger.getLogger(GestoreMedico.class.getName()).log(Level.SEVERE, null, ex);
        }
        pm.setData_prescrizione(dataPrescrizione);
        pm.setData_scadenza(dataScadenza);
        pm.setMedico(m);
        pm.setPaziente(paziente);
        pm.setReferto(rm);
        prescrizioneMedicaFacade.create(pm);
        lpm.add(pm);

        return pm;
    }

    @Override
    public List<String> ottieniMultimedia(Long idRM) {
        RefertoMedico rm = refertoMedicoFacade.find(idRM);
        String s = rm.getLista_images();

        List<String> multimedia = new ArrayList<>();

        if (s != null && s.equals("") == false) {
            String[] temp = s.split(";");
            multimedia.addAll(Arrays.asList(temp));
        }

        return multimedia;
    }

    @Override
    public String getAgenda(Long medicoId) {

        HttpCalendarClient conn = new HttpCalendarClient();
        Medico m = medicoFacade.find(medicoId);
        String struttura = "";
        switch (m.getClass().getName()) {
            case "MedicoOspedaliero":
                //devo partire dalla strutture xke non c'e' il doppio riferimento
                for (Ospedale o : ospedaleFacade.findAll()) {
                    for (Reparto r : o.getLista_reparti()) {
                        if (r.getLista_medici().contains(((MedicoOspedaliero) m))) {
                            struttura = o.getNome();
                            break;
                        }
                    }
                    //esco dal ciclo degli ospedali se ho trovato la strutture che mi serve
                    if(!struttura.equals("")) break;
                }   
                break;
            case "MedicoEsterno":
                //prendo direttamente il nome dello studio medico
                struttura = ((MedicoEsterno) m).getStudioMedico().getNome();
                break;
        }
        
        String agendaSrc = conn.get_calendar_id(struttura, m.getUsername());
        return agendaSrc;
    }
}
