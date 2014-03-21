/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.Paziente;
import java.io.StringWriter;
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

    private static String JSONFail = "{\"result\":\"fail\"}";

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
        } catch (Exception e) {
            return JSONFail;
        }
        return jsonText;
    }

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
        } catch (Exception e) {
            return JSONFail;
        }
        return jsonText;
    }
}
