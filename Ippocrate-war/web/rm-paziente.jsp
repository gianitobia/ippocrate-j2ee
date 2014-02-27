<%-- 
    Document   : rm-paziente
    Created on : 27-feb-2014, 16.44.14
    Author     : Marco
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entity.PrescrizioneMedica"%>
<%@page import="java.util.List"%>
<%@page import="Entity.RefertoMedico"%>
<jsp:useBean id="CCpaziente" class="Entity.CartellaClinica" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    int numR = Integer.parseInt(request.getParameter("num"));
    RefertoMedico referto = CCpaziente.getLista_referti().get(numR);%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Referto medico del paziente</title>

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
                    <a class="navbar-brand" href="home-medico.jsp">Ippocrate</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home-medico.jsp">Home</a></li>
                        <li class="active"><a href="MedicoServlet?action=mieiPazienti">I miei pazienti</a></li>
                        <li><a href="#">Il mio calendario</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi visualizzare i dettagli del referto medico del paziente.</p>
            </div>
            <div class="page-header">
                <h1>Referto medico di <%= CCpaziente.getPaziente().getNome() 
                        + " " + CCpaziente.getPaziente().getCognome() %></h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Dettagli</div>
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt>Tipo di visita</dt>
                        <dd><%= referto.getTipoVisita().getNome()%></dd>
                        <dt>Data visita</dt>
                        <dd><%= sdf.format(referto.getDataVisita())%></dd>
                        <dt>Diagnosi</dt>
                        <dd><%= referto.getDiagnosi()%></dd>
                    </dl>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Multimedia</div>
                <div class="panel-body">
                    ## foto e altri documenti multimediali ##
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
                        <% List<PrescrizioneMedica> prescrizioni = referto.getLista_prescrizioni();
                            for (int i = 0; i < prescrizioni.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getData_prescrizione())%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getData_scadenza())%></td>
                            <td><%= prescrizioni.get(i).getMedicinale()%></td>
                            <td><%= prescrizioni.get(i).getNumero_confezioni()%></td>
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
