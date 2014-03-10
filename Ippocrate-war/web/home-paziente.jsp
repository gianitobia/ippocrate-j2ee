<%-- 
    Document   : home-paziente
    Created on : 17-dic-2013, 22.28.52
    Author     : Marco
--%>

<jsp:useBean id="paziente" class="Transient.PazienteTransient" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Home Paziente</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/navbar.css" rel="stylesheet">
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
                        <li class="active"><a href="home-paziente.jsp">Home</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Prenotazioni <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="PrenotazioneServlet?action=ottieniPr">Le mie prenotazioni</a></li>
                                <li><a href="PrenotazioneServlet?action=nuovaPr">Nuova prenotazione</a></li>
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
                <h1>Benvenuto,<br>sig. <%= paziente.getCognome()%>!</h1>
                <br>
                <p>Il nuovo portale Ippocrate ti permette di prenotare comodamente
                    una nuova visita medica<br> ma anche di vedere tutti i tuoi referti medici.
                </p>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
