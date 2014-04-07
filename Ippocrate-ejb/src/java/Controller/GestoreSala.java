/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.OspedaleFacadeLocal;
import Entity.Sala;
import Entity.SalaFacadeLocal;
import Entity.StrutturaMedicaFacadeLocal;
import HttpClient.HttpCalendarClient;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Alex
 */
@Stateless
public class GestoreSala implements GestoreSalaLocal {
    
    @EJB
    private OspedaleFacadeLocal ospedaleFacade;
    
    @EJB
    private StrutturaMedicaFacadeLocal strutturaMedicaFacade;
    
    @EJB
    private SalaFacadeLocal salaFacade;
    
    @Override
    public String getCalendar(Long IdSala) {
        
        HttpCalendarClient conn = new HttpCalendarClient();
        Sala m = salaFacade.find(IdSala);
        String struttura = "";
        if(m.getStudioMedico() != null)
            struttura = m.getStudioMedico().getNome();
        else {
            struttura = m.getReparto().getOspedale().getNome();
        }
        return conn.get_calendar_id(struttura, m.getTipoLaboratorio());
    }
    
}
