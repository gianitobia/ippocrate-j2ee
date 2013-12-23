<%--
    Document   : quickinsert
    Created on : 21-dic-2013, 13.52.21
    Author     : Marco
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
        <form id="form_medico" action="QuickInsert?action=crea_medico" method="post">
            <h1>Crea medico</h1>
            <div class="btn-group" data-toggle="buttons">
                <label class="btn btn-default **active**">
                    <input type="radio" name="tipo_medico" id="inputWalls" value="Medico esterno" checked>
                    Medico esterno </label>
                <label class="btn btn-default">
                    <input type="radio" name="tipo_medico" id="inputWalls" value="Medico ospedaliero">
                    Medico ospedaliero </label>
            </div>
            <input name="cognome" type="text" placeholder="cognome"/><br/>
            <input name="data_nascita" type="text" placeholder="2000/12/01"/><br/>
            <input name="nome" type="text" placeholder="nome"/><br/>
            <input name="password" type="text" placeholder="password"/><br/>
            <input name="pin_code" type="text" placeholder="pin_code"/><br/>
            <input name="specializzazione" type="text" placeholder="specializzazione"/><br/>
            <input name="username" type="text" placeholder="username"/><br/>
            <input name="num_ufficio" type="text" placeholder="num_ufficio"/><br/>
            <input type="submit" placeholder="crea"/>
        </form>

        <form id="form_paziente" action="QuickInsert?action=crea_paziente" method="post">
            <h1>Crea paziente</h1>
            <input name="cf" type="text" placeholder="cf"/><br/>
            <input name="cognome" type="text" placeholder="cognome"/><br/>
            <input name="data_nascita" type="text" placeholder="2000/12/01"/><br/>
            <input name="indirizzo" type="text" placeholder="indirizzo"/><br/>
            <input name="luogo_nascita" type="text" placeholder="luogo_nascita"/><br/>
            <input name="nome" type="text" placeholder="nome"/><br/>
            <input name="password" type="text" placeholder="password"/><br/>
            <input name="sesso" type="text" placeholder="sesso"/><br/>
            <input type="submit" placeholder="crea"/>
        </form>

        <form id="form_prestazione" action="QuickInsert?action=crea_prestazione" method="post">
            <h1>Crea prestazione medica</h1>
            <input name="durata" type="text" placeholder="durata"/><br/>
            <input name="nome" type="text" placeholder="nome"/><br/>
            <input type="submit" placeholder="crea"/>
        </form>

        <form id="form_ospedale" action="QuickInsert?action=crea_struttura" method="post">
            <h1>Crea ospedale</h1>
            <div class="btn-group" data-toggle="buttons">
                <label class="btn btn-default **active**">
                    <input type="radio" name="tipo_strutturaMedica" id="inputWalls" value="Studio medico" checked>
                    Studio medico </label>
                <label class="btn btn-default">
                    <input type="radio" name="tipo_strutturaMedica" id="inputWalls" value="Ospedale">
                    Ospedale </label>
            </div>
            <input name="nome" type="text" placeholder="nome"/><br/>
            <input name="indirizzo" type="text" placeholder="indirizzo"/><br/>
            <input type="submit" placeholder="crea"/>
        </form>
    </body>
</html>
