/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HttpClient;

import Entity.Prenotazione;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

//Libreria per la gesione dei JSON
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Alex
 */
public class HttpCalendarClient {

    private final String url = "http://localhost:5000/ippocrate/calendar/v1.0/";
    private final CloseableHttpClient httpclient;

    public HttpCalendarClient() {
        httpclient = HttpClients.createDefault();
    }

    /*
     Funzione per inviare una request al WS remoto:
     TRUE - Risposta positiva
     FALSE - Risposta negativa
     */
    private String send_request(JSONObject req, String operation) {
        String success = null;
        //imposto il "contenitore" della risposta JSON
        CloseableHttpResponse response1 = null;
        //creo una richiesta di tipo POSTal WS
        HttpPost r_post = new HttpPost(url + operation);
        //imposto l'HEADER della richiesta a JSON
        r_post.addHeader(new BasicHeader("Content-Type", "application/json"));
        //Creo l'entita' da inserire nella richiesta, ipostandone come contenuto il JSON
        StringEntity param = new StringEntity(req.toJSONString(), "UTF8");
        param.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        r_post.setEntity(param);
        //EFFETTUO LA RICHIESTA
        try {
            //EFFETTUO la richiesta ed attendo la risposta dal WS
            response1 = httpclient.execute(r_post);
            if (response1.getEntity() != null) {
                //converto lo stream ottenuto in un oggetto JSON
                JSONObject risposta = convertStreamToJson(response1.getEntity().getContent());
                if (risposta != null) {
                    String result = (String) risposta.get("code");
                    if (result.equalsIgnoreCase("201")) {
                        success = (String) risposta.get("id");
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(HttpCalendarClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                response1.close();
            } catch (IOException ex) {
                Logger.getLogger(HttpCalendarClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return success;
    }

    /*
     Funzione per inviare una request al WS e salvarne la risposta in oggetto JSON
     */
    private JSONObject send_request_response(JSONObject req, String operation) {
        //oggetto da rimpire e restituire
        JSONObject res = null;
        //imposto il "contenitore" della risposta JSON
        CloseableHttpResponse response1 = null;
        //creo una richiesta di tipo POSTal WS
        HttpPost r_post = new HttpPost(url + operation);
        //imposto l'HEADER della richiesta a JSON
        r_post.addHeader(new BasicHeader("Content-Type", "application/json"));
        //Creo l'entita' da inserire nella richiesta, ipostandone come contenuto il JSON
        StringEntity param = new StringEntity(req.toJSONString(), "UTF8");
        param.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "application/json"));
        r_post.setEntity(param);
        //EFFETTUO LA RICHIESTA
        try {
            //EFFETTUO la richiesta ed attendo la risposta dal WS
            response1 = httpclient.execute(r_post);
            if (response1.getEntity() != null) //converto lo stream ottenuto in un oggetto JSON
            {
                res = convertStreamToJson(response1.getEntity().getContent());
            }

        } catch (IOException ex) {
            Logger.getLogger(HttpCalendarClient.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                response1.close();
            } catch (IOException ex) {
                Logger.getLogger(HttpCalendarClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return res;
    }

    /*
     Funzione per richiedere la creazione di un nuovo evento
     al ws remoto, protocollo di comunicazione:
     1. Invio JSON contenente evento
     2. Ricevo risultato di creazione/fallimento (201/400)
     */
    public String create_event(Prenotazione e) {
        return this.send_request(e.reservationToJSON(), "new_event/");
    }

    /*
     Funzione per richiedere la cancellazione di un nuovo evento
     al WS remoto, protocollo di comunicazione:
     1. Invio JSON contenente evento
     2. Ricevo risultato di creazione/fallimento (201/400)
     */
    public String delete_event(Prenotazione e) {
        return this.send_request(e.reservationToJSON(), "delete_event/");
    }

    /*
     Funzione per richiedere la disponibilita' di uno slot in
     calendario di una sala:
     1. Invio JSON contenente evento
     2. Ricevo risultato di creazione/fallimento (201/400)
     */
    public String slot_available(Prenotazione e) {
        return this.send_request(e.reservationToJSON(), "check_slot/");
    }

    /*
     Funzione che richiede l'id di un calendario al WS Python, in input prende il
     nome della struttura medica, mentre entita e' riferito a medico o sala
     */
    public String get_calendar_id(String nomeStruttura, String entita) {
        JSONObject obj = new JSONObject();
        obj.put("struttura", nomeStruttura);
        obj.put("entita", entita);

        return this.send_request(obj, "get_calendar/");
    }

    /*
     Funzione che richiede gli slot liberi di una settimana, ritorna 
     una lista di vettori di stringhe:
     L = {
     (1) -> stringa[0] = start, stringa[1] = end
     (2) -> ...
     ...
     }      
     */
    public ArrayList<String[]> slots_available_week(int n_week, String ospedale, String sala) {
        //oggetto da restituire
        ArrayList<String[]> disponibili = null;

        //Costruisco il file JSON di richiesta
        JSONObject req = new JSONObject();
        req.put("ospedale", ospedale);
        req.put("sala", sala);
        req.put("settimana", new Integer(n_week));

        //Effettuo la richiesta
        JSONObject risp = this.send_request_response(req, "slots_free/");
        if (((String) risp.get("code")).equalsIgnoreCase("200")) {
            disponibili = new ArrayList<>();
            JSONArray slots = (JSONArray) risp.get("slots");
            //Iterator<JSONObject> slot = slots.iterator();
            for (Object obj : slots) {
                JSONObject slot = (JSONObject) obj;
                String[] val = new String[2];
                val[0] = (String) slot.get("start");
                val[1] = (String) slot.get("end");
                disponibili.add(val);
            }
        }
        return disponibili;
    }
    
    /*
     public String createAllCalendars(List<StrutturaMedica> str) {
     //Creo l'oggetto richiesta
     JSONObject req = new JSONObject();
     JSONArray strutture = new JSONArray();
     //Per ogni Struttura creo un componente della richiesta JSON
     for (StrutturaMedica m : str) {
     JSONObject temp = new JSONObject();
     temp.put("nome", m.getNome());

     List<Sala> sale = new ArrayList<>();
     List<Medico> medici = new ArrayList<>();
     switch (m.getClass().getName()) {
     case "Entity.Ospedale": {
     //Se e' un ospedale devo scorreri i reparti per sale/medici
     for (Reparto r : ((Ospedale) m).getLista_reparti()) {
     sale.addAll(r.getLista_sale());
     medici.addAll(r.getLista_medici());
     }
     break;
     }
     case "Entity.StudioMedico": {
     sale.addAll(((StudioMedico) m).getLista_sale());
     medici.addAll(((StudioMedico) m).getLista_medici());
     }
     }

     //creo un JSONArray di Sale
     JSONArray sp = new JSONArray();
     for (Sala s : sale) {
     sp.add(s.getTipoLaboratorio());
     }
     temp.put("sale", sp);

     //creo un JSONArray di Medici
     JSONArray mp = new JSONArray();
     for (Medico md : medici) {
     mp.add(md.getUsername());
     }
     temp.put("medici", mp);

     //Aggiungo l'oggetto al JSONArray di strutture
     strutture.add(temp);
     }
     //Aggiungo il corpo della richiesta JSON
     req.put("strutture", strutture);

     return this.send_request(req, "create_calendars/");
     }
     */
//    public static void main(String[] args) {
//
//        HttpCalendarClient test = new HttpCalendarClient();
//        Prenotazione nuovo = new Prenotazione("23456",
//                "Maria Vittoria",
//                "lab_analisi",
//                "2014-03-26T10:00:00.000+01:00",
//                "2014-03-26T10:30:00.000+01:00");
//        nuovo.setGoogle_Id("jntvdldnqg4toiomtt4rb62428");
//        System.out.println("creazione: " + nuovo.getGoogle_Id());
//        test.delete_event(nuovo);
        /*
     System.out.println("cancellazione: " + test.delete_event(new Prenotazione("123", "molinette", "sala", "345", "678")));
     System.out.println("slot_check: " + test.slot_available(new Prenotazione("123", "molinette", "sala", "345", "678")));
     System.out.println("slots_free: ");
     for (String[] s : test.slots_available_week(15, "molinette", "rianimazione")) {
     System.out.println("Start: "+ s[0] + " End: "+ s[1]);
     }*/
//    }
    private static JSONObject convertStreamToJson(InputStream is) {
        try {
            return (JSONObject) (new JSONParser()).parse(new BufferedReader(new InputStreamReader(is)));
        } catch (IOException | ParseException ex) {
            Logger.getLogger(HttpCalendarClient.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
