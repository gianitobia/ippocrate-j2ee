<%-- 
    Document   : mia-agenda
    Created on : 1-mar-2014, 17.17.44
    Author     : Marco
--%>

<%--<jsp:useBean id="medico" class="Transient.MedicoTransient" scope="session" />--%>
<jsp:useBean id="medico" class="Entity.Medico" scope="session" />
<jsp:useBean id="agenda" type="String" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: La mia agenda</title>

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
                        <li><a href="MedicoServlet?action=mieiPazienti">I miei pazienti</a></li>
                        <li class="active"><a href="MedicoServlet?action=getAgenda">La mia agenda</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi visualizzare la tua agenda,
                    <br> i tuoi appuntamenti e i tuoi impegni.</p>
            </div>
            <div class="page-header">
                <h1>La mia agenda</h1>
            </div>
            <div style="text-align: center">
                <iframe src="<%= agenda %>" 
                        style=" border-width:0 " width="900" height="600" 
                        frameborder="0" scrolling="no">                     
                </iframe>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
