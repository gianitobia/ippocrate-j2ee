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

import Entity.PrestazioneSala;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marco
 */
@Local
public interface GestoreInserimentoDatiLocal {

    Long addPaziente(String nome, String cognome, String cf, String password, String sesso, String indirizzo, Date data_nascita, String luogo_nascita);

    Long addMedicoEsterno(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code);

    Long addMedicoOspedaliero(String nome, String cognome, String specializzazione, Date data_nascita, String username, String password, String pin_code, String num_ufficio);

    Long addOspedale(String nome, String indrizzo);

    Long addStudioMedico(String nome, String indirizzo);

    Long addPrestazioneSala(int durata, String nome);

    Long addPrestazioneMedico(int durata, String nome);

    Long addReparto(long id_ospedale, String nome, long id_primario);

    Long addSalaOspedale(long id_reparto, String tipo_laboratorio, long id_medico_responsabile);

    Long addSalaStudio(long id_studio_medico, String tipo_laboratorio, long id_medico_responsabile);

    void addPrestazioniToSala(long id_sala, List<PrestazioneSala> prestazioni);

}
