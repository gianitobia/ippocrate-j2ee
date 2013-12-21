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
 * @author: Varesano
 */
public class PopolaTabelle {

    public static void popolaCartellaClinica(String url, String user, String pwd)
            throws SQLException, FileNotFoundException, IOException {

        Connection c = DriverManager.getConnection(url, user, pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/CartellaClinica.txt"));
        String[] valori;
        while (s.hasNextLine()) {
            valori = s.nextLine().split(",");
            st.executeUpdate("INSERT INTO CARTELLACLINICA(ID, ANAMNESI) "
                    + "VALUES('" + valori[0] + "','" + valori[1] + "')");
        }
        st.close();
        c.close();
    }

    public static void popolaPaziente(String url, String user, String pwd)
            throws SQLException, FileNotFoundException, IOException {

        Connection c = DriverManager.getConnection(url, user, pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/Paziente.txt"));
        String[] valori;
        while (s.hasNextLine()) {
            valori = s.nextLine().split(",");
            st.executeUpdate("INSERT INTO PAZIENTE(ID, NOME, COGNOME, PASSWORD"
                    + ", CF, SESSO, INDIRIZZO, DATA_NASCITA, LUOGO_NASCITA, CARTELLA_CLINICA_ID) "
                    + "VALUES('" + valori[0] + "','" + valori[1] + "','" + valori[2] + "','" + valori[3]
                    + "','" + valori[4] + "','" + valori[5] + "','" + valori[6]
                    + "','" + valori[7] + "','" + valori[8] + "','" + valori[9] + "')");
        }
        st.close();
        c.close();
    }

    public static void popolaAgenda(String url, String user, String pwd)
            throws SQLException, FileNotFoundException, IOException {

        Connection c = DriverManager.getConnection(url, user, pwd);
        Statement st = c.createStatement();
        Scanner s = new Scanner(new File("src/java/Utility/Agenda.txt"));
        String[] valori;
        while (s.hasNextLine()) {
            valori = s.nextLine().split(",");
            st.executeUpdate("INSERT INTO AGENDA(ID, CLIENT_ID, DEVELOPER_KEY, ID_CALENDARIO,"
                    + " NOME_UTENTE, PASSWORD, SECRET_KEY) "
                    + "VALUES('" + valori[0] + "','" + valori[1] + "','" + valori[2] + "','" + valori[3]
                    + "','" + valori[4] + "','" + valori[5] + "','" + valori[6] + "')");
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
            
            popolaCartellaClinica(url, user, pwd);
            popolaPaziente(url, user, pwd);
            popolaAgenda(url, user, pwd);

            //conn.close();      
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
