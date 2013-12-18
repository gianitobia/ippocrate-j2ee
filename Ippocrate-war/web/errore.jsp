<%-- 
    Document   : error.jsp
    Created on : 17-dic-2013, 22.52.58
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% if(session.getAttribute("error") == null) { %>
    <jsp:forward page="index.html"></jsp:forward>
<% } else {
    String error = (String)session.getAttribute("error");
    session.setAttribute("error", null);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ippocrate :: Errore</title>
    </head>
    <body>
        <h1><%= error%></h1>
    </body>
</html>

<%
}
%>
