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
public interface RefertoMedicoFacadeLocal {

    void create(RefertoMedico refertoMedico);

    void edit(RefertoMedico refertoMedico);

    void remove(RefertoMedico refertoMedico);

    RefertoMedico find(Object id);

    List<RefertoMedico> findAll();

    List<RefertoMedico> findRange(int[] range);

    int count();

}
