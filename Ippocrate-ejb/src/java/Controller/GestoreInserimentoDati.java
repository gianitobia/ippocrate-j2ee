/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.CartellaClinica;
import Entity.CartellaClinicaFacadeLocal;
import Entity.MedicoEsterno;
import Entity.MedicoEsternoFacadeLocal;
import Entity.MedicoOspedaliero;
import Entity.MedicoOspedalieroFacadeLocal;
import Entity.OspedaleFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.PrestazioneFacadeLocal;
import Entity.RefertoMedico;
import Entity.StudioMedicoFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreInserimentoDati implements GestoreInserimentoDatiLocal {

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
    public Long addOspedale(String nome, String indrizzo) {
        return null;
    }

    @Override
    public Long addStudioMedico(String nome, String indirizzo) {
        return null;
    }

    @Override
    public Long addPrestazione(String durata, String nome) {
        return null;
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

}
