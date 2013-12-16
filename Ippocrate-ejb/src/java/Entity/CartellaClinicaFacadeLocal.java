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
public interface CartellaClinicaFacadeLocal {

    void create(CartellaClinica cartellaClinica);

    void edit(CartellaClinica cartellaClinica);

    void remove(CartellaClinica cartellaClinica);

    CartellaClinica find(Object id);

    List<CartellaClinica> findAll();

    List<CartellaClinica> findRange(int[] range);

    int count();

}
