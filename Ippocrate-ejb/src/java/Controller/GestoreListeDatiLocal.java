/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ospedale;
import Entity.Paziente;
import Entity.StudioMedico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface GestoreListeDatiLocal {

    List<Ospedale> ottieniListaOspedali();

    List<StudioMedico> ottieniListaStudiMedici();

    List<Paziente> ottieniListaPazienti();

}
