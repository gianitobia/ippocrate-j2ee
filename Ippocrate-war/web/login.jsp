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
        <title>JSP Page</title>
    </head>
    <body>
        <form id="login_form" action="#">
            <div id="form_medico">
                <h1>Login medico</h1>
                <input type="text" value="username"/>
                <input type="password" value="password"/>
                <input type="text" value="pin code"/>
            </div>
            <div id="form_paziente">
                <h1>Login paziente</h1>
                <p></p><input type="text" value="Codice Fiscale"/>
                <input type="password" value="password"/>
            </div>
        </form>
    </body>
</html>
