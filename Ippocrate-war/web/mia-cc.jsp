<%-- 
    Document   : mia-cc
    Created on : 1-gen-2014, 18.55.30
    Author     : Marco
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Transient.RefertoMedicoTransient"%>
<%@page import="java.util.List"%>
<jsp:useBean id="miaCC" class="Transient.CartellaClinicaTransient" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: La mia cartella clinica</title>

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
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Prenotazioni <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="PrenotazioneServlet?action=ottieniPr">Le mie prenotazioni</a></li>
                                <li><a href="PrenotazioneServlet?action=nuovaPr">Nuova prenotazione</a></li>
                            </ul>
                        </li>
                        <li class="active"><a href="CCServlet?action=miaCC">Cartella clinica</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="/Ippocrate-war/LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi leggere la tua cartella clinica, 
                    compresi tutti i referti medici delle tue visite.</p>
            </div>
            <div class="page-header">
                <h1>La mia cartella clinica</h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Anamnesi</div>
                <div class="panel-body">
                    <p><%= miaCC.getAnamnesi()%></p>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Referti medici</div>
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tipo visita</th>
                            <th>Data</th>
                            <th>Medico</th>
                            <th>Diagnosi</th>
                            <th>Altro</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<RefertoMedicoTransient> referti = miaCC.getReferti();
                            for (int i = 0; i < referti.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= referti.get(i).getTipoVisita()%></td>
                            <td><%= sdf.format(referti.get(i).getDataVisita())%></td>
                            <td><%= referti.get(i).getCognomeM()%></td>
                            <td><%= referti.get(i).getDiagnosi()%></td>
                            <td><a href="mio-rm.jsp?num=<%=i%>">visualizza</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
