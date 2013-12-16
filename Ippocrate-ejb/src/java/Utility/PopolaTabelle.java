package Utility;

import java.io.*;
import java.sql.*;
import java.util.*;

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
        while(s.hasNextLine()){
            st.executeUpdate("INSERT INTO CARTELLACLINICA(ID, ANAMNESI) " +
                    "VALUES('"+s.nextLine()+"','"+s.nextLine()+"')" );
        }
        st.close();
        c.close();
    }
    
    public static void popolaPaziente(String url, String user, String pwd) 
            throws SQLException, FileNotFoundException, IOException {
        
        Connection c = DriverManager.getConnection(url,user,pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/Paziente.txt"));
        while(s.hasNextLine()){
            st.executeUpdate("INSERT INTO PAZIENTE(ID, CF, COGNOME, DATA_NASCITA,"
                    + " INDIRIZZO, LUOGO_NASCITA, NOME, SESSO, CARTELLA_CLINICA_ID) " +
                    "VALUES('"+s.nextLine()+"','"+s.nextLine()+"','"+s.nextLine()+"','"+s.nextLine()+
                    "','"+s.nextLine()+"','"+s.nextLine()+"','"+s.nextLine()+
                    "','"+s.nextLine()+"','"+s.nextLine()+"')" );
        }
        st.close();
        c.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/ippocrate?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pwd = "password";

        try {     
            //Class.forName("com.mysql.jdbc.Driver").newInstance();
           
            //Establish connection using DriverManager 
            //Connection conn = DriverManager.getConnection(url, user, pwd);
            
            popolaCartellaClinica(url,user,pwd);
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
