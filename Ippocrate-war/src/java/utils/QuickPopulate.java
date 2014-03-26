/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Controller.GestoreInserimentoDatiLocal;
import Entity.CartellaClinicaFacadeLocal;
import Entity.MedicoEsternoFacadeLocal;
import Entity.MedicoOspedalieroFacadeLocal;
import Entity.OspedaleFacadeLocal;
import Entity.PazienteFacadeLocal;
import Entity.RepartoFacadeLocal;
import Entity.SalaFacadeLocal;
import Entity.StudioMedicoFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author toby
 */
@WebServlet(name = "QuickPopulate", urlPatterns = {"/QuickPopulate"})
public class QuickPopulate extends HttpServlet {

    @EJB
    private GestoreInserimentoDatiLocal insert;

    @EJB
    private MedicoOspedalieroFacadeLocal medicoOspedalieroFacade;

    @EJB
    private MedicoEsternoFacadeLocal medicoEsternoFacade1;

    @EJB
    private OspedaleFacadeLocal ospedaleFacade;

    @EJB
    private PazienteFacadeLocal pazienteFacade;

    @EJB
    private RepartoFacadeLocal repartoFacade;

    @EJB
    private MedicoEsternoFacadeLocal medicoEsternoFacade;

    @EJB
    private CartellaClinicaFacadeLocal cartellaClinicaFacade;

    @EJB
    private StudioMedicoFacadeLocal studioMedicoFacade;

    @EJB
    private SalaFacadeLocal salaFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String[] prestazioniSala = {"Amniocentesi",
            "Biopsia cervicovaginale ",
            "Ecocolordoppler del seno",
            "Ecocolordoppler ostetrico-ginecologico ",
            "Ecografia del seno",
            "Ecografia ginecologica",
            "Ecografia ostetrica",
            "Ecografia strutturale",
            "Pap-test",
            "Implantologia",
            "Otturazione carie 3 pareti",
            "Elettrocardiogramma",
            "Infiltrazione articolare",
            "Doppler vascolare",
            "Terapia sclerosante",
            "Trattamento delle ulcere varicose",
            "Correnti di Kotz",
            "Correnti interferenziali",
            "Elettrostimolazioni",
            "Elettroterapia antalgica",
            "Ionoforesi",
            "Linfodrenaggio manuale",
            "Magnetoterapia a placche",
            "Massoterapia terapeutica",
            "Rieducazione motoria",
            "Ultrasuonoterapia",
            "Ecografia addome superiore",
            "Rettoscopia – Proctoscopia",
            "Chirurgia dermatologica",
            "Crioterapia",
            "Dermatoscopia",
            "Elettrocoagulazione",
            "Mesoterapia",
            "Peeling cutaneo",
            "Ricerca microscopica infezioni della pelle",
            "Terapie dermatologiche topiche",
            "Trattamento anticellulite",
            "Trattamento antietà con crio-resurfacing",
            "Trattamento laser dei capillari",
            "Trattamento rughe con acido ialuronico",
            "Trattamento smagliature",
            "Tricogramma",
            "Cura del piede",
            "Massaggio circolatorio del piede",
            "Esame audiometrico",
            "Esame impedenzometrico",
            "Esame vestibolare",
            "Impedenzometria ",
            "Laringoscopia",
            "Otoscopia",
            "Rinoscopia",
            "Fondo oculare",
            "Fonometria",
            "Ago aspirato ecoguidato del seno",
            "Agobiopsia del seno",
            "Dermatoscopia del seno",
            "Ecocolordoppler del seno",
            "Ecografia del seno"};
        
        String[] prestazioniMedico = {"Visita ginecologica",
            "Visita ostetrica",
            "Visita senologica",
            "Visita internistica",
            "Ablazione tartaro",
            "Tampone vaginale",
            "Capsula in oro-ceramica",
            "Estrazione dente permanente",
            "Visita diabetologica ",
            "Visita endocrinologica",
            "Visita odontoiatrica",
            "Visita ortodontica",
            "Visita cardiologia",
            "Visita ortopedica",
            "Visita neonatologica",
            "Visita pediatrica",
            "Visita angiologia",
            "Visita dermatologica",
            "Visita chirurgica vascolare ",
            "Visita epatologica",
            "Visita gastroenterologica",
            "Visite dietologiche ",
            "Colloquio psicodiagnostico",
            "Colloquio psicologico",
            "Misurazione dello stress",
            "Psicoterapia individuale",
            "Visita otorino",
            "Test psicodiagnostico",
            "Visita oculistica",
            "Visita senologica",
            "Visita senologica con ecografia",
            "Visita dermatologica"};
        
        insert.addPrestazioni(prestazioniMedico,prestazioniSala);
        
        //creazione dio
        Long medico_dio = insert.addMedicoOspedaliero("Gregory", "House", "Patologo", new Date(1959, 5, 15), "house", "sonodio", "666", "1C");
        Long medico_pippa = insert.addMedicoEsterno("Hershel", "Greene", "Ginecologo", new Date(1942, 11, 17), "hershel", "sonopippa", "666");

        //creazione ospedali
        Long id_o_1 = insert.addOspedale("Maria Vittoria", "Via Cibrario, 72, Torino");
        Long id_o_2 = insert.addOspedale("CTO", "Via Gianfranco Zuretti, 29, 10126 Torino");
        Long id_o_3 = insert.addOspedale("Amedeo di Savoia", "Corso Svizzera, 164, 10149 Torino");
        Long id_o_4 = insert.addOspedale("Molinette", "Corso Bramante, 88, 10126 Torino");

        //creazione studi medici
        Long id_sm_1 = insert.addStudioMedico("R.I.B.A.", "Corso Regina Margherita, 10, 10133 Torino");
        Long id_sm_2 = insert.addStudioMedico("Corba", "Via Roma, 1, 10012 Torino");
        Long id_sm_3 = insert.addStudioMedico("C.D.C", "Piazza Bernini, 5, 10136 Torino");

        //creazione reparti
        Long id_r_1 = insert.addReparto(id_o_1, "Cardiologia", medico_dio);
        Long id_r_2 = insert.addReparto(id_o_1, "Chirurgia generale", medico_dio);
        Long id_r_3 = insert.addReparto(id_o_1, "Dialisi", medico_dio);
        Long id_r_4 = insert.addReparto(id_o_1, "Gastroenterologia", medico_dio);
        Long id_r_5 = insert.addReparto(id_o_1, "Geriatria", medico_dio);
        Long id_r_6 = insert.addReparto(id_o_1, "Radiologia", medico_dio);
        Long id_r_7 = insert.addReparto(id_o_1, "Ortopedia", medico_dio);
        Long id_r_8 = insert.addReparto(id_o_1, "Laboratorio analisi", medico_dio);
        Long id_r_9 = insert.addReparto(id_o_1, "Medicina fisica e riabilitazione", medico_dio);
        Long id_r_10 = insert.addReparto(id_o_1, "Ortopedia e Traumatologia", medico_dio);

        Long id_r_11 = insert.addReparto(id_o_2, "Cardiologia", medico_dio);
        Long id_r_12 = insert.addReparto(id_o_2, "Chirurgia generale", medico_dio);
        Long id_r_13 = insert.addReparto(id_o_2, "Dialisi", medico_dio);
        Long id_r_14 = insert.addReparto(id_o_2, "Gastroenterologia", medico_dio);
        Long id_r_15 = insert.addReparto(id_o_2, "Geriatria", medico_dio);
        Long id_r_16 = insert.addReparto(id_o_2, "Radiologia", medico_dio);
        Long id_r_17 = insert.addReparto(id_o_2, "Ortopedia", medico_dio);
        Long id_r_18 = insert.addReparto(id_o_2, "Laboratorio analisi", medico_dio);
        Long id_r_19 = insert.addReparto(id_o_2, "Medicina fisica e riabilitazione", medico_dio);
        Long id_r_20 = insert.addReparto(id_o_2, "Ortopedia e Traumatologia", medico_dio);

        Long id_r_21 = insert.addReparto(id_o_3, "Cardiologia", medico_dio);
        Long id_r_22 = insert.addReparto(id_o_3, "Chirurgia generale", medico_dio);
        Long id_r_23 = insert.addReparto(id_o_3, "Dialisi", medico_dio);
        Long id_r_24 = insert.addReparto(id_o_3, "Gastroenterologia", medico_dio);
        Long id_r_25 = insert.addReparto(id_o_3, "Geriatria", medico_dio);
        Long id_r_26 = insert.addReparto(id_o_3, "Radiologia", medico_dio);
        Long id_r_27 = insert.addReparto(id_o_3, "Ortopedia", medico_dio);
        Long id_r_28 = insert.addReparto(id_o_3, "Laboratorio analisi", medico_dio);
        Long id_r_29 = insert.addReparto(id_o_3, "Medicina fisica e riabilitazione", medico_dio);
        Long id_r_30 = insert.addReparto(id_o_3, "Ortopedia e Traumatologia", medico_dio);

        Long id_r_31 = insert.addReparto(id_o_4, "Cardiologia", medico_dio);
        Long id_r_32 = insert.addReparto(id_o_4, "Chirurgia generale", medico_dio);
        Long id_r_33 = insert.addReparto(id_o_4, "Dialisi", medico_dio);
        Long id_r_34 = insert.addReparto(id_o_4, "Gastroenterologia", medico_dio);
        Long id_r_35 = insert.addReparto(id_o_4, "Geriatria", medico_dio);
        Long id_r_36 = insert.addReparto(id_o_4, "Radiologia", medico_dio);
        Long id_r_37 = insert.addReparto(id_o_4, "Ortopedia", medico_dio);
        Long id_r_38 = insert.addReparto(id_o_4, "Laboratorio analisi", medico_dio);
        Long id_r_39 = insert.addReparto(id_o_4, "Medicina fisica e riabilitazione", medico_dio);
        Long id_r_40 = insert.addReparto(id_o_4, "Ortopedia e Traumatologia", medico_dio);

        //inserimento sale ospedale
        insert.addSalaOspedale(id_r_6, "Radiografia", medico_dio);
        insert.addSalaOspedale(id_r_26, "Radiografia", medico_dio);
        insert.addSalaOspedale(id_r_36, "Radiografia", medico_dio);
        insert.addSalaOspedale(id_r_6, "RMN", medico_dio);
        insert.addSalaOspedale(id_r_26, "RMN", medico_dio);
        insert.addSalaOspedale(id_r_36, "RMN", medico_dio);
        insert.addSalaOspedale(id_r_8, "Analisi", medico_dio);
        insert.addSalaOspedale(id_r_28, "Analisi", medico_dio);
        insert.addSalaOspedale(id_r_38, "Analisi", medico_dio);

        //inserimento sale studi medici
        insert.addSalaStudio(id_sm_1, "Radiografia", medico_pippa);
        insert.addSalaStudio(id_sm_1, "RMN", medico_pippa);
        insert.addSalaStudio(id_sm_2, "Radiografia", medico_pippa);
        insert.addSalaStudio(id_sm_2, "RMN", medico_pippa);
        insert.addSalaStudio(id_sm_3, "RMN", medico_pippa);
        insert.addSalaStudio(id_sm_1, "Analisi", medico_pippa);
        insert.addSalaStudio(id_sm_2, "Analisi", medico_pippa);
        insert.addSalaStudio(id_sm_3, "Analisi", medico_pippa);

        //inserimento pazienti
        insert.addPaziente("Arrigo", "Toscano", "10000", "10000", "M", "via cocci, 7", new Date(1963,12,10), "Torino");
        insert.addPaziente("Raffaele", "Udinese", "11000", "11000", "M", "Via Acrone, 109", new Date(1980,8,6), "Sarezzano");
        insert.addPaziente("Francesco", "Arcuri", "11100", "11100", "M", "Corso Alcide De Gasperi, 32", new Date(1990,10,27), "Candide");
        insert.addPaziente("Macario", "Napolitano", "11110", "11110", "M", "Via Galvani, 74", new Date(1992,5,23), "Roma");
        insert.addPaziente("Teodata", "Lombardo", "11111", "11111", "F", "Via Nazionale, 131", new Date(1982,7,21), "Trafoi");
        insert.addPaziente("Maia", "Gallo", "10111", "10111", "F", "Via Venezia, 43", new Date(1992,3,21), "Trento");
        insert.addPaziente("Aldo", "Siciliano", "10011", "10011", "M", "Piazza Bovio, 71", new Date(1988,10,1), "Bologna");
        insert.addPaziente("Damiana", "Lorenzo", "20000", "20000", "F", "Vico Giganti, 68", new Date(1997,1,5), "Milano");
        insert.addPaziente("Simonetta", "Fiorentino", "20002", "20002", "F", "Via Agostino Depretis, 98", new Date(1987,10,5), "Prato");
        insert.addPaziente("Rosita", "Buccho", "20022", "20022", "F", "Piazza Trieste e Trento, 70", new Date(1988,10,16), "Prunetto");
        insert.addPaziente("Gaetana", "Panicucci", "20222", "20222", "F", "Viale Augusto, 10", new Date(1978,11,16), "Messina");
        insert.addPaziente("Siro", "Greco", "22222", "22222", "M", "Corso Vittorio Emanuele, 95", new Date(1986,12,11), "Roma");
        insert.addPaziente("Adelfina", "Pirozzi", "22000", "22000", "F", "Via Francesco Del Giudice, 109", new Date(1979,1,18), "Napoli");
        insert.addPaziente("Eligio", "Beneventi", "22200", "22200", "M", "Via Valpantena, 17", new Date(1985,2,29), "Genova");
        insert.addPaziente("Mara", "Rossi", "22220", "22220", "F", "Via Sergente Maggiore, 124", new Date(1989,5,5), "Cuneo");
        insert.addPaziente("Irmina", "Pagnotto", "30000", "30000", "F", "Via Nizza, 148", new Date(1999,10,5), "Torino");
        insert.addPaziente("Alina", "Mazzi", "33000", "33000", "F", "Via Volto San Luca, 30", new Date(1996,9,6), "Torino");
        insert.addPaziente("Clotilde", "Beneventi", "33300", "33300", "F", "Via Loreto, 81", new Date(1976,6,24), "Livorno");
        insert.addPaziente("Marco", "Onio", "33330", "33330", "M", "Via degli Aldobrandeschi, 77", new Date(1985,2,29), "Genova");
        insert.addPaziente("Santo", "Castiglione", "33333", "33333", "M", "Piazza Trieste e Trento, 127", new Date(1995,12,19), "Torino");
        insert.addPaziente("Luisa", "Pisano", "33303", "33303", "F", "Via Carlo Alberto, 18", new Date(1975,11,18), "Avellino");
        insert.addPaziente("Livio", "Piccio", "33033", "33033", "M", "Corso Vittorio Emanuele, 15", new Date(1976,9,30), "Bari");
        insert.addPaziente("Quinto", "Fallaci", "30333", "30333", "M", "Via San Pietro Ad Aram, 57", new Date(1948,6,6), "Modena");
        insert.addPaziente("Anselmo", "Mancini", "40000", "40000", "M", "Via Antonio Cecchi, 94", new Date(1983,6,6), "Brindisi");
        insert.addPaziente("Tolomeo", "Trevisano", "40004", "40004", "M", "Via di Santa Melania, 44", new Date(1984,9,17), "Venezia");
        
        
        insert.linkStruttureMedici();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /*  String nome, String cognome, String cf, String password,
             String sesso, String indirizzo, Date data_nascita, String luogo_nascita */

            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet QuickPopulate</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet QuickPopulate at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
