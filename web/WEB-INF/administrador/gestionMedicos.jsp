<%-- 
    Document   : gestionMedicos
    Created on : 13-nov-2018, 21:39:52
    Author     : urieldiaz
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
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

        <link rel="stylesheet" href="css/styleAdministrador.css">    
        <script rel="stylesheet" href="lib/jquery/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="lib/jquery/jquery-ui.css">
        <link rel="stylesheet" href="lib/jquery/jquery-ui.min.css">
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>
        <script src="js/autocomplete.js"></script>

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
                            <img src="img/user.png" class="imagenPerfil" alt="">
                        </div>
                    </div>

                    <div class="row justify-content-center mb-2">
                        <div class="col-6 text-center">
                            <span class="textoSidebar m-0">Julio Badillo</span>
                            <span class="textoSidebar userSidebar m-0">@juliobadillo</span>
                        </div>
                    </div>

                    <div class="row justify-content-center">

                        <div class="col-2 text-center">
                            <a class="iconoSidebar" href="" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar" href="" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                    <li id="irAInicioAdministrador"><a><i class="fas fa-home"></i>Inicio</a></li>

                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Gestion médicos</a></li>

                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Gestion navegadoras</a></li>

                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Gestion pacientes</a></li>

                    <li id="IrAGestionAdministrador"><a><i class="fas fa-users"></i>Gestion administradores</a></li>

                    <li id="IrAMiCuenta"><a><i class="fas fa-users"></i>Mi cuenta</a></li>

                    <li id="IrAReasignarMedico"><a><i class="fas fa-sync"></i>Reasignar médico</a></li>

                    <li id="salirCuenta"><a><i class="fas fa-sign-out-alt"></i>Cerrar sesión</a></li>

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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Bienvenido, </span><span style="font-weight:700; color:#6c6f80;">Julio
                                Badillo
                            </span> <img src="img/user.png" class="ml-2" style="width: 30px;" alt=""> </span>

                    </div>
                </nav>

                <!-- Navegacion -->

                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a href="./index2.html" class="colorMoradoLight">Inicio</a></span>
                        - <span class="colorGlobal">Gestion de Médicos</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Médicos</h1>
                    </div>
                </div>


                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" style="border-radius:20px" data-toggle="modal"
                                        data-target="#modalAgregarMedico"><i class="fas fa-plus-circle mr-2"></i>Agregar Médico</button>
                            </div>
                        </div>

                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaMedicos">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>                                
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. Empledo</th>
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col">Acciones</th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaMedicosAdmistrador}" var="medico">
                                    <tr>
                                        <td id="nombre-${medico.idEmpleado}" value="${medico.nombre}" > <c:out value="${medico.nombre} ${medico.primerApellido} ${medico.segundoApellido}"/> </td>
                                        <td id="correo-${medico.idEmpleado}" value="${medico.correo}" > <c:out value="${medico.correo}"/> </td>
                                        <td id="telefono-${medico.idEmpleado}" value="${medico.telefono}" > <c:out value="${medico.telefono}"/> </td>                                
                                        <td id="noEmpleado-${medico.idEmpleado}" value="${medico.noEmpleado}" > <c:out value="${medico.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${medico.idEmpleado}" value="${medico.nombreEspecialidad}" > <c:out value="${medico.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${medico.idEmpleado}" value="${medico.cedulaProfesional}" > <c:out value="${medico.cedulaProfesional}"/> </td>

                                        <td>
                                            <button class="btn btn-primary btn-editarMedico" data-toggle="modal" data-id="${medico.idEmpleado}" data-target="#modalEditarMedico"><i
                                                    class="fas fa-edit"></i></button>
                                            <button class="btn btn-danger" id="btn-eliminarMedico" data-id="${medico.idEmpleado}"><i 
                                                    class="fas fa-trash-alt"></i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                            

                            </tbody>
                        </table>
                    </div>
                </div>

                <!-- ********** MODAL EDITAR MEDICO ********** -->
                <div class="modal fade" id="modalEditarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idMedico" value="">

                                <!-- FORMULARIO EDITAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-nombreMedico" class="form-control" value="Julio">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-primerApellidoMedico" class="form-control" value="Badillo">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-segundoApellidoMedico" class="form-control" value="Guzman">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-at"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-correoMedico" class="form-control" value="juliobadillo@gmail.com">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-phone"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-telefonoMedico" class="form-control" value="7778998">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fab fa-slack-hash"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-noEmpleadoMedico" class="form-control" value="HU89K">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend ui-widget">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-especialidadMedico" class="form-control especialidad" value="Especialidad" list="listEspecialidades">  
                                            <datalist id="listEspecialidades">                                            
                                            </datalist>
                                        </div>
                                    </div>
                                    <div class="col-6">

                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">
                                                    <i class="fas fa-user-graduate"></i>
                                                </div>
                                            </div>
                                            <input type="text" id="editar-cedulaProfesionalMedico" class="form-control" value="Cédula profesional">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btn-guardarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Guardar
                                    Cambios
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- ********** MODAL AGREGAR MEDICO ********** -->
                <div class="modal fade" id="modalAgregarMedico" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Médico</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR MEDICO -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreMedico" placeholder="Nombre">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-telefonoMedico" placeholder="Teléfono">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoMedico"
                                                   placeholder="Primer Apellido">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoMedico"
                                                   placeholder="Segundo Apellido">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoMedico" placeholder="Correo">
                                        </div>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoMedico"
                                                   placeholder="No. empleado">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadMedico"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-posiciondMedico" list="listPosiciones"
                                                   placeholder="Posicion">
                                            <datalist id="listPosiciones">                                            
                                            </datalist>
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-12">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="far fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaMedico" placeholder="Cédula Profesional">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-passwordMedico" placeholder="Contraseña">
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-password2Medico"
                                                   placeholder="Confirmar contraseña">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <button type="button" class="btn btn-morado-solid mt-2" data-dismiss="modal">Imprimir los términos y condiciones</button>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" id="autoSizingCheck2">
                                            <label class="form-check-label" for="autoSizingCheck2">
                                                El médico está informado y aceptó los términos y condiciones
                                            </label>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" style="border-radius:20px" class="btn btn-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarMedico" type="button" style="border-radius:20px" class="btn btn-primary">Agregar médico</button>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>