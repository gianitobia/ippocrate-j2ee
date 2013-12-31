<%--
    Document   : quicklist-pazienti
    Created on : 30-dic-2013, 18.58.13
    Author     : toby
--%>

<%@page import="Entity.Paziente"%>
<jsp:useBean id="pazienti" class="java.util.List<Entity.Paziente>" scope="session" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ippocrate :: lista pazienti</title>
    </head>
    <body>
        <div>
            <h1>Lista Pazienti</h1>
            <% for (Paziente p : pazienti) {
            %> <p> <%= p.toString()%> </p> <%
                }
            %>
        </div>
    </body>
</html>
