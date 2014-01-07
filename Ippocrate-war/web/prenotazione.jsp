<%--
    Document   : prenotazione
    Created on : 07-gen-2014, 18.26.00
    Author     : Marco
--%>

<%@page import="java.util.List"%>
<%@page import="Entity.Prestazione"%>
<jsp:useBean id="prestazioni" type="List<Prestazione>" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Nuova prenotazione</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/navbar.css" rel="stylesheet">

        <script type="text/javascript">
            $(function() {
                $("#data").datepicker();
            });
        </script>
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
                                <li><a href="PrenotazioneServlet?action=ottieniPr">Le mie prenotazioni</a></li>
                                <li class="active"><a href="PrenotazioneServlet?action=nuovaPr">Nuova prenotazione</a></li>
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
                <p>Da questa pagina puoi prenotare una nuova visita medica.</p>
            </div>
            <div class="page-header">
                <h1>Nuova prenotazione</h1>
            </div>
            <!-- da selezionare tipologia prestazione, struttura medica, data -->
            <div class="panel panel-primary">
                <div class="panel-heading">Prenota</div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form">
                        <div class="form-group">
                            <label for="prest" class="col-sm-2 control-label">Prestazione</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="prest">
                                    <% for (int i = 0; i < prestazioni.size(); i++) {%>
                                    <option><%= prestazioni.get(i).getNome()%></option>
                                    <%}%>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="strut" class="col-sm-2 control-label">Struttura medica</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="strut" disabled>
                                    <option></option>
                                </select>
                            </div>
                        </div>
                        <!-- da leggere calendario di google-->
                        <div class="form-group">
                            <label for="data" class="col-sm-2 control-label">Data</label>
                            <div class="col-sm-10">
                                <input type="input" class="form-control" id="data">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default btn-primary">Prenota</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
