/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.CartellaClinicaTransient;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestoreCartellaClinicaLocal {

    CartellaClinicaTransient ottieniCC(long pazienteId);
    
}
