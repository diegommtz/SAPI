/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Author Angel Gtz

$(document).ready(function () {
    $("#RestablcerContra").on('click', function () {
        console.log("Presionó cmabiar contrasena");
        
        $.ajax({
            url: "RecuperarController",
            data: {
                key: "cambiarContrasena",
            
                password: $("#cambio1").val(),
                password2: $("#cambio2").val()
            },
            method: "POST",
            success: function (response) {
                if (response == "success") {
                    
                } else {
                   
                }
            },
            error: function (xhr) {
            
            }
        });

    });
     $('#recuperarEnviarCorreo').on('click', function () {
        console.log("Click en Recuperar después de ingresar el correo"); 
        var mail = $('#email');
        $.get("RecuperarController",{
            key: "recuperarEnviarCorreo",
            email: mail.val()
        },
                function (response,status) {
                    console.log(response);
                    
                    if (response != "") {
                        console.log("Intentando redireccionar");
                        document.open("text/html", "replace");
                        document.write(response);
                        document.close();
                    } else {
                        console.log("Error al cargar");
                    
                    }
                }
        );
            
    });

    
});