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
public interface StudioMedicoFacadeLocal {

    void create(StudioMedico studioMedico);

    void edit(StudioMedico studioMedico);

    void remove(StudioMedico studioMedico);

    StudioMedico find(Object id);

    List<StudioMedico> findAll();

    List<StudioMedico> findRange(int[] range);

    int count();

}
