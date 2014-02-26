/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Agenda;
import Entity.Medico;
import Entity.PrenotazioneTransient;
import Entity.Prestazione;
import Entity.Sala;
import Entity.StrutturaMedica;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestorePrenotazioneLocal {

    List<PrenotazioneTransient> ottieniPrenotazioni(long pazienteId);

    List<Prestazione> ottieniPrestazioniPrenotabili();

    List<StrutturaMedica> ottieniStruttureMedichePerPrestazione(Prestazione p);

    List<Medico> ottieniMediciPerPrestazioneEStrutturaMedica(Prestazione p, StrutturaMedica sm);

    Agenda ottieniAgendaMedico(Medico m);

    List<Sala> ottieniSalePerPrestazioneEStrutturaMedica(Prestazione p, StrutturaMedica sm);

}
