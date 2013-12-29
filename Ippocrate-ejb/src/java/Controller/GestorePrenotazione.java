/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.AgendaFacadeLocal;
import Entity.Prenotazione;
import Entity.PrenotazioneFacadeLocal;
import Entity.Prestazione;
import Entity.PrestazioneFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StrutturaMedica;
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
    private AgendaFacadeLocal agendaFacade;

    @EJB
    private SalaFacadeLocal salaFacade;

    @EJB
    private PrestazioneFacadeLocal prestazioneFacade;

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

    @Override
    public List<Prestazione> ottieniPrestazioniPrenotabili() {
        List<Prestazione> prestazioni = prestazioneFacade.findAll();
        return prestazioni;
    }

    @Override
    public List<Sala> ottieniSalePerPrestazione(Prestazione prestazione) {
        List<Sala> sale = prestazione.getLista_sale();
        return sale;
    }

    @Override
    public List<StrutturaMedica> ottieniStruttureMedichePerPrestazione(Prestazione prestazione) {
        List<Sala> sale = ottieniSalePerPrestazione(prestazione);
        for (Sala s : sale) {
            //TODO da fare
        }
        return null;
    }

}
