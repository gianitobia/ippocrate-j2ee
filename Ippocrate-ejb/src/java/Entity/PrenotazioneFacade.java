/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author toby
 */
@Stateless
public class PrenotazioneFacade extends AbstractFacade<Prenotazione> implements PrenotazioneFacadeLocal {

    @PersistenceContext(unitName = "Ippocrate-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrenotazioneFacade() {
        super(Prenotazione.class);
    }

}
