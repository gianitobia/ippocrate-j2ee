/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import Entity.CartellaClinicaFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Marco
 */
@Stateless
public class GestoreCartellaClinica implements GestoreCartellaClinicaLocal {
    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;
    
}
