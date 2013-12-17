/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.Paziente;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface GestoreLoginLocal {

    boolean verificaLoginMedico(String username, String password, String pin_code);

    Paziente verificaLoginPaziente(String cf, String password);
    
}
