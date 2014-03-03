<%-- 
    Document   : cc-paziente
    Created on : 27-feb-2014, 16.29.04
    Author     : Marco
--%>

<%@page import="Entity.PrestazioneMedico"%>
<%@page import="Entity.CartellaClinica"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entity.RefertoMedico"%>
<%@page import="java.util.List"%>
<jsp:useBean id="CCpaziente" class="Entity.CartellaClinica" scope="session" />
<jsp:useBean id="medico" class="Entity.Medico" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<PrestazioneMedico> prestazioni = medico.getMiePrestazioni();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Cartella clinica del paziente</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/navbar.css" rel="stylesheet">

        <script language="JavaScript">
            function setXMLHttpRequest() {
                var xhr = null;
                if (window.XMLHttpRequest) { // browser standard con supporto nativo
                    xhr = new XMLHttpRequest();
                }
                else if (window.ActiveXObject) { // browser MS Internet Explorer - ActiveX
                    xhr = new ActiveXObject("Microsoft.XMLHTTP");
                }
                return xhr;
            }

            var xhrObj = setXMLHttpRequest();   // crea oggetto XMLHTTPRequest per gestire comunicazione asincrona con server

            function annullaModifica() {
                document.getElementById("textAnamnesi").value = <%= "\"" + CCpaziente.getAnamnesi() + "\""%>;
            }

            function svuotaCreazione() {
                document.getElementById("data").value = "";
                document.getElementById("diagn").value = "";
                document.getElementById("multim").value = "";
                document.getElementById("medic").value = "";
                document.getElementById("numConf").value = "";
                document.getElementById("dataScad").value = "";
            }

            function confermaModifica() {
                var nuovaAnamnesi = document.getElementById("textAnamnesi").value;
                var url = "MedicoServlet?action=modificaAnamnesi_" + nuovaAnamnesi;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage1; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function updatePage1() {
                if (xhrObj.readyState === 4) {
                    var risp = xhrObj.responseText;
                    document.getElementById("anamnesi").innerHTML = risp;
                }
            }

            function creaReferto() {
                var iPrest = document.getElementById("prest").value;
                var dataVisita = document.getElementById("data").value;
                var diagnosi = document.getElementById("diagn").value;
                var file = document.getElementById("multim").value;
                var medic = document.getElementById("medic").value;
                var numConf = document.getElementById("numConf").value;
                var dataScad = document.getElementById("dataScad").value;
                var url = "MedicoServlet?action=creaReferto_" + iPrest + "_" +
                        dataVisita + "_" + diagnosi + "_" + file + "_" + medic + "_" +
                        numConf + "_" + dataScad;
                xhrObj.open("GET", url, true); // connessione asincrona (true) al server (indirizzo=url)
                xhrObj.onreadystatechange = updatePage2; // indico funzione (updatePage) da invocare quando il server termina l’esecuzione della richiesta
                xhrObj.send(null); // invio oggetto XMLHttpRequest a web server
            }

            function updatePage2() {
                if (xhrObj.readyState === 4) {
                    var risp = xhrObj.responseText;
                    document.getElementById("tabReferti").innerHTML += risp;
                    svuotaCreazione();
                }
            }
        </script>
    </head>
    <body>
        <div class="container">
            <!-- Static navbar -->
            <div class="navbar navbar-default" role="navigation">
                <div class="navbar-header">         
                    <a class="navbar-brand" href="home-medico.jsp">Ippocrate</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="home-medico.jsp">Home</a></li>
                        <li class="active"><a href="MedicoServlet?action=mieiPazienti">I miei pazienti</a></li>
                        <li><a href="mia-agenda.jsp">La mia agenda</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="login.jsp">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi visualizzare la cartella clinica
                    del paziente.</p>
            </div>
            <div class="page-header">
                    <h1>Cartella clinica di <%= CCpaziente.getPaziente().getNome()
                            + " " + CCpaziente.getPaziente().getCognome()%></h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Anamnesi
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-primary btn-sm" 
                            title="Modifica" data-toggle="modal" data-target="#modalAnamnesi">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                </div>
                <div class="panel-body">
                    <p id="anamnesi"><%= CCpaziente.getAnamnesi()%></p>
                </div>
                <div class="modal fade" id="modalAnamnesi">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Modifica anamnesi</h4>
                            </div>
                            <div class="modal-body">
                                <textarea id="textAnamnesi" class="form-control" rows="3"
                                          style="max-width: 100%; min-width: 100%; min-height: 2.5em;"><%= CCpaziente.getAnamnesi()%></textarea>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal" onclick="annullaModifica()">Annulla</button>
                                <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="confermaModifica()">Conferma</button>
                            </div>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Referti medici
                    &nbsp;&nbsp;
                    <button type="button" class="btn btn-primary btn-sm" 
                            title="Aggiungi referto" data-toggle="modal" data-target="#modalReferto">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                </div>
                <div class="modal fade" id="modalReferto">
                    <div class="modal-dialog" style="width: 65%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Aggiungi referto</h4>
                            </div>
                            <form class="form-horizontal" role="form">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="prest" class="col-sm-2 control-label">Tipo visita</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" id="prest">
                                                <% for (int i = 0; i < prestazioni.size(); i++) {%>
                                                <option value="<%= i%>"><%= prestazioni.get(i).getNome()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="data" class="col-sm-2 control-label">Data</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="data" placeholder="01/12/2013">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="diagn" class="col-sm-2 control-label">Diagnosi</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="diagn">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="multim" class="col-sm-2 control-label">Allega file</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="multim">
                                        </div>
                                    </div>
                                    <div class="well well-sm">
                                        <div class="form-group">
                                            <label for="medic" class="col-sm-3 control-label">Medicinale</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="medic">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="numConf" class="col-sm-3 control-label">Quantità</label>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" id="numConf">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dataScad" class="col-sm-3 control-label">Data scadenza prescrizione</label>
                                            <div class="col-sm-2">
                                                <input type="text" class="form-control" id="dataScad" placeholder="01/12/2013">
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="svuotaCreazione()">Annulla</button>
                                    <button type="button" class="btn btn-primary" data-dismiss="modal" onclick="creaReferto()">Conferma</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Tipo visita</th>
                            <th>Data</th>
                            <th>Diagnosi</th>
                            <th>Altro</th>
                        </tr>
                    </thead>
                    <tbody id="tabReferti">
                        <% List<RefertoMedico> referti = CCpaziente.getLista_referti();
                            for (int i = 0; i < referti.size(); i++) {%>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= referti.get(i).getTipoVisita().getNome()%></td>
                            <td><%= sdf.format(referti.get(i).getDataVisita())%></td>
                            <td><%= referti.get(i).getDiagnosi()%></td>
                            <td><a href="rm-paziente.jsp?num=<%=i%>">visualizza</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div> <!-- /container -->
        <!-- Bootstrap core JavaScript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </body>
</html>
