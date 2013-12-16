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
public interface MedicoOspedalieroFacadeLocal {

    void create(MedicoOspedaliero medicoOspedaliero);

    void edit(MedicoOspedaliero medicoOspedaliero);

    void remove(MedicoOspedaliero medicoOspedaliero);

    MedicoOspedaliero find(Object id);

    List<MedicoOspedaliero> findAll();

    List<MedicoOspedaliero> findRange(int[] range);

    int count();

}
