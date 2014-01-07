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
 * @author Marco
 */
@Stateless
public class PrestazioneMedicoFacade extends AbstractFacade<PrestazioneMedico> implements PrestazioneMedicoFacadeLocal {
    @PersistenceContext(unitName = "Ippocrate-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PrestazioneMedicoFacade() {
        super(PrestazioneMedico.class);
    }
    
}
