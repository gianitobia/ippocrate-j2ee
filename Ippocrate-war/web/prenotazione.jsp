<%-- 
    Document   : prenotazione
    Created on : 16-dic-2013, 16.01.06
    Author     : Marco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CSS/style.css" rel="stylesheet" type="text/css">
        <title>Ippocrate :: Prenotazione</title>
    </head>
    <body>
        <fieldset>
            <legend>Nuova prenotazione</legend>
            <form>
                <!-- Selezione della tipologia di visita medica -->
                <label>Tipologia visita:</label>
                <select name="tipologia">
                    <option>selezionare tipologia visita</option>
                    <option>Visita cardiologica</option>
                    <option>Visita fisiatrica</option>
                    <option>Visita ginecologica</option>
                    <option>Visita psichiatrica</option>
                </select>
                <!-- Selezione della struttura medica disponibile -->
                <label>Struttura medica:</label>
                <select name="struttura">
                    <option>selezionare struttura medica</option>
                    <option>Osp. Molinette</option>
                    <option>Osp. Sant'Anna</option>
                    <option>Centro Fisiatrico da Pippo</option>
                </select>
                <!-- Selezione della data in cui effettuare la visita medica -->
                <label>Data visita:</label>
                <iframe src="https://www.google.com"></iframe>
            </form>
        </fieldset>
    </body>
</html>
