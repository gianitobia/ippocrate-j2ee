<%-- 
    Document   : miei-pazienti
    Created on : 27-feb-2014, 11.40.26
    Author     : Marco
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<jsp:useBean id="pazienti" class="List<Entity.Paziente>" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: I miei pazienti</title>

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
                        <li><a href="MedicoServlet?action=getAgenda">La mia agenda</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi visualizzare i tuoi pazienti, 
                    con tutti i loro referti medici.</p>
            </div>
            <div class="page-header">
                <h1>I miei pazienti</h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Pazienti</div>
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Nome</th>
                            <th>Cognome</th>
                            <th>Sesso</th>
                            <th>Data nascita</th>
                            <th>Altro</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (int i = 0; i < pazienti.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= pazienti.get(i).getNome()%></td>
                            <td><%= pazienti.get(i).getCognome()%></td>
                            <td><%= pazienti.get(i).getSesso()%></td>
                            <td><%= sdf.format(pazienti.get(i).getData_nascita())%></td>
                            <td><a href="MedicoServlet?action=ottieniCC_<%=i%>">visualizza</a></td>
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

