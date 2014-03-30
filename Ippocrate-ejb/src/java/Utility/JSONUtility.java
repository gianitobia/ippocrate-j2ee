/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import Entity.CartellaClinica;
import Entity.Paziente;
import Entity.PrescrizioneMedica;
import Entity.RefertoMedico;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.LinkedList;
import org.json.simple.*;
import java.util.List;
import java.util.Map;
import org.apache.commons.codec.binary.Base64;

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

    /**
     * Metodo che trasforma un file (un'immagine di un referto) in un array di
     * byte
     *
     * @param file che rappresenta l'immagine in input
     * @return array di byte
     * @throws IOException in caso di trasformazione fallita
     */
    private static byte[] loadFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
            throw new IOException("File: " + file.getName() + "is too large");
        }
        byte[] bytes = new byte[(int) length];
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
            offset += numRead;
        }

        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;
    }

    /**
     * Realizza il JSON partendo da una lista di path di file
     *
     * @param multimedia lista di path di file multimediali
     * @return JSON delle immagini dei referti medici (codificate in base64)
     */
    public static String encodeImageToJSON(List<String> multimedia) {
//ESEMPIO {
//            "multimedia": [
//                            {"image": "image_1"},
//                            {"image": "image_2"},
//                            {"image": "image_3"}
//                          ]
//        }              

        JSONObject obj = new JSONObject();
        List l = new LinkedList();

        String path = JSONUtility.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String path2 = path.substring(1, path.indexOf("dist")) + "Ippocrate-war/web/";

        for (String multim : multimedia) {
            String path3 = path2 + multim;
            File imgFile = new File(path3);
            if (imgFile.exists()) {
                byte[] bytes;
                try {
                    bytes = loadFile(imgFile);
                } catch (IOException ex) {
                    return JSONFail;
                }
                byte[] encoded = Base64.encodeBase64(bytes);
                String encodedString = new String(encoded);
                Map m = new HashMap();
                m.put("image", encodedString);
                l.add(m);
            }
        }
        obj.put("multimedia", l);

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
     * Realizza il JSON partendo da una lista di prescrizioni mediche
     *
     * @param lpm lista di prescrizioni mediche
     * @return JSON delle prescrizioni mediche
     */
    public static String listaPMToJSON(List<PrescrizioneMedica> lpm) {
//ESEMPIO {
//            "prescrizioni": [
//                              {"idPM": "34", "dataPrescrizione": "15/04/2013", "dataScadenza": "01/05/2013", "medicinale": "Analgesico", "quantita": "3"},
//                              {"idPM": "33", "dataPrescrizione": "18/07/2013", "dataScadenza": "18/02/2014", "medicinale": "Antipiretico", "quantita": "1"},
//                              {"idPM": "21", "dataPrescrizione": "22/02/2013", "dataScadenza": "15/04/2014", "medicinale": "Cerotti", "quantita": "5"}
//                            ]
//        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        JSONObject obj = new JSONObject();

        List l = new LinkedList();

        for (PrescrizioneMedica pm : lpm) {
            Map m = new HashMap();
            m.put("idPM", pm.getId().toString());
            m.put("dataPrescrizione", sdf.format(pm.getData_prescrizione()));
            m.put("dataScadenza", sdf.format(pm.getData_scadenza()));
            m.put("medicinale", pm.getMedicinale());
            m.put("quantita", pm.getNumero_confezioni());
            l.add(m);
        }
        obj.put("prescrizioni", l);

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
