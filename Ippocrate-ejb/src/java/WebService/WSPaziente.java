/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Controller.GestoreCartellaClinicaLocal;
import Controller.GestoreLoginLocal;
import Controller.GestoreMedicoLocal;
import Controller.GestoreUtenteLocal;
import Entity.CartellaClinica;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
import Entity.PrescrizioneMedica;
import Transient.PazienteTransient;
import Utility.JSONUtility;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Marco
 */
@WebService(serviceName = "WSPaziente")
@Stateless()
public class WSPaziente {

    @EJB
    private GestoreCartellaClinicaLocal gestoreCartellaClinica;

    @EJB
    private GestoreLoginLocal gestoreLogin;

    @EJB
    private GestoreMedicoLocal gestoreMedico;

    @EJB
    private GestoreUtenteLocal gestoreUtente;

    @EJB
    private PazienteFacadeLocal ejbRef;

    @WebMethod(operationName = "create")
    @Oneway
    public void createP(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.create(paziente);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void editP(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.edit(paziente);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void removeP(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.remove(paziente);
    }

    @WebMethod(operationName = "find")
    public Paziente findP(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<Paziente> findAllP() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<Paziente> findRangeP(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int countP() {
        return ejbRef.count();
    }

    /* --- Web Service operation utilizzate dal Client Farmacia ---*/
    /**
     * Operazione che verifica l'esistenza di un paziente con CF dato in input
     *
     * @param CF, codice fiscale paziente da cercare
     * @return id del paziente
     */
    @WebMethod(operationName = "verificaCF")
    public Long verificaCF(@WebParam(name = "CF") String CF) {
        return gestoreUtente.verificaCF(CF);
    }

    /**
     * Recupera le informazioni del paziente in input restituendo un
     * PazienteTransient
     *
     * @param id del paziente
     * @return PazienteTransient che rappresenta il paziente
     */
    @WebMethod(operationName = "getPazienteTransient")
    public PazienteTransient getPazienteTransient(@WebParam(name = "id") Long id) {
        return gestoreUtente.ottieniPaziente(id);
    }

    /* --- Web Service operation utilizzate dal Client Android ---*/
    /**
     * Presi dati in input effettua il login sull'applicazione
     *
     * @param username del medico
     * @param pincode del medico
     * @param password del medico
     * @return JSON "loginOk": id del medico se trovato, oppure -1
     */
    @WebMethod(operationName = "effettuaLogin")
    public String effettuaLogin(@WebParam(name = "username") String username,
            @WebParam(name = "pincode") String pincode, @WebParam(name = "password") String password) {
        Long risp = gestoreLogin.verificaLoginMedico(username, pincode, password);
        return JSONUtility.creaGenericoJSON("loginOK", risp.toString());
    }

    /**
     * Restituisce i pazienti di un medico in formato JSON
     *
     * @param idMedico Long che rappresenta l'id del medico
     * @return JSON che rappresenta la lista dei pazienti
     */
    @WebMethod(operationName = "trovaPazienti")
    public String trovaPazienti(@WebParam(name = "idMedico") Long idMedico) {
        List<Paziente> lp = gestoreMedico.ottieniMieiPazienti(idMedico);
        return JSONUtility.listaPazientiToJSON(lp);
    }

    /**
     * Restituisce la cartella clinica di un paziente in formato JSON
     *
     * @param idPaziente paziente di cui si vuole la cartella clinica
     * @return JSON che rappresenta la cartella clinica del paziente
     */
    @WebMethod(operationName = "ottieniCC")
    public String ottieniCC(@WebParam(name = "idPaziente") Long idPaziente) {
        CartellaClinica cc = gestoreMedico.ottieniCCPaziente(idPaziente);
        return JSONUtility.cartellaClinicaToJSON(cc);
    }

    /**
     * Metodo che restituisce i file multimediali di un referto medico
     *
     * @param idRM referto medico di cui si vogliono i file multimediali
     * @return file multimediali
     */
    @WebMethod(operationName = "ottieniMultimedia")
    public String ottieniMultimedia(@WebParam(name = "idRM") Long idRM) {
        List<String> multimedia = gestoreMedico.ottieniMultimedia(idRM);
        //TODO
        return null;
    }

    /**
     * Metodo che restituisce le prescrizioni mediche di un referto medico
     *
     * @param idRM referto medico di cui si vogliono le prescrizioni mediche
     * @return prescrizioni mediche
     */
    @WebMethod(operationName = "ottieniPM")
    public String ottieniPM(@WebParam(name = "idRM") Long idRM) {
        List<PrescrizioneMedica> lpm = gestoreCartellaClinica.ottieniPM(idRM);
        return JSONUtility.listaPMToJSON(lpm);
    }

}
