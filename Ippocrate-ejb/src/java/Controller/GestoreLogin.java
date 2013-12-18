/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medico;
import Entity.MedicoFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toby
 */
@Stateless
public class GestoreLogin implements GestoreLoginLocal {

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @EJB
    private MedicoFacadeLocal medicoFacade;

    @Override
    public long verificaLoginMedico(String username, String password, String pin_code) {
        for (Medico m : medicoFacade.findAll()) {
            if (m.getUsername().equals(username) && m.getPassword().equals(password) && m.getPin_code().equals(pin_code)) {
                return m.getId();
            }
        }
        return -1;
    }

    @Override
    public long verificaLoginPaziente(String cf, String password) {
        //if(cf.equals("1234"))
        //return true;
        for (Paziente p : pazienteFacade.findAll()) {
            if (p.getCf().equals(cf) && p.getPassword().equals(password)) {
                return p.getId();
            }
        }
        return -1;
    }
}
