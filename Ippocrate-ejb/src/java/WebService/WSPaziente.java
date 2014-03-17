/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Controller.GestoreLoginLocal;
import Controller.GestoreMedicoLocal;
import Controller.GestoreUtenteLocal;
import Entity.Paziente;
import Entity.PazienteFacadeLocal;
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
     * @param idM Long che rappresenta l'id del medico
     * @return JSON che rappresenta la lista dei pazienti
     */
    @WebMethod(operationName = "trovaPazienti")
    public String trovaPazientiJSON(@WebParam(name = "idM") Long idM) {
        List<Paziente> lp = gestoreMedico.ottieniMieiPazienti(idM);
        return JSONUtility.listaPazientiToJSON(lp);
    }

}
