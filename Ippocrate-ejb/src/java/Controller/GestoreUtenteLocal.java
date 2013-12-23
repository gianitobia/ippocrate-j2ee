/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.MedicoTransient;
import Entity.PazienteTransient;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface GestoreUtenteLocal {

    PazienteTransient ottieniPaziente(long user_id);

    MedicoTransient ottieniMedico(long user_id);

}
