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
public class PrenotazioneMedico extends Prenotazione implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Medico medico;

    @OneToOne
    private PrestazioneMedico tipo_prestazione;

    /**
     * Get the value of tipo_prestazione
     *
     * @return the value of tipo_prestazione
     */
    public PrestazioneMedico getTipo_prestazione() {
        return tipo_prestazione;
    }

    /**
     * Set the value of tipo_prestazione
     *
     * @param tipo_prestazione new value of tipo_prestazione
     */
    public void setTipo_prestazione(PrestazioneMedico tipo_prestazione) {
        this.tipo_prestazione = tipo_prestazione;
    }

    /**
     * Get the value of medico
     *
     * @return the value of medico
     */
    public Medico getMedico() {
        return medico;
    }

    /**
     * Set the value of medico
     *
     * @param medico new value of medico
     */
    public void setMedico(Medico medico) {
        this.medico = medico;
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
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PrenotazioneMedico)) {
            return false;
        }
        PrenotazioneMedico other = (PrenotazioneMedico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrenotazioneMedico [" + "id " + id + " " + "medico " + medico + " " + "getData_prenotazione " + getData_prenotazione() + " " + "getPaziente " + getPaziente() + " " + "getTipo_prestazione " + getTipo_prestazione() + "]";
    }

    /**
     * Metodo che trasforma una prenotazione di tipo medico in un JSON per
     * l'aggiunta nel calendario google
     *
     * @return JSONObject che rappresenta la prenotazione
     */
    @Override
    public JSONObject reservationToJSON() {
        //utilizzo la libreria SimpleJSON
        JSONObject obj = new JSONObject();
        obj.put("prenotazione", this.id + " - " + this.tipo_prestazione.getNome());
        obj.put("struttura", super.getStruttura_medica().getNome());
        obj.put("id_prestazione", this.medico.getId().toString());
        //id_prestazione rappresenta l'id utilizzato per filtrare il calendario google su cui salvare l'evento

        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss.S'+01:00'");
        obj.put("start", ft.format(super.getData_prenotazione()));

        Date dataFine = new Date(super.getData_prenotazione().getTime()
                + (60000 * this.getTipo_prestazione().getDurata()));

        obj.put("end", ft.format(dataFine));
        //imposto l'ID di google nel JSON
        if (super.getGoogleId() != null) {
            obj.put("id_google", super.getGoogleId());
        }
        return obj;
    }

}
