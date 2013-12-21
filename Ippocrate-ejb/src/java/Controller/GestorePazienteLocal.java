/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestorePazienteLocal {

    void addPaziente(String nome, String cognome, String password, String cf, String sesso, String indirizzo, Date data_nascita, String luogo_nascita);
    
}
