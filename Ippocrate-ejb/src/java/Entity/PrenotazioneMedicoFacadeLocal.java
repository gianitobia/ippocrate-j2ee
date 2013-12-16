/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface PrenotazioneMedicoFacadeLocal {

    void create(PrenotazioneMedico prenotazioneMedico);

    void edit(PrenotazioneMedico prenotazioneMedico);

    void remove(PrenotazioneMedico prenotazioneMedico);

    PrenotazioneMedico find(Object id);

    List<PrenotazioneMedico> findAll();

    List<PrenotazioneMedico> findRange(int[] range);

    int count();

}
