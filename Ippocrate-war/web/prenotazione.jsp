<%--
    Document   : prenotazione
    Created on : 07-gen-2014, 18.26.00
    Author     : Marco
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Prestazione"%>
<jsp:useBean id="prestazioni" type="List<Prestazione>" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Nuova prenotazione</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">        

        <!-- Custom styles for this template -->
        <link href="css/navbar.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet">
        <link href="css/bootstrap-timepicker.css" rel="stylesheet">   



        <script language="JavaScript">
            function setXMLHttpRequest() {
                var xhr = null;
                if (window.XMLHttpRequest) { // browser standard con supporto nativo
                    xhr = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) { // browser MS Internet Explorer - ActiveX
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
                return xhr;
            }

            var xhrObj = setXMLHttpRequest();   // crea oggetto XMLHTTPRequest per gestire comunicazione asincrona con server
            var indexOfPrest;
            var indexOfStrut;
            var indexOfMedi;

            function cercaStrutture() {
                indexOfPrest = document.getElementById("prest").selectedIndex;
                var url = "PrenotazioneServlet?action=cercaStrutture_" + indexOfPrest;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage1; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function updatePage1() {
                if (xhrObj.readyState === 4) {
                    document.getElementById("strut").disabled = false;
                    document.getElementById("medi").disabled = true;
                    document.getElementById("medi").innerHTML = "<option></option>";
                    document.getElementById("calendario").hidden = true;
                    document.getElementById("data").disabled = true;
                    document.getElementById("ora").disabled = true;
                    var risp = xhrObj.responseText;
                    document.getElementById("strut").innerHTML = risp;
                    document.getElementById("strut").selectedIndex = -1;
                }
            }

            function cercaMedico(iStrut) {
                indexOfStrut = iStrut;
                //Cerca i medici di quella strut che fanno quella prestazione
                var url = "PrenotazioneServlet?action=cercaMedico_" + indexOfStrut;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage2; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function updatePage2() {
                if (xhrObj.readyState === 4) {
                    document.getElementById("medi").disabled = false;
                    document.getElementById("calendario").hidden = true;
                    document.getElementById("data").disabled = true;
                    document.getElementById("ora").disabled = true;
                    var risp = xhrObj.responseText;
                    document.getElementById("medi").innerHTML = risp;
                    document.getElementById("medi").selectedIndex = -1;
                }
            }

            function cercaAgendaSale(iStrut) {
                indexOfStrut = iStrut;
                //Cerca l'agenda di una Sala(passando una StrutturaMedica)
                var url = "PrenotazioneServlet?action=cercaAgendaSale_" + indexOfStrut;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage3; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function cercaAgendaMedico(iMedi) {
                indexOfMedi = iMedi;
                //Cerca l'agenda di un Medico
                var url = "PrenotazioneServlet?action=cercaAgendaMedico_" + indexOfMedi;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage3; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function updatePage3() {
                if (xhrObj.readyState === 4) {
                    document.getElementById("divCalendario").hidden = false;
                    document.getElementById("calendario").hidden = false;
                    document.getElementById("data").disabled = false;
                    document.getElementById("ora").disabled = false;
                    var risp = xhrObj.responseText;
                    document.getElementById("calendario").innerHTML = risp;

                }
            }

            function controllaOrario() {
                var ora = document.getElementById("ora").value;
                var hm = ora.split(":");
                if (hm[0] < 8 | hm[0] > 19) {
                    document.getElementById("footer").hidden = false;
                    document.getElementById("footer").innerHTML = "<button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>\n\
                                                                   <strong>ERRORE!</strong> non è possibile prenotare in orario notturno";
                    return false;
                }
                return true;
            }
        </script>
    </head>
    <body>
        <div class="container">
            <!-- Static navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="home-paziente.jsp">Ippocrate</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home-paziente.jsp">Home</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Prenotazioni <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="PrenotazioneServlet?action=ottieniPr">Le mie prenotazioni</a></li>
                                <li class="active"><a href="PrenotazioneServlet?action=nuovaPr">Nuova prenotazione</a></li>
                            </ul>
                        </li>
                        <li><a href="CCServlet?action=miaCC">Cartella clinica</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi prenotare una nuova visita medica.</p>
            </div>
            <div class="page-header">
                <h1>Nuova prenotazione</h1>
            </div>
            <!-- da selezionare tipologia prestazione, struttura medica, data -->
            <div class="panel panel-primary">
                <div class="panel-heading">Prenota</div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="PrenotazioneServlet?action=creaPrenotazione"  onSubmit="return controllaOrario()" method="POST">
                        <div class="form-group">
                            <label for="prest" class="col-sm-2 control-label">Tipo visita</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="prest" onchange="cercaStrutture()" required>                                    
                                    <% for (int i = 0; i < prestazioni.size(); i++) {%>
                                    <option><%= prestazioni.get(i).getNome()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="strut" class="col-sm-2 control-label">Struttura medica</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="strut" disabled required>
                                    <option></option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="medi" class="col-sm-2 control-label">Medico</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="medi" disabled required>
                                    <option></option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dataora" class="col-sm-2 control-label">Data/Ora</label>
                            <div class="col-sm-3">
                                <div class="input-group date" >
                                    <input type="text"  class="form-control" id="data" name="data" data-provide="datepicker" placeholder="21/10/2014" disabled required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
                                </div>                                
                            </div>
                            <div class="col-sm-3">
                                <div class="input-group bootstrap-timepicker">
                                    <input type="text" class="form-control" id="ora" name="ora" placeholder="12:30" disabled required>
                                    <span class="input-group-addon"><i class="glyphicon glyphicon-time"></i></span>
                                </div>
                            </div> 
                        </div>                            
                        <div id="divCalendario" class="form-group" hidden="true" style="height: 600px;">
                            <label for="calendario" class="col-sm-2 control-label">Disponibilità</label>
                            <div id="calendario" class="col-sm-10">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default btn-primary">Prenota</button>
                            </div>
                        </div>
                    </form>       
                    <div class="alert alert-danger alert-dismissable" id="footer" hidden="true">                                               
                    </div>
                </div>                                
            </div>            
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="js/bootstrap-datepicker.it.js"></script>
        <script type="text/javascript" src="js/bootstrap-timepicker.js"></script>

        <script type="text/javascript">
                                    document.getElementById("prest").selectedIndex = -1;
                                    $.fn.datepicker.defaults.format = "dd/mm/yyyy";
                                    $.fn.datepicker.defaults.language = "it";
                                    $.fn.datepicker.defaults.todayBtn = "linked";
                                    $('#ora').timepicker({
                                        showMeridian: false,
                                        defaultTime: '12:30',
                                        minuteStep: 30

                                    });
                                    document.getElementById("ora").value = "";
        </script>
    </body>
</html>
