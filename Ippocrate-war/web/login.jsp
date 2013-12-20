<%--
    Document   : login
    Created on : 16-dic-2013, 15.50.45
    Author     : toby
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Login</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/signin.css" rel="stylesheet">
        <script>
            function cambio_login(elem_id) {
                switch (elem_id) {
                    case 1:
                        document.getElementById("bl").setAttribute("class", "btn btn-default active");
                        document.getElementById("br").setAttribute("class", "btn btn-default");
                        document.getElementById("form_medico").style.display = "block";
                        document.getElementById("form_paziente").style.display = "none";
                        break;
                    case 2:
                        document.getElementById("bl").setAttribute("class", "btn btn-default");
                        document.getElementById("br").setAttribute("class", "btn btn-default active");
                        document.getElementById("form_medico").style.display = "none";
                        document.getElementById("form_paziente").style.display = "block";
                        break;
                }
            }
        </script>
    </head>
    <body>      
        <div class="container">
            <div class="row">              
                <div id="testa" class="col-md-4 col-md-offset-4">
                    <h2>Tipologia login</h2>
                    <div class="btn-group">
                        <button id="bl" type="button" class="btn btn-default" onclick="cambio_login(1)">Medico</button>
                        <button id="br" type="button" class="btn btn-default" onclick="cambio_login(2)">Paziente</button>
                    </div>
                </div>
            </div>
            <form id="form_medico" class="form-signin" action="LoginServlet?action=login_medico" role="form" method="POST">
                <h2 class="form-signin-heading">Effettua il login</h2>
                <input name="username-medico" type="text" class="form-control" placeholder="Username" required>
                <input id="pin" name="pincode-medico" type="password" class="form-control" placeholder="Pin Code" required>
                <input name="password-medico" type="password" class="form-control" placeholder="Password" required>             
                <button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
            </form>
            <form id="form_paziente" class="form-signin" action="LoginServlet?action=login_paziente" role="form" method="POST">
                <h2 class="form-signin-heading">Effettua il login</h2>
                <input name="codfisc-paziente" type="text" class="form-control" placeholder="Codice fiscale" required>
                <input name="password-paziente" type="password" class="form-control" placeholder="Password" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Accedi</button>
            </form>
        </div> <!-- /container -->
    </body>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</html>
