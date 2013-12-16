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
public interface MedicoFacadeLocal {

    void create(Medico medico);

    void edit(Medico medico);

    void remove(Medico medico);

    Medico find(Object id);

    List<Medico> findAll();

    List<Medico> findRange(int[] range);

    int count();

}
