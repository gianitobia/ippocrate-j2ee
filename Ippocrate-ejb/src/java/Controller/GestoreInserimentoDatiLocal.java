/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
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
public interface GestoreInserimentoDatiLocal {

    Long addPaziente(String nome, String cognome, String password, String cf, String sesso, String indirizzo, Date data_nascita, String luogo_nascita);

    Long addMedicoEsterno(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code);

    Long addMedicoOspedaliero(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code, String num_ufficio);

    Long addOspedale(String nome, String indrizzo);

    Long addStudioMedico(String nome, String indirizzo);

    Long addPrestazione(String durata, String nome);
}
