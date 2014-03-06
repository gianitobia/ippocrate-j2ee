/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import Entity.Paziente;
import Entity.PazienteFacadeLocal;
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
    private PazienteFacadeLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "create")
    @Oneway
    public void create(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.create(paziente);
    }
    
    @WebMethod(operationName = "edit")
    @Oneway
    public void edit(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.edit(paziente);
    }
    
    @WebMethod(operationName = "remove")
    @Oneway
    public void remove(@WebParam(name = "paziente") Paziente paziente) {
        ejbRef.remove(paziente);
    }
    
    @WebMethod(operationName = "find")
    public Paziente find(@WebParam(name = "id") Object id) {
        return ejbRef.find(id);
    }
    
    @WebMethod(operationName = "findAll")
    public List<Paziente> findAll() {
        return ejbRef.findAll();
    }
    
    @WebMethod(operationName = "findRange")
    public List<Paziente> findRange(@WebParam(name = "range") int[] range) {
        return ejbRef.findRange(range);
    }
    
    @WebMethod(operationName = "count")
    public int count() {
        return ejbRef.count();
    }

    /**
     * Operazione che verifica l'esistenza di un paziente con CF dato in input
     */
    @WebMethod(operationName = "verificaCF")
    public Long verificaCF(@WebParam(name = "CF") String CF) {
        List<Paziente> lp = ejbRef.findAll();
        for (Paziente p : lp) {
            if (p.getCf().equals(CF)) {
                return p.getId();
            }
        }
        return new Long(-1);
    }
    
}
