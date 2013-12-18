/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.Medico;
import Entity.MedicoFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toby
 */
@Stateless
public class GestoreLogin implements GestoreLoginLocal {
    @EJB
    private MedicoFacadeLocal medicoFacade;

    @Override
    public long verificaLoginMedico(String username, String password, String pin_code) {
        for(Medico m : medicoFacade.findAll()){
            if(m.getUsername().equals(username) && m.getPassword().equals(password) && m.getPin_code().equals(pin_code)){
                return m.getId();
            }
        }
        return 0;
    }
}
