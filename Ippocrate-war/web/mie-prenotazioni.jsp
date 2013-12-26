<%-- 
    Document   : mie-prenotazioni
    Created on : 26-dic-2013, 17.17.27
    Author     : Marco
--%>

<%@page import="Entity.Prenotazione"%>
<%@page import="java.util.List"%>
<jsp:useBean id="paziente" class="Entity.PazienteTransient" scope="session" />
<jsp:useBean id="prenotazioni" type="List<Prenotazione>" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Le mie prenotazioni</title>

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
                        <li><a href="home-paziente.jsp">Home</a></li>
                        <li class="dropdown active">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Prenotazioni <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="active"><a href="PrenotazioneServlet?action=ottieni">Le mie prenotazioni</a></li>
                                <li><a href="#">Nuova prenotazione</a></li>
                            </ul>
                        </li>
                        <li><a href="#">Cartella clinica</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi controllare la lista delle tue visite prenotate.</p>
            </div>
            <div class="page-header">
                <h1>Le mie prenotazioni</h1>
            </div><!-- Table -->
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Tipo visita</th>
                        <th>Data</th>
                        <th>Luogo</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < prenotazioni.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= prenotazioni.get(i).getTipo_prestazione().getNome()%></td>
                            <td><%= prenotazioni.get(i).getData_prenotazione()%></td>
                            <td><%= prenotazioni.get(i).getStruttura_medica().getNome()%></td>
                        </tr>
                        <tr class="hidden">
                            <table class="table">
                                <!-- Usare class="hidden" per nascondere le info aggiuntive -->
                                <div class="well">
                                    <dl class="dl-horizontal">
                                        <dt>Orario</dt>
                                        <dd>Leggi l'orario della visita</dd>
                                        <dt>Altro</dt>
                                        <dd>Inserire tutti i dettagli della prenotazione</dd>
                                    </dl>
                                </div>
                            </table>
                        </tr>
                <%}%>
                </tbody>
            </table>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
