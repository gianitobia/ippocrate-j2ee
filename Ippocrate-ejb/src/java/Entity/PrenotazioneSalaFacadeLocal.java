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
public interface PrenotazioneSalaFacadeLocal {

    void create(PrenotazioneSala prenotazioneSala);

    void edit(PrenotazioneSala prenotazioneSala);

    void remove(PrenotazioneSala prenotazioneSala);

    PrenotazioneSala find(Object id);

    List<PrenotazioneSala> findAll();

    List<PrenotazioneSala> findRange(int[] range);

    int count();

}
