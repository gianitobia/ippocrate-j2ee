/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.CartellaClinica;
import Entity.CartellaClinicaFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestorePaziente implements GestorePazienteLocal {
    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @Override
    public void addPaziente(String nome, String cognome, String cf, String password,
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
        cartellaClinicaFacade.create(cc);
        p.setCartella_clinica(cc);
        pazienteFacade.create(p);
    }
}
