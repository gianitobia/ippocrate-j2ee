<%-- 
    Document   : home-paziente
    Created on : 17-dic-2013, 22.28.52
    Author     : Marco
--%>

<jsp:useBean id="paziente" class="Entity.Paziente" scope="session" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ippocrate :: Home Paziente</title>
    </head>
    <body>              
        <h1>Benvenuto 
            <%= paziente.getCognome() %> <%= paziente.getNome() %>!
        </h1>
    </body>
</html>
