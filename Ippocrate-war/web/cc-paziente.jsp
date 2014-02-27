<%-- 
    Document   : cc-paziente
    Created on : 27-feb-2014, 16.29.04
    Author     : Marco
--%>

<%@page import="Entity.CartellaClinica"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entity.RefertoMedico"%>
<%@page import="java.util.List"%>
<jsp:useBean id="CCpaziente" class="Entity.CartellaClinica" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Cartella clinica del paziente</title>

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
                <p>Da questa pagina puoi visualizzare la cartella clinica
                    del paziente.</p>
            </div>
            <div class="page-header">
                <h1>Cartella clinica di <%= CCpaziente.getPaziente().getNome() 
                        + " " + CCpaziente.getPaziente().getCognome() %></h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Anamnesi</div>
                <div class="panel-body">
                    <p><%= CCpaziente.getAnamnesi()%></p>
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
                            <th>Diagnosi</th>
                            <th>Altro</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% List<RefertoMedico> referti = CCpaziente.getLista_referti();
                            for (int i = 0; i < referti.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= referti.get(i).getTipoVisita().getNome() %></td>
                            <td><%= sdf.format(referti.get(i).getDataVisita())%></td>
                            <td><%= referti.get(i).getDiagnosi()%></td>
                            <td><a href="rm-paziente.jsp?num=<%=i%>">visualizza</a></td>
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
