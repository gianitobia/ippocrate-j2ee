/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Controller.GestoreCartellaClinicaLocal;
import Entity.PrescrizioneMedica;
import Entity.PrescrizioneMedicaFacadeLocal;
import Transient.PrescrizioneMedicaTransient;
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
@WebService(serviceName = "WSPrescrizioneMedica")
@Stateless()
public class WSPrescrizioneMedica {

    @EJB
    private GestoreCartellaClinicaLocal gestoreCartellaClinica;

    @EJB
    private PrescrizioneMedicaFacadeLocal ejbRef;

    @WebMethod(operationName = "create")
    @Oneway
    public void createPM(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.create(prescrizioneMedica);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void editPM(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.edit(prescrizioneMedica);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void removePM(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.remove(prescrizioneMedica);
    }

    @WebMethod(operationName = "find")
    public PrescrizioneMedica findPM(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<PrescrizioneMedica> findAllPM() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<PrescrizioneMedica> findRangePM(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int countPM() {
        return ejbRef.count();
    }

    /**
     * Recupera le prescrizioni mediche del paziente restituendole in formato
     * PrescrizioneMedicaTransient
     *
     * @param idPaziente di cui vogliamo le prescrizioni mediche
     * @return lista di PrescrizioneMedicaTransient
     */
    @WebMethod(operationName = "getPMTransient")
    public List<PrescrizioneMedicaTransient> getPMTransient(@WebParam(name = "idPaziente") Long idPaziente) {
        return gestoreCartellaClinica.ottieniPM(idPaziente);
    }

    /**
     * Modifica la prescrizione medica impostando consegnata a si'
     * @param idPM identificatore della PM da consegnare
     * @return la PM Transient modificata
     */
    @WebMethod(operationName = "segnaConsegnata")
    public PrescrizioneMedicaTransient segnaConsegnata(@WebParam(name = "idPM") Long idPM) {
        return gestoreCartellaClinica.segnaConsegnata(idPM);
    }

}
