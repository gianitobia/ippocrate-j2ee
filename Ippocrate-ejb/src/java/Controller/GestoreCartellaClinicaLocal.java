/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.PrescrizioneMedica;
import Transient.CartellaClinicaTransient;
import Transient.PrescrizioneMedicaTransient;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestoreCartellaClinicaLocal {

    CartellaClinicaTransient ottieniCC(Long pazienteId);

    List<PrescrizioneMedicaTransient> ottieniPMT(Long pazienteId);

    PrescrizioneMedicaTransient segnaConsegnata(Long idPM);

    List<PrescrizioneMedica> ottieniPM(Long idRM);

}
