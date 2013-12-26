/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Prenotazione;
import Entity.PrenotazioneFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestorePrenotazione implements GestorePrenotazioneLocal {

    @EJB
    private PrenotazioneFacadeLocal prenotazioneFacade;

    @Override
    public List<Prenotazione> ottieniPrenotazioni(long pazienteId) {
        ArrayList l = new ArrayList();

        for (Prenotazione p : prenotazioneFacade.findAll()) {
            if (p.getPaziente().getId() == pazienteId) {
                l.add(p);
            }
        }

        return l;
    }
}
