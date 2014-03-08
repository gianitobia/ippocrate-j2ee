<%-- 
    Document   : mio-rm
    Created on : 1-gen-2014, 22.10.48
    Author     : Marco
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Transient.PrescrizioneMedicaTransient"%>
<%@page import="java.util.List"%>
<%@page import="Transient.RefertoMedicoTransient"%>
<jsp:useBean id="miaCC" class="Transient.CartellaClinicaTransient" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    int numR = Integer.parseInt(request.getParameter("num"));
    RefertoMedicoTransient referto = miaCC.getReferti().get(numR);%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Referto medico</title>

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
                <p>Da questa pagina puoi visualizzare i dettagli del tuo referto medico.</p>
            </div>
            <div class="page-header">
                <h1>Il mio referto medico</h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Dettagli</div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt>Tipo di visita</dt>
                        <dd><%= referto.getTipoVisita()%></dd>
                        <dt>Data visita</dt>
                        <dd><%= sdf.format(referto.getDataVisita())%></dd>
                        <dt>Medico</dt>
                        <dd><%= referto.getCognomeM()%></dd>
                        <dt>Diagnosi</dt>
                        <dd><%= referto.getDiagnosi()%></dd>
                    </dl>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Multimedia</div>
                <div class="panel-body">
                    <% String listaImg = referto.getLista_images();
                        if (listaImg != null && listaImg.equals("") == false) {
                            String[] multim = listaImg.split(";");
                            for (int i = 0; i < multim.length; i++) {%>
                    <div class="col-md-3">
                        <a href="<%= multim[i]%>">
                            <img src="<%= multim[i]%>" alt="Immagine <%= i + 1%>" 
                                 class="img-thumbnail" style="max-height: 250px; max-width: 250px;">
                        </a>
                    </div>
                    <%}%>
                    <%}%>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Prescrizioni mediche</div>
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Data prescrizione</th>
                            <th>Data scadenza prescrizione</th>
                            <th>Medicinale</th>
                            <th>Quantità</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<PrescrizioneMedicaTransient> prescrizioni = referto.getLista_PMTransient();
                            for (int i = 0; i < prescrizioni.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getDataPrescrizione())%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getDataScadenza())%></td>
                            <td><%= prescrizioni.get(i).getMedicinale()%></td>
                            <td><%= prescrizioni.get(i).getNumConfezioni()%></td>
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
