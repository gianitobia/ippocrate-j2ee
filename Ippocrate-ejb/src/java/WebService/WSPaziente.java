/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

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

    /**
     * Restituisce i pazienti di un medico in formato JSON
     *
     * @param idM Long che rappresenta l'id del medico
     * @return JSON che rappresenta la lista dei pazienti
     */
    @WebMethod(operationName = "trovaPazienti")
    public String trovaPazientiJSON(@WebParam(name = "idM") Long idM) {
        List<Paziente> lp = gestoreMedico.ottieniMieiPazienti(idM.longValue());
        return JSONUtility.listaPazientiToJSON(lp);
    }

}
