/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.CartellaClinica;
import Entity.Paziente;
import Entity.RefertoMedico;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.simple.*;
import java.util.List;
import java.util.Map;

/**
 * Classe utile per creare JSON
 *
 * @author Marco
 */
public class JSONUtility {

    private static final String JSONFail = "{\"result\":\"fail\"}";

    /**
     * Realizza il JSON partendo da una lista di pazienti
     *
     * @param lp lista di pazienti
     * @return JSON della lista di pazienti
     */
    public static String listaPazientiToJSON(List<Paziente> lp) {
//ESEMPIO {
//            "mieiPazienti": [
//                              {"idPaziente": "11", "nome": "Marco", "cognome": "Busso"},
//                              {"idPaziente": "12", "nome": "Marco", "cognome": "Varesano"},
//                              {"idPaziente": "13", "nome": "Tobia", "cognome": "Giani"}
//                            ]
//        }

        JSONObject obj = new JSONObject();

        List l = new LinkedList();

        for (Paziente p : lp) {
            Map m = new HashMap();
            m.put("idPaziente", p.getId().toString());
            m.put("nome", p.getNome());
            m.put("cognome", p.getCognome());
            l.add(m);
        }
        obj.put("mieiPazienti", l);

        StringWriter out = new StringWriter();
        String jsonText = "";
        try {
            obj.writeJSONString(out);
            jsonText = out.toString();
        } catch (IOException e) {
            return JSONFail;
        }
        return jsonText;
    }

    /**
     * Realizza il JSON partendo da due input
     *
     * @param param1
     * @param param2
     * @return JSON contenente i due input
     */
    public static String creaGenericoJSON(String param1, String param2) {
//ESEMPIO {
//            "param1": "param2"
//        }

        JSONObject obj = new JSONObject();
        obj.put(param1, param2);

        StringWriter out = new StringWriter();
        String jsonText = "";
        try {
            obj.writeJSONString(out);
            jsonText = out.toString();
        } catch (IOException e) {
            return JSONFail;
        }
        return jsonText;
    }

    /**
     * Realizza il JSON partendo da una cartella clinica
     *
     * @param cc cartella clinica del paziente
     * @return JSON della cartella clinica
     */
    public static String cartellaClinicaToJSON(CartellaClinica cc) {
//ESEMPIO {
//            "idCC": "19",
//            "anamnesi": "Mal di gola. Distorsione caviglia dx",
//            "referti": [
//                         {"idRM": "11", "tipoVisita": "Visita cardiologica", "data": "15/04/2013", "medico": "Bianchi", "diagnosi": "Mal di gola acuto"},
//                         {"idRM": "14", "tipoVisita": "Visita ortopedica", "data": "22/03/2014", "medico": "Rossi", "diagnosi": "Distorsione caviglia dx"}
//                       ]
//        }

        List<RefertoMedico> lrm = cc.getLista_referti();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        JSONObject obj = new JSONObject();

        obj.put("idCC", cc.getId().toString());
        obj.put("anamnesi", cc.getAnamnesi());

        List l = new LinkedList();

        for (RefertoMedico rm : lrm) {
            Map m = new HashMap();
            m.put("idRM", rm.getId().toString());
            m.put("tipoVisita", rm.getTipoVisita().getNome());
            m.put("data", sdf.format(rm.getDataVisita()));
            m.put("medico", rm.getMedico().getCognome());
            m.put("diagnosi", rm.getDiagnosi());
            l.add(m);
        }
        obj.put("referti", l);

        StringWriter out = new StringWriter();
        String jsonText = "";
        try {
            obj.writeJSONString(out);
            jsonText = out.toString();
        } catch (IOException e) {
            return JSONFail;
        }
        return jsonText;
    }
}
