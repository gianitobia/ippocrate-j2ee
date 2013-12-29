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

import Entity.Prestazione;
import java.util.Date;
import java.util.List;
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

    Long addPrestazione(int durata, String nome);

    Long addReparto(long id_ospedale, String nome, long id_primario);

    Long addSalaOspedale(long id_reparto, String tipo_laboratorio, long id_medico_responsabile);

    Long addSalaStudio(long id_studio_medico, String tipo_laboratorio, long id_medico_responsabile);

    void addPrestazioniToSala(long id_sala, List<Prestazione> prestazioni);

}
