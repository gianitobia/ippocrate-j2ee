/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Ospedale;
import Entity.OspedaleFacadeLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.StudioMedico;
import Entity.StudioMedicoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toby
 */
@Stateless
public class GestoreListeDati implements GestoreListeDatiLocal {

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @EJB
    private StudioMedicoFacadeLocal studioMedicoFacade;
    @EJB
    private OspedaleFacadeLocal ospedaleFacade;

    @Override
    public List<Ospedale> ottieniListaOspedali() {
        return ospedaleFacade.findAll();
    }

    @Override
    public List<StudioMedico> ottieniListaStudiMedici() {
        return studioMedicoFacade.findAll();
    }

    @Override
    public List<Paziente> ottieniListaPazienti() {
        return pazienteFacade.findAll();
    }
}
