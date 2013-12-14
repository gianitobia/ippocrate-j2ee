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
public interface RepartoFacadeLocal {

    void create(Reparto reparto);

    void edit(Reparto reparto);

    void remove(Reparto reparto);

    Reparto find(Object id);

    List<Reparto> findAll();

    List<Reparto> findRange(int[] range);

    int count();
    
}
