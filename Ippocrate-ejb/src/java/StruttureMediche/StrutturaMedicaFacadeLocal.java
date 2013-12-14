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
public interface StrutturaMedicaFacadeLocal {

    void create(StrutturaMedica strutturaMedica);

    void edit(StrutturaMedica strutturaMedica);

    void remove(StrutturaMedica strutturaMedica);

    StrutturaMedica find(Object id);

    List<StrutturaMedica> findAll();

    List<StrutturaMedica> findRange(int[] range);

    int count();
    
}
