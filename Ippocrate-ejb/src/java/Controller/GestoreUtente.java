/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Medico;
import Entity.MedicoFacadeLocal;
import Transient.MedicoTransient;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Transient.PazienteTransient;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author toby
 */
@Stateless
public class GestoreUtente implements GestoreUtenteLocal {

    @EJB
    private MedicoFacadeLocal medicoFacade;
    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @Override
    public PazienteTransient ottieniPaziente(long user_id) {
        Paziente p = pazienteFacade.find(user_id);
        PazienteTransient pt = new PazienteTransient();
        pt.setId(p.getId());
        pt.setCf(p.getCf());
        pt.setCognome(p.getCognome());
        pt.setData_nascita(p.getData_nascita());
        pt.setIndirizzo(p.getIndirizzo());
        pt.setLuogo_nascita(p.getLuogo_nascita());
        pt.setNome(p.getNome());
        pt.setSesso(p.getSesso());
        return pt;
    }

    @Override
    public MedicoTransient ottieniMedicoT(long user_id) {
        Medico m = medicoFacade.find(user_id);
        MedicoTransient mt = new MedicoTransient();
        mt.setId(m.getId());
        mt.setCognome(m.getCognome());
        mt.setNome(m.getNome());
        mt.setData_nascita(m.getData_nascita());
        mt.setSpecializzazione(m.getSpecializzazione());
        if (m.getClass().getName().equals("Entity.MedicoOspedaliero")) {
            mt.setTipo("O");
            mt.setNum_ufficio(((Entity.MedicoOspedaliero) m).getNum_ufficio());
        } else {
            mt.setTipo("E");
        }

        return mt;
    }

    @Override
    public Medico ottieniMedico(long user_id) {
        return medicoFacade.find(user_id);
    }
}
