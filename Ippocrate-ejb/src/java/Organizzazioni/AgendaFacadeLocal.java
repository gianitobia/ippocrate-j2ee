/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Organizzazioni;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author toby
 */
@Local
public interface AgendaFacadeLocal {

    void create(Agenda agenda);

    void edit(Agenda agenda);

    void remove(Agenda agenda);

    Agenda find(Object id);

    List<Agenda> findAll();

    List<Agenda> findRange(int[] range);

    int count();
    
}
