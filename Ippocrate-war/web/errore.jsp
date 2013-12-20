<%-- 
    Document   : error.jsp
    Created on : 17-dic-2013, 22.52.58
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if (session.getAttribute("error") == null) { %>
<jsp:forward page="index.html"></jsp:forward>
<% } else {
    String error = (String) session.getAttribute("error");
    session.setAttribute("error", null);
%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Errore</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <div class="jumbotron">
                <h1>Ippocrate</h1>
                <br>
                <div class="alert alert-danger"><strong>Attenzione!</strong> Si è 
                    verificato un errore.<br><%= error%></div>
            </div>
        </div>
    </body>
</html>
<%
    }
%>