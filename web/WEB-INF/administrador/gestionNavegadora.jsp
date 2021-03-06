<%-- 
    Document   : gestionNavegadora
    Created on : 15-nov-2018, 2:30:33
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

        <title>SAPI | Navegadoras</title>
        <link rel="icon" href="img/logo-cancer.ico">
        
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
        <script src="js/appAdministrador.js"></script>
        <script src="js/ajaxAdministrador.js"></script>

    </head>

    <body>
        
        <div class="cargandoAgregarNavegadora" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Agregando a la navegadora, por favor espere...</p>
        </div>
        
        <div class="recuperarInfoNavegadora" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Recuperando la información de la navegadora, por favor espere...</p>
        </div>
        
        <div class="cargandoEditarNavegadora" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Actualizando información de la navegadora, por favor espere...</p>
        </div>
        
        <div class="cargandoEliminarNavegadora" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Eliminando a la navegadora, por favor espere...</p>
        </div>
        
        <div class="cargandoIrAMedico" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando la lista de médicos...</p>
        </div>
        <div class="cargandoIrANavegadora" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando la lista de navegadoras...</p>
        </div>
        <div class="cargandoIrAPaciente" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando la lista de pacientes...</p>
        </div>
        <div class="cargandoIrAAdministrador" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando la lista de administradores...</p>
        </div>
        <div class="cargandoVerRendimiento" id="loading-screen" style="display: none">
            <img src="img/loading.svg">
            <p class="clear">Cargando rendimiento de la navegadora...</p>
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
                            <a class="iconoSidebar IrAMiCuenta" title="Mi Cuenta"><i class="fas fa-cog"></i></a>
                        </div>

                        <div class="col-2">
                            <a class="iconoSidebar salirCuenta" title="Cerrar Sesión"><i class="fas fa-power-off"></i></a>
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

                    <li id="IrAGestionMedicos"><a><i class="fas fa-briefcase-medical"></i>Médicos</a></li>

                    <li id="IrAGestionNavegadora"><a><i class="fas fa-calendar-alt"></i>Navegadoras</a></li>

                    <li id="IrAGestionPaciente"><a><i class="fas fa-users"></i>Pacientes</a></li>

                    <li id="IrAGestionAdministrador"><a><i class="fas fa-shield-alt"></i>Administradores</a></li>

                    <li id="IrAMiCuenta"><a><i class="far fa-user"></i>Mi cuenta</a></li>
                    
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

                        <span class="pull-right d-block"><span style="color:#6c6f80">Hola, </span><span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span></span>
                    </div>
                </nav>

                <!-- Navegacion -->


                <div class="row mb-3">
                    <div class="col-12 text-right">
                        <span class="iconoHome mr-2"><i class="fas fa-home"></i></span><span><a class="colorMoradoLight">Administrador</a></span>
                        - <span class="colorGlobal">Gestion de Navegadoras</span>
                    </div>
                </div>

                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloMisCitas text-center m-0">Gestión de Navegadoras</h1>
                    </div>
                </div>


                <!-- Gestion -->

                <div class="card mt-3">
                    <div class="card-body">

                        <!-- Boton agregar -->

                        <div class="row mb-3">
                            <div class="col-12">
                                <button class="btn btn-morado float-right" data-toggle="modal" data-target="#modalAgregarNavegadora"
                                        style="border-radius:20px;"><i class="fas fa-plus-circle mr-2"></i>Agregar Navegadora</button>
                            </div>
                        </div>

                        <!-- Table -->

                        <table class="table table-striped mt-3" id="tablaNavegadoras">
                            <thead>
                                <tr>
                                    <th scope="col">Nombre</th>
                                    <th scope="col">Correo</th>
                                    <th scope="col">Teléfono</th>
                                    <th scope="col">No. empleado</th>                                
                                    <th scope="col">Especialidad</th>
                                    <th scope="col">Cédula Profesional</th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody>

                                <c:forEach items="${ListaNavegadorasAdministrador}" var="navegadora">
                                    <tr>
                                        <td id="nombre-${navegadora.idEmpleado}" value="${navegadora.nombre}" > <c:out value="${navegadora.nombre} ${navegadora.primerApellido} ${navegadora.segundoApellido}"/> </td>
                                        <td id="correo-${navegadora.idEmpleado}" value="${navegadora.correo}" > <c:out value="${navegadora.correo}"/> </td>
                                        <td id="telefono-${navegadora.idEmpleado}" value="${navegadora.telefono}" > <c:out value="${navegadora.telefono}"/> </td>                                
                                        <td id="noEmpleado-${navegadora.idEmpleado}" value="${navegadora.noEmpleado}" > <c:out value="${navegadora.noEmpleado}"/> </td>                                                        
                                        <td id="nombreEspecialidad-${navegadora.idEmpleado}" value="${navegadora.nombreEspecialidad}" > <c:out value="${navegadora.nombreEspecialidad}"/> </td>                                
                                        <td id="cedulaProfesional-${navegadora.idEmpleado}" value="${navegadora.cedulaProfesional}" > <c:out value="${navegadora.cedulaProfesional}"/> </td>                              
                                        <td>
                                            <button class="btn btn-success m-1 btn-verNavegadora" data-id="${navegadora.idEmpleado}">                                        
                                                <i class="fas fa-chart-line"></i>
                                            </button>
                                            <button class="btn btn-primary btn-editarNavegadora m-1" data-toggle="modal"
                                                    data-target="#modalEditarNavegadora" data-id="${navegadora.idEmpleado}" ><i class="fas fa-edit"></i>
                                            </button>
                                            <button class="btn btn-danger m-1 btn-eliminarNavegadora" data-id="${navegadora.idEmpleado}"><i class="fas fa-trash-alt">

                                                </i></button>
                                        </td>
                                    </tr>
                                </c:forEach>                           
                            </tbody>
                        </table>
                    </div>
                </div>


                <!-- ********** MODAL EDITAR NAVEGADORA ********** -->
                <div class="modal fade" data-keyboard="false" data-backdrop="static" id="modalEditarNavegadora" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Editar Navegadora</h5>
                                <button type="button" class="close clearCancelEditNavegadoraModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <input type="hidden" id="idNavegadora" value="">

                                <!-- FORMULARIO EDITAR NAVEGADORA -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-nombreNavegadora"
                                                   placeholder="Nombre">
                                        </div>
                                        <span class="text-danger" id="errorEditarNombreNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-correoNavegadora"
                                                   placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorEditarCorreoNavegadora">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: ejemplo@ejemplo.com</span>
                                        <span class="text-warning" id="errorEditarCorreoRepetidoNavegadora">El correo ya existe.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-primerApellidoNavegadora"
                                                   placeholder="Primer Apellido">
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoPaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-segundoApellidoNavegadora"
                                                   placeholder="Segundo apellido (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorEditarApellidoMaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-telefonoNavegadora"
                                                   placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorEditarTelefonoNavegadora">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-no-empleadoNavegadora"
                                                   placeholder="No. empleado">
                                        </div>
                                        <span class="text-danger" id="errorEditarNumNavegadora">Formato incorrecto, deben ser 6 dígitos.</span>
                                        <span class="text-warning" id="errorEditarNumEmpleadoRepetidoNavegadora">El número de empleado ya existe.</span>
                                    </div>
                                </div>



                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-cedulaNavegadora"
                                                   placeholder="Cédula Profesional (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorEditarCedulaNavegadora">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="editar-especialidad" placeholder="Especialidad" list="listEspecialidades">
                                            <datalist id="listEspecialidades"></datalist>
                                        </div>
                                        <span class="text-danger" id="errorEditarEspecialidadNavegadora">Selecciona una especialidad válida.</span>
                                    </div>
                                </div>
                                
                                 <div class="row mb-3" id="error-camposEditarNavegadora">
                                    <div class="col-12 text-center">
                                        <span class="text-danger">Debes llenar correctamente los campos para editar la cuenta.</span>
                                    </div>
                                </div>
                                
                                <div class="row mb-3" id="error-editarDatosRepetidosNavegadora">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger clearCancelEditNavegadoraModal" data-dismiss="modal" style="border-radius: 20px;">Cancelar</button>
                                <button id="btn-guardarNavegadora" type="button" class="btn btn-primary" style="border-radius: 20px;">Guardar
                                    Cambios</button>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- ********** MODAL AGREGAR NAVEGADORA ********** -->
                <div class="modal fade" data-keyboard="false" data-backdrop="static" id="modalAgregarNavegadora" tabindex="-1" role="dialog" aria-hidden="true">
                    <div class="modal-dialog modal-dialog-centered modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title">Agregar Navegadora</h5>
                                <button type="button" class="close clearAddNavegadoraModal" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <!-- FORMULARIO AGREGAR NAVEGADORA -->
                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-nombreNavegadora"
                                                   placeholder="Nombre">
                                        </div>
                                        <span class="text-danger" id="errorNombreNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 255 caracteres.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-phone"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-telefonoNavegadora"
                                                   placeholder="Teléfono">
                                        </div>
                                        <span class="text-danger" id="errorTelefonoNavegadora">Formato incorrecto, deben ser 10 dígitos.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-primerApellidoNavegadora"
                                                   placeholder="Primer Apellido">
                                        </div>
                                        <span class="text-danger" id="errorApellidoPaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-segundoApellidoNavegadora"
                                                   placeholder="Segundo Apellido (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorApellidoMaternoNavegadora">Formato incorrecto, solo caracteres alfabéticos con un mínimo de 2 y un máximo de 127 caracteres.</span>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-at"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-correoNavegadora"
                                                   placeholder="Correo">
                                        </div>
                                        <span class="text-danger" id="errorCorreoNavegadora">El formato no es correcto, introduce un mínimo de 2 y un máximo de 254 caracteres. Ejemplo: example@example.com</span>
                                        <span class="text-warning" id="errorCorreoRepetidoNavegadora">El correo ya existe.</span>
                                    </div>

                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fab fa-slack-hash"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-noEmpleadoNavegadora"
                                                   placeholder="No. empleado">
                                        </div>
                                        <span class="text-danger" id="errorNumEmpleadoNavegadora">Formato incorrecto, deben ser 6 dígitos.</span>
                                        <span class="text-warning" id="errorNumEmpleadoRepetidoNavegadora">El número de empleado ya existe.</span>
                                    </div>
                                </div>

                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-user-graduate"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-especialidadNavegadora"
                                                   placeholder="Especialidad" list="listEspecialidades">
                                        </div>
                                        <span class="text-danger" id="errorAgregarEspecialidadNavegadora">Selecciona una especialidad válida.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-id-card"></i></div>
                                            </div>
                                            <input type="text" class="form-control" id="agregar-cedulaNavegadora"
                                                   placeholder="Cédula Profesional (Opcional)">
                                        </div>
                                        <span class="text-danger" id="errorCedulaNavegadora">Formato incorrecto, deben ser 7 dígitos.</span>
                                    </div>
                                </div>


                                <div class="form-group row">
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-passwordNavegadora"
                                                   placeholder="Contraseña">
                                            <div id="navegadoraContrasena" class="input-group-append bg-white">
                                                <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                            </div>
                                        </div>
                                        <span class="text-danger" id="errorPass1Navegadora">Formato incorrecto, la contraseña debe tener al menos 1 número, 1 letra minúscula, 1 mayúscula y una extensión de 8 a 14 caracteres.</span>
                                    </div>
                                    <div class="col-6">
                                        <div class="input-group">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text"><i class="fas fa-lock"></i></div>
                                            </div>
                                            <input type="password" class="form-control" id="agregar-password2Navegadora"
                                                   placeholder="Confirmar contraseña">
                                            <div id="navegadoraContrasenaConfirmacion" class="input-group-append bg-white">
                                                <div class="input-group-text border-left-0 rounded-left bg-white"><i class="far fa-eye"></i></div>
                                            </div>
                                        </div>
                                        <span class="text-warning" id="noEqualPasswordsError">Las contraseñas no son iguales.</span>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                        <a href="documentos/Terminos-y-Condiciones-SAPI.pdf" download>
                                            <button type="button" class="btn btn-morado-solid mt-2" >Descargar los términos y condiciones</button>
                                        </a>
                                    </div>
                                </div>

                                <div class="form-group row justify-content-center">
                                    <div class="col-12 text-center">
                                         <div class="form-check form-check-inline"> 
                                            <label><input class="form-check-input" type="checkbox" id="terminosNavegadora" /> La navegadora está informada y aceptó los términos y condiciones</label>
                                        </div>
                                    </div>
                                    <span class="text-danger" id="errorTerminosNavegadora">Se deben aceptar los términos y condiciones.</span>
                                </div>

                                <div class="row mb-3" id="error-camposNavegadora">
                                    <div class="col-12 text-center">
                                        <span class="text-danger">Completa todos los campos y asegúrate de aceptar los términos para registrar la cuenta.</span>
                                    </div>
                                </div>

                                <div class="row mb-3" id="error-datosRepetidosNavegadora">
                                    <div class="col-12 text-center">
                                        <span class="text-warning">Estás tratando de registrar datos existentes. <br> Revisa de nuevo.</span>
                                    </div>
                                </div>
                                
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-danger clearAddNavegadoraModal" style="border-radius:20px;" data-dismiss="modal">Cancelar</button>
                                <button id="btn-agregarNavegadora" type="button" class="btn btn-primary" style="border-radius:20px;">Agregar Navegadora</button>
                            </div>
                        </div>
                    </div>
                </div>


            </div>
        </div>

    </body>

</html>