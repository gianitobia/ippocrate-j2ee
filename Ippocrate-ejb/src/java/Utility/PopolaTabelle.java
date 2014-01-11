package Utility;

import Controller.GestoreInserimentoDatiLocal;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author: Varesano
 */
public class PopolaTabelle {
    GestoreInserimentoDatiLocal gestoreInserimentoDati = lookupGestoreInserimentoDatiLocal();
    
//    public static void popolaCartellaClinica()
//            throws SQLException, FileNotFoundException, IOException {
//
//        Connection c = DriverManager.getConnection(url, user, pwd);
//        Statement st = c.createStatement();
//        Scanner s = new Scanner(new File("src/java/Utility/CartellaClinica.txt"));
//        String[] valori;
//        while (s.hasNextLine()) {
//            valori = s.nextLine().split(",");
//            st.executeUpdate("INSERT INTO CARTELLACLINICA(ID, ANAMNESI) "
//                    + "VALUES('" + valori[0] + "','" + valori[1] + "')");
//        }
//        st.close();
//        c.close();
//    }

    public void popolaPaziente() throws FileNotFoundException {

        Scanner s = new Scanner(new File("src/java/Utility/Paziente.txt"));
        String[] valori;
        while (s.hasNextLine()) {
            valori = s.nextLine().split(",");
            
            gestoreInserimentoDati.addPaziente(valori[1], valori[2], valori[4], valori[3], valori[5], valori[6], new Date(valori[7]), valori[8]);
//            st.executeUpdate("INSERT INTO PAZIENTE(ID, NOME, COGNOME, PASSWORD"
//                    + ", CF, SESSO, INDIRIZZO, DATA_NASCITA, LUOGO_NASCITA, CARTELLA_CLINICA_ID) "
//                    + "VALUES('" + valori[0] + "','" + valori[1] + "','" + valori[2] + "','" + valori[3]
//                    + "','" + valori[4] + "','" + valori[5] + "','" + valori[6]
//                    + "','" + valori[7] + "','" + valori[8] + "','" + valori[9] + "')");
        }
    }

//    public static void popolaAgenda()
//            throws SQLException, FileNotFoundException, IOException {
//
//        Scanner s = new Scanner(new File("src/java/Utility/Agenda.txt"));
//        String[] valori;
//        while (s.hasNextLine()) {
//            valori = s.nextLine().split(",");
//            Agenda a = new Agenda();
//            a.setId(Long.parseLong(valori[0]));
//            /*st.executeUpdate("INSERT INTO AGENDA(ID, CLIENT_ID, DEVELOPER_KEY, ID_CALENDARIO,"
//                    + " NOME_UTENTE, PASSWORD, SECRET_KEY) "
//                    + "VALUES('" + valori[0] + "','" + valori[1] + "','" + valori[2] + "','" + valori[3]
//                    + "','" + valori[4] + "','" + valori[5] + "','" + valori[6] + "')");*/
//           agendaFacade.create(a);
//        }
//    }

    public static void main(String[] args) {
        PopolaTabelle pt = new PopolaTabelle();
        try {
            pt.popolaPaziente();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PopolaTabelle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private GestoreInserimentoDatiLocal lookupGestoreInserimentoDatiLocal() {
        try {
            Context c = new InitialContext();
            return (GestoreInserimentoDatiLocal) c.lookup("java:global/Ippocrate/Ippocrate-ejb/GestoreInserimentoDati!Controller.GestoreInserimentoDatiLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
