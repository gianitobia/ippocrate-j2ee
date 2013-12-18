package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *  @author: Varesano
 */
public class PopolaTabelle {
    
    public static void popolaCartellaClinica(String url, String user, String pwd) 
            throws SQLException, FileNotFoundException, IOException {
        
        Connection c = DriverManager.getConnection(url,user,pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/CartellaClinica.txt"));
        String[] valori;
        while(s.hasNextLine()){
            valori = s.nextLine().split(",");          
            st.executeUpdate("INSERT INTO CARTELLACLINICA(ID, ANAMNESI) " +
                    "VALUES('"+valori[0]+"','"+valori[1]+"')" );
        }
        st.close();
        c.close();
    }
    
    public static void popolaPaziente(String url, String user, String pwd) 
            throws SQLException, FileNotFoundException, IOException {
        
        Connection c = DriverManager.getConnection(url,user,pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/Paziente.txt"));
        String[] valori;
        while(s.hasNextLine()){
            valori = s.nextLine().split(",");                      
            st.executeUpdate("INSERT INTO PAZIENTE(ID, CF, COGNOME, DATA_NASCITA,"
                    + " INDIRIZZO, LUOGO_NASCITA, NOME, PASSWORD, SESSO, CARTELLA_CLINICA_ID) " +
                    "VALUES('"+valori[0]+"','"+valori[1]+"','"+valori[2]+"','"+valori[3]+
                    "','"+valori[4]+"','"+valori[5]+"','"+valori[6]+
                    "','"+valori[7]+"','"+valori[8]+"','"+valori[9]+"')" );
        }
        st.close();
        c.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ippocrate?zeroDateTimeBehavior=convertToNull";
 /* Inserisci il tuo user e la tua password */
        String user = MySqlAuth.user;
        String pwd = MySqlAuth.pwd;

        try {     
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            //Establish connection using DriverManager 
            //Connection conn = DriverManager.getConnection(url, user, pwd);
            
            popolaCartellaClinica(url,user,pwd);
            popolaPaziente(url,user,pwd);
            //creaTabellaUtenti(url,user,pwd);
//            popolaTabellaUtentiDaFile(url,user,pwd);
//            creaTabellaCorsi(url,user,pwd);
//            popolaTabellaCorsiDaFile(url,user,pwd);
//            creaTabellaAppelli(url,user,pwd);
//            popolaTabellaAppelliDaFile(url,user,pwd);
//            creaTabellaIscrizione(url, user, pwd);
//            popolaTabellaIscrizioneDaFile(url, user, pwd);
//            creaTabellaCaricoDidattico(url, user, pwd);
//            popolaTabellaCaricoDidatticoDaFile(url, user, pwd);
            //conn.close();      
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
