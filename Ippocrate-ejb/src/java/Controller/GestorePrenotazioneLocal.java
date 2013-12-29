/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Prenotazione;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestorePrenotazioneLocal {

    List<Prenotazione> ottieniPrenotazioni(long pazienteId);

}
