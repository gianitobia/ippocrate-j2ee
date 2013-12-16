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
public interface MedicoEsternoFacadeLocal {

    void create(MedicoEsterno medicoEsterno);

    void edit(MedicoEsterno medicoEsterno);

    void remove(MedicoEsterno medicoEsterno);

    MedicoEsterno find(Object id);

    List<MedicoEsterno> findAll();

    List<MedicoEsterno> findRange(int[] range);

    int count();

}
