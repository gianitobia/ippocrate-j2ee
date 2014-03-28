/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        String data = ((int) (1960 + Math.random() * 55)) + "-"+ ((int) (Math.random() * 11 + 1))+"-"+ ((int) (Math.random() * 30 + 1));
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
}
