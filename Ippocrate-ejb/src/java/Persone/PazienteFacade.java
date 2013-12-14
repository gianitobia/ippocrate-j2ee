/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author toby
 */
@Stateless
public class PazienteFacade extends AbstractFacade<Paziente> implements PazienteFacadeLocal {
    @PersistenceContext(unitName = "Ippocrate-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PazienteFacade() {
        super(Paziente.class);
    }
    
}
