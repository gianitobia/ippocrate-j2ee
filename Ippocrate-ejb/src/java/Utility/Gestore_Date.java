/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Gestore_Date {
    
    //Genera un data random
    public static Date generateDate() {
        DateFormat ndf = new SimpleDateFormat("yyyy-MM-dd");
        String data = ((int) (1960 + Math.random() * 25)) + "-"+ ((int) (Math.random() * 11 + 1))+"-"+ ((int) (Math.random() * 30 + 1));
        Date d = new Date();
        try {
            d = ndf.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(Gestore_Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    
    //genera una data da un stringa;
    public static Date generateDateFromString(String data, char separator) {
        DateFormat ndf = new SimpleDateFormat("dd" + separator + "MM" + separator +"yyyy");
        Date d = new Date();
        try {
            d = ndf.parse(data);
            ndf = new SimpleDateFormat("yyyy-MM-dd");
            d = ndf.parse(ndf.format(d));
        }catch (ParseException ex) {
            Logger.getLogger(Gestore_Date.class.getName()).log(Level.SEVERE, null, ex);
        } return d;
    }
    
    //Restituisce una stringa rappresentate la data in input formattata con un separatore scelto;
    public static String generateStringFromDate(Date data, char separator) {
        DateFormat ndf = new SimpleDateFormat("dd" + separator + "MM" + separator +"yyyy");
        return ndf.format(data);    
    }
    
    //Restituisce un array di due data (la prima precedente alla seconda) rispettivamente 
    //per data creazione di una prescrizione e scadenza
    public static Date[] generateDateInterval(int interval_days) {
        Date[] dates = new Date[2];
        DateFormat ndf = new SimpleDateFormat("yyyy-MM-dd");
        String data = (2013 + "-" + ((int) (Math.random() * 11 + 1)) + "-" + ((int) (Math.random() * 30 + 1)));
        Date d = new Date();
        try {
            //imposto la data di prescrizione
            d = ndf.parse(data);
            dates[0] = d;
            //Prendo un calendario gli setto al data[0] e ci agigungo i giorni in input
            Calendar c = Calendar.getInstance();
            c.setTime(d);
            c.add(Calendar.DATE, interval_days);
            dates[1] = c.getTime();
        } catch (ParseException ex) {
            Logger.getLogger(Gestore_Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dates;
    } 
}
