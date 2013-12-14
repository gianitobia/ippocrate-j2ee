/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package StruttureMediche;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface OspedaleFacadeLocal {

    void create(Ospedale ospedale);

    void edit(Ospedale ospedale);

    void remove(Ospedale ospedale);

    Ospedale find(Object id);

    List<Ospedale> findAll();

    List<Ospedale> findRange(int[] range);

    int count();
    
}
