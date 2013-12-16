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
public interface PrescrizioneMedicaFacadeLocal {

    void create(PrescrizioneMedica prescrizioneMedica);

    void edit(PrescrizioneMedica prescrizioneMedica);

    void remove(PrescrizioneMedica prescrizioneMedica);

    PrescrizioneMedica find(Object id);

    List<PrescrizioneMedica> findAll();

    List<PrescrizioneMedica> findRange(int[] range);

    int count();

}
