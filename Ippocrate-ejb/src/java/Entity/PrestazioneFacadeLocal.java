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
public interface PrestazioneFacadeLocal {

    void create(Prestazione prestazione);

    void edit(Prestazione prestazione);

    void remove(Prestazione prestazione);

    Prestazione find(Object id);

    List<Prestazione> findAll();

    List<Prestazione> findRange(int[] range);

    int count();

}
