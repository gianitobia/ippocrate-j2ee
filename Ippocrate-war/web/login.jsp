<%--
    Document   : login
    Created on : 16-dic-2013, 15.50.45
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ippocrate :: Login</title>
        <link href="CSS/style.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <h1>Sei un ...</h1>
        <ul>
            <li class="login-scelta"><a href="">Medico</a></li>
            <li class="login-scelta"><a href="">Paziente</a></li>
        </ul>
        <form id="form_medico" action="#">
            <h1>Login medico</h1>
            <label for="username-medico">Username : </label><input name="username-medico" type="text" value=""/><br/>
            <label for="password-medico">Password : </label><input name="password-medico" type="password" value=""/><br/>
            <label for="pincode-medico">Pin code : </label><input name="pincode-medico"type="text" value=""/><br/>
        </form>
        <form id="form_paziente" action="#">
            <h1>Login paziente</h1>
            <label for="codfisc-paziente">Codice fiscale : </label><input name="codfisc-paziente" type="text" value=""/><br/>
            <label for="password-paziente">Password : </label><input name="password-paziente" type="password" value=""/><br/>
        </form>
    </body>
</html>
