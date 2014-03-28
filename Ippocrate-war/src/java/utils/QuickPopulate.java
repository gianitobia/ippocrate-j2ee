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
import Entity.PrestazioneMedico;
import Entity.PrestazioneSala;
import Entity.RepartoFacadeLocal;
import Entity.SalaFacadeLocal;
import Entity.StudioMedicoFacadeLocal;
import static Utility.Gestore_Date.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
            "Risonanza magnetica",
            "Ago aspirato ecoguidato del seno",
            "Agobiopsia del seno",
            "Dermatoscopia del seno",
            "Ecocolordoppler del seno",
            "Ecografia del seno",
            "Analisi del sangue",
            "Analisi delle feci",
            "Test antidroga",
            "Ingessatura di un arto superiore",
            "Ingessatura di un arto inferiore",
            "Sostituzione del gesso",
            "Rimozione del gesso"
        };

        String[] prestazioniMedico = {
            "Visita ginecologica",
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
        //Long id_r_2 = insert.addReparto(id_o_1, "Chirurgia generale", medico_dio);
        //Long id_r_3 = insert.addReparto(id_o_1, "Dialisi", medico_dio);
        //Long id_r_4 = insert.addReparto(id_o_1, "Gastroenterologia", medico_dio);
        //Long id_r_5 = insert.addReparto(id_o_1, "Geriatria", medico_dio);
        //Long id_r_6 = insert.addReparto(id_o_1, "Radiologia", medico_dio);
        Long id_r_7 = insert.addReparto(id_o_1, "Ortopedia", medico_dio);
        Long id_r_8 = insert.addReparto(id_o_1, "Laboratorio analisi", medico_dio);
        Long id_r_9 = insert.addReparto(id_o_1, "Medicina fisica e riabilitazione", medico_dio);
        //Long id_r_10 = insert.addReparto(id_o_1, "Ortopedia e Traumatologia", medico_dio);

        //Long id_r_11 = insert.addReparto(id_o_2, "Cardiologia", medico_dio);
        //Long id_r_12 = insert.addReparto(id_o_2, "Chirurgia generale", medico_dio);
        //Long id_r_13 = insert.addReparto(id_o_2, "Dialisi", medico_dio);
        //Long id_r_14 = insert.addReparto(id_o_2, "Gastroenterologia", medico_dio);
        //Long id_r_15 = insert.addReparto(id_o_2, "Geriatria", medico_dio);
        Long id_r_16 = insert.addReparto(id_o_2, "Radiologia", medico_dio);
        Long id_r_17 = insert.addReparto(id_o_2, "Ortopedia", medico_dio);
        Long id_r_18 = insert.addReparto(id_o_2, "Laboratorio analisi", medico_dio);
        Long id_r_19 = insert.addReparto(id_o_2, "Medicina fisica e riabilitazione", medico_dio);
        //Long id_r_20 = insert.addReparto(id_o_2, "Ortopedia e Traumatologia", medico_dio);

        Long id_r_21 = insert.addReparto(id_o_3, "Cardiologia", medico_dio);
        //Long id_r_22 = insert.addReparto(id_o_3, "Chirurgia generale", medico_dio);
        //Long id_r_23 = insert.addReparto(id_o_3, "Dialisi", medico_dio);
        //Long id_r_24 = insert.addReparto(id_o_3, "Gastroenterologia", medico_dio);
        //Long id_r_25 = insert.addReparto(id_o_3, "Geriatria", medico_dio);
        Long id_r_26 = insert.addReparto(id_o_3, "Radiologia", medico_dio);
        //Long id_r_27 = insert.addReparto(id_o_3, "Ortopedia", medico_dio);
        //Long id_r_28 = insert.addReparto(id_o_3, "Laboratorio analisi", medico_dio);
        Long id_r_29 = insert.addReparto(id_o_3, "Medicina fisica e riabilitazione", medico_dio);
        //Long id_r_30 = insert.addReparto(id_o_3, "Ortopedia e Traumatologia", medico_dio);

        Long id_r_31 = insert.addReparto(id_o_4, "Cardiologia", medico_dio);
        //Long id_r_32 = insert.addReparto(id_o_4, "Chirurgia generale", medico_dio);
        //Long id_r_33 = insert.addReparto(id_o_4, "Dialisi", medico_dio);
        //Long id_r_34 = insert.addReparto(id_o_4, "Gastroenterologia", medico_dio);
        //Long id_r_35 = insert.addReparto(id_o_4, "Geriatria", medico_dio);
        Long id_r_36 = insert.addReparto(id_o_4, "Radiologia", medico_dio);
        Long id_r_37 = insert.addReparto(id_o_4, "Ortopedia", medico_dio);
        //Long id_r_38 = insert.addReparto(id_o_4, "Laboratorio analisi", medico_dio);
        //Long id_r_39 = insert.addReparto(id_o_4, "Medicina fisica e riabilitazione", medico_dio);
        //Long id_r_40 = insert.addReparto(id_o_4, "Ortopedia e Traumatologia", medico_dio);

        //inserimento sale ospedale
        //Long id_s_1 = insert.addSalaOspedale(id_r_6, "Radiografia", medico_dio);
        Long id_s_2 = insert.addSalaOspedale(id_r_16, "Radiografia", medico_dio);
        Long id_s_3 = insert.addSalaOspedale(id_r_26, "Radiografia", medico_dio);
        Long id_s_4 = insert.addSalaOspedale(id_r_36, "Radiografia", medico_dio);
        //Long id_s_5 = insert.addSalaOspedale(id_r_6, "RMN", medico_dio);
        Long id_s_6 = insert.addSalaOspedale(id_r_16, "RMN", medico_dio);
        Long id_s_7 = insert.addSalaOspedale(id_r_26, "RMN", medico_dio);
        Long id_s_8 = insert.addSalaOspedale(id_r_36, "RMN", medico_dio);
        Long id_s_9 = insert.addSalaOspedale(id_r_8, "Analisi", medico_dio);
        Long id_s_10 = insert.addSalaOspedale(id_r_18, "Analisi", medico_dio);
        //Long id_s_11 = insert.addSalaOspedale(id_r_28, "Analisi", medico_dio);
        //Long id_s_12 = insert.addSalaOspedale(id_r_38, "Analisi", medico_dio);
        Long id_s_13 = insert.addSalaOspedale(id_r_7, "Sala gessi", medico_dio);
        Long id_s_14 = insert.addSalaOspedale(id_r_17, "Sala gessi", medico_dio);
        //Long id_s_15 = insert.addSalaOspedale(id_r_27, "Sala gessi", medico_dio);
        Long id_s_16 = insert.addSalaOspedale(id_r_37, "Sala gessi", medico_dio);
        Long id_s_17 = insert.addSalaOspedale(id_r_9, "Palestra per riabilitazione", medico_dio);
        Long id_s_18 = insert.addSalaOspedale(id_r_19, "Palestra per riabilitazione", medico_dio);
        Long id_s_19 = insert.addSalaOspedale(id_r_29, "Palestra per riabilitazione", medico_dio);
        //Long id_s_20 = insert.addSalaOspedale(id_r_39, "Palestra per riabilitazione", medico_dio);
        Long id_s_21 = insert.addSalaOspedale(id_r_1, "Elettrocardiografia", medico_dio);
        //Long id_s_22 = insert.addSalaOspedale(id_r_11, "Elettrocardiografia", medico_dio);
        Long id_s_23 = insert.addSalaOspedale(id_r_21, "Elettrocardiografia", medico_dio);
        Long id_s_24 = insert.addSalaOspedale(id_r_31, "Elettrocardiografia", medico_dio);

        //inserimento sale studi medici
        Long id_s_25 = insert.addSalaStudio(id_sm_1, "Radiografia", medico_pippa);
        Long id_s_26 = insert.addSalaStudio(id_sm_1, "RMN", medico_pippa);
        Long id_s_27 = insert.addSalaStudio(id_sm_2, "Radiografia", medico_pippa);
        Long id_s_28 = insert.addSalaStudio(id_sm_2, "RMN", medico_pippa);
        Long id_s_29 = insert.addSalaStudio(id_sm_3, "RMN", medico_pippa);
        Long id_s_30 = insert.addSalaStudio(id_sm_1, "Analisi", medico_pippa);
        Long id_s_31 = insert.addSalaStudio(id_sm_2, "Analisi", medico_pippa);
        Long id_s_32 = insert.addSalaStudio(id_sm_3, "Analisi", medico_pippa);
        Long id_s_33 = insert.addSalaStudio(id_sm_1, "Palestra per riabilitazione", medico_pippa);
        Long id_s_34 = insert.addSalaStudio(id_sm_2, "Palestra per riabilitazione", medico_pippa);
        Long id_s_35 = insert.addSalaStudio(id_sm_3, "Palestra per riabilitazione", medico_pippa);
        Long id_s_36 = insert.addSalaStudio(id_sm_1, "Elettrocardiografia", medico_pippa);
        Long id_s_37 = insert.addSalaStudio(id_sm_2, "Elettrocardiografia", medico_pippa);
        Long id_s_38 = insert.addSalaStudio(id_sm_3, "Elettrocardiografia", medico_pippa);

        //inserimento pazienti
        insert.addPaziente("Arrigo", "Toscano", "10000", "10000", "M", "via Cocci, 7", generateDate(), "Torino");
        insert.addPaziente("Raffaele", "Udinese", "11000", "11000", "M", "Via Acrone, 109", generateDate(), "Sarezzano");
        insert.addPaziente("Francesco", "Arcuri", "11100", "11100", "M", "Corso Alcide De Gasperi, 32", generateDate(), "Candide");
        insert.addPaziente("Macario", "Napolitano", "11110", "11110", "M", "Via Galvani, 74", generateDate(), "Roma");
        insert.addPaziente("Teodata", "Lombardo", "11111", "11111", "F", "Via Nazionale, 131", generateDate(), "Trafoi");
        insert.addPaziente("Maia", "Gallo", "10111", "10111", "F", "Via Venezia, 43", generateDate(), "Trento");
        insert.addPaziente("Aldo", "Siciliano", "10011", "10011", "M", "Piazza Bovio, 71", generateDate(), "Bologna");
        insert.addPaziente("Damiana", "Lorenzo", "20000", "20000", "F", "Vico Giganti, 68", generateDate(), "Milano");
        insert.addPaziente("Simonetta", "Fiorentino", "20002", "20002", "F", "Via Agostino Depretis, 98", generateDate(), "Prato");
        insert.addPaziente("Rosita", "Buccho", "20022", "20022", "F", "Piazza Trieste e Trento, 70", generateDate(), "Prunetto");
        insert.addPaziente("Gaetana", "Panicucci", "20222", "20222", "F", "Viale Augusto, 10", generateDate(), "Messina");
        insert.addPaziente("Siro", "Greco", "22222", "22222", "M", "Corso Vittorio Emanuele, 95", generateDate(), "Roma");
        insert.addPaziente("Adelfina", "Pirozzi", "22000", "22000", "F", "Via Francesco Del Giudice, 109", generateDate(), "Napoli");
        insert.addPaziente("Eligio", "Beneventi", "22200", "22200", "M", "Via Valpantena, 17", generateDate(), "Genova");
        insert.addPaziente("Mara", "Rossi", "22220", "22220", "F", "Via Sergente Maggiore, 124", generateDate(), "Cuneo");
        insert.addPaziente("Irmina", "Pagnotto", "30000", "30000", "F", "Via Nizza, 148", generateDate(), "Torino");
        insert.addPaziente("Alina", "Mazzi", "33000", "33000", "F", "Via Volto San Luca, 30", generateDate(), "Torino");
        insert.addPaziente("Clotilde", "Beneventi", "33300", "33300", "F", "Via Loreto, 81", generateDate(), "Livorno");
        insert.addPaziente("Marco", "Onio", "33330", "33330", "M", "Via degli Aldobrandeschi, 77", generateDate(), "Genova");
        insert.addPaziente("Santo", "Castiglione", "33333", "33333", "M", "Piazza Trieste e Trento, 127", generateDate(), "Torino");
        insert.addPaziente("Luisa", "Pisano", "33303", "33303", "F", "Via Carlo Alberto, 18", generateDate(), "Avellino");
        insert.addPaziente("Livio", "Piccio", "33033", "33033", "M", "Corso Vittorio Emanuele, 15", generateDate(), "Bari");
        insert.addPaziente("Quinto", "Fallaci", "30333", "30333", "M", "Via San Pietro Ad Aram, 57", generateDate(), "Modena");
        insert.addPaziente("Anselmo", "Mancini", "40000", "40000", "M", "Via Antonio Cecchi, 94", generateDate(), "Brindisi");
        insert.addPaziente("Tolomeo", "Trevisano", "40004", "40004", "M", "Via di Santa Melania, 44", generateDate(), "Venezia");

        insert.addPaziente("Giorgio", "Toscani", "100001", "10000", "M", "via Noci, 7", generateDate(), "Torino");
        insert.addPaziente("Roberto", "Marche", "110001", "11000", "M", "Via Acrone, 109", generateDate(), "Sarezzano");
        insert.addPaziente("Ugo", "Arcuri", "111001", "11100", "M", "Corso Alcide De Gasperi, 32", generateDate(), "Candide");
        insert.addPaziente("Marika", "Napoli", "111101", "11110", "M", "Via Galvani, 74", generateDate(), "Roma");
        insert.addPaziente("Olmo", "Lordo", "111111", "11111", "F", "Via Nazionale, 131", generateDate(), "Trafoi");
        insert.addPaziente("Maria", "Galli", "101111", "10111", "F", "Via Venezia, 43", generateDate(), "Roma");
        insert.addPaziente("Aldo", "Siciliano", "100111", "10011", "M", "Piazza Bovio, 71", generateDate(), "Bologna");
        insert.addPaziente("Damiano", "Tarantino", "2030001", "20000", "F", "Vico Giganti, 68", generateDate(), "Milano");
        insert.addPaziente("Simonetta", "Scenna", "2400012", "20002", "F", "Via Agostino Depretis, 98", generateDate(), "Prato");
        insert.addPaziente("Rosa", "Bucco", "200222", "200122", "F", "Piazza Trieste e Trento, 70", generateDate(), "Prunetto");
        insert.addPaziente("Gaetano", "Panucci", "201222", "210222", "F", "Viale Augusto, 10", generateDate(), "Avellino");
        insert.addPaziente("Matteo", "Greco", "2222124", "222212", "M", "Corso Vittorio Emanuele, 95", generateDate(), "Roma");
        insert.addPaziente("Adelfina", "Pirozzi", "220400", "22000", "F", "Via Francesco Del Giudice, 109", generateDate(), "Napoli");
        insert.addPaziente("Eligio", "Beneventi", "222300", "22200", "M", "Via Valpantena, 17", generateDate(), "Genova");
        insert.addPaziente("Armanda", "Papa", "222230", "22220", "F", "Via Sergente Maggiore, 124", generateDate(), "Cuneo");
        insert.addPaziente("Gelmina", "Patto", "300030", "30000", "F", "Via Nizza, 148", generateDate(), "Torino");
        insert.addPaziente("Adelina", "Mazzi", "330006", "33000", "F", "Via Volto San Luca, 30", generateDate(), "Torino");
        insert.addPaziente("Cloe", "Benvenuti", "333050", "33300", "F", "Via Loreto, 81", generateDate(), "Livorno");
        insert.addPaziente("Garco", "Orio", "33330", "533330", "M", "Via degli Aldobrandeschi, 77", generateDate(), "Genova");
        insert.addPaziente("Santino", "Castiglione", "332333", "33333", "M", "Piazza Trieste e Trento, 127", generateDate(), "Torino");
        insert.addPaziente("Luca", "Pisano", "33303", "334303", "F", "Via Carlo Alberto, 18", generateDate(), "Venezia");
        insert.addPaziente("Livio", "Piccolo", "33033", "333033", "M", "Corso Vittorio Emanuele, 15", generateDate(), "Bari");
        insert.addPaziente("Mara", "Fellaci", "30333", "303433", "M", "Via San Pietro Ad Aram, 57", generateDate(), "Modena");
        insert.addPaziente("Gianna", "Mancini", "40000", "406000", "M", "Via Antonio Cecchi, 94", generateDate(), "Brindisi");
        insert.addPaziente("Arte", "Treviso", "40004", "4000774", "M", "Via di Santa Melania, 44", generateDate(), "Avellino");

        //inserimento medici
        //medici ospedalieri
        insert.addMedicoOspedaliero("Cassandra", "Trentini", "Ginecologia", generateDate(), "1000", "1000", "1000", "28");
        insert.addMedicoOspedaliero("Irma", "Folliero", "Immunologia", generateDate(), "2000", "2000", "2000", "T4");
        insert.addMedicoOspedaliero("Neera", "Li Fonti", "Cardiochirurgia", generateDate(), "3000", "3000", "3000", "F6");
        insert.addMedicoOspedaliero("Salomone", "Cocci", "Ematologia", generateDate(), "4000", "4000", "4000", "C3");
        insert.addMedicoOspedaliero("Alfio", "Panicucci", "Nefrologia", generateDate(), "5000", "5000", "5000", "4A");
        insert.addMedicoOspedaliero("Camilla", "Genovese", "Urologia", generateDate(), "6000", "6000", "6000", "7V");
        insert.addMedicoOspedaliero("Jacopo", "Zetticci", "Cardiologia", generateDate(), "7000", "7000", "7000", "7S");
        insert.addMedicoOspedaliero("Imelda", "Fanucci", "Endocrinologia", generateDate(), "8000", "8000", "8000", "2R");
        insert.addMedicoOspedaliero("Guglielma", "Bergamaschi", "Neurooncologia", generateDate(), "9000", "9000", "9000", "2R");
        insert.addMedicoOspedaliero("Luigina", "Longo", "Ginecologia", generateDate(), "1001", "1001", "1001", "2T");
        insert.addMedicoOspedaliero("Natale", "Milanesi", "Chirurgia generale", generateDate(), "2002", "2002", "2002", "4E");
        insert.addMedicoOspedaliero("Albertino", "Cremonesi", "Medicina generale", generateDate(), "3003", "3003", "3003", "3R");
        insert.addMedicoOspedaliero("Muzio", "Padovesi", "Radiologia", generateDate(), "4004", "4004", "4004", "9R");
        insert.addMedicoOspedaliero("Tolomeo", "Colombo", "Radiologia", generateDate(), "5005", "5005", "5005", "4R");
        insert.addMedicoOspedaliero("Immacolata", "Zetticci", "Neurologia", generateDate(), "6006", "6006", "6006", "9N");
        insert.addMedicoOspedaliero("Urania", "Sal", "Patologia orale", generateDate(), "7007", "7007", "7007", "4O");
        insert.addMedicoOspedaliero("Saverio", "Greco", "Ortopedia", generateDate(), "8008", "8008", "8008", "O9");
        insert.addMedicoOspedaliero("Quintilio", "Marcelo", "Medicina dello sport", generateDate(), "9009", "9009", "9009", "S4");
        insert.addMedicoOspedaliero("Imelda", "Bianchi", "Medicina interna", generateDate(), "1101", "1101", "1101", "I2");
        insert.addMedicoOspedaliero("Ubalda", "Bergamaschi", "Neurologia", generateDate(), "2202", "2202", "2202", "N4");
        insert.addMedicoOspedaliero("Stella", "De Luca", "Allergologia", generateDate(), "3303", "3303", "3303", "A9");
        insert.addMedicoOspedaliero("Tranquilla", "Nucci", "Anestesia", generateDate(), "4404", "4404", "4404", "AN7");
        insert.addMedicoOspedaliero("Silvio", "Lombardi", "Radiologia", generateDate(), "5505", "5505", "5505", "R12");
        insert.addMedicoOspedaliero("Jacopo", "Manfrin", "Cardiochirurgia", generateDate(), "6606", "6606", "6606", "F7");

        //medici esterni
        insert.addMedicoEsterno("Arcangela", "Greece", "Cardiochirurgia", generateDate(), "7707", "7707", "7707");
        insert.addMedicoEsterno("Consuelo", "Longo", "Nefrologia", generateDate(), "8808", "8808", "8808");
        insert.addMedicoEsterno("Armando", "Sal", "Endocrinologia", generateDate(), "9909", "9909", "9909");
        insert.addMedicoEsterno("Immacolata", "Mazzanti", "Radiologia", generateDate(), "1111", "1111", "1111");
        insert.addMedicoEsterno("Frediana", "Iadanza", "Chirurgia generale", generateDate(), "2222", "2222", "2222");
        insert.addMedicoEsterno("Massimo", "Padovano", "Patologia orale", generateDate(), "3333", "3333", "3333");
        insert.addMedicoEsterno("Germana", "Ferri", "Medicina del lavoro", generateDate(), "4444", "4444", "4444");
        insert.addMedicoEsterno("Landolfo", "Lettiere", "Radiologia", generateDate(), "5555", "5555", "5555");
        insert.addMedicoEsterno("Amerigo", "Marcelo", "Radiologia", generateDate(), "6666", "6666", "6666");
        insert.addMedicoEsterno("Petronio", "Dellucci", "Chirurgia generale", generateDate(), "7777", "7777", "7777");

        List<PrestazioneMedico> listPrestazioniMedico = insert.addPrestazioniMedico(prestazioniMedico);
        List<PrestazioneSala> listPrestazioniSala = insert.addPrestazioniSala(prestazioniSala);

        List<PrestazioneSala> prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(7));
        prest.add(listPrestazioniSala.get(57));
        //insert.addPrestazioniToSala(id_s_1, prest);
        insert.addPrestazioniToSala(id_s_2, prest);
        insert.addPrestazioniToSala(id_s_3, prest);
        insert.addPrestazioniToSala(id_s_4, prest);
        insert.addPrestazioniToSala(id_s_27, prest);
        insert.addPrestazioniToSala(id_s_25, prest);

        prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(53));
        //insert.addPrestazioniToSala(id_s_5, prest);
        insert.addPrestazioniToSala(id_s_6, prest);
        insert.addPrestazioniToSala(id_s_7, prest);
        insert.addPrestazioniToSala(id_s_8, prest);
        insert.addPrestazioniToSala(id_s_26, prest);
        insert.addPrestazioniToSala(id_s_28, prest);
        insert.addPrestazioniToSala(id_s_29, prest);

        prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(60));
        prest.add(listPrestazioniSala.get(61));
        prest.add(listPrestazioniSala.get(59));
        insert.addPrestazioniToSala(id_s_9, prest);
        insert.addPrestazioniToSala(id_s_10, prest);
        //insert.addPrestazioniToSala(id_s_11, prest);
        //insert.addPrestazioniToSala(id_s_12, prest);
        insert.addPrestazioniToSala(id_s_30, prest);
        insert.addPrestazioniToSala(id_s_31, prest);
        insert.addPrestazioniToSala(id_s_32, prest);

        prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(64));
        prest.add(listPrestazioniSala.get(65));
        prest.add(listPrestazioniSala.get(62));
        prest.add(listPrestazioniSala.get(63));
        insert.addPrestazioniToSala(id_s_13, prest);
        insert.addPrestazioniToSala(id_s_14, prest);
        //insert.addPrestazioniToSala(id_s_15, prest);
        insert.addPrestazioniToSala(id_s_16, prest);

        prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(24));
        prest.add(listPrestazioniSala.get(46));
        insert.addPrestazioniToSala(id_s_17, prest);
        insert.addPrestazioniToSala(id_s_18, prest);
        insert.addPrestazioniToSala(id_s_19, prest);
        //insert.addPrestazioniToSala(id_s_20, prest);
        insert.addPrestazioniToSala(id_s_33, prest);
        insert.addPrestazioniToSala(id_s_34, prest);
        insert.addPrestazioniToSala(id_s_35, prest);

        prest = new ArrayList<>();
        prest.add(listPrestazioniSala.get(11));
        prest.add(listPrestazioniSala.get(31));
        insert.addPrestazioniToSala(id_s_21, prest);
        //insert.addPrestazioniToSala(id_s_22, prest);
        insert.addPrestazioniToSala(id_s_23, prest);
        insert.addPrestazioniToSala(id_s_24, prest);
        insert.addPrestazioniToSala(id_s_36, prest);
        insert.addPrestazioniToSala(id_s_37, prest);
        insert.addPrestazioniToSala(id_s_38, prest);

        insert.linkStruttureMedici();
        insert.linkRepartiPazienti();
        insert.linkMediciPazienti();
        insert.addCartelleCliniche();

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
