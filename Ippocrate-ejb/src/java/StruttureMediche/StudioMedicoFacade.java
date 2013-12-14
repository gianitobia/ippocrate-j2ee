/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StruttureMediche;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author toby
 */
@Stateless
public class StudioMedicoFacade extends AbstractFacade<StudioMedico> implements StudioMedicoFacadeLocal {
    @PersistenceContext(unitName = "Ippocrate-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudioMedicoFacade() {
        super(StudioMedico.class);
    }
    
}
