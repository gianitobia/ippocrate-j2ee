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
    public Long verificaLoginMedico(String username, String pincode, String password) {
        for (Medico m : medicoFacade.findAll()) {
            if (m.getUsername().equals(username) && m.getPin_code().equals(pincode)
                    && m.getPassword().equals(password)) {
                return m.getId();
            }
        }
        return new Long(-1);
    }

    @Override
    public Long verificaLoginPaziente(String cf, String password) {
        for (Paziente p : pazienteFacade.findAll()) {
            if (p.getCf().equals(cf) && p.getPassword().equals(password)) {
                return p.getId();
            }
        }
        return new Long(-1);
    }

}
