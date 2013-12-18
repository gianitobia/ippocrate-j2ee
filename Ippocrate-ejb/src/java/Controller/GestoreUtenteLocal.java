/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.Medico;
import Entity.PazienteTransient;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface GestoreUtenteLocal {

    PazienteTransient ottieniPaziente(long user_id);

    Medico ottieniMedico(long user_id);
    
}
