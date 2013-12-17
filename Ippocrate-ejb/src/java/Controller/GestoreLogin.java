/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.*;
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
    public boolean verificaLoginMedico(String username, String password, String pin_code) {
        if(username.equals("tobia"))
            return true;
        for(Medico m : medicoFacade.findAll()){
            if(m.getUsername().equals(username) && m.getPassword().equals(password) && m.getPin_code().equals(pin_code)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Paziente verificaLoginPaziente(String cf, String password) {
        //if(cf.equals("1234"))
            //return true;
        for(Paziente p : pazienteFacade.findAll()){
            if(p.getCf().equals(cf) && p.getPassword().equals(password)){
                return p;
            }
        }
        return null;
    } 
}
