/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.CartellaClinica;
import Entity.Medico;
import Entity.Paziente;
import Entity.RefertoMedico;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;
import javax.servlet.http.Part;

/**
 *
 * @author Marco
 */
@Local
public interface GestoreMedicoLocal {

    List<Paziente> ottieniMieiPazienti(long medicoId);

    CartellaClinica modificaAnamnesi(long ccId, String nuovaAnamnesi);

    List<RefertoMedico> aggiungiReferto(Medico m, int iPrest, String diagn, Paziente p,
            Part filePart, String file, String d, String medic, int numConf, String dataScadenza);

    CartellaClinica ottieniCCPaziente(long idP);

}
