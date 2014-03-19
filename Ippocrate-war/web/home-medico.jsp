<%-- 
    Document   : home-medico
    Created on : 17-dic-2013, 12.47.53
    Author     : toby
--%>

<%--<jsp:useBean id="medico" class="Transient.MedicoTransient" scope="session" />--%>
<jsp:useBean id="medico" class="Entity.Medico" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Home Medico</title>

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
                        <li class="active"><a href="home-medico.jsp">Home</a></li>
                        <li><a href="MedicoServlet?action=mieiPazienti">I miei pazienti</a></li>
                        <li><a href="mia-agenda.jsp">La mia agenda</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <h1>Benvenuto,<br>dott. <%= medico.getCognome()%>!</h1>
                <br>
                <p>Il nuovo portale Ippocrate ti permette di vedere l'elenco dei tuoi pazienti e la tua agenda.</p>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
