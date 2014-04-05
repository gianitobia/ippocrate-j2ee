<%-- 
    Document   : rm-paziente
    Created on : 27-feb-2014, 16.44.14
    Author     : Marco
--%>

<%@page import="Entity.PrestazioneMedico"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Entity.PrescrizioneMedica"%>
<%@page import="java.util.List"%>
<%@page import="Entity.RefertoMedico"%>
<jsp:useBean id="CCpaziente" class="Entity.CartellaClinica" scope="session" />
<jsp:useBean id="medico" class="Entity.Medico" scope="session" />
<% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    int numR = Integer.parseInt(request.getParameter("num"));
    RefertoMedico referto = CCpaziente.getLista_referti().get(numR);
    List<PrestazioneMedico> prestazioni = medico.getPrestazioniEffettuabili();
%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="it">
    <head>
        <meta charset="ISO-8859-1">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Ippocrate :: Referto medico del paziente</title>

        <!-- Bootstrap core CSS -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/bootstrap.file.css" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/navbar.css" rel="stylesheet">
        <link href="css/datepicker.css" rel="stylesheet">

        <script language="JavaScript">
            function annullaModifica() {
                document.getElementById("prest").value = <%= "\"" + referto.getTipoVisita().getNome() + "\""%>;
                document.getElementById("data").value = <%= "\"" + sdf.format(referto.getDataVisita()) + "\""%>;
                document.getElementById("diagn").value = <%= "\"" + referto.getDiagnosi() + "\""%>;
            }

            function svuotaCreazione() {
                document.getElementById("medic").value = "";
                document.getElementById("numConf").value = "";
                document.getElementById("dataPres").value = "";
                document.getElementById("dataScad").value = "";
            }

            function modificaPresMedica(medicinale, numConfezioni, dataPrescrizione, dataScadadenza, numR, i) {
                document.getElementById("medicN").value = medicinale;
                document.getElementById("numConfN").value = numConfezioni;
                document.getElementById("dataPresN").value = dataPrescrizione;
                document.getElementById("dataScadN").value = dataScadadenza;
                document.getElementById('modPresModal').action = "MedicoServlet?action=modificaPresMedica_" + numR + "_" + i;
                $("#modalPresMediche").modal("show");
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
                        <li><a href="MedicoServlet?action=getAgenda">La mia agenda</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="LoginServlet?action=invalida">Logout</a></li>
                    </ul>
                </div><!--/.nav-collapse -->
            </div>
            <!-- Main component for a primary marketing message or call to action -->
            <div class="jumbotron">
                <p>Da questa pagina puoi visualizzare i dettagli del referto medico del paziente.</p>
            </div>
            <div class="page-header">
                <h1>Referto medico di <%= CCpaziente.getPaziente().getNome()
                            + " " + CCpaziente.getPaziente().getCognome()%></h1>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Dettagli
                    &nbsp;&nbsp;
                    <% if (referto.getMedico().getCognome().equals(medico.getCognome())) {%>                  
                    <button type="button" class="btn btn-primary btn-sm" 
                            title="Modifica dettagli" data-toggle="modal" data-target="#modalDettagliRefMedico">
                        <span class="glyphicon glyphicon-pencil"></span>
                    </button>
                    <%}%>
                </div>
                <div class="modal fade" id="modalDettagliRefMedico">
                    <div class="modal-dialog" style="width: 65%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Modifica referto</h4>
                            </div>
                            <form class="form-horizontal" action="MedicoServlet?action=modificaDettagliRefMedico_<%=numR%>"  method="POST" >
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="prest" class="col-sm-2 control-label">Tipo visita</label>
                                        <div class="col-sm-7">
                                            <select class="form-control" id="prest" name="prest">
                                                <% for (int i = 0; i < prestazioni.size(); i++) {%>
                                                <option value="<%= i%>"><%= prestazioni.get(i).getNome()%></option>
                                                <%}%>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="data" class="col-sm-2 control-label">Data</label>
                                        <div class="col-sm-3">
                                            <div class="input-group date" data-provide="datepicker">
                                                <input type="text"  class="form-control" id="data" name="data" required value=<%= "\"" + sdf.format(referto.getDataVisita()) + "\""%> >
                                                <span class="input-group-addon" ><i class="glyphicon glyphicon-calendar"></i></span>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="diagn" class="col-sm-2 control-label">Diagnosi</label>
                                        <div class="col-sm-7">
                                            <input type="text" class="form-control" id="diagn" name="diagn" required value=<%= "\"" + referto.getDiagnosi() + "\""%>>
                                        </div>
                                    </div>
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="annullaModifica()">Annulla</button>
                                    <button type="submit" class="btn btn-primary">Conferma</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <div class="panel-body">
                    <dl class="dl-horizontal">
                        <dt>Tipo di visita</dt>
                        <dd><%= referto.getTipoVisita().getNome()%></dd>
                        <dt>Data visita</dt>
                        <dd><%= sdf.format(referto.getDataVisita())%></dd>
                        <dt>Medico</dt>
                        <dd><%= referto.getMedico().getCognome()%></dd>
                        <dt>Diagnosi</dt>
                        <dd><%= referto.getDiagnosi()%></dd>
                    </dl>
                </div>             
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Multimedia
                    &nbsp;&nbsp;
                    <% if (referto.getMedico().getCognome().equals(medico.getCognome())) {%>
                    <button type="button" class="btn btn-primary btn-sm" 
                            title="Aggiungi immagine" data-toggle="modal" data-target="#modalMultimedia">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                    <%}%>
                </div>

                <div class="modal fade" id="modalMultimedia">
                    <div class="modal-dialog" style="width: 65%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Modifica multimedia</h4>
                            </div>
                            <form class="form-horizontal" action="MedicoServlet?action=aggiungiMultimediaRefMedico_<%=numR%>"  method="POST" enctype="multipart/form-data">
                                <div class="modal-body">
                                    <div class="form-group">
                                        <label for="multim" class="col-sm-2 control-label">Allega file</label>
                                        <div class="col-sm-7">  
                                            <div class="input-group">
                                                <span class="input-group-btn">
                                                    <span class="btn btn-primary btn-file">
                                                        Allega<input type="file" accept="image/*" id="multim" name="multim">
                                                    </span>
                                                </span>
                                                <input type="text" class="form-control" readonly>
                                            </div>                                       
                                        </div>
                                    </div>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" >Annulla</button>
                                    <button type="submit" class="btn btn-primary">Conferma</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->
                <div class="panel-body">
                    <% String listaImg = referto.getLista_images();
                        if (listaImg != null && listaImg.equals("") == false) {
                            String[] multim = listaImg.split(";");
                            for (int i = 0; i < multim.length; i++) {%>
                    <div class="col-md-3">
                        <a href="<%= multim[i]%>">
                            <img src="<%= multim[i]%>" alt="Immagine <%= i + 1%>" 
                                 class="img-thumbnail" style="max-height: 250px; max-width: 250px;">
                        </a>
                    </div>
                    <%}%>
                    <%}%>
                </div>
            </div>
            <div class="panel panel-primary">
                <div class="panel-heading">Prescrizioni mediche   
                    &nbsp;&nbsp;
                    <% if (referto.getMedico().getCognome().equals(medico.getCognome())) {%>
                    <button type="button" class="btn btn-primary btn-sm" 
                            title="Aggiungi prescrizione" data-toggle="modal" data-target="#modalPrescrizione">
                        <span class="glyphicon glyphicon-plus"></span>
                    </button>
                    <%}%>
                </div>  

                <div class="modal fade" id="modalPrescrizione">
                    <div class="modal-dialog" style="width: 65%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Aggiungi prescrizione medica</h4>
                            </div>
                            <form class="form-horizontal" action="MedicoServlet?action=aggiungiPresMedica_<%=numR%>"  method="POST" >
                                <div class="modal-body">
                                    <div class="form-group">                                        
                                        <div class="form-group">
                                            <label for="medic" class="col-sm-3 control-label">Medicinale</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="medic" name="medic" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="numConf" class="col-sm-3 control-label">Quantità</label>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" id="numConf" name="numConf" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dataPres" class="col-sm-3 control-label">Data prescrizione</label>
                                            <div class="col-sm-3">                                               
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="text"  class="form-control" id="dataPres" name="dataPres" placeholder="01/12/2013" required>
                                                    <span class="input-group-addon" ><i class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dataScad" class="col-sm-3 control-label">Data scadenza prescrizione</label>
                                            <div class="col-sm-3">
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="text"  class="form-control" id="dataScad" name="dataScad" placeholder="01/12/2014" required>
                                                    <span class="input-group-addon" ><i class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal" onclick="svuotaCreazione()">Annulla</button>
                                    <button type="submit" class="btn btn-primary">Conferma</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->




                <div class="modal fade" id="modalPresMediche">
                    <div class="modal-dialog" style="width: 65%">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h4 class="modal-title">Modifica prescrizione medica</h4>
                            </div>
                            <form class="form-horizontal" id="modPresModal" action=""  method="POST" >
                                <div class="modal-body">
                                    <div class="form-group">                                        
                                        <div class="form-group">
                                            <label for="medicN" class="col-sm-3 control-label">Medicinale</label>
                                            <div class="col-sm-5">
                                                <input type="text" class="form-control" id="medicN" name="medicN" value="" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="numConfN" class="col-sm-3 control-label">Quantità</label>
                                            <div class="col-sm-1">
                                                <input type="text" class="form-control" id="numConfN" name="numConfN" value="" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dataPresN" class="col-sm-3 control-label">Data prescrizione</label>
                                            <div class="col-sm-3">                                               
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="text"  class="form-control" id="dataPresN" name="dataPresN" value="" required>
                                                    <span class="input-group-addon" ><i class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="dataScadN" class="col-sm-3 control-label">Data scadenza prescrizione</label>
                                            <div class="col-sm-3">
                                                <div class="input-group date" data-provide="datepicker">
                                                    <input type="text"  class="form-control" id="dataScadN" name="dataScadN" value="" required>
                                                    <span class="input-group-addon" ><i class="glyphicon glyphicon-calendar"></i></span>
                                                </div>
                                            </div>
                                        </div>
                                    </div>   
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-default" data-dismiss="modal">Annulla</button>
                                    <button type="submit" class="btn btn-primary">Conferma</button>
                                </div>
                            </form>
                        </div><!-- /.modal-content -->
                    </div><!-- /.modal-dialog -->
                </div><!-- /.modal -->


                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Data prescrizione</th>
                            <th>Data scadenza prescrizione</th>
                            <th>Medicinale</th>
                            <th>Quantità</th>
                                <% if (referto.getMedico().getCognome().equals(medico.getCognome())) {%>
                            <th>Altro</th>
                                <%}%>
                        </tr>
                    </thead>
                    <% List<PrescrizioneMedica> prescrizioni = referto.getLista_prescrizioni();
                        for (int i = 0; i < prescrizioni.size(); i++) {%>
                    <tbody>
                        <tr>
                            <td><%= i + 1%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getData_prescrizione())%></td>
                            <td><%= sdf.format(prescrizioni.get(i).getData_scadenza())%></td>
                            <td><%= prescrizioni.get(i).getMedicinale()%></td>
                            <td><%= prescrizioni.get(i).getNumero_confezioni()%></td>
                            <% if (referto.getMedico().getCognome().equals(medico.getCognome())) {%>
                            <td><button type="button" class="btn btn-primary btn-xs"   
                                        title="Modifica prescrizione" onclick="modificaPresMedica(<%= "\'" + referto.getLista_prescrizioni().get(i).getMedicinale() + "\'"%>,
                                        <%= "\'" + referto.getLista_prescrizioni().get(i).getNumero_confezioni() + "\'"%>,
                                        <%= "\'" + sdf.format(referto.getLista_prescrizioni().get(i).getData_prescrizione()) + "\'"%>,
                                        <%= "\'" + sdf.format(referto.getLista_prescrizioni().get(i).getData_scadenza()) + "\'"%>,
                                        <%=numR%>,
                                        <%=i%>)"><span class="glyphicon glyphicon-pencil"></span></button></td>
                                    <%}%>
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
        <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
        <script type="text/javascript" src="js/bootstrap-datepicker.it.js"></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript">
                                            $.fn.datepicker.defaults.format = "dd/mm/yyyy";
                                            $.fn.datepicker.defaults.language = "it";
                                            $.fn.datepicker.defaults.todayBtn = "linked";
                                            $(document)
                                                    .on('change', '.btn-file :file', function() {
                                                        var input = $(this),
                                                                numFiles = input.get(0).files ? input.get(0).files.length : 1,
                                                                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
                                                        input.trigger('fileselect', [numFiles, label]);
                                                    });
                                            $(document).ready(function() {
                                                $('.btn-file :file').on('fileselect', function(event, numFiles, label) {

                                                    var input = $(this).parents('.input-group').find(':text'),
                                                            log = numFiles > 1 ? numFiles + ' files selected' : label;
                                                    if (input.length) {
                                                        input.val(log);
                                                    } else {
                                                        if (log)
                                                            alert(log);
                                                    }

                                                });
                                            });
        </script>
    </body>
</html>
