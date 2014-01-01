/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Agenda;
import Entity.AgendaFacadeLocal;
import Entity.CartellaClinica;
import Entity.CartellaClinicaFacadeLocal;
import Entity.MedicoEsterno;
import Entity.MedicoEsternoFacadeLocal;
import Entity.MedicoOspedaliero;
import Entity.MedicoOspedalieroFacadeLocal;
import Entity.Ospedale;
import Entity.OspedaleFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.Prestazione;
import Entity.PrestazioneFacadeLocal;
import Entity.RefertoMedico;
import Entity.Reparto;
import Entity.RepartoFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StudioMedico;
import Entity.StudioMedicoFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreInserimentoDati implements GestoreInserimentoDatiLocal {

    @EJB
    private SalaFacadeLocal salaFacade;

    @EJB
    private RepartoFacadeLocal repartoFacade;
    @EJB
    private AgendaFacadeLocal agendaFacade;
    @EJB
    private PrestazioneFacadeLocal prestazioneFacade;
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

        CartellaClinica cc = new CartellaClinica();
        cc.setPaziente(p);
        cc.setLista_referti(new ArrayList<RefertoMedico>());
        cc.setAnamnesi("");
        cartellaClinicaFacade.create(cc);
        p.setCartella_clinica(cc);
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
        Agenda a = new Agenda();
        agendaFacade.create(a);
        m.setVisite(a);
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
        Agenda a = new Agenda();
        agendaFacade.create(a);
        m.setVisite(a);
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
        sm.setLista_pazienti(new ArrayList<Paziente>());
        studioMedicoFacade.create(sm);
        return sm.getId();
    }

    @Override
    public Long addPrestazione(int durata, String nome) {
        Prestazione p = new Prestazione();
        p.setNome(nome);
        p.setDurata(durata);
        prestazioneFacade.create(p);
        return p.getId();
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
        o.getLista_reparti().add(r);
        repartoFacade.create(r);
        return r.getId();
    }

    @Override
    public Long addSalaOspedale(long id_reparto, String tipo_laboratorio, long id_medico_responsabile) {
        Sala s = new Sala();
        s.setTipoLaboratorio(tipo_laboratorio);
        Agenda a = new Agenda();
        agendaFacade.create(a);
        s.setAgenda(a);
        s.setLista_prestazioni(new ArrayList<Prestazione>());
        MedicoOspedaliero m = medicoOspedalieroFacade.find(id_medico_responsabile);
        s.setMedico_responsabile(m);
        salaFacade.create(s);
        Reparto r = repartoFacade.find(id_reparto);
        r.getLista_sale().add(s);
        return s.getId();
    }

    @Override
    public Long addSalaStudio(long id_studio_medico, String tipo_laboratorio, long id_medico_responsabile) {
        Sala s = new Sala();
        s.setTipoLaboratorio(tipo_laboratorio);
        Agenda a = new Agenda();
        agendaFacade.create(a);
        s.setAgenda(a);
        s.setLista_prestazioni(new ArrayList<Prestazione>());
        MedicoEsterno m = medicoEsternoFacade.find(id_medico_responsabile);
        s.setMedico_responsabile(m);
        salaFacade.create(s);
        StudioMedico sm = studioMedicoFacade.find(id_studio_medico);
        sm.getLista_sale().add(s);
        return s.getId();
    }

    @Override
    public void addPrestazioniToSala(long id_sala, List<Prestazione> prestazioni) {
        Sala s = salaFacade.find(id_sala);
        s.getLista_prestazioni().addAll(prestazioni);
    }
}