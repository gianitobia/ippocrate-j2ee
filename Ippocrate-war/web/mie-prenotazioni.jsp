<%--
    Document   : mie-prenotazioni
    Created on : 26-dic-2013, 17.17.27
    Author     : Marco
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Transient.PrenotazioneTransient"%>
<%@page import="java.util.List"%>
<jsp:useBean id="prenotazioni" type="List<PrenotazioneTransient>" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("E' 'dd/MM/yyyy' ore 'HH:mm");%>

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
                                <li class="active"><a href="PrenotazioneServlet?action=ottieniPr">Le mie prenotazioni</a></li>
                                <li><a href="PrenotazioneServlet?action=nuovaPr">Nuova prenotazione</a></li>
                            </ul>
                        </li>
                        <li><a href="CCServlet?action=miaCC">Cartella clinica</a></li>
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
            </div>
            <table class="table table-condensed table-hover">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Tipo visita</th>
                        <th>Data</th>
                        <th>Luogo</th>
                        <th>Info</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < prenotazioni.size(); i++) {%>
                    <tr>
                        <td><%= i + 1%></td>
                        <td><%= prenotazioni.get(i).getNomePr()%></td>
                        <td><%= sdf.format(prenotazioni.get(i).getData())%></td>
                        <td><%= prenotazioni.get(i).getNomeSM()%></td>
                        <td>
                            <div class="panel panel-default">
                                <div class="panel-body">
                                    <dl class="dl-horizontal">
                                        <dt>Nome struttura medica</dt>
                                        <dd><%= prenotazioni.get(i).getNomeSM()%></dd>
                                        <dt>Indirizzo</dt>
                                        <dd><%= prenotazioni.get(i).getIndirizzoSM()%></dd>
                                        <dt>Data</dt>
                                        <dd><%= sdf.format(prenotazioni.get(i).getData())%></dd>
                                        <dt>Tipo visita</dt>
                                        <dd><%= prenotazioni.get(i).getNomePr()%></dd>
                                        <dt>Durata visita</dt>
                                        <dd><%= prenotazioni.get(i).getDurataPr()%> minuti</dd>
                                        <% if (prenotazioni.get(i).getTipo().equals("M")) {%>
                                        <dt>Medico</dt>
                                        <dd><%= prenotazioni.get(i).getCognomeM()%></dd>
                                        <% if (prenotazioni.get(i).getUfficioM() != null) {%>
                                        <dt>Ufficio</dt>
                                        <dd><%= prenotazioni.get(i).getUfficioM()%></dd>
                                        <%}%>
                                        <%} else {%>
                                        <dt>Tipo laboratorio</dt>
                                        <dd><%= prenotazioni.get(i).getTipoLaboratorioS()%></dd>
                                        <%}%>
                                    </dl>
                                </div>
                            </div>
                        </td>
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
