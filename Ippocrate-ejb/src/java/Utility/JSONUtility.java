/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.Paziente;
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

    /**
     * Realizza il JSON partendo da una lista di pazienti
     *
     * @param lp lista di pazienti
     * @return JSON della lista di pazienti
     */
    public static String listaPazientiToJSON(List<Paziente> lp) {
//ESEMPIO {
//            "mieiPazienti": [
//                              {"nome": "Marco", "cognome": "Busso"},
//                              {"nome": "Marco", "cognome": "Varesano"},
//                              {"nome": "Tobia", "cognome": "Giani"}
//                            ]
//        }

        JSONObject obj = new JSONObject();

        List l = new LinkedList();

        try {
            for (Paziente p : lp) {
                Map m = new HashMap();
                m.put("nome", p.getNome());
                m.put("cognome", p.getCognome());
                l.add(m);
            }
            obj.put("mieiPazienti", l);
        } catch (Exception e) {
            System.err.println(e);
        }
        return obj.toJSONString();
    }

}
