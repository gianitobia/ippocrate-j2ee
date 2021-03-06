/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medico;
import Transient.MedicoTransient;
import Transient.PazienteTransient;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface GestoreUtenteLocal {

    PazienteTransient ottieniPaziente(Long user_id);

    MedicoTransient ottieniMedicoT(Long user_id);

    Medico ottieniMedico(Long user_id);

    Long verificaCF(String CF);

}
