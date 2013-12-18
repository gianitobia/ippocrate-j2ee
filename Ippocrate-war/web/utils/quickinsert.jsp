<%-- 
    Document   : quickinsert
    Created on : 17-dic-2013, 19.23.01
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quick insert</title>
    </head>
    <body>
        <h1>Quick insert di vari dati</h1>
        <form id="form_medico" action="quickinsert?action=crea_medico" method="post">
            <h1>Crea medico</h1>
            <input name="cognome" type="text" value="cognome"/><br/>
            <input name="data_nascita" type="text" value="data_nascita"/><br/>
            <input name="nome" type="text" value="nome"/><br/>
            <input name="password" type="text" value="password"/><br/>
            <input name="pin_code" type="text" value="pin_code"/><br/>
            <input name="specializzazione" type="text" value="specializzazione"/><br/>
            <input name="username" type="text" value="username"/><br/>
            <input name="visite_id" type="text" value="visite_id"/><br/>
            <input name="num_ufficio" type="text" value="num_ufficio"/><br/>
            <input type="submit" value="crea"/>
        </form>
        
        <form id="form_paziente" action="quickinsert?action=crea_paziente" method="post">
            <h1>Crea paziente</h1>
            <input name="cf" type="text" value="cf"/><br/>
            <input name="cognome" type="text" value="cognome"/><br/>
            <input name="data_nascita" type="text" value="data_nascita"/><br/>
            <input name="indirizzo" type="text" value="indirizzo"/><br/>
            <input name="luogo_nascita" type="text" value="luogo_nascita"/><br/>
            <input name="nome" type="text" value="nome"/><br/>
            <input name="password" type="text" value="password"/><br/>
            <input name="sesso" type="text" value="sesso"/><br/>
            <input name="cartella_clinica" type="text" value="cartella_clinica"/><br/>
            <input type="submit" value="crea"/>
        </form>
    </body>
</html>