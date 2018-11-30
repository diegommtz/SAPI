<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%-- Hace rereferencia al conjunto de reglas --%>
<!DOCTYPE html>
<html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">

        <title>SAPI | Inicio</title>

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


        <link rel="stylesheet" href="css/styleNavegadora.css">
        <link rel="stylesheet" href="css/styleNavegadoraImg.css">
        <script src="js/appNavegadora.js"></script>        
        <script src="js/ajaxNavegadora.js"></script>
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
                                <a class="iconoSidebar" href="" title="Cerrar Sesión">
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

                        <span class="pull-right d-block">
                            <span style="color:#6c6f80">Bienvenido, </span>
                            <span style="font-weight:700; color:#6c6f80;">${sessionScope.nombre} ${sessionScope.primerApellido}
                            </span>
                        </span>
                    </div>
                </nav>

                <!-- **************************************************************** -->
                <!-- ***** A PARTIR DE AQUI ESCRIBEN EL CODIGO QUE QUIERAN..... ***** -->
                <!-- **************************************************************** -->

                <div class="row mb-3 justify-content-end">
                    <div class="col-3 text-center">
                        <span class="iconoHome mr-2">
                            <i class="fas fa-home"></i>
                        </span>
                        <span>
                            <a href="./index.html" class="colorMoradoLight">Inicio</a>
                        </span>
                        -
                        <span class="colorGlobal">Formulario</span>
                    </div>
                </div>
                <!-- Jumbotron Titulo -->

                <div class="jumbotron jumbotron-fluid p-2">
                    <div class="container">
                        <h1 class="display-4 tituloPacientes text-center m-0">Formato de Control Preconsulta Mama</h1>
                    </div>
                </div>

                <div class="card mt-3">
                    <div class="card-body p-4">

                        <div class="row justify-content-center">
                            <div class="col-10">

                                <!-- FORMULARIO -->
                                <!-- <form> -->

                                <!-- PANTALLA 1 -->

                                <div id="pantalla1">
                                    <!-- ***** PRZ ***** -->
                                    <form>
                                        <div class="form-group row mt-4">

                                            <div class="col-6">
                                                <label for="">PRZ</label>
                                                <div class="input-group mb-2">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-file-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input name="prz-expediente" type="text" class="form-control" id="prz-expediente" placeholder="Introduce PRZ">
                                                </div>
                                            </div>

                                            <div class="col-6">

                                                <label for="">Médico Adscrito</label>
                                                <div class="input-group">
                                                    <div class="input-group-append">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-user-md"></i>
                                                        </div>
                                                    </div>
                                                    <select name="medico-adscrito" class="form-control" id="medico-adscrito">

                                                        <option disabled selected>Seleccione un Médico Adscrito</option>

                                                        <c:forEach items="${listaMedicos}" var="adscrito">  

                                                            <option value='<c:out value="${adscrito.idPersona}"/>'><c:out value='${adscrito.nombre} ${adscrito.primerApellido} ${adscrito.segundoApellido}'/> </option>

                                                        </c:forEach>

                                                    </select>
                                                </div>
                                                <div class="form-check mt-2">
                                                    <input name="noAdscrito" class="form-check-input" type="checkbox" value="" id="noAdscrito">
                                                    <label class="form-check-label" for="defaultCheck1">
                                                        No estuvo el Médico adscrito
                                                    </label>
                                                </div>
                                            </div>



                                        </div>

                                        <!-- ***** Tipo de paciente y Medico radiologo ***** -->
                                        <div class="form-group row mt-4">

                                            <div class="col-6">
                                                <label for="">Tipo de paciente</label>
                                                <div class="input-group">

                                                    <div class="input-group-append">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-street-view"></i>
                                                        </div>
                                                    </div>
                                                    <select name= "tipoPaciente" class="form-control" id="tipoPaciente">
                                                        <option disabled selected>Seleccione un tipo de paciente</option>

                                                        <option value="0">Primera vez</option>
                                                        <option value="1">Segunda opiniÃ¯Â¿Â½n</option>

                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-6">

                                                <label for="">Médico Radiólogo</label>
                                                <div class="input-group">
                                                    <div class="input-group-append">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-user-md"></i>
                                                        </div>
                                                    </div>
                                                    <select name="medico-radiologo" class="form-control" id="medico-radiologo">

                                                        <option disabled selected>Seleccione un Radiólogo</option>

                                                        <c:forEach items="${listaRadiologos}" var="radiologo">  

                                                            <option value='<c:out value="${radiologo.idPersona}"/>'><c:out value='${radiologo.nombre} ${radiologo.primerApellido} ${radiologo.segundoApellido}'/> </option>

                                                        </c:forEach>
                                                        <option value="otro">Otro</option>

                                                    </select>

                                                </div>
                                                <div class="form-check mt-2">
                                                    <input name="esSustituto" class=" form-check-input" type="checkbox" value="" id="esSustituto">
                                                    <label class="form-check-label" for="defaultCheck1">
                                                        No estuvo médico radiologo
                                                    </label>
                                                </div>
                                            </div>

                                        </div>


                                        <!-- Fecha Navegación -->
                                        <div class="form-group row mt-4">

                                            <div class="col-6">
                                                <label for="">Fecha de navegación</label>

                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>

                                                    <input name= "fechaNavegacion" placeholder="Introduce la fecha de navegación" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                           id="fechaNavegacion">
                                                </div>
                                            </div>


                                            <!-- Médico residente -->
                                            <div class="col-6">
                                                <label for="">Médico Residente</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-user-md"></i>
                                                        </div>
                                                    </div>

<!--<<<<<<< HEAD-->
                                                   <select name="medico-residente" class="form-control" id="medico-residente">

                                                        <option disabled selected>Seleccione un Residente</option>

                                                        <c:forEach items="${listaResidentes}" var="residente">  

                                                            <option value='<c:out value="${residente.idPersona}"/>'><c:out value='${residente.nombre} ${residente.primerApellido} ${residente.segundoApellido}'/> </option>

                                                        </c:forEach>
                                                        <option value="otro">Otro</option>
                                                        <!--=======
                                                                                                            <input name = "medico-residente" type="text" id="medico-residente" class="form-control" class="form-control" placeholder="Introduce Médico Residente">
                                                                                                        </div>
                                                                                                    </div>
                                                        >>>>>>> origin/AngelRaul
                                                        -->
                                                    </select>
                                                </div>

                                                <div class="form-check mt-2">
                                                    <input name="noAdscrito" class=" form-check-input" type="checkbox" value="" id="noAdscrito">
                                                    <label class="form-check-label" for="defaultCheck1">
                                                        No estuvo médico residente
                                                    </label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Fecha Consulta-->
                                        <div class="form-group row mt-4 justify-content-center">

                                            <div class="col-12">
                                                <label for="">Fecha de consulta</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input name="fechaConsulta" placeholder="Introduce la fecha de consulta" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                           id="fechaConsulta">
                                                </div>
                                            </div>

                                        </div>
                                    </form>
                                    <!-- Boton guardar y continuar -->
                                    <div class="row justify-content-center mt-5">
                                        <div class="col-4">
                                            <button id="btn-save1" class="btn btn-outline-primary btn-block" style="border-radius:20px">

                                                <i class="fas fa-save mr-2" ></i>Guardar y Continuar Despuós</button>
                                        </div>
                                        <div class="col-4">
                                            <button class="btn btn-outline-success btn-block" id="btn-continue1" style="border-radius:20px">
                                                <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                        </div>
                                    </div>

                                </div>

                                <!-- PANTALLA 2 -->
                                <div id="pantalla2">
                                    <form>
                                        <!-- Nivel educativo-->
                                        <div class="form-group row mt-3">

                                            <div class="col-6">
                                                <label for="">Nivel educativo</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-graduation-cap"></i>
                                                        </div>
                                                    </div>
                                                    <select name = "nivelEducativo" class="form-control" id="nivelEducativo">
                                                        <option disabled selected>Seleccione un nivel educativo</option>

                                                        <c:forEach items="${listaEscolaridad}" var="escolaridad"> 

                                                            <option value='<c:out value="${escolaridad.idEscolaridad}"/>'><c:out value='${escolaridad.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Alergias-->
                                        <div class="form-group row mt-3">
                                            <div class="col-6">
                                                <label for="">Alergias</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-file-contract"></i>
                                                        </div>
                                                    </div>
                                                    <input name="alergias" type="text" id="alergias" class="form-control" placeholder="Introduce las alergias separadas por comas ( , )">

                                                </div>
                                            </div>
                                        </div>

                                        <!-- Estado hormonal-->
                                        <div class="form-group row mt-3">

                                            <div class="col-6">
                                                <label for="">Estado hormonal</label>
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-thermometer-three-quarters"></i>
                                                        </div>
                                                    </div>
                                                    <select name="estadoHormonal" class="form-control" id="estadoHormonal">
                                                        <option disabled selected>Selecciona un estado hormonal</option>
                                                        <option value="1">Premenopáusica</option>
                                                        <option value="2">Postmenopáusica</option>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- Seguro popular-->

                                        <div class="form-group row mt-4">

                                            <div class="col-12">
                                                <div class="form-group form-check">
                                                    <input name="tieneSeguroPopular" type="checkbox" class="form-check-input" id="tieneSeguroPopular">

                                                    <label class="form-check-label" for="tieneSeguroP">óCuentas con algón seguro?
                                                    </label>
                                                </div>

                                                <div class="input-group" id="tiene-seguro">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-ambulance"></i>
                                                        </div>
                                                    </div>
                                                    <select name="tiene-seguro" class="form-control tiene-seguro">
                                                        <option disabled selected>Seleccione un seguro</option>

                                                        <c:forEach items="${listaSeguro}" var="seguro">  

                                                            <option value='<c:out value="${seguro.idSeguro}"/>'><c:out value='${seguro.nombre}'/> </option>

                                                        </c:forEach>

                                                    </select>
                                                </div>

                                                <input name="numSeguro" type="text" id="numSeguro" class="form-control mt-2" placeholder="Introduce el nómero de tu seguro">
                                            </div>


                                        </div>

                                        <!-- Mastografia y ultrasonido de mama -->
                                        <div class="form-group row">

                                            <div class="col-12">
                                                <div class="form-check form-check-inline">
                                                    <input name="primeraMasto" class="form-check-input" type="checkbox" id="primeraMasto" value="option1">

                                                    <label class="form-check-label" for="inlineCheckbox1">Mastografóa en el INCan
                                                        antes de su primera cita</label>
                                                </div>
                                            </div>



                                        </div>



                                        <div class="row mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">Tratamiento previo:
                                                </h6>
                                            </div>
                                        </div>

                                        <!-- Cirugia -->

                                        <div class="form-group row">
                                            <div class="col-12">
                                                <div class="form-group form-check">
                                                    <input name="tiene-cirugia" type="checkbox" class="form-check-input" id="tiene-cirugia">
                                                    <label class="form-check-label" for="tiene-cirugia">Cirugía</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div id="divCirugia">

                                            <div class="row">
                                                <div class="input-group col-12">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>

                                                    <input name="fecha-cirugia" placeholder="Introduce la fecha de cirugóa" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                           id="fecha-cirugia">
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12 input-group">
                                                    <select name="cirugia" class="form-control" id="cirugia">

                                                        <option disabled selected>Introduce la cirugóa</option>
                                                        <c:forEach items="${listaCirugia}" var="cirugia">  

                                                            <option value='<c:out value="${cirugia.idTratamiento}"/>'><c:out value='${cirugia.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <textarea name="detalle-cirugia" style="min-height: 150px !important;" class="form-control" id="detalle-cirugia" placeholder="Escribe detalles del tratamiento"></textarea>
                                                </div>
                                            </div>

                                        </div>

                                        <!-- Quimioterapia -->

                                        <div class="form-group row mt-3">
                                            <div class="col-12">
                                                <div class="form-group form-check">
                                                    <input name="tiene-quimioterapia" type="checkbox" class="form-check-input" id="tiene-quimioterapia">
                                                    <label class="form-check-label" for="tiene-quimioterapia">Quimioterapia</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div id="divQuimioterapia">

                                            <div class="row">
                                                <div class="input-group col-12">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input name="fecha-quimioterapia" placeholder="Introduce la fecha de quimioterapia" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                           id="fecha-quimioterapia">
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12 input-group">
                                                    <input name="quimioterapia" type="text" id="quimioterapia" class="form-control" class="form-control" placeholder="Introduce el nómero de ciclos">
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <textarea name="detalle-quimioterapia" style="min-height: 150px !important;" class="form-control" id="detalle-quimioterapia" placeholder="Escribe detalles del tratamiento"></textarea>
                                                </div>
                                            </div>

                                        </div>

                                        <!-- Radioterapia-->

                                        <div class="form-group row mt-3">
                                            <div class="col-12">
                                                <div class="form-group form-check">
                                                    <input name="tiene-radioterapia" type="checkbox" class="form-check-input" id="tiene-radioterapia">
                                                    <label class="form-check-label" for="tiene-radioterapia">Radioterapia</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div id="divRadioterapia">

                                            <div class="row">
                                                <div class="input-group col-12">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input name="fecha-radioterapia" placeholder="Introduce la fecha de radioterapia" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                           id="fecha-radioterapia">
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12 input-group">
                                                    <input name="radioterapia" type="text" id="radioterapia" class="form-control" class="form-control" placeholder="Introduce el nómero de ciclos">
                                                </div>
                                            </div>

                                            <div class="row mt-3">
                                                <div class="col-12">
                                                    <textarea name="detalle-radioterapia" style="min-height: 150px !important;" class="form-control" id="detalle-radioterapia" placeholder="Escribe detalles del tratamiento"></textarea>
                                                </div>
                                            </div>

                                        </div>

                                        <!-- Estudios previos -->

                                        <div class="row mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">Estudios previos:
                                                </h6>
                                            </div>
                                        </div>

                                        <div class="form-group row">

                                            <div class="col-10 mt-2">
                                                <div class="form-group form-check">
                                                    <input name="tiene-mastografia" type="checkbox" class="form-check-input" id="tiene-mastografia">

                                                    <label class="form-check-label" for="tiene-mastografia">Mastrografóa</label>
                                                </div>
                                                <div class="input-group" id="tiene-mastografiaPrevia">
                                                    <select name="tipoMastografia" class="form-control" id="tipoMastografia">
                                                        <option disabled selected>Mastrografóa BI-RADS</option>

                                                        <c:forEach items="${listaBirads}" var="birads">  
                                                            <option value='<c:out value="${birads.idBirads}"/>'><c:out value='${birads.nombre}'/> </option>
                                                        </c:forEach>

                                                    </select>

                                                    <div class="input-group col-8" id="fechaMasto">
                                                        <div class="input-group-prepend">
                                                            <div class="input-group-text">
                                                                <i class="fas fa-calendar-alt"></i>
                                                            </div>
                                                        </div>

                                                        <input name="fechaPreMasto" placeholder="Introduce la fecha de mastografóa" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                               id="fechaPreMasto">
                                                    </div>
                                                </div>



                                            </div>



                                            <div class="col-10 mt-3">
                                                <div class="form-group form-check">
                                                    <input name = "tiene-ultrasonido-mama" type="checkbox" class="form-check-input" id="tiene-ultrasonido-mama">
                                                    <label class="form-check-label" for="tiene-ultrasonido-mama">Ultrasonido de mama</label>
                                                </div>
                                                <div class="input-group" id="tiene-UltrasonidoPrevio">
                                                    <select name="tipoUltrasonidoMama" class="form-control" id="tipoUltrasonidoMama">
                                                        <option disabled selected>Ultrasonido Mama BI-RADS</option>
                                                        <c:forEach items="${listaBirads}" var="birads">  

                                                            <option value='<c:out value="${birads.idBirads}"/>'><c:out value='${birads.nombre}'/> </option>

                                                        </c:forEach>

                                                    </select>

                                                    <div class="input-group col-8" id="fechaUsg">
                                                        <div class="input-group-prepend">
                                                            <div class="input-group-text">
                                                                <i class="fas fa-calendar-alt"></i>
                                                            </div>
                                                        </div>
                                                        <input name="fechaPreUsg" placeholder="Introduce la fecha de ultrasonido" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')"
                                                               id="fechaPreUsg">
                                                    </div>
                                                </div>

                                            </div>

                                        </div>



                                        <!-- Resultado o reporte de patologia -->

                                        <div class="row mt-4 mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">Resultado o reporte
                                                    de patologóa:</h6>
                                            </div>
                                        </div>
                                        <div class="input-group">
                                            <select name="resultadoAnterior-patologia" class="form-control" id="resultadoAnterior-patologia">
                                                <option disabled selected>Seleccione Resultado Patologóa:</option>

                                                <c:forEach items="${listaTipoHistologico}" var="resultadoPatologia">  

                                                    <option value='<c:out value="${resultadoPatologia.idTipoHistologico}"/>'><c:out value='${resultadoPatologia.nombre}'/> </option>

                                                </c:forEach>

                                            </select>

                                        </div>

                                        <div class="form-group row mt-4" id="introducirOtroPatologia">
                                            <div class="col-12">
                                                <input name="introducirOtroResultadoPatologia" id="OtroResultadoPatologia" type="text" class="form-control" placeholder="Introduce otro resultado">
                                            </div>
                                        </div>

                                        <!-- Entrega de laminillas y bloques -->

                                        <div class="form-group row mt-4">
                                            <div class="col-12">
                                                <label class="d-block display-4 text-secondary mb-3" for=""><h6 style="font-size:26px;">Entrega:
                                                    </h6></label>
                                                <div class="form-check form-check-inline">
                                                    <input name="entregaLaminillas" class="form-check-input" type="checkbox" id="entregaLaminillas" value="laminillas">
                                                    <label class="form-check-label" for="entregaLaminillas">Laminillas</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row" id="contenedor-laminillas">
                                            <div class="col-4">

                                                <input name="numLaminillas" type="text" id="numLaminillas" class="form-control" placeholder="Introduce el nómero">
                                            </div>
                                            <div class="col-6">
                                                <input name="serieLaminillas" type="text" id="serieLaminillas" class="form-control" placeholder="Identificadores separados por ( , )">
                                            </div>
                                        </div>

                                        <div class="form-group row mt-4">
                                            <div class="col-12">
                                                <div class="form-check form-check-inline">
                                                    <input name="entregaBloques" class="form-check-input" type="checkbox" id="entregaBloques" value="laminillas">
                                                    <label class="form-check-label" for="entregaBloques">Bloques de parafina</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="row" id="contenedor-bloques">
                                            <div class="col-4">

                                                <input name="numBloques" type="text" id="numBloques" class="form-control" placeholder="Introduce el nómero">
                                            </div>
                                            <div class="col-6">
                                                <input name="serieBloques" type="text" id="serieBloques" class="form-control" placeholder="Identificadores separados por ( , )">
                                            </div>
                                        </div>
                                    </form>
                                    <div class="row justify-content-center mt-5">
                                        <div class="col-4">
                                            <button class="btn btn-outline-danger btn-block" id="btn-back2" style="border-radius:20px">
                                                <i class="fas fa-undo mr-2"></i>Regresar</button>
                                        </div>
                                        <div class="col-4">
                                            <button id="btn-save2" class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                                <i class="fas fa-save mr-2" ></i>Guardar y Continuar Despuós</button>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-2">
                                        <div class="col-8">
                                            <form action="ReporteControllerJaspersoft?key=generar-reporte1" method="post">
                                                <button type="submit" class="btn btn-morado btn-block" id="btn-exportar1" style="border-radius:20px">
                                                    <i class="fas fa-file-contract mr-2"></i> Generar Reporte</button>
                                            </form>
                                        </div>
                                    </div>
                                    <div class="row justify-content-center mt-2">
                                        <div class="col-8">
                                            <button class="btn btn-outline-success btn-block" id="btn-continue2" style="border-radius:20px">
                                                <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                        </div>
                                    </div>

                                </div>

                                <!-- OMAR -->

                                <!-- PANTALLA 3 -->
                                <div id="pantalla3">
                                    <form>
                                        <div class="row justify-content-center">
                                            <div class="col-12 text-center">
                                                <p class="display-4 tituloPacientes">Estudios Preconsulta</p>
                                            </div>
                                        </div>



                                        <!-- Biopsia -->

                                        <!-- Checkbox biopsia -->
                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input class="form-check-input" type="checkbox" id="tiene-biopsia">
                                                    <label class="form-check-label" for="tiene-biopsia"> Biopsia</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar biopsia -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-biopsia" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="biopsia-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Rayos X -->

                                        <!-- Checkbox rayox x -->
                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="rayosAdded" class="form-check-input" type="checkbox" id="tiene-rayosX">
                                                    <label class="form-check-label" for="tiene-rayosX"> Rayos X</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar rayos -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-rayosX" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="rayos-contenedor">

                                        </div>


                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Ultrasonido -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-ultrasonido" class="form-check-input" type="checkbox" id="tiene-ultrasonido">
                                                    <label class="form-check-label" for="tiene-ultrasonido"> Ultrasonido</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar ultrasonido -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-ultrasonido" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="ultrasonido-contenedor">

                                        </div>


                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Medicina Nuclear -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-medicina-nuclear" class="form-check-input" type="checkbox" id="tiene-medicina-nuclear">
                                                    <label class="form-check-label" for="tiene-medicina-nuclear"> Medicina Nuclear</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar medicina nuclear -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-medicinaNuclear" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="medicinaNuclear-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Laboratorio -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-laboratorio" class="form-check-input" type="checkbox" id="tiene-laboratorio">
                                                    <label class="form-check-label" for="tiene-laboratorio"> Laboratorio</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar laboratorio -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-laboratorio" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="laboratorio-contenedor">

                                        </div>


                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Valoracion -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-valoracion" class="form-check-input" type="checkbox" id="tiene-valoracion">
                                                    <label class="form-check-label" for="tiene-valoracion"> Valoración</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar valoración -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-valoracion" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="valoracion-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Espirometria -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-espirometria" class="form-check-input" type="checkbox" id="tiene-espirometria">
                                                    <label class="form-check-label" for="tiene-espirometria"> Espirometróa/Inhaloterapia</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar espirometria -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-espirometria" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="espirometria-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Electrocardiograma -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-electrocardiograma" class="form-check-input" type="checkbox" id="tiene-electrocardiograma">
                                                    <label class="form-check-label" for="tiene-electrocardiograma"> Electrocardiograma
                                                        (ECG)
                                                    </label>
                                                </div>
                                            </div>
                                            <!-- boton agregar electrocardiograma -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-electrocardiograma" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="electrocardiograma-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>


                                        <!-- Ecocardiograma -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-ecocardiograma" class="form-check-input" type="checkbox" id="tiene-ecocardiograma">
                                                    <label class="form-check-label" for="tiene-ecocardiograma"> Ecocardiograma</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar ecocardiograma -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-ecocardiograma" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="ecocardiograma-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Trabajo Social-->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-trabajo-social" class="form-check-input" type="checkbox" id="tiene-trabajo-social">
                                                    <label class="form-check-label" for="tiene-trabajo-social"> Trabajo Social</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar trabajo social -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-trabajoSocial" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>


                                        <div id="trabajoSocial-contenedor">

                                        </div>

                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Programas -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-programa" class="form-check-input" type="checkbox" id="tiene-programa">
                                                    <label class="form-check-label" for="tiene-programa"> Programa</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar programa -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-programa" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="programa-contenedor">

                                        </div>


                                        <div class="row">
                                            <div class="col-12">
                                                <hr>
                                            </div>
                                        </div>

                                        <!-- Otro -->

                                        <div class="row mt-5 mb-3">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="tiene-otro" class="form-check-input" type="checkbox" id="tiene-otro">
                                                    <label class="form-check-label" for="tiene-otro"> Otro</label>
                                                </div>
                                            </div>
                                            <!-- boton agregar otro -->
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-2 add-otro" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>
                                        </div>

                                        <div id="otro-contenedor">

                                        </div>

                                    </form>

                                    <div class="row justify-content-center mt-5">
                                        <div class="col-4">
                                            <button class="btn btn-outline-danger btn-block" id="btn-back3" style="border-radius:20px">
                                                <i class="fas fa-undo mr-2"></i>Regresar</button>
                                        </div>
                                        <div class="col-4">
                                            <button id="btn-save3" class="btn btn-outline-primary btn-block" style="border-radius:20px">

                                                <i class="fas fa-save mr-2" ></i>Guardar y Continuar Después</button>
                                        </div>
                                        <div class="col-4">
                                            <button class="btn btn-outline-success btn-block" id="btn-continue3" style="border-radius:20px">
                                                <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                        </div>
                                    </div>

                                </div>

                                <div id="pantalla4">
                                    <form>    
                                        <div class="row mt-4">
                                            <div class="col-12">
                                                <div class="form-check form-check-inline">
                                                    <input name="resultadosCheckbox" class="form-check-input mr-3" type="checkbox" id="resultadosCheckbox" value="option1">
                                                    <label class="form-check-label" for="resultadosCheckbox">Resultados</label>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row mt-4">

                                            <div class="col-3">

                                                <span>Decisión preconsulta</span>

                                            </div>

                                            <div class="col-4">

                                                <div class="input-group">
                                                    <select name="decisionPreconsulta" class="form-control" id="decisionPreconsulta">

                                                        <option disabled selected>Seleccione la decisión</option>              

                                                        <option>Unidad funcional</option>
                                                        <option>Alta</option>
                                                        <option>Alta voluntaria</option>
                                                        <option>Finada</option>
                                                        <option>Perdida</option>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-5">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input name="fecha-decisionPreconsulta" placeholder="Fecha decisión" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type = 'date')" id="fecha-decisionPreconsulta">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row mt-4">

                                            <div class="col-3">
                                                <span>Nivel socioeconómico</span>
                                            </div>

                                            <div class="col-4">

                                                <div class="input-group">
                                                    <select name="nivelSocioeconomico" class="form-control" id="nivelSocioeconomico">

                                                        <option disabled selected>Seleccione el nivel socioeconómico</option>
                                                        <c:forEach items="${listaNivelSocioEconomico}" var="nivel">  

                                                            <option value='<c:out value="${nivel.idNivelSocioEconomico}"/>'><c:out value='${nivel.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row mt-4">
                                            <div class="col-10">
                                                <div class="form-check form-check-inline">
                                                    <input name="seLlamo" class="form-check-input mr-3" type="checkbox" id="seLlamo" value="option1">
                                                    <label class="form-check-label" for="inlineCheckbox1">Llamada al paciente</label>
                                                </div>
                                            </div>
                                            <div class="col-2 text-center">
                                                <button type="button" class="btn btn-morado ml-3 add-llamada" style="border-radius: 25px;">
                                                    <i class="fas fa-plus"></i>
                                                </button>
                                            </div>

                                        </div>

                                        <div class="llamadaInit" id="llamadaInit">

                                        </div>

                                        <!-- <div id="datosLlamada">
                                            <div class="col-5" id="fechaLlamada">
                                                <div class="input-group">
                                                    <div class="input-group-prepend">
                                                        <div class="input-group-text">
                                                            <i class="fas fa-calendar-alt"></i>
                                                        </div>
                                                    </div>
                                                    <input placeholder="Fecha llamada" class="selectStyle form-control textbox-n" type="text" onfocus="(this.type='date')" id="fecha-llamada">
                                                    <button type="button" id="add-datosLlamada" class="btn btn-primary ml-3" style="border-radius: 25px;">
                                                        <i class="fas fa-plus-circle"></i>
                                                    </button>
                                                </div>
                                            </div>
        
        
                                            <div class="form-group row">
                                                <div class="col-12 m-3">
                                                    <textarea class="form-control" id="motivoLlamada" style="min-height:100px;" placeholder="Introduce el motivo de la llamada "></textarea>
                                                </div>
                                            </div>
                                        </div> -->


                                        <div class="row mt-3 mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">Comentarios y reporte
                                                    de incidencias:</h6>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-12">
                                                <textarea name="comentarios" class="form-control" id="exampleFormControlTextarea1" style="min-height:200px;" placeholder="Introduce comentarios "></textarea>
                                            </div>
                                        </div>

                                        <div class="row mt-5 mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">Comentarios adicionales
                                                    del médico:</h6>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="form-group row">
                                        <div class="col-12">
                                            <textarea name="comentariosAdicionales" class="form-control" id="comentariosAdicionales" style="min-height:200px;" placeholder="Introduce comentarios adicionales"></textarea>
                                        </div>
                                    </div>

                                    <div class="row justify-content-center mt-5">
                                        <div class="col-4">
                                            <button class="btn btn-outline-danger btn-block" id="btn-back4" style="border-radius:20px">
                                                <i class="fas fa-undo mr-2"></i>Regresar</button>
                                        </div>
                                        <div class="col-4">
                                            <button id="btn-save4" class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                                <i class="fas fa-save mr-2" ></i>Guardar y Continuar Después</button>
                                        </div>
                                        <div class="col-4">
                                            <button class="btn btn-outline-success btn-block" id="btn-continue4" style="border-radius:20px">
                                                <i class="fas fa-arrow-circle-right mr-2"></i>Continuar</button>
                                        </div>

                                    </div>

                                </div>

                                <!-- PANTALLA 5 -->
                                <div id="pantalla5">

                                    <form>    
                                        <div class="form-group row mt-4">

                                            <div class="col-12">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Etapa Clínica</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="etapaClinica" class="form-control" id="etapaClinica">
                                                        <option disabled selected>Seleccione etapa clínica</option>
                                                        <c:forEach items="${listaEtapaClinica}" var="etapa">  

                                                            <option value='<c:out value="${etapa.idEtapaClinica}"/>'><c:out value='${etapa.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-6 mt-4">

                                                <label for="">Resultados de mastografóa</label>
                                                <div class="input-group">

                                                    <select name="ResultadoTipoMastografia" class="form-control" id="ResultadoTipoMastografia">
                                                        <option disabled selected>MastrografÃ¯Â¿Â½a BI-RADS</option>

                                                        <c:forEach items="${listaBirads}" var="birads">  
                                                            <option value='<c:out value="${birads.idBirads}"/>'><c:out value='${birads.nombre}'/> </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                            <div class="col-6 mt-4">
                                                <label for="">Resultados del ultrasonido</label>
                                                <div class="input-group">
                                                    <select name="tipoUSG" class="form-control" id="tipoUSG">

                                                        <option disabled selected>Mastrografóa BI-RADS</option>
                                                        <c:forEach items="${listaBirads}" var="birads">  

                                                            <option value='<c:out value="${birads.idBirads}"/>'><c:out value='${birads.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>
                                            </div>

                                        </div>

                                        <div class="row mt-5 mb-3">
                                            <div class="col-12">
                                                <h6 class="display-4 text-secondary" style="font-size:26px;">TNM:</h6>
                                            </div>
                                        </div>

                                        <div class="form-group row">

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">T:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="tumorPrimarioT" class="form-control" id="tumorPrimarioT">
                                                        <option disabled selected>Seleccione T:</option>

                                                        <c:forEach items="${listaT}" var="t">  

                                                            <option value='<c:out value="${t.idTCodificado}"/>'><c:out value='${t.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label name="" class="form-check-label" for="etapaClinica">N:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="gangliosN" class="form-control" id="gangliosN">
                                                        <option disabled selected>Seleccione N:</option>
                                                        <c:forEach items="${listaN}" var="n">  

                                                            <option value='<c:out value="${n.idNCodificado}"/>'><c:out value='${n.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">M:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="metastasisM" class="form-control" id="metastasisM">

                                                        <option disabled selected>Seleccione M:</option>
                                                        <c:forEach items="${listaM}" var="m">  

                                                            <option value='<c:out value="${m.idMCodificado}"/>'><c:out value='${m.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                        </div>

                                        <div class="form-group row mt-4">

                                            <div class="col-6">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Resultado Patologóa:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="resultado-patologia" class="form-control" id="resultado-patologia">
                                                        <option disabled selected>Seleccione Resultado Patologóa:</option>

                                                        <c:forEach items="${listaTipoHistologico}" var="resultadoPatologia">  

                                                            <option value='<c:out value="${resultadoPatologia.idTipoHistologico}"/>'><c:out value='${resultadoPatologia.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>

                                                </div>

                                            </div>
                                            <div class="col-6">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Grado Histológico:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="grado-histologico" class="form-control" id="grado-histologico">
                                                        <option disabled selected>Seleccione Grado Histológico:</option>
                                                        <c:forEach items="${listaGradoHistologico}" var="gradoHistologico">  

                                                            <option value='<c:out value="${gradoHistologico.idGradoHistologico}"/>'><c:out value='${gradoHistologico.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="form-group row mt-4" id="introducirOtro">
                                            <div class="col-6">
                                                <input name="otroResultPato" id="otroResultadoPatologiaPost" type="text" class="form-control" placeholder="Introduce otro resultado">
                                            </div>
                                        </div>

                                        <div class="form-group row mt-4">

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Her2:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="receptor-her2" class="form-control" id="receptor-her2">
                                                        <option disabled selected>Seleccione Her2:</option>

                                                        <c:forEach items="${listaHer2}" var="her2">  

                                                            <option value='<c:out value="${her2.idHer2}"/>'><c:out value='${her2.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Fish:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="receptor-fish" class="form-control" id="receptor-fish">
                                                        <option disabled selected>Seleccione Fish:</option>
                                                        <c:forEach items="${listaFish}" var="fish">  
                                                            <option value='<c:out value="${fish.idFish}"/>'><c:out value='${fish.nombre}'/> </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-4">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">RE:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="receptor-re" class="form-control" id="receptor-re">
                                                        <option disabled selected>Seleccione RE:</option>
                                                        <c:forEach items="${listaRE}" var="re">  
                                                            <option value='<c:out value="${re.idReceptorEstrogeno}"/>'><c:out value='${re.nombre}'/> </option>
                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-6 mt-3">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">RP:</label>
                                                </div>
                                                <div class="input-group">
                                                    <select name="receptor-rp" class="form-control" id="receptor-rp">
                                                        <option disabled selected>Seleccione RP:</option>
                                                        <c:forEach items="${listaRP}" var="rp">  

                                                            <option value='<c:out value="${rp.idReceptorProgesterona}"/>'><c:out value='${rp.nombre}'/> </option>

                                                        </c:forEach>
                                                    </select>
                                                </div>

                                            </div>

                                            <div class="col-6 mt-3">
                                                <div class="form-group">

                                                    <label class="form-check-label" for="etapaClinica">Ki67:</label>
                                                </div>
                                                <div class="input-group">
                                                    <input name="ki67" type="text" class="form-control" id="ki67" placeholder="Introduce Ki67">
                                                    <label type="text" class="ml-2 mt-2">%</label>
                                                </div>

                                            </div>
                                        </div>
                                    </form>    
                                    <div class="row justify-content-center mt-5">
                                        <div class="col-4">
                                            <button class="btn btn-outline-danger btn-block" id="btn-back5" style="border-radius:20px">
                                                <i class="fas fa-undo mr-2"></i>Regresar</button>
                                        </div>
                                        <div class="col-4">
                                            <button id="btn-save5" class="btn btn-outline-primary btn-block" style="border-radius:20px">
                                                <i class="fas fa-save mr-2" ></i>Guardar y Continuar Después</button>

                                        </div>

                                    </div>

                                    <div class="row justify-content-center mt-3">
                                        <div class="col-8">
                                            <form action="ReporteControllerJaspersoft?key=generar-reporte2" method="post">
                                                <button type="submit" class="btn btn-morado btn-block" id="btn-export2" style="border-radius:20px" >
                                                    <i class="fas fa-file-contract mr-2"></i> Generar Reporte</button>
                                            </form>
                                        </div>
                                    </div>

                                    <div class="row justify-content-center mt-3">
                                        <div class="col-8">
                                            <button class="btn btn-outline-success btn-block" id="btn-sendAll" style="border-radius:20px">
                                                <i class="fas fa-check-circle mr-2"></i>Enviar</button>
                                        </div>
                                    </div>

                                </div>
                            </div>

                        </div>
                    </div>

                </div>
            </div>

        </div>
    </body>

</html>