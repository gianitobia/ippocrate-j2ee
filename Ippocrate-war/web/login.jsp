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
        <script>
            function cambio_login(elem_id) {
                switch (elem_id) {
                    case 1:
                        document.getElementById("form_medico").style.display = "block";
                        document.getElementById("form_paziente").style.display = "none";

                        break;
                    case 2:
                        document.getElementById("form_paziente").style.display = "block";
                        document.getElementById("form_medico").style.display = "none";
                        break;
                }
            }
        </script>
    </head>
    <body>
        <h1>Sei un ...</h1>
        <ul>
            <li class="login-scelta" onclick="cambio_login(1)">Medico</li>
            <li class="login-scelta" onclick="cambio_login(2)">Paziente</li>
        </ul>
        <form id="form_medico" action="LoginServlet?action=login_medico" style="display:block;" method="post">
            <h1>Login medico</h1>
            <label for="username-medico">Username : </label><input name="username-medico" type="text" value=""/><br/>
            <label for="password-medico">Password : </label><input name="password-medico" type="password" value=""/><br/>
            <label for="pincode-medico">Pin code : </label><input name="pincode-medico"type="text" value=""/><br/>
            <input type="submit" value="Accedi"/>
        </form>
        <form id="form_paziente" action="LoginServlet?action=login_paziente" style="display:none;" method="post">
            <h1>Login paziente</h1>
            <label for="codfisc-paziente">Codice fiscale : </label><input name="codfisc-paziente" type="text" value=""/><br/>
            <label for="password-paziente">Password : </label><input name="password-paziente" type="password" value=""/><br/>
            <input type="submit" value="Accedi"/>
        </form>
    </body>
</html>
