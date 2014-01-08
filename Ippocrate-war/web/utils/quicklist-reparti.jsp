<%--
    Document   : quicklist-reparti
    Created on : 7-gen-2014, 9.11.52
    Author     : toby
--%>

<%@page import="Entity.Reparto"%>
<jsp:useBean id="reparti" class="java.util.List<Entity.Reparto>" scope="session" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ippocrate :: lista reparti</title>
    </head>
    <body>
        <%
            if (reparti != null) {
        %>
        <h1>Lista reparti</h1>

        <%
            for (Reparto r : reparti) {
        %><p><%= r.toString()%> <a href="QuickList?action=sale&reparto=<%= r.getId()%>">Vai alle sale</a></p><%
                }
            }
        %>
    </body>
</html>
