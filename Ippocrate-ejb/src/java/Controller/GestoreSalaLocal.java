/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.Reparto;
import Entity.StrutturaMedica;
import javax.ejb.Local;

/**
 *
 * @author Alex
 */
@Local
public interface GestoreSalaLocal {

    String getCalendar(Long IdSala);

}
