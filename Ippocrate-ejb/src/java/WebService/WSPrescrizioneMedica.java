/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package WebService;

import Entity.PrescrizioneMedica;
import Entity.PrescrizioneMedicaFacadeLocal;
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
    private PrescrizioneMedicaFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.create(prescrizioneMedica);
    }

    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.edit(prescrizioneMedica);
    }

    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "prescrizioneMedica") PrescrizioneMedica prescrizioneMedica) {
        ejbRef.remove(prescrizioneMedica);
    }

    @WebMethod(operationName = "find")
    public PrescrizioneMedica find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }

    @WebMethod(operationName = "findAll")
    public List<PrescrizioneMedica> findAll() {
        return ejbRef.findAll();
    }

    @WebMethod(operationName = "findRange")
    public List<PrescrizioneMedica> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }

    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }
    
}
