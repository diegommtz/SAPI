<%-- 
    Document   : rendimiento
    Created on : 01-nov-2018, 15:19:59
    Author     : urieldiaz, julioguzman, shannonrosas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Inicio</title>

        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="lib/fontawesome/css/all.css" rel="stylesheet" />
        <link href='lib/fullcalendar/fullcalendar.css' rel='stylesheet' />
        <link href="lib/tooltipster/dist/css/tooltipster.bundle.min.css" rel="stylesheet" />
        <link href="lib/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css" rel="stylesheet"
              />
        <link href="lib/datatables/datatables.min.css" rel="stylesheet" type="text/css" />
        <script src="lib/jquery/jquery-3.3.1.js" type="application/javascript"></script>
        <script src="lib/jquery/jqueryPostGo.js" type="application/javascript"></script>
        <script src="lib/popper/popper.min.js" type="application/javascript"></script>
        <script src="lib/bootstrap/js/bootstrap.js" type="application/javascript"></script>
        <script src='lib/moment/moment.min.js' type="application/javascript"></script>
        <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
        <script src="lib/fullcalendar/locale-all.js"></script>
        <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
        <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript"></script>
        <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>


        <link rel="stylesheet" href="css/styleNavegadora.css">
        <link rel="stylesheet" href="css/styleNavegadoraImg.css">
        <script src="js/appNavegadora.js"></script>
        <script src="js/appNavegadora2.js"></script>
        <script src="js/ajaxNavegadora.js"></script>
        <script src="js/autocomplete.js"></script>
        <script src="js/rendimiento.js"></script>

    </head>

    <body>

        <div class="wrapper">

            <!-- SIDEBAR -->
            <nav id="sidebar">

                <div class="sidebar-header">

                    <div class="row text-center justify-content-center mt-2">
                        <div class="col-12">
                            <img src="img/logoSapi.png" style="width: 70%; display:block; margin:auto;" alt="">
                        </div>
                    </div>

                </div>

                <div class="profile">

                    <div class="row">
                        <div class="col-12 mb-2 mt-4">
                            <img src="data:image/jpeg;base64,${sessionScope.base64Img}" class="imagenPerfil edit-image" width="66px" height="66px" alt="">
                        </div>
                    </div>

                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">${sessionScope.nombre} ${sessionScope.primerApellido}</span>
                            <span class="textoSidebar userSidebar m-0">@${sessionScope.usuario}</span>
                        </div>
                    </div>

                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta">
                                <i class="fas fa-cog"></i>
                            </a>
                        </div>


                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión" id="salirCuenta2">
                                <i class="fas fa-power-off"></i>
                            </a>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-12 text-center">
                        <hr style="background-color:white !important">
                    </div>
                </div>

                <!-- MENU PRINCIPAL ENLACES -->
                <ul class="list-unstyled components">

                    <li id="irADashboard"><a><i class="fas fa-home"></i>Inicio</a></li>

                    <li id="irAForm"><a><i class="fas fa-home"></i>Ir a Form</a></li>

                    <li id="irACalendario"><a><i class="fas fa-calendar-alt"></i>Calendario</a></li>

                    <li id="irARendimiento"><a><i class="fas fa-chart-line"></i>Mi Rendimiento</a></li>

                    <li id="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta</a></li>

                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>

                </ul>

            </nav>

            <!-- CONTENIDO PRINCIPAL  -->

            <div id="content">

                <!-- MENU -->

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">


                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}

                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <!-- 1.- TOTAL DE VISITAS POR MES -->
                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Total de visitas por mes</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table" id="totalVisitasMes">
                            <thead>
                                <tr>
                                    <th scope="col">Mes</th>
                                    <th scope="col">Total de visitas</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>
                        
                    </div>
                </div>

                <!-- 2.- CANTIDAD DE VISITAS POR EDADDES -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por Edades</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasEdades">
                            <thead>
                                <tr>
                                    <th scope="col">Edad</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>
                
                <!-- 3.- CANTIDAD DE VISITAS POR ESCOLARIDAD -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por Escolaridad</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasEscolaridad">
                            <thead>
                                <tr>
                                    <th scope="col">Escolaridad</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>
                
                <!-- 4.- CANTIDAD DE VISITAS POR LUGAR DE RESIDENCIA -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por lugar de residencia</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasLugar">
                            <thead>
                                <tr>
                                    <th scope="col">Lugar</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>
                
                <!-- 5.- CANTIDAD DE VISITAS POR NIVEL SOCIOECONOMICO -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por nivel socioeconómico</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasNivel">
                            <thead>
                                <tr>
                                    <th scope="col">Nivel Socioeconómico</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>
                
                <!-- 6.- CANTIDAD DE VISITAS POR DECISION PRE-CONSULTA -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por decision pre-consulta</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasDecision">
                            <thead>
                                <tr>
                                    <th scope="col">Decisión</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>
                
                <!-- 7.- CANTIDAD DE VISITAS POR RESULTADO PATOLOGIA -->
                <div class="jumbotron jumbotron-fluid p-2 mt-4">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Cantidad de visitas por resultado de patología</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body">
                        <table class="table table-striped" id="cantidadVisitasResultado">
                            <thead>
                                <tr>
                                    <th scope="col">Resultado</th>
                                    <th scope="col">Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </table>

                    </div>
                </div>


            </div>
            
            <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>

    </body>

</html>
