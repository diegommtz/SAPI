<%-- 
    Document   : cuentaPaciente
    Created on : 15/10/2018, 01:59:33 PM
    Author     : Angel GTZ, julioguzman, shannonrosas
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Cuenta</title>
        <link rel="icon" href="img/logo-cancer.ico">

        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet"/>
        <link href="lib/fontawesome/css/all.css" rel="stylesheet"/>
        <link href='lib/fullcalendar/fullcalendar.css' rel='stylesheet'/>
        <link href="lib/tooltipster/dist/css/tooltipster.bundle.min.css" rel="stylesheet" />
        <link href="lib/tooltipster/dist/css/plugins/tooltipster/sideTip/themes/tooltipster-sideTip-shadow.min.css" rel="stylesheet" />
        <link href="lib/datatables/datatables.min.css" rel="stylesheet" type="text/css"/> 
        <script src="lib/jquery/jquery-3.3.1.js" type="application/javascript"></script>
        <script src="lib/jquery/jqueryPostGo.js" type="application/javascript"></script>
        <script src="lib/popper/popper.min.js" type="application/javascript"></script>
        <script src="lib/bootstrap/js/bootstrap.js" type="application/javascript"></script> 
        <script src='lib/moment/moment.min.js' type="application/javascript" ></script>
        <script src='lib/fullcalendar/fullcalendar.js' type="application/javascript"></script>
        <script src="lib/fullcalendar/locale-all.js"></script>
        <script src="lib/sweetalert/dist/sweetalert.min.js"></script>
        <script src="lib/tooltipster/dist/js/tooltipster.bundle.min.js" type="text/javascript" ></script>
        <script src="lib/datatables/datatables.min.js" type="text/javascript"></script>

        <link rel="stylesheet" href="css/stylePotencial.css">
        <script src="js/appPotencial.js"></script>
        <script src="js/ajaxPotencial.js"></script>  

    </head>

    <body>
        
        <div class="cargandoIrAMisCitas" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando el calendario, por favor espere...</p>
        </div>
        
        <div class="cargandoIrAInicio" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando, por favor espere...</p>
        </div>
        
        <div class="cargandoIrAPreguntas" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando preguntas frecuentes, por favor espere...</p>
        </div>
        
        <div class="cargandoIrACuenta" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando tus datos, por favor espere...</p>
        </div>

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
                            <a class="iconoSidebar" id="irACuenta1"><i class="fas fa-cog"></i></a>
                        </div>
                        <div class="col-2">
                            <a class="iconoSidebar" id="salirCuenta1"><i class="fas fa-power-off"></i></a>
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

                    <li id ="irACitaPreconsulta"><a><i class="fas fa-home"></i>Cita a Preconsulta </a></li>

                    <li id ="irAMisCitas"><a><i class="fas fa-calendar-alt"></i>Mis Citas
                                <c:choose>
                                    <c:when test="${sessionScope.estatus==1}">
                                    <span class="notificacion">1</span>                        
                                </c:when>
                            </c:choose>
                        </a>                    
                    </li>

                    <li id ="irACuenta"><a><i class="far fa-user"></i>Mi Cuenta </a></li>

                    <li id ="irAPreguntasFrecuentes"><a><i class="fas fa-question-circle"></i>Preguntas Frecuentes </a></li>

                    <li id ="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar Sesión</a></li>

                </ul>

            </nav>

            <!-- PANTALLAS DE CARGA -->

            <div class="loading-screenGuardar" id="loading-screen" style="display: none">
                <img src="img/loading.svg">
                <p class="clear">Guardando tu información, por favor espere...</p>
            </div>

            <!-- CONTENIDO PRINCIPAL  -->

            <div id="content">

                <!-- MENU -->

                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container-fluid">

                        <button id="sidebarCollapse" class="btn boton-collapse">
                            <i class="fas fa-align-justify"></i>
                        </button>

                        <!-- aqui se inyecta la sesion de id-->
                        <input type="hidden" id="sesionPaciente" value="${sessionScope.idSesion}" />
                        <input type="hidden" id="idPaciente" value="${sessionScope.idPaciente}"/>

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">
                                ${sessionScope.nombre} ${sessionScope.primerApellido}</span></span>
                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome mr-2"><i class="fas fa-home irAInicioPotencial"></i></span><span><a class="colorMoradoLight irAInicioPotencial">Inicio</a></span>
                        - <span class="colorGlobal">Mi Cuenta</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMiCuenta text-center m-0">Mi cuenta</h1>
                    </div>
                </div>

                <!-- Contenido del contenedor blanco -->
                <div class="card mt-3">
                    <div class="card-body">

                        <form>

                            <!-- Imagen -->
                            <div class="form-group row justify-content-center">
                                <div class="col-12 text-center">
                                    <input type="file" class="editar-imagen" id="file-input" name="file-image"/>
                                    <label for="file-input" id="fileLabel">
                                        <img src="data:image/jpeg;base64,${sessionScope.base64Img}" id="ImagenPerfil" class="edit-image" alt="Click aquí" title="Click aquí" width="200px" height="200px">
                                    </label>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col-12 text-center">
                                    <h4 class="FotoPerfil text-secondary" style="font-size:17px;">Edita tu foto de perfil</h4>
                                    <span class="text-danger" id="error-imgPerfil">No es una extensión válida. Puedes subir un archivo .jpg o .png</span>
                                </div>
                            </div>

                            <!-- 1 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="name">Nombre</label>
                                    <input type="text" class="form-control" id="name" value="${sessionScope.nombre}" readonly/>
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="surname1">Primer apellido</label>
                                    <input type="text" class="form-control" id="surname1" value="${sessionScope.primerApellido}" readonly/>
                                </div>
                            </div>

                            <!-- 2 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="surname2">Segundo apellido</label>
                                    <input type="text" class="form-control" id="surname2" value="${sessionScope.segundoApellido}" readonly/>
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="username">Usuario</label>
                                    <input type="text" class="form-control" id="username" value="${sessionScope.usuario}" readonly/>
                                </div>
                            </div>

                            <!-- 3 -->
                            <div class="form-group row justify-content-center">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="myEmail">Correo</label>

                                    <input type="email" class="form-control" id="myEmail" name="myEmail" value="${sessionScope.correo}"  required/>
                                    <span class="text-danger" id="error-correo">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                    <span class="text-warning" id="errorCorreoRepetido">El correo ya existe.</span>
                                </div>
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-12 col-12 mb-2">
                                    <label for="telephoneNum">Teléfono</label>
                                    <input type="text" class="form-control" id="telephoneNum" name="telephoneNum"
                                           value="${sessionScope.telefono}" required />
                                    <span class="text-danger" id="error-tel">El formato no es correcto, deben ser 10 dígitos.</span>
                                </div>
                            </div>

                            <div class="form-group row justify-content-center">
                                <div class="col-xl-8 col-lg-8 col-md-8 col-sm-12 col-12 mb-2">
                                    <label for="myPRZ">PRZ</label>
                                    <input type="text" class="form-control" id="myPRZ" value="${sessionScope.prz}"
                                           readonly/>
                                </div>
                            </div>

                            <div class="row mb-3" id="error-datosRepetidos">
                                <div class="col-12 text-center">
                                    <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                </div>
                            </div>

                            <!-- 5 -->
                            <div class="form-group row justify-content-center mt-4">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-12">
                                    <button type="button" id = "guardarCambios" class="btn btn-outline-success btn-block display-4 truncate" style="border-radius:20px"><i
                                            class="fas fa-save mr-1"></i>
                                        Guardar Cambios</button>
                                </div>
                            </div>


                            <!-- 6 -->
                            <div class="form-group row justify-content-center mt-3">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-12">
                                    <button type="button" class="btn btn-outline-info btn-block display-4 truncate" id="btn-contraseña" style="border-radius:20px" data-toggle="modal"
                                            data-target="#modalCambiarContraseña"><i class="fas fa-key mr-1"></i>
                                        Cambiar Contraseña</button>
                                </div>
                            </div>

                            <div class="row justify-content-center">
                                <div class="col-8 text-center">
                                    <hr>
                                </div>
                            </div>

                            <div class="form-group row justify-content-center mt-4">
                                <div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 col-12">
                                    <button type="button" class="btn btn-outline-danger btn-block truncate" style="border-radius:20px" id="eliminarCuentaPotencial"><i
                                            class="fas fa-trash-alt mr-1"></i>
                                        Eliminar Cuenta</button>

                                </div>
                        </form>

                    </div>
                </div>

            </div>

            <!-- ********** MODAL EDITAR CONTRASEÑA **********-->
            <div class="modal fade" id="modalCambiarContraseña" tabindex="-1" data-keyboard="false" data-backdrop="static" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Cambiar contraseña</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="form-group col-12">
                                    <label for="name">Contraseña</label>
                                    <div id="cambio1Contrasena" class="input-group-append bg-white">
                                        <input type="password" class="form-control" id="password" placeholder="Ingresa tu nueva contraseña" />
                                        <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="error-contrasena">
                                <div class="col-12">
                                    <span class="text-danger error1">La contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="form-group col-12">
                                    <label for="name">Confirma tu contraseña</label>
                                    <div id="cambio2Contrasena" class="input-group-append bg-white">
                                        <input type="password" class="form-control" id="password2" placeholder="Reingresa tu nueva contraseña" />
                                        <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row" id="noEqualPasswordsError">
                                <div class="col-12">
                                    <span class="text-warning error2">Las contraseñas no son iguales.</span>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-danger myCleaner" style="border-radius: 20px" data-dismiss="modal">Cancelar</button>
                            <button type="button" class="btn btn-primary" id="btn-cambiarContrasena" style="border-radius: 20px">Cambiar contraseña</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- ******* FIN MODAL EDITAR CONTRASEÑA ********-->

        </div>

        <script src="js/validacionesCuentaPotencial.js" type="application/javascript"></script>
    </body>

</html>
