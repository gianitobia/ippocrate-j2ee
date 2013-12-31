<%--
    Document   : quicklist-strutturemediche
    Created on : 30-dic-2013, 18.56.41
    Author     : toby
--%>

<%@page import="Entity.StudioMedico"%>
<%@page import="Entity.Ospedale"%>
<jsp:useBean id="ospedali" class="java.util.List<Entity.Ospedale>" scope="session" />
<jsp:useBean id="studimedici" class="java.util.List<Entity.StudioMedico>" scope="session" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ippocrate :: liste strutture mediche</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div>
            <%
                if (ospedali != null) {
            %>
            <h1>Lista Ospedali</h1>

            <%
                for (Ospedale o : ospedali) {
            %><p><%= o.toString()%></p><%
                    }
                }
            %>

            <%
                if (studimedici != null) {
            %>

            <%
                for (StudioMedico s : studimedici) {
            %><p><%= s.toString()%></p><%
                    }
                }
            %>
        </div>
    </body>
</html>
