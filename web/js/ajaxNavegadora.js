$(document).ready(function () {

    $('#errorNombreNavegadora').hide();
    $('#errorCurpNavegadora').hide();
    $('#errorCurpRepetidoNavegadora').hide();
    $('#errorFechaNavegadora').hide();
    $('#errorApellidoPaternoNavegadora').hide();
    $('#errorApellidoMaternoNavegadora').hide();
    $('#errorNombreUsuarioNavegadora').hide();
    $('#errorUsuarioRepetidoNavegadora').hide();
    $('#errorECivilNavegadora').hide();
    $('#errorColoniaNavegadora').hide();
    $('#errorCalleNavegadora').hide();
    $('#errorNoInteriorNavegadora').hide();
    $('#errorNoExteriorNavegadora').hide();
    $('#errorEstadoNavegadora').hide();
    $('#errorMunicipioNavegadora').hide();
    $('#errorTelefonoNavegadora').hide();
    $('#errorCorreoNavegadora').hide();
    $('#errorPass1Navegadora').hide();
    $('#errorPass2Navegadora').hide();
    $('#error-CPexisteNavegadora').hide();
    $('#errorCodigoPostalNavegadora').hide();
    $('#noEqualPasswordsErrorNavegadora').hide();

    
    $('#error-editar-NombreNavegadora').hide();
    $('#error-editar-ApellidoPaternoNavegadora').hide();
    $('#error-editar-ApellidoMaternoNavegadora').hide();
    $('#error-editar-NombreUsuarioNavegadora').hide();
    $('#error-editar-CorreoNavegadora').hide();
    $('#error-editar-CurpNavegadora').hide();
    $('#error-editar-ColoniaNavegadora').hide();
    $('#error-editar-CalleNavegadora').hide();
    $('#error-editar-NoExteriorNavegadora').hide();
    $('#error-editar-NoInteriorNavegadora').hide();
    $('#error-editar-CurpRepetidoNavegadora').hide();
    $('#error-editar-TelefonoNavegadora').hide();
    $('#error-editar-ECivilNavegadora').hide();
    $('#error-editar-FechaNavegadora').hide();
    $('#error-editar-EstadoNavegadora').hide();
    $('#error-editar-MunicipioNavegadora').hide();
    $('#error-editar-UsuarioRepetidoNavegadora').hide();
        

    //Terminos y condiciones
    $('#acepto-terminos').change(function () {

        if (parseInt($(this).val()) === parseInt('0')) {
            $(this).val('1');
        } else {
            $(this).val('0');
        }


    });

    //Codigo Postal en Agregar Paciente
    $('#codigo-postalNavegadora').on('change', function () {

        $.ajax({

            url: 'ZonaController',
            cache: false,
            method: 'POST',
            data: {

                key: "getEstadoyMunicipio",
                numeroCP: $('#codigo-postalNavegadora').val()

            },
            success: function (response) {

                if (response == 'postalCodeDoesntExist') {
                    $('#error-CPexiste').show();

                } else {
                    $('#error-CPexiste').hide();
                    var json = JSON.parse(response);

                    if ($('#codigo-postalNavegadora').val().length === 5) {

                        //Limpia los campos 
                        $("#estadoNavegadora").each(function () {
                            $(this).children().remove();
                        });

                        $("#municipioNavegadora").each(function () {
                            $(this).children().remove();
                        });

                        //Carga estado
                        $('#estadoNavegadora').append("<option value='" + json[0] + "'>" + json[1] + "</option>");

                        //Carga Municipio
                        $('#municipioNavegadora').append("<option value='" + json[2] + "'>" + json[3] + "</option>");

                    } else {

                        $('#estadoNavegadora').removeAttr('disabled');
                        $('#estadoNavegadora').removeAttr('selected');

                    }

                    console.log(json);
                }

            }

        });


    });

    //Agregar Paciente
    $('#agregarPaciente').on('click', function (e) {


        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "registraUsuario",
                nombre: $('#nombreNavegadora').val(),
                curp: $('#curpNavegadora').val(),
                fechaNacimiento: $('#cumpleNavegadora').val(),
                apellido1: $('#primer-apellidoNavegadora').val(),
                apellido2: $('#segundo-apellidoNavegadora').val(),
                usuario: $('#usuarioNavegadora').val(),
                estadoCivil: $('#estado-civilNavegadora').val(),
                calle: $('#calleNavegadora').val(),
                noInterior: $('#numIntNavegadora').val(),
                noExterior: $('#numExtNavegadora').val(),
                codigoPostal: $('#codigo-postalNavegadora').val(),
                estado: $('#estadoNavegadora').val(),
                municipio: $('#municipioNavegadora').val(),
                telefono: $('#telNavegadora').val(),
                correo: $('#correoNavegadora').val(),
                colonia: $('#colNavegadora').val(),
                pass1: $('#contraNavegadora').val(),
                pass2: $('#confContraNavegadora').val(),
                terminos: $('#acepto-terminos').val()

            },
            success: function (response) {
                console.log(response);
                console.log("FUNCIONÓ! (creo)");
            }

        });


    });

    //  Editar paciente
    $('.btn-editar').on('click', function () {

        $('#hidden-idPaciente').val($(this).data('id'));
        
       
        $.ajax({

            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {

                key: "obtener-paciente",
                idPaciente: $('#hidden-idPaciente').val(),

            },
            success: function (response) {

                var data = JSON.parse(response);

                console.log(data);

                $('#editarNombreNavegadoraAPaciente').val(data.nombre);
                $('#editarCurpNavegadoraAPaciente').val(data.curp);
                $('#editarCumpleNavegadoraAPaciente').val(formatDate(new Date(data.fechaNacimiento)));
                $('#editarPrimer-apellidoNavegadoraAPaciente').val(data.primerApellido);
                $('#editarSegundo-apellidoNavegadoraAPaciente').val(data.segundoApellido);
                $('#editarSegundo-apellidoNavegadoraAPaciente').val(data.segundoApellido);
                $('#editarUsuarioNavegadoraAPaciente').val(data.usuario);
                $('#editarEstado-civilNavegadora').val(data.idEstadoCivil);
                $('#editarColNavegadoraAPaciente').val(data.colonia);
                $('#editarCalleNavegadoraAPaciente').val(data.calle);
                $('#editarNumIntNavegadoraAPaciente').val(data.noInt);
                $('#editarNumExtNavegadoraAPaciente').val(data.noExt);
                $('#editarEstadoNavegadoraAPaciente').val(data.idEstado);
                $('#editarTelNavegadoraAPaciente').val(data.telefono);
                $('#editarCorreoNavegadoraAPaciente').val(data.correo);

                $.ajax({

                    url: 'ZonaController',
                    cache: false,
                    method: 'POST',
                    data: {

                        key: "getByEstado",
                        idEstado: data.idEstado

                    },
                    success: function (response) {

                        //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                        $(".editarMunicipios select").each(function () {
                            $(this).children().remove();
                        });
                        var json = JSON.parse(response);
                        for (var i = 0; i < json.length; i++) {
                            $('.editarMunicipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                        }
                        $('.editarMunicipios select').prop('selectedIndex', 0);
                        console.log(json);
                        $('#editarMunicipioNavegadoraAPaciente').val(data.idMunicipio);
                    }

                });
            }

        });

    });
    
    $('#btn-guardarCambios').on('click', function () {
        console.log("Presionó Guardar Cambios");
        
      
        
        
        // FALTA OBTENER EL ID DEL PACIENTE 
        
        $.ajax({
                url: 'NavegadoraController',
                cache: false,
                method: 'POST',
                data: {
                    key: "actualizar-paciente",
                    idPaciente: $('#hidden-idPaciente').val(),
                    nombre: $('#editarNombreNavegadoraAPaciente').val(),
                    apellido1: $('#editarPrimer-apellidoNavegadoraAPaciente').val(),
                    apellido2: $('#editarSegundo-apellidoNavegadoraAPaciente').val(),
                    usuario: $("#editarUsuarioNavegadoraAPaciente").val(),
                    correo: $('#editarCorreoNavegadoraAPaciente').val(),
                    curp: $('#editarCurpNavegadoraAPaciente').val(),
                    colonia: $('#editarColNavegadoraAPaciente').val(),
                    calle: $('#editarCalleNavegadoraAPaciente').val(),
                    noExterior: $("#editarNumExtNavegadoraAPaciente").val(),
                    noInterior: $("#editarNumIntNavegadoraAPaciente").val(),
                    telefono: $("#editarTelNavegadoraAPaciente").val(),
                    estadoCivil: $("#editarEstado-civilNavegadora").val(),
                    fechaNacimiento: $("#editarCumpleNavegadoraAPaciente").val(),
                    estado: $("#editarEstadoNavegadoraAPaciente").val(),
                    municipio: $("#editarMunicipioNavegadoraAPaciente").val()
                },success: function (response) {
                        swal({
                            title: 'Buen Trabajo',
                            text: "Cuenta registrada correctamente",
                            type: 'success',
                            confirmButtonColor: '#3085d6',
                            confirmButtonText: 'Ok'
                        })
                    }

            });
    });

    //Redirige a documentos
    $('.btn-ver').on('click', function () {
        
        $('#hidden-idPaciente').val($(this).data('id'));
        
        //alert('saludos con el id: ' +  $('#hidden-idPaciente').val())
        
        $.post("SAPI", {
            file: "navegadora/documentos.jsp",
            idPacientePotencialAtendido: $('#hidden-idPaciente').val()
        },
                function (response, status, xhr) {
                    //console.log(response);
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }                    
                }
        );
    });

    $('.irAVerDocumento').on('click', function () {

        console.log("Click");
        console.log($(this).data('id') + " " + $("#hiddenIdPaciente").val());
        $.post("SAPI", {
            file: "navegadora/verDocumento.jsp",
            idDocumentoInicialVista: $(this).data('id'),
            idPacientePotencialAtendido: $("#hiddenIdPaciente").val(),

            siguiente: 0
        },
                function (response, status, xhr) {
                    //console.log(response);
                    if (status == "success") {
                        if (response == "error") {
                            console.log(response);
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    //Aprobar paciente

    //fecha navegacion
    $('#Fecha-Navegacion').on('change', function () {

        console.log($(this).val());

    });


    //Obtene Fecha consulta
    $('#Fecha-Consulta').on('change', function () {

        console.log($(this).val());

    });

    $('.btn-aceptar').on('click', function (e) {


        $('#hidden-idPaciente').val($(this).data('id'));


    });

    $('#btn-aceptarDocumento').on('click', function () {

        alert('el id final es:' + $('#hidden-idPaciente').val());

        $.ajax({

            url: 'NavegadoraController',
            cache: false,
            method: 'POST',
            data: {

                key: "aprobar-paciente",
                idPaciente: $('#hidden-idPaciente').val(),
                fechaNavegacion: $('#Fecha-Navegacion').val(),
                fechaConsulta: $('#Fecha-Consulta').val(),
                tipoPaciente: $('#tipo-paciente').val()


            },
            success: function (response) {
                if (response == 'success') {
                    swal("Buen trabajo!", "El paciente se aprobo correctamente!", "success");
                    //$('#modalAceptarUsuario').toggle();
                    $('#Fecha-Navegacion').val('').attr("type", "text");
                    $('#Fecha-Consulta').val('').attr("type", "text");
                    $('#tipo-paciente').prop('selectedIndex', 0);


                } else {
                    swal("Algo salio mal!", "El paciente no se pudo aprobar!", "error");
                }
            }

        });
    });

    //Eliminar paciente
    $('.btn-eliminar').on('click', function () {

        alert('saludos con el id' + $(this).data('id'));

        var idPaciente = $(this).data('id');
        var boton = $(this);

        swal({
            title: "¿Estás segura?",
            text: "Una vez eliminado, el paciente y sus datos ya no se podrán recuperar.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((eliminar) => {

                    if (eliminar) {

                        $.ajax({

                            url: 'NavegadoraController',
                            cache: false,
                            method: 'POST',
                            data: {

                                key: "eliminar-paciente",
                                idPaciente: idPaciente,

                            },
                            success: function (response) {


                                swal("Buen trabajo!", "El paciente se eliminó correctamente!", "success");
                                boton.parent().parent().remove();


                            },
                            error: function () {
                                swal("Buen trabajo!", "El paciente se eliminó correctamente!", "error");
                            }

                        });



                    } else {

                    }
                });

    });


    /*
     $('.irAVerDocumento').on('click', function () {     
     
     $.get("SAPI", {
     file: "navegadora/verDocumento.jsp",
     idDocumentoInicial : $(this).data('id'),
     idPaciente: $("#hiddenIdPaciente")
     
     
     },
     function (response, status, xhr) {
     //console.log(response);
     if (status == "success") {
     if (response == "error") {
     $("#msj-error").show();
     } else {
     document.open("text/html", "replace");
     document.write(response);
     document.close();
     }
     }
     }
     );
     });
     */

    //Eliminar cuenta
    $('#eliminarCuentaNavegadora').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos se eliminarán y no podrás recuperarlos ni poder acceder a tu cuenta.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],

        })
                .then((eliminar) => {
                    if (eliminar) {
                        $.ajax({
                            url: "NavegadoraController",
                            data: {
                                key: "eliminarCuentaNavegadora",
                                idCuenta: $("#sesionPaciente").val()

                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "error") {
                                    console.log("Error al cargar");
                                } else {
                                    console.log("Intentando redireccionar");
                                    document.open("text/html", "replace");
                                    document.write(response);
                                    document.close();

                                }
                            },
                            error: function (xhr) {

                            }

                        });


                    } else {

                    }
                });

    });

    //Enviar Observaciones
    $('#enviarObservaciones').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Estas observaciones se enviarán al paciente.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((enviar) => {
                    if (enviar) {

                        //ajax para aprobar

                        location.href = "./index.html"

                    } else {

                    }
                });

    });

    $('#btn-cancelar').on('click', () => {

        swal({
            title: "¿Estás segura(o) de cancelar la cita?",
            text: "El paciente tendrá que solicitar de nuevo cita a preconsulta.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((cancelar) => {
                    if (cancelar) {



                    } else {

                    }
                });

    });

    //Enviar todos los datos del formulario
    $('#btn-sendAll').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Los datos serán almacenados y no será posible su posterior edición.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((enviar) => {
                    if (enviar) {



                    } else {

                    }
                });

    });

    //aprobar
    $('#btn-aprobar').on('click', () => {

        swal({
            title: "¿Estás segura(o)?",
            text: "Este documento será guardado como un documento válido y no podrás cambiar ese estatus.",
            icon: "warning",
            buttons: true,
            buttons: ['Cancelar', 'Aceptar'],
            dangerMode: true,
        })
                .then((aprobar) => {
                    if (aprobar) {

                        //ajax para aprobar

                        //location.href = "./documentos3.html"
                        var data = {key: "aprobarDocumento"};
                        $.ajax({
                            url: "NavegadoraController",
                            data: data,
                            method: "POST",
                            success: function (response) {
                                if (response == "true")
                                {
                                    swal({
                                        type: 'success',
                                        title: 'Éxito',
                                        text: 'Se aprobó con éxito el documento.',
                                    });
                                } else
                                {
                                    swal({
                                        type: 'error',
                                        title: 'Ups',
                                        text: 'Hubo un problema al aprobar el documento.',
                                    });
                                }
                            },
                            error: function (xhr) {
                                //alert(xhr.statusText);
                            }

                        });

                    } else {

                    }
                });

    });


    //rechazar documento
    $('#btn-rechazarDocumento').on('click', () => {


        //ajax para rechazar

        //location.href = "./documentos3.html"
        var data = {key: "rechazarDocumento", comentario: $('#motivoRechazo').val()};
        $('#motivoRechazo').val("");
        $.ajax({
            url: "NavegadoraController",
            data: data,
            method: "POST",
            success: function (response) {
                if (response == "true")
                {
                    swal({
                        type: 'success',
                        icon: 'success',
                        title: 'Éxito',
                        text: 'Se rechazo con éxito el documento.',
                    });
                } else
                {
                    swal({
                        type: 'error',
                        icon: 'error',
                        title: 'Ups',
                        text: 'Hubo un problema al rechazar el documento.',
                    });
                }
            },
            error: function (xhr) {
                //alert(xhr.statusText);
            }

        });

    });

    $('#btn-siguiente').on('click', function () {


        swal({
            icon: 'info',
            title: 'Cargando',
            text: 'Estamos buscando el siguiente documento',
            //timer:8000,         
            buttons: false
        });

        var data = {idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(), idDocumentoInicialVista: $('#idDocumentoInicialVista').val(), key: 1};

        console.log(JSON.stringify(data));

        $.post("SAPI", {
            idPacientePotencialAtendido: $('#idPacientePotencialAtendido').val(),
            idDocumentoInicialVista: $('#idDocumentoInicialVista').val(),
            siguiente: 1,
            file: "navegadora/verDocumento.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {

                        } else if (response == "todos")
                        {
                            console.log("Redireccionar a documentos"); 
                            $.post("SAPI", {
                                file: "navegadora/documentos.jsp",
                                idPacientePotencialAtendido: "hola"
                            },
                                    function (response, status, xhr) {
                                        //console.log(response);
                                        if (status == "success") {
                                            if (response == "error") {
                                                $("#msj-error").show();
                                            } else {
                                                document.open("text/html", "replace");
                                                document.write(response);
                                                document.close();
                                            }
                                        }
                                    }
                            );
                            swal({
                                title: 'No más documentos por revisar.',
                                timer: 3000
                            });                                                      
                            
                        } else {
                            swal.close();
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#irADashboard').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/index.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#irACalendario').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/calendar.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });
    
    $('#irARendimiento').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/rendimiento.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#irACuenta').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/cuentaNavegadora.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('#guardarCambios').on('click', function () {

        if (isValidPhoneNumber($("#telefono")) && isValidEmail($("#correo"))) {

            console.log("Presionó GuardarCambios")
            var form = $("form")[0];
            var data = new FormData(form);
            data.append("key", "cambiarDatos");
            data.forEach((value, key) => {
                console.log(key + " " + value);
            })


            $.ajax({
                url: "NavegadoraController",
                data: data,
                method: "POST",
                encType: "multipart/form-data",
                processData: false,
                contentType: false,
                cache: false,
                success: function (response) {
                    $.post("SAPI", {
                        file: "navegadora/cuentaNavegadora.jsp"
                    },
                            function (response, status, xhr) {
                                console.log("El ajax fue exitoso!!-----------------------");
                                if (status == "success") {
                                    if (response == "error") {
                                        $("#msj-error").show();
                                    } else {
                                        document.open("text/html", "replace");
                                        document.write(response);
                                        document.close();

                                    }
                                }
                            }
                    );
                }, error: function (xhr) {
                    //alert(xhr.statusText);
                }

            });
        } else {
            swal({
                title: "Datos invalidos!",
                text: "Revisa todos los campos antes de continuar",
                icon: "error",
            });
        }
    });

    //Cambiar imagen temporalmente en elfront
    function readURL(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#ImagenPerfil').attr('src', e.target.result);
            }

            reader.readAsDataURL(input.files[0]);
        }
    }

    $("#file-input").on('change', function () {
        console.log("Llegó :)");
        readURL(this);
    });

    //Cambiar contraseña

    $("#btn-updatePassword").on('click', function () {



        //Modal cambiar contraseña 
        swal({
            title: "¿Estás segura(o) que deseas guardar los cambios de tu contraseña?",
            text: "No podras volver a usar tu contraseña anterior para ingresar",
            icon: "warning",
            buttons: true,
            buttons: ['Regresar', 'Cambiar contraseña'],
            dangerMode: true
        })
                .then((cambiar) => {
                    if (cambiar) {


                        $.ajax({
                            url: "NavegadoraController",
                            data: {
                                key: "cambiarContrasena",
                                idCuenta: $("#sesionPaciente").val(),
                                password: $("#password").val(),
                                password2: $("#password-confirm").val()
                            },
                            method: "POST",
                            success: function (response) {
                                if (response == "success") {
                                    swal({
                                        title: "Contraseña actualizada",
                                        icon: "success",
                                    });
                                    $("#password").val('');
                                    $("#password-confirm").val('');
                                } else {
                                    //Aqui no se que hace
                                }
                            },
                            error: function (xhr) {

                            }
                        });
                        $('#modalCambiarContraseña').modal('toggle');
                    } else {

                    }

                });
    });

    //Cargar los municipios con base en el estado
    $('#estadoNavegadora').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#estadoNavegadora').val()
            },
            method: 'POST',
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".municipios select").each(function () {
                    $(this).children().remove();
                });
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    $('.municipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }
                $('.municipios select').prop('selectedIndex', 0);
                console.log(json);
            }
        });
    });

    $('#editarEstadoNavegadoraAPaciente').on('change', function () {
        $.ajax({
            url: 'ZonaController',
            data: {
                key: "getByEstado",
                idEstado: $('#editarEstadoNavegadoraAPaciente').val()
            },
            method: 'POST',
            success: function (response) {

                //Limpiar el select antes de que haga una consulta para que no se emapalmen los municipios
                $(".editarMunicipios select").each(function () {
                    $(this).children().remove();
                });
                var json = JSON.parse(response);
                for (var i = 0; i < json.length; i++) {
                    $('.editarMunicipios select').append("<option value=" + json[i].idMunicipio + ">" + json[i].nombre + "</option>");
                }
                $('.editarMunicipios select').prop('selectedIndex', 0);
                console.log(json);
            }
        });
    });

    function isValidEmail(input) {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    };

    function isValidPhoneNumber(input) {

        var m = input.val();

        var expreg = /^[0-9]{10,10}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    };

    $('#irVerForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });

    $('.descargarDocumento').on('click', function () {


        $.post("NavegadoraController",
                {
                    key: 'descargarArchivo',
                    idDocumento: $(this).data('id')
                },
                function (data, status) {

                });
    });

    $('#irAForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"

        },
                function (response, status, xhr) {
                    console.log(response);
                    if(status=="success"){
                        if (response=="error"){
                            $("#msj-error").show();
                        }else{
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                     }
                }
         );
    });

    // Pantallas del formulario 
    $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {
        console.log("click on 'btn-save[i]'");

        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;
    });


    function salir() {
        alert();

    };
    
    //VALIDACIONES
    //NOMBRE EN EL REGISTRO
    $('#nombreNavegadora').on('change', function () {

        if (isValidName($(this))) {
            $('#errorNombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreNavegadora').hide();
        } else {
            $('#errorNombreNavegadora').show();
        }

    });

    //PRIMER APELLIDO EN EL REGISTRO
    $('#primer-apellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoPaternoNavegadora').hide();
        } else {
            $('#errorApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO EN EL REGISTRO
    $('#segundo-apellidoNavegadora').on('change', function () {

        if (isValidLastName($(this))) {
            $('#errorApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorApellidoMaternoNavegadora').hide();
        } else {
            $('#errorApellidoMaternoNavegadora').show();
        }

    });

    //NOMBRE DE USUARIO EN EL REGISTRO
    $('#usuarioNavegadora').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#usuarioNavegadora').val()


            },
            success: function (response) {

                if (response == 'UsuarioAlreadyExists') {
                    $('#usuarioNavegadora').css('color', 'orange');
                    $('#errorUsuarioRepetidoNavegadora').show();
                } else {
                    $('#errorUsuarioRepetidoNavegadora').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#errorNombreUsuarioNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorNombreUsuarioNavegadora').hide();
        } else {
            $('#errorNombreUsuarioNavegadora').show();
        }

    });


    //CORREO EN EL REGISTRO
    $('#correoNavegadora').on('change', function () {

        if (isValidEmail($(this))) {
            $('#errorCorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCorreoNavegadora').hide();
        } else {
            $('#errorCorreoNavegadora').show();
        }

    });

    //CONTRASEÑA1 EN EL REGISTRO
    $('#contraNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass1Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass1Navegadora').hide();
        } else {
            $('#errorPass1Navegadora').show();
        }

    });

    //CONTRASEÑA2 EN EL REGISTRO
    $('#confContraNavegadora').on('change', function () {

        if (isValidPassword($(this))) {
            $('#errorPass2Navegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorPass2Navegadora').hide();
        } else {
            $('#errorPass2Navegadora').show();
        }

    });

    //CURP EN EL REGISTRO
    $('#curpNavegadora').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#curpNavegadora').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#curpNavegadora').css('color', 'orange');
                    $('#errorCurpRepetidoNavegadora').show();
                } else {
                    $('#errorCurpRepetidoNavegadora').hide();
                    }
                }
            });
            
        if (isValidCURP($(this))) {
            $('#errorCurpNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#errorCurpNavegadora').hide();
        } else {
            $('#errorCurpNavegadora').show();
        }
    });
            
            

    //PARA SALIR DE LA CUENTA
    $('#salirCuenta').on('click', function () {

        console.log("Salir cuenta");
        $.get("LoginController", {
            key: "cerrar-sesion"
        },
                function (response, status, xhr) {
                    console.log(response);
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }

            );
        });


    


        //TELEFONO EN EL REGISTRO
        $('#telNavegadora').on('change', function () {

            if (isValidPhoneNumber($(this))) {
                $('#errorTelefonoNavegadora').hide();
            } else if ($(this).val() == '') {
                $('#errorTelefonoNavegadora').hide();
            } else {
                $('#errorTelefonoNavegadora').show();
            }

        });

        //ESTADO CIVIL EN EL REGISTRO
        $('#estado-civilNavegadora').on('change', function () {

            if (isValidSelect($(this))) {
                $('#errorECivilNavegadora').hide();
            } else {
                $('#errorECivilNavegadora').show();
            }

        });

        //FECHA DE NACIMIENTO EN EL REGISTRO
        $('#cumpleNavegadora').on('change', function () {

            if (isValidDate($(this))) {
                $('#errorFechaNavegadora').hide();
            } else {
                $('#errorFechaNavegadora').show();
            }

        });

        //ESTADO EN EL REGISTRO
        $('#estadoNavegadora').on('change', function () {

            if (isValidSelect($(this))) {
                $('#errorEstadoNavegadora').hide();
            } else {
                $('#errorEstadoNavegadora').show();
            }

        });

        //MUNICIPIO EN EL REGISTRO
        $('#municipioNavegadora').on('change', function () {

            if (isValidSelect($(this))) {
                $('#errorMunicipioNavegadora').hide();
            } else {
                $('#errorMunicipioNavegadora').show();
            }

        });

        //COLONIA EN EL REGISTRO
        $('#colNavegadora').on('change', function () {

            if (isValidColonia($(this))) {
                $('#errorColoniaNavegadora').hide();
            } else {
                $('#errorColoniaNavegadora').show();
            }

        });

        //CALLE EN EL REGISTRO
        $('#calleNavegadora').on('change', function () {

            if (isValidStreet($(this))) {
                $('#errorCalleNavegadora').hide();
            } else {
                $('#errorCalleNavegadora').show();
            }

        });

        //NUMERO EXTERIOR EN EL REGISTRO
         $('#numExtNavegadora').on('change', function () {

            if (isValidExtNumber($(this))) {
                $('#errorNoExteriorNavegadora').hide();
            } else {
                $('#errorNoExteriorNavegadora').show();
            }

        });

        //NUMERO INTERIOR EN EL REGISTRO
        $('#numIntNavegadora').on('change', function () {

            if (isValidIntNumber($(this))) {
                $('#errorNoInteriorNavegadora').hide();
            } else {
                $('#errorNoInteriorNavegadora').show();
            }


    });

    
    //NOMBRE AL EDITAR
    $('#editarNombreNavegadoraAPaciente').on('change', function () {

        


        if (isValidName($(this))) {
            $('#error-editar-NombreNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreNavegadora').hide();
        } else {
            $('#error-editar-NombreNavegadora').show();
        }

    });

    //PRIMER APELLIDO AL EDITAR
    $('#editarPrimer-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoPaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoPaternoNavegadora').hide();
        } else {
            $('#error-editar-ApellidoPaternoNavegadora').show();
        }

    });

    //SEGUNDO APELLIDO AL EDITAR
    $('#editarSegundo-apellidoNavegadoraAPaciente').on('change', function () {

        if (isValidLastName($(this))) {
            $('#error-editar-ApellidoMaternoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-ApellidoMaternoNavegadora').hide();
        } else {
            $('#error-editar-ApellidoMaternoNavegadora').show();
        }

    });

    //NOMBRE DE USUARIO AL EDITAR
    $('#editarUsuarioNavegadoraAPaciente').on('change', function () {

        $.ajax({

            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {

                key: "repiteUsuario",
                usuario: $('#editarUsuarioNavegadoraAPaciente').val()


            },
            success: function (response) {

                if (response === 'UsuarioAlreadyExists') {
                    $('#editarUsuarioNavegadoraAPaciente').css('color', 'orange');
                    $('#error-editar-UsuarioRepetidoNavegadora').show();                    
                } else {
                    $('#error-editar-UsuarioRepetidoNavegadora').hide();
                }

            }

        });

        if (isValidUserName($(this))) {
            $('#error-editar-NombreUsuarioNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-NombreUsuarioNavegadora').hide();
        } else {
            $('#error-editar-NombreUsuarioNavegadora').show();
        }

    });

    //CORREO AL EDITAR
    $('#editarCorreoNavegadoraAPaciente').on('change', function () {

        if (isValidEmail($(this))) {
            $('#error-editar-CorreoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CorreoNavegadora').hide();
        } else {
            $('#error-editar-CorreoNavegadora').show();
        }

    });



    //CURP AL EDITAR
    $('#editarCurpNavegadoraAPaciente').on('change', function () {

        $.ajax({
            url: 'RegistraUsuarioController',
            cache: false,
            method: 'POST',
            data: {
                key: "repiteCurp",
                curp: $('#editarCurpNavegadoraAPaciente').val()
            },
            success: function (response) {

                if (response === 'CurpAlreadyExists') {
                    $('#editarCurpNavegadoraAPaciente').css('color', 'orange');
                    $('#error-editar-CurpRepetidoNavegadora').show();
                } else {
                    $('#error-editar-CurpRepetidoNavegadora').hide();
                }

            }
        });


        if (isValidCURP($(this))) {
            $('#error-editar-CurpNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-CurpNavegadora').hide();
        } else {
            $('#error-editar-CurpNavegadora').show();
        }

    });

    //TELEFONO AL EDITAR
    $('#editarTelNavegadoraAPaciente').on('change', function () {

        if (isValidPhoneNumber($(this))) {
            $('#error-editar-TelefonoNavegadora').hide();
        } else if ($(this).val() == '') {
            $('#error-editar-TelefonoNavegadora').hide();
        } else {
            $('#error-editar-TelefonoNavegadora').show();
        }

    });

    //ESTADO CIVIL AL EDITAR
    $('#editarEstado-civilNavegadora').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-ECivilNavegadora').hide();
        } else {
            $('#error-editar-ECivilNavegadora').show();
        }

    });

    //FECHA DE NACIMIENTO AL EDITAR
    $('#editarCumpleNavegadoraAPaciente').on('change', function () {

        if (isValidDate($(this))) {
            $('#error-editar-FechaNavegadora').hide();
        } else {
            $('#error-editar-FechaNavegadora').show();
        }

    });

    //ESTADO AL EDITAR
    $('#editarEstadoNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-EstadoNavegadora').hide();
        } else {
            $('#error-editar-EstadoNavegadora').show();
        }

    });

    //MUNICIPIO AL EDITAR
    $('#editarMunicipioNavegadoraAPaciente').on('change', function () {

        if (isValidSelect($(this))) {
            $('#error-editar-MunicipioNavegadora').hide();
        } else {
            $('#error-editar-MunicipioNavegadora').show();
        }

    });

    //COLONIA AL EDITAR
    $('#editarColNavegadoraAPaciente').on('change', function () {

        if (isValidColonia($(this))) {
            $('#error-editar-ColoniaNavegadora').hide();
        } else {
            $('#error-editar-ColoniaNavegadora').show();
        }

    });

    //CALLE AL EDITAR
    $('#editarCalleNavegadoraAPaciente').on('change', function () {

        if (isValidStreet($(this))) {
            $('#error-editar-CalleNavegadora').hide();
        } else {
            $('#error-editar-CalleNavegadora').show();
        }

    });

    //NUMERO EXTERIOR AL EDITAR
    $('#editarNumExtNavegadoraAPaciente').on('change', function () {

        if (isValidExtNumber($(this))) {
            $('#error-editar-NoExteriorNavegadora').hide();
        } else {
            $('#error-editar-NoExteriorNavegadora').show();
        }

    });

    //NUMERO INTERIOR AL EDITAR
    $('#editarNumIntNavegadoraAPaciente').on('change', function () {

        if (isValidIntNumber($(this))) {
            $('#error-editar-NoInteriorNavegadora').hide();
        } else {
            $('#error-editar-NoInteriorNavegadora').show();
        }

    });
    
    // Pantallas del formulario 
     $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {
        console.log("click on 'btn-save[i]'");
        
        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 5; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
            }
        }
        data.append("key", "btn-save");
        data.forEach((value, key) => {
            console.log(key + " " + value);
        });
        $.ajax({
            url: "NavegadoraController",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function (request, status, error) {
                console.log("Enviar datos Error " + request.responseText);
                console.log("Enviar datos Error status " + status);
                console.log("Enviar datos Error error" + error);
                //alert("No enontre el controlador" + status);                               
            }
        });

    });
    $('#irAForm').on('click', function () {
        $.post("SAPI", {
            file: "navegadora/form.jsp"
        },
                function (response, status, xhr) {
                    console.log("El ajax fue exitoso!!-----------------------");
                    if (status == "success") {
                        if (response == "error") {
                            $("#msj-error").show();
                        } else {
                            console.log(response);
                            document.open("text/html", "replace");
                            document.write(response);
                            document.close();
                        }
                    }
                }
        );
    });
});


    // Pantallas del formulario 
     $('#btn-save1, #btn-save2,#btn-save3,#btn-save4,#btn-save5').on('click', function () {
         
        
        var biopsias = [];
        console.log("Biopsia 1");
        $('.tuplaBiopsia').each(function () {
            
            var biopsia = {tipo:$(this).find('.tipoBiopsia').val(),
                fecha:$(this).find('.fechaBiopsia').val(),
                lugar:$(this).find('.parteCuerpoBiopsia').val()
            };
            
            biopsias.push(biopsia);
            console.log(biopsia);
        });
        console.log("Biopsia 2");
         
       var rayosxs = [];
       console.log("Rayos x");
        $('.tuplaRayosX').each(function () {
            var rayosx = {tipo:$(this).find('.tipoRayosX').val(),
                            fecha: $(this).find('.fechaRayos').val()
                        };
            rayosxs.push(rayosx);
            console.log(rayosx);                                
        });
        console.log("Rayox x");        
        
        var ultrasonidos = [];
        console.log("Ultrasonido");
        $('.tuplaUltrasonido').each(function () {
            var ultrasonido = {parte:$(this).find('.parteCuerpoUltrasonido').val(),
                fecha: $(this).find('.fechaUltrasonido').val()
            };
            
            ultrasonidos.push(ultrasonido);            
            console.log(ultrasonido);                    
        });
        console.log("Ultrasonido");
        
                
        var medicinasNucleares = []
        console.log("Medicina Nuclear");
        $('.tuplaMedicinaNuclear').each(function () {
            var medicinaNuclear = {medicinaNuclear:$(this).find('.medicinaNuclear').val(),
                fecha:$(this).find('.fechaMedicinaNuclear').val()
            };            
            console.log(medicinaNuclear);                    
            medicinasNucleares.push(medicinaNuclear);
        });
        console.log("Medicina Nuclear");
        
                         
        var laboratorios = [];
        console.log("tuplaLaboratorio");
        $('.tuplaLaboratorio').each(function () {
            var laboratorio = {fecha:$(this).find('.fechaLaboratorio').val()};
            laboratorios.push(laboratorio);
            console.log(laboratorio);                    
        });
        console.log("tuplaLaboratorio");
        
        
        var valoraciones = [];
        console.log("tuplaValoracion");
        $('.tuplaValoracion').each(function () {
            
            var valoracion = {valoracion:$(this).find('.valoracion').val(),
                fecha:$(this).find('.fechaValoracion').val()
            };
            valoraciones.push(valoracion);
            console.log(valoracion);                    
        });
        console.log("tuplaValoracion");
        
        
        var espirometrias = [];
        console.log("tuplaEspirometria");
        $('.tuplaEspirometria').each(function () {
            var espirometria = {fecha:$(this).find('.fechaEspirometria').val()};
            espirometrias.push(espirometria);
            console.log(espirometria);                    
        });
        console.log("tuplaEspirometria");
        
        
        var electrocardiogramas = [];
        console.log("tuplaElectrocardiograma");
        $('.tuplaElectrocardiograma').each(function () {
            var electrocardiograma = {fecha:$(this).find('.fechaElectrocardiograma').val()};
            
            electrocardiogramas.push(electrocardiograma);
            console.log(electrocardiograma);                    
        });
        console.log("tuplaElectrocardiograma");
        
        
        var ecocardiogramas = [];
        console.log("tuplaEcocardiograma");
        $('.tuplaEcocardiograma').each(function () {
            var ecocardiograma = {fecha:$(this).find('.fechaEcocardiograma').val()};
            
            ecocardiogramas.push(ecocardiograma);
            console.log(ecocardiograma);                    
        });
        console.log("tuplaEcocardiograma");
        
                 
        var trabajosSociales = []
        console.log("tuplaTrabajoSocial");
        $('.tuplaTrabajoSocial').each(function () {
            var trabajoSocial = {fecha: $(this).find('.fechaTrabajoSocial').val()};
            trabajosSociales.push(trabajoSocial);
            console.log(trabajoSocial);                    
        });
        console.log("tuplaTrabajoSocial");
        
        
        var programas = [];
        console.log("tuplaPrograma");
        $('.tuplaPrograma').each(function () {
            var programa = {programa:$(this).find('.programa').val(),
            fecha: $(this).find('.fechaPrograma').val()};        
            programas.push(programa);
            console.log(programa);                        
        });
        console.log("tuplaPrograma");
        
                        
        var otrosEstudios = [];
        console.log("tuplaOtro");
        $('.tuplaOtro').each(function () {
            var otroEstudio = {fecha:$(this).find('.fechaOtro').val(),
            otroEstudio: $(this).find('.otro-estudioPreconsulta').val()};
        
            otrosEstudios.push(otroEstudio);
            console.log(otroEstudio);                                
        });
        console.log("tuplaOtro");
                
               
        var llamadas = [];
        $('.tuplaLlamada').each(function () {

            var llamada = {
                fecha: $(this).find('.fecha-llamada').val(),
                motivo: $(this).find('.comentario-llamada').val()
            };

            llamadas.push(llamada);
            console.log(llamada);
        });
        
        
         
        console.log("Comentarios del médico");
        var comentariosMedico = $("#comentariosAdicionales").val();
        if(comentariosMedico == null)
        {
           comentariosMedico = "";
        }
        console.log(comentariosMedico);
        console.log("Comentarios del médico");
        
        var tipoUltrasonidoMama = $('#tipoUltrasonidoMama').val();
        if(tipoUltrasonidoMama == null)
            tipoUltrasonidoMama = "";
        
        console.log("click on 'btn-save[i]'");
        
        var data = new FormData();
        var form;
        var dataTemp;
        var formValues;

        for (var i = 0; i < 5; i++) {
            form = $("form")[i];
            dataTemp = new FormData(form);
            formValues = dataTemp.entries();
            while (!(ent = formValues.next()).done) {
                // ent.value[0] es la 'key' and ent.value[1] es el valor
                data.append(ent.value[0], ent.value[1]);
                console.log(ent.value[0] + " : " + ent.value[1]);
            }
        }
        console.log("##########################################################################################");
        data.append("key", "btn-save");      
        data.append("biopsias",JSON.stringify(biopsias));
        data.append("rayosxs",JSON.stringify(rayosxs));
        data.append("ultrasonidos",JSON.stringify(ultrasonidos));
        data.append("medicinasNucleares",JSON.stringify(medicinasNucleares));
        data.append("laboratorios",JSON.stringify(laboratorios));
        data.append("valoraciones",JSON.stringify(valoraciones));
        data.append("espirometrias",JSON.stringify(espirometrias));
        data.append("electrocardiogramas",JSON.stringify(electrocardiogramas));
        data.append("ecocardiogramas",JSON.stringify(ecocardiogramas));
        data.append("trabajosSociales",JSON.stringify(trabajosSociales));
        data.append("programas",JSON.stringify(programas));
        data.append("otrosEstudios",JSON.stringify(otrosEstudios));
        data.append("comentariosMedico",comentariosMedico);
        data.append("tipoUltrasonidoMama",tipoUltrasonidoMama);
        data.append("llamadasCita",JSON.stringify(llamadas));
        data.forEach((value, key) => {
            console.log(key + " " + value);
        });
        $.ajax({
            url: "NavegadoraController",
            method: "POST",
            data: data,
            enctype: "multipart/form-data",
            processData: false,
            contentType: false,
            success: function (response) {
                if (response == "success") {
                    console.log("ok");
                } else {
                    console.log("Algo pasó" + response);
                }
            },
            error: function (request, status, error) {
                console.log("Enviar datos Error " + request.responseText);
                console.log("Enviar datos Error status " + status);
                console.log("Enviar datos Error error" + error);
                //alert("No enontre el controlador" + status);                               
            }
        });

    });

    //});
    
    function isValidEmail(input) {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    }
    ;

    function isValidPhoneNumber(input) {

        var m = input.val();

        var expreg = /^[0-9]{10,10}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }
    ;


    function formatDate(date) {
        var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

        if (month.length < 2) month = '0' + month;
        if (day.length < 2) day = '0' + day;

        return [year, month, day].join('-');
    }

    function isValidName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    }

    function isValidLastName(input) {

        var m = input.val();

        var expreg = /^[-a-zA-Z\u00E0-\u00FCñÑ. ]{2,127}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidEmail(input) {

        var m = input.val();

        ////Expresion regular por el estandard: RFC 5322
        var expreg = /^[a-zA-Z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;

    }

    function isValidPassword(input) {

        var m = input.val();

        //var expreg = /^[a-zA-Z0-9]{8,14}$/;
        var expreg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{8,14}$/;
        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {

            input.css('border', '');
            input.css('color', '');
        }

        return true;

    }

    function isValidCURP(input) {

        var m = input.val();

        var expreg = /^([A-Z][AEIOUX][A-Z]{2}\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\d|3[01])[HM](?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)[B-DF-HJ-NP-TV-Z]{3}[A-Z\d])(\d)$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidPhoneNumber(input) {

        var m = input.val();

        var expreg = /^[0-9]{10,10}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidSelect(input) {

        if (!input.val()) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidDate(input) {

        //Obtener fecha
        let today = new Date();

        //Valor seleccionado del input
        let date_from = input.val();
        date_from = new Date(date_from);

        let event = false;

        today < date_from ? event = true : event = false;


        if (!input.val() || event) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidColonia(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,500}$/;


        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }

    function isValidStreet(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z\u00E0-\u00FCñÑ.0-9 ]{1,255}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    function isValidIntNumber(input) {

        var m = input.val();

        var expreg = /^[#a-zA-Z0-9]{1,100000}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    function isValidExtNumber(input) {

        var m = input.val();

        var expreg = /^[#0-9]{1,100000}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;


    }

    function isValidUserName(input) {

        var m = input.val();

        var expreg = /^[a-zA-Z0-9]{4,16}$/;

        if (!expreg.test(m)) {

            input.css('border', '1px solid red');
            input.css('color', 'red');
            return false;

        } else {
            input.css('border', '');
            input.css('color', '');
        }

        return true;
    }    
