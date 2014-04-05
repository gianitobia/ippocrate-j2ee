/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import org.json.simple.JSONObject;

/**
 *
 * @author toby
 */
@Entity
public class PrenotazioneSala extends Prenotazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Sala sala;

    @OneToOne
    private PrestazioneSala tipo_prestazione;

    /**
     * Get the value of tipo_prestazione
     *
     * @return the value of tipo_prestazione
     */
    public PrestazioneSala getTipo_prestazione() {
        return tipo_prestazione;
    }

    /**
     * Set the value of tipo_prestazione
     *
     * @param tipo_prestazione new value of tipo_prestazione
     */
    public void setTipo_prestazione(PrestazioneSala tipo_prestazione) {
        this.tipo_prestazione = tipo_prestazione;
    }

    /**
     * Get the value of sala
     *
     * @return the value of sala
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Set the value of sala
     *
     * @param sala new value of sala
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "PrenotazioneSala [" + "id " + id + " " + "sala " + sala + " " + "getData_prenotazione " + getData_prenotazione() + " " + "getPaziente " + getPaziente() + " " + "getTipo_prestazione " + getTipo_prestazione() + "]";
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrenotazioneSala)) {
            return false;
        }
        PrenotazioneSala other = (PrenotazioneSala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    /**
     * Metodo che trasforma una prenotazione di tipo sala in un JSON per
     * l'aggiunta nel calendario google
     *
     * @return JSONObject che rappresenta la prenotazione
     */
    @Override
    public JSONObject reservationToJSON() {
        //utilizzo la libreria SimpleJSON
        JSONObject obj = new JSONObject();
        obj.put("prenotazione", this.id);
        obj.put("struttura", super.getStruttura_medica().getNome());
        obj.put("id_prestazione", this.sala.getId().toString());
        //id_prestazione rappresenta l'id utilizzato per filtrare il calendario google su cui salvare l'evento

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss.SSS'+02:00'");
        obj.put("start", ft.format(super.getData_prenotazione()));

        Date dataFine = new Date(super.getData_prenotazione().getTime()
                + (60000 * this.getTipo_prestazione().getDurata()));

        obj.put("end", ft.format(dataFine));
        //imposto l'ID di google nel JSON
        if (super.getGoogleId() != null) {
            obj.put("id_google", super.getGoogleId());
        }

        System.out.println(obj.toJSONString());
        return obj;
    }

}
