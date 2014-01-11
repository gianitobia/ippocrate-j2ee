/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.AgendaFacadeLocal;
import Entity.Medico;
import Entity.MedicoOspedaliero;
import Entity.Prenotazione;
import Entity.PrenotazioneFacadeLocal;
import Entity.PrenotazioneMedico;
import Entity.PrenotazioneSala;
import Entity.PrenotazioneTransient;
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
    public List<PrenotazioneTransient> ottieniPrenotazioni(long pazienteId) {
        ArrayList l = new ArrayList();

        for (Prenotazione p : prenotazioneFacade.findAll()) {
            if (p.getPaziente().getId() == pazienteId) {
                PrenotazioneTransient pt = new PrenotazioneTransient();
                pt.setNomeSM(p.getStruttura_medica().getNome());
                pt.setIndirizzoSM(p.getStruttura_medica().getIndirizzo());
                pt.setData(p.getData_prenotazione());

                if (p.getClass().getName().equals("Entity.PrenotazioneMedico")) {
                    pt.setTipo("M");
                    pt.setNomePr(((PrenotazioneMedico) p).getTipo_prestazione().getNome());
                    pt.setDurataPr(((PrenotazioneMedico) p).getTipo_prestazione().getDurata());
                    Medico m = ((PrenotazioneMedico) p).getMedico();
                    pt.setCognomeM(m.getCognome());
                    if (m.getClass().getName().equals("Entity.MedicoOspedaliero")) {
                        pt.setUfficioM(((MedicoOspedaliero) m).getNum_ufficio());
                    }
                } else {
                    pt.setTipo("S");
                    pt.setNomePr(((PrenotazioneSala) p).getTipo_prestazione().getNome());
                    pt.setDurataPr(((PrenotazioneSala) p).getTipo_prestazione().getDurata());
                    pt.setTipoLaboratorioS(((PrenotazioneSala) p).getSala().getTipoLaboratorio());
                }
                l.add(pt);
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
        //TODO
        //List<Sala> sale = prestazione.getLista_sale();
        //return sale;
        return null;
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
