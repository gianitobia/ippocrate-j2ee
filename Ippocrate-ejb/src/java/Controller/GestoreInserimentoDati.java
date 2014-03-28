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
import Entity.MedicoEsternoFacadeLocal;
import Entity.MedicoFacadeLocal;
import Entity.MedicoOspedaliero;
import Entity.MedicoOspedalieroFacadeLocal;
import Entity.Ospedale;
import Entity.OspedaleFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.PrescrizioneMedica;
import Entity.PrescrizioneMedicaFacadeLocal;
import Entity.Prestazione;
import Entity.PrestazioneMedico;
import Entity.PrestazioneMedicoFacadeLocal;
import Entity.PrestazioneSala;
import Entity.PrestazioneSalaFacadeLocal;
import Entity.RefertoMedico;
import Entity.RefertoMedicoFacadeLocal;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StudioMedico;
import Entity.StudioMedicoFacadeLocal;
import static Utility.Gestore_Date.*;
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
public class GestoreInserimentoDati implements GestoreInserimentoDatiLocal {

    @EJB
    private RefertoMedicoFacadeLocal refertoMedicoFacade;
    @EJB
    private PrescrizioneMedicaFacadeLocal prescrizioneMedicaFacade;

    @EJB
    private MedicoFacadeLocal medicoFacade;

    @EJB
    private SalaFacadeLocal salaFacade;

    @EJB
    private RepartoFacadeLocal repartoFacade;
    @EJB
    private PrestazioneSalaFacadeLocal prestazioneSalaFacade;
    @EJB
    private PrestazioneMedicoFacadeLocal prestazioneMedicoFacade;
    @EJB
    private OspedaleFacadeLocal ospedaleFacade;
    @EJB
    private StudioMedicoFacadeLocal studioMedicoFacade;
    @EJB
    private MedicoEsternoFacadeLocal medicoEsternoFacade;
    @EJB
    private MedicoOspedalieroFacadeLocal medicoOspedalieroFacade;
    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;
    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @Override
    public Long addPaziente(String nome, String cognome, String cf, String password,
            String sesso, String indirizzo, Date data_nascita, String luogo_nascita) {
        Paziente p = new Paziente();
        p.setCf(cf);
        p.setPassword(password);
        p.setCognome(cognome);
        p.setNome(nome);
        p.setSesso(sesso);
        p.setData_nascita(data_nascita);
        p.setLuogo_nascita(luogo_nascita);
        p.setIndirizzo(indirizzo);
        pazienteFacade.create(p);
        return p.getId();
    }

    @Override
    public Long addMedicoEsterno(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code) {
        MedicoEsterno m = new MedicoEsterno();
        m.setNome(nome);
        m.setCognome(cognome);
        m.setSpecializzazione(specializzazione);
        m.setData_nascita(data_nascita);
        m.setUsername(username);
        m.setPassword(password);
        m.setPin_code(pin_code);
        m.setLista_pazienti(new ArrayList<Paziente>());
        medicoEsternoFacade.create(m);
        return m.getId();
    }

    @Override
    public Long addMedicoOspedaliero(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code, String num_ufficio) {
        MedicoOspedaliero m = new MedicoOspedaliero();
        m.setNome(nome);
        m.setCognome(cognome);
        m.setSpecializzazione(specializzazione);
        m.setData_nascita(data_nascita);
        m.setUsername(username);
        m.setPassword(password);
        m.setPin_code(pin_code);
        m.setNum_ufficio(num_ufficio);
        medicoOspedalieroFacade.create(m);
        return m.getId();
    }

    @Override
    public Long addOspedale(String nome, String indirizzo) {
        Ospedale o = new Ospedale();
        o.setNome(nome);
        o.setIndirizzo(indirizzo);
        // da completare l'aggiunta di reparti
        o.setLista_reparti(new ArrayList<Reparto>());
        ospedaleFacade.create(o);
        return o.getId();
    }

    @Override
    public Long addStudioMedico(String nome, String indirizzo) {
        StudioMedico sm = new StudioMedico();
        sm.setNome(nome);
        sm.setIndirizzo(indirizzo);
        // da completare l'aggiunta dei pazienti
        sm.setLista_medici(new ArrayList<MedicoEsterno>());
        studioMedicoFacade.create(sm);
        return sm.getId();
    }

    @Override
    public Long addPrestazioneSala(int durata, String nome) {
        PrestazioneSala ps = new PrestazioneSala();
        ps.setNome(nome);
        ps.setDurata(durata);
        prestazioneSalaFacade.create(ps);
        return ps.getId();
    }

    @Override
    public Long addPrestazioneMedico(int durata, String nome) {
        PrestazioneMedico pm = new PrestazioneMedico();
        pm.setNome(nome);
        pm.setDurata(durata);
        prestazioneMedicoFacade.create(pm);
        return pm.getId();
    }

    @Override
    public Long addReparto(long id_ospedale, String nome, long id_primario) {
        Reparto r = new Reparto();
        r.setNome(nome);
        MedicoOspedaliero p = medicoOspedalieroFacade.find(id_primario);
        r.setPrimario(p);
        r.setLista_medici(new ArrayList<MedicoOspedaliero>());
        r.setLista_pazienti(new ArrayList<Paziente>());
        r.setLista_sale(new ArrayList<Sala>());
        Ospedale o = ospedaleFacade.find(id_ospedale);
        r.setOspedale(o);
        o.getLista_reparti().add(r);
        repartoFacade.create(r);
        return r.getId();
    }

    @Override
    public Long addSalaOspedale(long id_reparto, String tipo_laboratorio, long id_medico_responsabile) {
        Sala s = new Sala();
        s.setTipoLaboratorio(tipo_laboratorio);
        s.setLista_prestazioni(new ArrayList<PrestazioneSala>());
        MedicoOspedaliero m = medicoOspedalieroFacade.find(id_medico_responsabile);
        s.setMedico_responsabile(m);
        salaFacade.create(s);
        Reparto r = repartoFacade.find(id_reparto);
        s.setReparto(r);
        r.getLista_sale().add(s);
        return s.getId();
    }

    @Override
    public Long addSalaStudio(long id_studio_medico, String tipo_laboratorio, long id_medico_responsabile) {
        Sala s = new Sala();
        s.setTipoLaboratorio(tipo_laboratorio);
        s.setLista_prestazioni(new ArrayList<PrestazioneSala>());
        MedicoEsterno m = medicoEsternoFacade.find(id_medico_responsabile);
        s.setMedico_responsabile(m);
        salaFacade.create(s);
        StudioMedico sm = studioMedicoFacade.find(id_studio_medico);
        s.setStudioMedico(sm);
        sm.getLista_sale().add(s);
        return s.getId();
    }

    @Override
    public void addPrestazioniToSala(long id_sala, List<PrestazioneSala> prestazioni) {
        Sala s = salaFacade.find(id_sala);
        s.getLista_prestazioni().addAll(prestazioni);
    }

    @Override
    public void addPrestazioni(String[] prestazioniMedico, String[] prestazioniSala) {
        List<Medico> medici = medicoFacade.findAll();
        List<PrestazioneMedico> prestazioni = new ArrayList<>();
        for (String pr : prestazioniMedico) {
            PrestazioneMedico p = new PrestazioneMedico();
            p.setNome(pr);
            p.setDurata(30);
            p.setLista_medici(new ArrayList<Medico>());
            prestazioneMedicoFacade.create(p);
            prestazioni.add(p);
        }

        List<PrestazioneSala> prestazioniS = new ArrayList<>();
        for (String pr : prestazioniSala) {
            PrestazioneSala p = new PrestazioneSala();
            p.setNome(pr);
            p.setDurata(30);
            p.setLista_sale(new ArrayList<Sala>());
            prestazioneSalaFacade.create(p);
            prestazioniS.add(p);
        }

        for (Medico m : medici) {
            int n = (int) (Math.random() * 4 + 1);
            for (int i = 0; i <= n; i++) {
                int ind = (int) (Math.random() * prestazioni.size());
                m.addPrestazioniEffettuabili(prestazioni.get(ind));
                prestazioni.get(ind).addMedico(m);
            }
        }
    }

    @Override
    public void linkStruttureMedici() {
        List<MedicoEsterno> mediciE = medicoEsternoFacade.findAll();
        List<StudioMedico> studi = studioMedicoFacade.findAll();
        for (MedicoEsterno m : mediciE) {
            int ind = (int) (Math.random() * studi.size());
            m.setStudioMedico(studi.get(ind));
            studi.get(ind).addMedico(m);
        }

        List<MedicoOspedaliero> mediciO = medicoOspedalieroFacade.findAll();
        List<Reparto> reparti = repartoFacade.findAll();
        for (MedicoOspedaliero m : mediciO) {
            int ind = (int) (Math.random() * reparti.size());
            reparti.get(ind).addMedico(m);
        }
    }

    @Override
    public void linkRepartiPazienti() {
        List<Paziente> pazienti = pazienteFacade.findAll();
        List<Reparto> reparti = repartoFacade.findAll();
        for (Paziente p : pazienti) {
            int ind = (int) (Math.random() * reparti.size());
            if (Math.random() > 0.6) {
                reparti.get(ind).addPaziente(p);
            }
        }
    }

    @Override
    public void addCartelleCliniche() {
        List<Paziente> pazienti = pazienteFacade.findAll();
        
        String[] frasi_anamnesi = {"Scoliosi evidente.",
            "Il padre all'età di 45 anni è stato colpito da angina pectoris",
            "Il nonno materno era diabetico.",
            "Nella fase infantile è stata soggetta a tutte le malattie infantili, compresa la rosolia.",
            "Alletà di anni 16 si è manifestata l'allergia al glutine.",
            "Sin dall'età di 18 anni si è manifestata ipertensione  arteriosa.",
            "Nell'anno 2000 ha subito appendicectomia.",
            "Nell'anno 2005 intervento per spina ossea all'arcata dentale superiore.",
            "Nell'anno 2011 Angioplastica PTCA + Stent.",
            "Durante l'anno 2004 accusava problemi respiratori che intensificavano con l'abbassarsi della temperatura  atmosferica.",
            "Nonostante la vaccinazione anti-influenzale, è stata colpita da sindrome influenzale nel mese di marzo.",
            "A seguito di un viaggio in Africa ha contratto la tubercolosi.",
            "Contratto HIV per contatto con siringa.",
            "Affetto da sindrome di Down diagnosticata all'eta di 4 anni.",
            "Rottura del sopracciglio per aver sbattuto a una mensola.",
            "Rottura del setto nasale causa pugno ricevuto in una rissa.",
            "Frattura dello sterno in incidente d'auto, mentre era sotto effetto dell'alcool.",
            "Lesione del legamento crociato anteriore durante una partita di calcetto."};

        String[] medicinali = {
            "Tegretol", "aspirina", "Benazepril", "Palexia", "Maalox", "Betadine", "Oki", "Dicloreum", "Diazepan", "Tachipirina", "Valontan", "Dolmen", "Sustanon", "Dissenten", "Enterostop", "Eskim", "Caravel", "Limpidex", "Levotuss", "Contramal", "Bonviva", "Mucosolvan", "Muscoril"
        };
        
        for (Paziente p : pazienti) {
            CartellaClinica cc = new CartellaClinica();
            cc.setPaziente(p);
            ArrayList<RefertoMedico> referti = new ArrayList<>();
        
            String anamnesi = "";
            List<Medico> med = medicoFacade.findAll();
            int righe = (int) (Math.random() * 2) + 1;
            for (int i = 0; i < righe; i++) {
                int ind = (int) (Math.random() * frasi_anamnesi.length);
                anamnesi += "\n" + frasi_anamnesi[ind];

                RefertoMedico r = new RefertoMedico();
                
                Date[] ds = generateDateInterval(180);
                Date d = ds[0];
                r.setDataVisita(d);
                r.setDiagnosi(frasi_anamnesi[ind]);
                
                Medico m = med.get((int) (med.size() * Math.random()));
                List<PrescrizioneMedica> pms = new ArrayList<>();
                for (int j = 0; j < Math.random() * 3; j++) {
                    PrescrizioneMedica pm = new PrescrizioneMedica();
                    if (Math.random() < 0.5) {
                        pm.setConsegnata("No");
                    } else {
                        pm.setConsegnata("Si");
                    }
                    pm.setData_prescrizione(d);
                    
                    Date d1 = ds[1];
                    pm.setData_scadenza(d1);
                    pm.setMedicinale(medicinali[(int) (medicinali.length * Math.random())]);
                    pm.setNumero_confezioni((int) (Math.random() * 3+1));
                    pm.setMedico(m);
                    pm.setPaziente(p);
                    pm.setReferto(r);
                    prescrizioneMedicaFacade.create(pm);
                    pms.add(pm);
                }
                r.setLista_prescrizioni(pms);
                r.setMedico(m);
                r.setPaziente(p);
                r.setLista_images("");
                r.setTipoVisita(m.getPrestazioniEffettuabili().get((int) (Math.random() * m.getPrestazioniEffettuabili().size())));
                refertoMedicoFacade.create(r);
                referti.add(r);
            }
            cc.setLista_referti(referti);
            cc.setAnamnesi(anamnesi);
            cartellaClinicaFacade.create(cc);
            cc.setPaziente(p);
            p.setCartella_clinica(cc);
        }
    }

    @Override
    public void linkMediciPazienti() {
        List<Paziente> pazienti = pazienteFacade.findAll();
        List<MedicoEsterno> medici = medicoEsternoFacade.findAll();
        for (Paziente p : pazienti) {
            int ind = (int) (Math.random() * medici.size());
            medici.get(ind).getLista_pazienti().add(p);
        }
    }
}
