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
        <link href="../css/quickinsert.css" rel="stylesheet">
        <title>Quick insert</title>
    </head>
    <body>
        <h1>Quick insert di vari dati</h1>
        <div>
            <h1>Crea medico</h1>
            <form id="form_medico" action="QuickInsert?action=crea_medico" method="post">
                <label>
                    <input type="radio" name="tipo_medico" value="Medico esterno" checked>
                    Medico esterno
                </label>
                <label>
                    <input type="radio" name="tipo_medico" value="Medico ospedaliero">
                    Medico ospedaliero
                </label><br><br>
                <input name="cognome" type="text" placeholder="cognome"/><br>
                <input name="data_nascita" type="text" placeholder="2000/12/01"/><br>
                <input name="nome" type="text" placeholder="nome"/><br>
                <input name="password" type="text" placeholder="password"/><br>
                <input name="pin_code" type="text" placeholder="pin_code"/><br>
                <input name="specializzazione" type="text" placeholder="specializzazione"/><br>
                <input name="username" type="text" placeholder="username"/><br>
                <input name="num_ufficio" type="text" placeholder="num_ufficio"/><br>
                <input type="submit" value="Crea"/>
                <!--<input type="reset" value="reset">-->
            </form>
        </div>
        <div>
            <h1>Crea paziente</h1>
            <form id="form_paziente" action="QuickInsert?action=crea_paziente" method="post">
                <input name="cf" type="text" placeholder="cf"/><br>
                <input name="cognome" type="text" placeholder="cognome"/><br>
                <input name="data_nascita" type="text" placeholder="2000/12/01"/><br>
                <input name="indirizzo" type="text" placeholder="indirizzo"/><br>
                <input name="luogo_nascita" type="text" placeholder="luogo_nascita"/><br>
                <input name="nome" type="text" placeholder="nome"/><br>
                <input name="password" type="text" placeholder="password"/><br>
                <input name="sesso" type="text" placeholder="sesso"/><br>
                <input type="submit" value="Crea"/>
            </form>
        </div>
        <div>
            <h1>Crea prestazione medica</h1>
            <form id="form_prestazione" action="QuickInsert?action=crea_prestazione" method="post">
                <input name="durata" type="text" placeholder="durata"/><br>
                <input name="nome" type="text" placeholder="nome"/><br>
                <input type="submit" value="Crea"/>
            </form>
        </div>
        <div>
            <h1>Crea ospedale</h1>
            <form id="form_ospedale" action="QuickInsert?action=crea_struttura" method="post">
                <label>
                    <input type="radio" name="tipo_strutturaMedica" value="Studio medico" checked>
                    Studio medico
                </label>
                <label>
                    <input type="radio" name="tipo_strutturaMedica" value="Ospedale">
                    Ospedale
                </label><br><br>
                <input name="nome" type="text" placeholder="nome"/><br>
                <input name="indirizzo" type="text" placeholder="indirizzo"/><br>
                <input type="submit" value="Crea"/>
            </form>
        </div>

        <div>Vai alle liste:
            <ul>
                <li><a href="QuickList?action=Ospedali">Ospedali</a></li>
                <li><a href="QuickList?action=StudiMedici">Studi medici</a></li>
                <li><a href="QuickList?action=Pazienti">Pazienti</a></li>
            </ul></div>
    </body>
</html>
