/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Persone;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface PazienteFacadeLocal {

    void create(Paziente paziente);

    void edit(Paziente paziente);

    void remove(Paziente paziente);

    Paziente find(Object id);

    List<Paziente> findAll();

    List<Paziente> findRange(int[] range);

    int count();
    
}
