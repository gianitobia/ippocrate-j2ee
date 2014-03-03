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
public interface PrestazioneSalaFacadeLocal {

    void create(PrestazioneSala prestazioneSala);

    void edit(PrestazioneSala prestazioneSala);

    void remove(PrestazioneSala prestazioneSala);

    PrestazioneSala find(Object id);

    List<PrestazioneSala> findAll();

    List<PrestazioneSala> findRange(int[] range);

    int count();

}
