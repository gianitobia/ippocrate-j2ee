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
 * @author Marco
 */
@Local
public interface PrestazioneMedicoFacadeLocal {

    void create(PrestazioneMedico prestazioneMedico);

    void edit(PrestazioneMedico prestazioneMedico);

    void remove(PrestazioneMedico prestazioneMedico);

    PrestazioneMedico find(Object id);

    List<PrestazioneMedico> findAll();

    List<PrestazioneMedico> findRange(int[] range);

    int count();
    
}
