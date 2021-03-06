/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.sql.Date;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.diagnostico.AuditoriaRegistroDiagnostico;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;

import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoPosicion;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Posicion;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNecesidadEspecial;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteNavegadora;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.CitaEmpleado;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.OtroResultadoPatologia;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionTratamiento.AuditoriaTratamientoPaciente;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.gestionTratamiento.AlergiaPacienteFarmaco;
import mx.itesm.sapi.bean.gestionTratamiento.TratamientoPaciente;
import mx.itesm.sapi.bean.persona.InformacionGeneralPersona;
import mx.itesm.sapi.bean.persona.Direccion;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Login;
import mx.itesm.sapi.bean.persona.Pic;

import mx.itesm.sapi.service.GeneralPoblacionServicioImpl;
import mx.itesm.sapi.service.diagnostico.AuditoriaRegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;

import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoPacienteServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoPosicionServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.PosicionServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNecesidadEspecialServicioImpl;


import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteNavegadoraServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaEmpleadoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.OtroResultadoPatologiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.AlergiaPacienteFarmacoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.AuditoriaTratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoPacienteServiceImpl;
import mx.itesm.sapi.service.persona.DireccionServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.LoginServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import mx.itesm.sapi.util.ExcelExport;

import org.apache.commons.io.IOUtils;

/**
 *
 * @author urieldiaz
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

@WebServlet(name = "AdministradorController", urlPatterns = {"/AdministradorController"})
public class AdministradorController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String key = request.getParameter("key");

        System.out.println("LLAVE:" + key);

        HttpSession sesion = request.getSession(true);

        if (sesion.getAttribute("idCuenta") == null) {
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("Sin sesión");
        } else {
            switch (key) {
                case "obtener-admin": {
                    int idAdmin = Integer.valueOf(request.getParameter("idAdmin"));

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador admin = empleadoServicioImpl.mostrarMedicoAdministrador(idAdmin, 2);//2 ES EL ROL DEL ADMINISTRADOR

                    PrintWriter out = response.getWriter();
                    out.print(new Gson().toJson(admin));
                    break;
                }
                case "actualizar-admin": {
                    System.out.println("Actualizar administrador");
                    int idMedicoAdministrador = Integer.valueOf(request.getParameter("idAdmin"));
                    String nombre = request.getParameter("nombre");
                    String primerApellido = request.getParameter("primerApellido");
                    String segundoApellido = request.getParameter("segundoApellido");
                    String correo = request.getParameter("correo");
                    String telefono = request.getParameter("telefono");
                    String noEmpleado = request.getParameter("noEmpleado");
                    String especialidad = request.getParameter("especialidad");
                    String posicion = request.getParameter("posicion");
                    String usuario = noEmpleado;
                    String cedula = request.getParameter("cedula");

                    System.out.println("idMEdico admin ".concat(String.valueOf(idMedicoAdministrador)));
                    System.out.println("nombre ".concat(nombre));
                    System.out.println("apellido 1 ".concat(primerApellido));
                    System.out.println("apellido 2 ".concat(segundoApellido));
                    System.out.println("correo  ".concat(correo));
                    System.out.println("telefeno ".concat(telefono));
                    System.out.println("noEmpleado ".concat(noEmpleado));
                    System.out.println("especialidad ".concat(especialidad));
                    System.out.println("posicion ".concat(posicion));
                    System.out.println("usuario ".concat(usuario));
                    System.out.println("cedula ".concat(cedula));

                    PrintWriter out = response.getWriter();

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador admin = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador, 2);//El 3 significa rol de médico

                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                    Especialidad especialidadAdmins = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);

                    PosicionServicioImpl posicionServicioImpl = new PosicionServicioImpl();

                    Posicion posicionMedicos = posicionServicioImpl.mostrarPosicion(posicion);

                    //Se utiliza el servicio de medicoEspecialidadServicio porque el admin y el médico son similares
                    MedicoEspecialidadServicioImpl adminEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();
                    MedicoEspecialidad adminEspecialidad = adminEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(idMedicoAdministrador);
                    adminEspecialidad.setCedulaProfesional(cedula);
                    adminEspecialidad.setIdEspecialidad(especialidadAdmins.getIdEspecialidad());
                    System.out.println(" adminiController medicoEspecialidad ".concat(String.valueOf(adminEspecialidad.getIdEmpleado())));
                    boolean medicoEspecialidadBoolean = adminEspecialidadServicioImpl.actualizarMedicoEspecialidad(adminEspecialidad);

                    //Se utiliza el servicio de medicoPosicionServicio porque el admin y el médico son similares
                    MedicoPosicionServicioImpl adminPosicionServicioImpl = new MedicoPosicionServicioImpl();
                    MedicoPosicion adminPosicion = adminPosicionServicioImpl.mostrarMedicoPosicionEmpleado(idMedicoAdministrador);
                    adminPosicion.setIdPosicion(posicionMedicos.getIdPosicion());
                    System.out.println(" adminiController medicoPosicion ".concat(String.valueOf(adminPosicion.getIdEmpleado())));
                    boolean medicoPosicionBoolean = adminPosicionServicioImpl.actualizarMedicoPosicion(adminPosicion);

                    PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                    Persona persona = personaServicioImpl.mostrarPersona(admin.getIdPersona());
                    persona.setNombre(nombre);
                    persona.setPrimerApellido(primerApellido);
                    persona.setSegundoApellido(segundoApellido);
                    persona.setCorreo(correo);
                    persona.setTelefono(telefono);
                    boolean personaBoolean = personaServicioImpl.actualizarPersonaMedico(persona);

                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(admin.getIdCuenta());
                    cuenta.setUsuario(usuario);
                    boolean cuentaBoolean = cuentaServicioImpl.actualizarCuenta(cuenta);

                    Empleado empleado = empleadoServicioImpl.mostrarEmpleado(admin.getIdEmpleado());
                    empleado.setNoEmpleado(noEmpleado);
                    boolean empleadoBoolean = empleadoServicioImpl.actualizarEmpleado(empleado);

                    if (medicoEspecialidadBoolean || personaBoolean || cuentaBoolean || empleadoBoolean) {
                        System.out.println("Actualizado exitoso");
                    } else {
                        System.out.println("MedicoEspecialidad: " + medicoEspecialidadBoolean);
                        System.out.println("Persona: " + personaBoolean);
                        System.out.println("Cuenta: " + cuentaBoolean);
                        System.out.println("Empleado: " + empleadoBoolean);
                        System.out.println("Actualizado no exitoso o, no se cambió nada");
                    }

                    if (medicoPosicionBoolean || personaBoolean || cuentaBoolean || empleadoBoolean) {
                        System.out.println("Actualizado exitoso");
                    } else {
                        System.out.println("MedicoEspecialidad: " + medicoPosicionBoolean);
                        System.out.println("Persona: " + personaBoolean);
                        System.out.println("Cuenta: " + cuentaBoolean);
                        System.out.println("Empleado: " + empleadoBoolean);
                        System.out.println("Actualizado no exitoso o, no se cambió nada");
                    }
                }
                break;
                case "obtener-medico": {
                    int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedicoAdministrador"));

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador, 3);//3 ES EL ROL DEL MÉDICO.

                    PrintWriter out = response.getWriter();
                    out.print(new Gson().toJson(medico));
                    break;
                }

                case "guardarCambios": {
                    System.out.println("Llegó al case de GuardarCambios");

                    String correo = request.getParameter("correo");
                    Part part = request.getPart("file-image");

                    System.out.println("Correo: ".concat(correo));

                    //Si tiene sesion iniciada
                    int keyRol = (int) sesion.getAttribute("idRol");
                    switch (keyRol) {
                        case 2: {

                            System.out.println("Entro al controller en guardarCambios");

                            PersonaServicioImpl personaServiceImpl = new PersonaServicioImpl();
                            Persona persona = personaServiceImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                            if ((int) part.getSize() > 0) {

                                PicServicioImpl picServicioImpl = new PicServicioImpl();
                                //AQUI
                                Pic picture = new Pic();

                                picture.setIdPersona((int) sesion.getAttribute("idPersona"));
                                picture.setContenido(part.getInputStream());
                                picture.setTamano((int) part.getSize());
                                picture.setTipo(part.getContentType());

                                picServicioImpl.agregarPic(picture);
                                //AQUI

                                Pic pic = picServicioImpl.mostrarPic(persona.getIdPersona());
                                try {
                                    InputStream imagen = pic.getContenido();
                                    byte[] bytes = IOUtils.toByteArray(imagen);
                                    String base64String = Base64.getEncoder().encodeToString(bytes);

                                    sesion.setAttribute("base64Img", base64String);
                                } catch (Exception es) {
                                    System.out.println("Sin foto de perfil");
                                }

                            }

                            persona.setCorreo(correo);

                            personaServiceImpl.actualizarPersona(persona);

                            sesion.setAttribute("correo", persona.getCorreo());
                            request.setAttribute("correo", sesion.getAttribute("correo"));

                        }

                    }

                    break;

                }
                case "repiteNoEmpleadoEdit": {

                    String noEmpleado = request.getParameter("noEmpleado");

                    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    System.out.println("idEmpleado: " + idEmpleado);

                    PrintWriter out = response.getWriter();

                    EmpleadoServicioImpl empleadoServicio = new EmpleadoServicioImpl();

                    //Checo si el usuario existe
                    if (empleadoServicio.existsNoEmpleado(noEmpleado, idEmpleado)) {

                        out.print("NoEmpleadoAlreadyExists");

                    } else {

                        //Si no existe, lo inserto
                        out.print("NoEmpleadoDoesntExist");

                    }
                }
                break;

                case "repiteCorreoEditEmpleado": {

                    String correo = request.getParameter("correo");

                    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    System.out.println("idEmpleado: " + idEmpleado);

                    Cuenta cuentaEdit;

                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();
                    cuentaEdit = cuentaServicio.mostrarCuentaidEmpleado(idEmpleado);

                    int idPersona = cuentaEdit.getIdPersona();

                    PersonaServicioImpl _registroServicio = new PersonaServicioImpl();

                    PrintWriter out = response.getWriter();

                    System.out.println("ENTRA AQUÍ");

                    //Checo si el usuario existe
                    if (_registroServicio.existsCorreo(correo, idPersona)) {
                        System.out.println("EXISTE");
                        out.print("CorreoAlreadyExists");

                    } else {
                        System.out.println("NO EXISTE");
                        //Si no existe, lo inserto
                        out.print("CorreoDoesntExist");

                    }
                }
                break;

                case "repiteCorreoEditPaciente": {

                    String correo = request.getParameter("correo");

                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                    System.out.println("idPaciente: " + idPaciente);

                    Persona personaEdit;

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                    personaEdit = personaServicio.mostrarPersonaPorIdPaciente(idPaciente);

                    int idPersona = personaEdit.getIdPersona();

                    PersonaServicioImpl _registroServicio = new PersonaServicioImpl();

                    PrintWriter out = response.getWriter();

                    System.out.println("ENTRA AQUÍ");

                    //Checo si el usuario existe
                    if (_registroServicio.existsCorreo(correo, idPersona)) {
                        System.out.println("EXISTE");
                        out.print("CorreoAlreadyExists");

                    } else {
                        System.out.println("NO EXISTE");
                        //Si no existe, lo inserto
                        out.print("CorreoDoesntExist");

                    }
                }
                break;
                
                case "repiteUsuarioEdit": {

                    String usuario = request.getParameter("usuario");
                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                    
                    System.out.println("usuario: " + usuario);
                    System.out.println("idPaciente: " + idPaciente);
                    
                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    PrintWriter out = response.getWriter();

                    System.out.println("ENTRA AQUÍ");

                    //Checo si el usuario existe
                    if (cuentaServicio.existsUsuario(usuario, idPaciente)) {
                        System.out.println("EXISTE");
                        out.print("UsuarioAlreadyExists");
                    } else {
                        System.out.println("NO EXISTE");
                        //Si no existe, lo inserto
                        out.print("UsuarioDoesn'tExists");

                    }
                }
                break;

                case "repiteCorreo": {

                    String correo = request.getParameter("correo");
                    int idPersona = (int) sesion.getAttribute("idPersona");
                    System.out.println("El id de persona es: " + idPersona);

                    PersonaServicioImpl _registroServicio = new PersonaServicioImpl();

                    PrintWriter out = response.getWriter();

                    System.out.println("ENTRA AQUÍ");

                    //Checo si el usuario existe
                    if (_registroServicio.existsCorreo(correo, idPersona)) {
                        System.out.println("EXISTE");
                        out.print("CorreoAlreadyExists");

                    } else {
                        System.out.println("NO EXISTE");
                        //Si no existe, lo inserto
                        out.print("CorreoDoesntExist");

                    }
                }
                break;

                case "actualizar-medico": {
                    System.out.println("Actualizar médico");
                    int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedico"));
                    String nombre = request.getParameter("nombre");
                    String primerApellido = request.getParameter("primerApellido");
                    String segundoApellido = request.getParameter("segundoApellido");
                    String correo = request.getParameter("correo");
                    String telefono = request.getParameter("telefono");
                    String noEmpleado = request.getParameter("noEmpleado");
                    String especialidad = request.getParameter("especialidad");
                    String posicion = request.getParameter("posicion");
                    String usuario = noEmpleado;
                    String cedula = request.getParameter("cedula");

                    System.out.println("idMEdico admin ".concat(String.valueOf(idMedicoAdministrador)));
                    System.out.println("nombre ".concat(nombre));
                    System.out.println("apellido 1 ".concat(primerApellido));
                    System.out.println("apellido 2 ".concat(segundoApellido));
                    System.out.println("correo  ".concat(correo));
                    System.out.println("telefeno ".concat(telefono));
                    System.out.println("noEmpleado ".concat(noEmpleado));
                    System.out.println("especialidad ".concat(especialidad));
                    System.out.println("posicion ".concat(posicion));
                    System.out.println("usuario ".concat(usuario));
                    System.out.println("cedula ".concat(cedula));

                    PrintWriter out = response.getWriter();

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador, 3);//El 3 significa rol de médico

                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                    Especialidad especialidadMedicos = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);

                    PosicionServicioImpl posicionServicioImpl = new PosicionServicioImpl();

                    Posicion posicionMedicos = posicionServicioImpl.mostrarPosicion(posicion);

                    MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();
                    MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(idMedicoAdministrador);
                    medicoEspecialidad.setCedulaProfesional(cedula);
                    medicoEspecialidad.setIdEspecialidad(especialidadMedicos.getIdEspecialidad());
                    System.out.println(" adminiController medicoEspecialidad ".concat(String.valueOf(medicoEspecialidad.getIdEmpleado())));
                    boolean medicoEspecialidadBoolean = medicoEspecialidadServicioImpl.actualizarMedicoEspecialidad(medicoEspecialidad);

                    MedicoPosicionServicioImpl medicoPosicionServicioImpl = new MedicoPosicionServicioImpl();
                    MedicoPosicion medicoPosicion = medicoPosicionServicioImpl.mostrarMedicoPosicionEmpleado(idMedicoAdministrador);
                    medicoPosicion.setIdPosicion(posicionMedicos.getIdPosicion());
                    System.out.println(" adminiController medicoPosicion ".concat(String.valueOf(medicoPosicion.getIdEmpleado())));
                    boolean medicoPosicionBoolean = medicoPosicionServicioImpl.actualizarMedicoPosicion(medicoPosicion);

                    PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                    Persona persona = personaServicioImpl.mostrarPersona(medico.getIdPersona());
                    persona.setNombre(nombre);
                    persona.setPrimerApellido(primerApellido);
                    persona.setSegundoApellido(segundoApellido);
                    persona.setCorreo(correo);
                    persona.setTelefono(telefono);
                    boolean personaBoolean = personaServicioImpl.actualizarPersonaMedico(persona);

                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(medico.getIdCuenta());
                    cuenta.setUsuario(usuario);
                    boolean cuentaBoolean = cuentaServicioImpl.actualizarCuenta(cuenta);

                    Empleado empleado = empleadoServicioImpl.mostrarEmpleado(medico.getIdEmpleado());
                    empleado.setNoEmpleado(noEmpleado);
                    boolean empleadoBoolean = empleadoServicioImpl.actualizarEmpleado(empleado);

                    if (medicoEspecialidadBoolean || personaBoolean || cuentaBoolean || empleadoBoolean) {
                        System.out.println("Actualizado exitoso");
                    } else {
                        System.out.println("MedicoEspecialidad: " + medicoEspecialidadBoolean);
                        System.out.println("Persona: " + personaBoolean);
                        System.out.println("Cuenta: " + cuentaBoolean);
                        System.out.println("Empleado: " + empleadoBoolean);
                        System.out.println("Actualizado no exitoso o, no se cambió nada");
                    }

                    if (medicoPosicionBoolean || personaBoolean || cuentaBoolean || empleadoBoolean) {
                        System.out.println("Actualizado exitoso");
                    } else {
                        System.out.println("MedicoEspecialidad: " + medicoPosicionBoolean);
                        System.out.println("Persona: " + personaBoolean);
                        System.out.println("Cuenta: " + cuentaBoolean);
                        System.out.println("Empleado: " + empleadoBoolean);
                        System.out.println("Actualizado no exitoso o, no se cambió nada");
                    }
                }
                break;
                case "obtener-paciente": {

                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                    InformacionGeneralPersona datos = personaServicio.mostrarInformacionGeneralPersona(idPaciente);

                    System.out.println("estadoCivil: " + datos.getIdEstadoCivil());
                    System.out.println("estado: " + datos.getIdEstado());

                    PrintWriter out = response.getWriter();
                    out.print(new Gson().toJson(datos));

                    break;

                }
                case "obtener-navegadora": {
                    int idNavegadora = Integer.valueOf(request.getParameter("idNavegadora"));

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador navegadora = empleadoServicioImpl.mostrarMedicoAdministrador(idNavegadora, 4);//4 ES EL ROL DE LA NAVEGADORA

                    PrintWriter out = response.getWriter();
                    out.print(new Gson().toJson(navegadora));
                    break;
                }
                case "actualiza-navegadora": {
                    System.out.println("Actualizar navegadora");
                    int idNavegadora = Integer.valueOf(request.getParameter("idNavegadora"));
                    String nombre = request.getParameter("nombre");
                    String telefono = request.getParameter("telefono");
                    String primerApellido = request.getParameter("primerApellido");
                    String segundoApellido = request.getParameter("segundoApellido");
                    String correo = request.getParameter("correo");
                    String noEmpleado = request.getParameter("noEmpleado");
                    String especialidad = request.getParameter("especialidad");
                    String cedula = request.getParameter("cedula");
                    String usuario = noEmpleado;

                    System.out.println("Id navegadora ".concat(String.valueOf(idNavegadora)));
                    System.out.println("nombre ".concat(nombre));
                    System.out.println("telefono ".concat(telefono));
                    System.out.println("primer apellido ".concat(primerApellido));
                    System.out.println("segundo apellido ".concat(segundoApellido));
                    System.out.println("correo ".concat(correo));
                    System.out.println("no empleado ".concat(noEmpleado));
                    System.out.println("especiaidad ".concat(especialidad));
                    System.out.println("Cedula ".concat(cedula));
                    System.out.println("Usuario ".concat(usuario));

                    PrintWriter out = response.getWriter();

                    EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                    TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idNavegadora, 4);//El 3 significa rol de médico

                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                    Especialidad especialidadMedicos = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);

                    MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl();
                    MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(idNavegadora);
                    medicoEspecialidad.setIdEspecialidad(especialidadMedicos.getIdEspecialidad());

                    System.out.println(" adminiController navegadora especialidad ".concat(String.valueOf(medicoEspecialidad.getIdEmpleado())));
                    boolean medicoEspecialidadBoolean = medicoEspecialidadServicioImpl.actualizarMedicoEspecialidad(medicoEspecialidad);

                    PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                    Persona persona = personaServicioImpl.mostrarPersona(medico.getIdPersona());
                    persona.setNombre(nombre);
                    persona.setPrimerApellido(primerApellido);
                    persona.setSegundoApellido(segundoApellido);
                    persona.setCorreo(correo);
                    persona.setTelefono(telefono);
                    boolean personaBoolean = personaServicioImpl.actualizarPersonaMedico(persona);

                    CuentaServicioImpl cuentaServicioImpl = new CuentaServicioImpl();
                    Cuenta cuenta = cuentaServicioImpl.mostrarCuenta(medico.getIdCuenta());
                    cuenta.setUsuario(usuario);
                    boolean cuentaBoolean = cuentaServicioImpl.actualizarCuenta(cuenta);

                    Empleado empleado = empleadoServicioImpl.mostrarEmpleado(medico.getIdEmpleado());
                    empleado.setNoEmpleado(noEmpleado);
                    boolean empleadoBoolean = empleadoServicioImpl.actualizarEmpleado(empleado);

                    if (medicoEspecialidadBoolean && personaBoolean && cuentaBoolean && empleadoBoolean) {
                        System.out.println("Actualizado exitoso");
                    } else {
                        System.out.println("MedicoEspecialidad: " + medicoEspecialidadBoolean);
                        System.out.println("Persona: " + personaBoolean);
                        System.out.println("Cuenta: " + cuentaBoolean);
                        System.out.println("Empleado: " + empleadoBoolean);
                        System.out.println("Actualizado no exitoso o, no se cambió nada");
                    }
                }
                break;

                case "eliminarEmpleado": {
                    System.out.println("Case para borrar a un empleado (cuenta y persona)");

                    /**
                     * Elimino la cuenta y persona del empleado obtenido
                     */
                    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    System.out.println("idEmpleado: " + idEmpleado);

                    int idEmpleadoS = (int) sesion.getAttribute("idEmpleado");                    
                    
                    Cuenta cuentaNav;

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();
                    cuentaNav = cuentaServicio.mostrarCuentaidEmpleado(idEmpleado);

                    int idCuenta = cuentaNav.getIdCuenta();
                    int idPersona = cuentaNav.getIdPersona();

                    if (cuentaNav != null) {
                        cuentaServicio.borradoLogicoCuenta(idCuenta);
                    }
                    if (idPersona != 0) {
                        personaServicio.borradoLogicoPersona(idPersona);
                    }

                    System.out.println("SUPUESTAMENTE YA LA BORRÓ");
                    
                    if(idEmpleadoS == idEmpleado){                        
                        System.out.println("Me borré a mi mismo '・o・'");
                        
                        PrintWriter out = response.getWriter();
                        out.print("meBorre");
                    }

                    break;
                }
                
                case "verificarRelacion": {
                    System.out.println("Case para ver si un médico tiene relación con algún paciente");

                    /**
                     * Manda a llamar al servicio de empleado y revisa si el médico tiene o no relación
                     * con algún paciente
                     */
                    int idEmpleado = Integer.parseInt(request.getParameter("idEmpleado"));
                    System.out.println("idEmpleado: " + idEmpleado);

                    EmpleadoServicioImpl empleadoServicio = new EmpleadoServicioImpl();
                    boolean relacion = empleadoServicio.relacionMedicoPaciente(idEmpleado);                    
                    
                    PrintWriter out = response.getWriter();
                    
                    if(relacion){
                        out.print("relacionExistente");
                    }
                    else{
                        out.print("relacionNoExistente");
                    }

                    break;
                }

                case "ReportePoblacion": {
                    try{
                        GeneralPoblacionServicioImpl MyTable = new GeneralPoblacionServicioImpl();
                        ArrayList<ArrayList<String>> myArrayList = MyTable.mostrarPoblacionGeneral();
                        response.setContentType("application/octet-stream");
                        response.setHeader("Content-Disposition", "attachment;filename=reportePoblacion.xls");
                        OutputStream os = response.getOutputStream();
                        ExcelExport.export("Poblacion",os, myArrayList);
                        os.flush();
                        os.close();
                    }catch(IOException ex){
                        System.out.print(this.getClass().toString().concat(ex.getMessage()));
                    } 
                    break;
                }
                      
                case "ActualizarReportePoblacion": {
                    try{
                        GeneralPoblacionServicioImpl MyTable = new GeneralPoblacionServicioImpl();
                        if(MyTable.actualizarPoblacionGeneral()){
                            System.out.println("YA CARGÓ");
                        }                        
                        PrintWriter out = response.getWriter();
                        out.print("Actualizado");
                    }catch(IOException ex){
                        System.out.print(this.getClass().toString().concat(ex.getMessage()));
                    } 
                    break;
                }

                case "autocompletarEspecialidades": {
                    EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                    List<Especialidad> especialidades = especialidadServicioImpl.mostrarEspecialidad();

                    PrintWriter out = response.getWriter();

                    Gson json = new Gson();
                    out.print(json.toJson(especialidades));
                    break;
                }
                case "autocompletarPosiciones": {

                    PosicionServicioImpl posiciones = new PosicionServicioImpl();
                    List<Posicion> posicion = posiciones.mostrarPosicion();

                    PrintWriter out = response.getWriter();
                    Gson json = new Gson();
                    out.print(json.toJson(posicion));

                    break;
                }

                case "cambiarContrasena": {

                    if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
                        // request.setAttribute("status", "");
                        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
                        return;
                    } else {
                        int idCuenta = (int) sesion.getAttribute("idCuenta");
                        String contrasena = request.getParameter("password");
                        String contrasena2 = request.getParameter("password2");

                        System.out.println("pass1: " + contrasena);
                        System.out.println("pass2: " + contrasena2);

                        if (contrasena.equals(contrasena2)) {

                            CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                            Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                            cuenta.setPassword(contrasena);

                            cuentaServicio.actualizarCuenta(cuenta);
                            PrintWriter out = response.getWriter();
                            out.print("success");
                        }

                    }

                    break;
                }
                case "reasignarPacientes":
                {
                    int idMedico1 =  Integer.parseInt(request.getParameter("doctor1"));
                    int idMedico2 =  Integer.parseInt(request.getParameter("doctor2"));
                    
                    System.out.println("Medico1 ".concat(String.valueOf(idMedico1)));
                    System.out.println("Medico2 ".concat(String.valueOf(idMedico2)));
                    
                    MedicoPacienteServicioImpl medicoPacienteServicioImpl = new MedicoPacienteServicioImpl();
                    int registrosCambiados = medicoPacienteServicioImpl.reasignarMedicoPaciente(idMedico1, idMedico2);
                                        
                    PrintWriter out = response.getWriter();
                    out.print(registrosCambiados);
                    
                    break;
                }

                case "actualizar-paciente": {

                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                    InformacionGeneralPersona datos = new InformacionGeneralPersona();

                    String nombre = request.getParameter("nombre");
                    String apellido1 = request.getParameter("apellido1");
                    String apellido2 = request.getParameter("apellido2");
                    String curp = request.getParameter("curp");
                    String fechaNacimiento = request.getParameter("fechaNacimiento");
                    String usuario = request.getParameter("usuario");
                    int estadoCivil = Integer.parseInt(request.getParameter("estadoCivil"));
                    String calle = request.getParameter("calle");
                    String noInterior = request.getParameter("noInterior");
                    String noExterior = request.getParameter("noExterior");
                    int estado = Integer.parseInt(request.getParameter("estado"));
                    int municipio = Integer.parseInt(request.getParameter("municipio"));
                    String telefono = request.getParameter("telefono");
                    String correo = request.getParameter("correo");
                    String colonia = request.getParameter("colonia");

                    Date fn = Date.valueOf(fechaNacimiento);

                    datos.setNombre(nombre);
                    datos.setPrimerApellido(apellido1);
                    datos.setSegundoApellido(apellido2);
                    datos.setCurp(curp);
                    datos.setFechaNacimiento(fn);
                    datos.setUsuario(usuario);
                    datos.setIdEstadoCivil(estadoCivil);
                    datos.setCalle(calle);
                    datos.setNoInt(noInterior);
                    datos.setNoExt(noExterior);
                    datos.setIdEstado(estado);
                    datos.setIdMunicipio(municipio);
                    datos.setTelefono(telefono);
                    datos.setCorreo(correo);
                    datos.setColonia(colonia);

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                    personaServicio.actualizarInformacionGeneralPersona(idPaciente, datos);

                    break;

                }

                case "eliminar-paciente": {

                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                    System.out.println("idPaciente: " + idPaciente);

                    PacienteServiceImpl pacienteServicioP = new PacienteServiceImpl();

                    int idCuenta = pacienteServicioP.obtenerCuenta(idPaciente);
                    int idPersona = pacienteServicioP.obtenerPersona(idCuenta);

                    System.out.println(idPaciente);
                    System.out.println(idCuenta);
                    System.out.println(idPersona);

                    /**
                     * creo los objetos de las tablas a modificar su estatus
                     */
                    /**
                     * Se comprueba que los objetos no sean nulos o vacios para
                     * crearlos al crearlos si tienen dependencia ciclan para
                     * buscar todos los datos que tienen encadenados para
                     * proseguir con el borrado logico en la base de datos
                     */
                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                    PersonaServicioImpl personaServicio = new PersonaServicioImpl();

                    Persona persona = personaServicio.mostrarPersona(idPersona);
                    personaServicio.borradoLogicoPersona(persona.getIdPersona());

                    PacienteServiceImpl pacienteServicio = new PacienteServiceImpl();
                    if (pacienteServicio.mostrarPaciente(idPaciente) != null) {

                        Paciente paciente = pacienteServicio.mostrarPaciente(idPaciente);
                        pacienteServicio.borradoLogicoPaciente(idPaciente);
                    }

                    LoginServicioImpl loginServicio = new LoginServicioImpl();
                    if (loginServicio.mostrarLoginIdCuenta(idCuenta) != null) {
                        Login login = loginServicio.mostrarLoginIdCuenta(idCuenta);
                        loginServicio.borradoLogicoLogin(login.getIdLogin());
                    }

                    DireccionServicioImpl direccionServicio = new DireccionServicioImpl();
                    if (direccionServicio.mostrarDireccion(persona.getIdDireccion()) != null) {
                        Direccion direccion = direccionServicio.mostrarDireccion(persona.getIdDireccion());
                        direccionServicio.borradoLogicoDireccion(direccion.getIdDireccion());
                    }
                    PicServicioImpl picServicio = new PicServicioImpl();
                    if (picServicio.mostrarPic(idPersona) != null) {
                        Pic pic = picServicio.mostrarPic(idPersona);
                        picServicio.borradoLogicoPic(pic.getIdPic());
                    }
                    EstadoPacientePacienteServiceImpl estadoPacientePacienteServicio = new EstadoPacientePacienteServiceImpl();
                    if (estadoPacientePacienteServicio.mostrarEstadoPacientePacienteIdPaciente(idPaciente) != null) {
                        EstadoPacientePaciente estadoPacientePaciente = estadoPacientePacienteServicio.mostrarEstadoPacientePacienteIdPaciente(idPaciente);
                        estadoPacientePacienteServicio.borradoLogicoEstadoPacientePaciente(estadoPacientePaciente.getIdEstadoPacientePaciente());
                    }
                    System.out.println("precitas");
                    CitaServicioImpl citaServicio = new CitaServicioImpl();
                    if (citaServicio.mostrarCitaIdEspecifico(idPaciente) != null) {

                        List<Cita> citas = new ArrayList<>();

                        citas = citaServicio.mostrarCitaIdEspecifico(idPaciente);
                        int citasTotales = citas.size() - 1;

                        int idCita = 0;
                        while (citasTotales > -1) {

                            System.out.println(citasTotales);
                            idCita = citas.get(citasTotales).getIdCita();

                            System.out.println(idCita);

                            ComentarioCitaServicioImpl comentarioCitaServicio = new ComentarioCitaServicioImpl();
                            if (comentarioCitaServicio.mostrarComentarioCitaIdCita(idCita) != null) {
                                ComentarioCita comentarioCita = comentarioCitaServicio.mostrarComentarioCitaIdCita(idCita);
                                comentarioCitaServicio.borradoLogicoComentarioCita(comentarioCita.getIdComentarioCita());
                            }

                            CitaEmpleadoServicioImpl citaEmpleadoServicio = new CitaEmpleadoServicioImpl();
                            if (citaEmpleadoServicio.mostrarCitaEmpleadoIdCita(idCita) != null) {
                                CitaEmpleado citaEmpleado = citaEmpleadoServicio.mostrarCitaEmpleadoIdCita(idCita);
                                citaEmpleadoServicio.borradoLogicoCitaEmpleado(citaEmpleado.getIdCitaEmpleado());
                            }

                            LlamadaCitaServicioImpl llamadaCitaServicio = new LlamadaCitaServicioImpl();
                            if (llamadaCitaServicio.mostrarLlamadaCitaIdCita(idCita) != null) {
                                LlamadaCita llamadaCita = llamadaCitaServicio.mostrarLlamadaCitaIdCita(idCita);
                                llamadaCitaServicio.borradoLogicoLlamadaCita(llamadaCita.getIdLlamadaCita());
                            }

                            citaServicio.borradoLogicoCita(idCita);

                            citasTotales = citasTotales - 1;
                            System.out.println(citasTotales);
                        }
                    }
                    System.out.println("poscitas");
                    PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicio = new PacienteMedicoTitularServicioImpl();
                    if (pacienteMedicoTitularServicio.mostrarPacienteMedicoTitularIdPaciente(idPaciente) != null) {
                        PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicio.mostrarPacienteMedicoTitularIdPaciente(idPaciente);
                        pacienteMedicoTitularServicio.borradoLogicoPacienteMedicoTitular(pacienteMedicoTitular.getIdPacienteMedicoTitular());
                    }

                    PacienteNavegadoraServicioImpl pacienteNavegadoraServicio = new PacienteNavegadoraServicioImpl();
                    if (pacienteNavegadoraServicio.mostrarPacienteNavegadoraIdPaciente(idPaciente) != null) {
                        PacienteNavegadora pacienteNavegadora = pacienteNavegadoraServicio.mostrarPacienteNavegadoraIdPaciente(idPaciente);
                        pacienteNavegadoraServicio.borradoLogicoPacienteNavegadora(pacienteNavegadora.getIdPacienteNavegadora());

                    }
                    DocumentoInicialServicioImpl documentoInicialServicio = new DocumentoInicialServicioImpl();
                    if (documentoInicialServicio.mostrarDocumentoInicialIdPaciente(idPaciente) != null) {
                        DocumentoInicial documentoInicial = documentoInicialServicio.mostrarDocumentoInicialIdPaciente(idPaciente);
                        documentoInicialServicio.borradoLogicoDocumentoInicial(documentoInicial.getIdDocumentoInicial());

                    }
                    PacienteNecesidadEspecialServicioImpl pacienteNecesidadEspecialServicio = new PacienteNecesidadEspecialServicioImpl();
                    if (pacienteNecesidadEspecialServicio.mostrarPacienteNecesidadEspecialIdPaciente(idPaciente) != null) {
                        PacienteNecesidadEspecial pacienteNecesidadEspecial = pacienteNecesidadEspecialServicio.mostrarPacienteNecesidadEspecialIdPaciente(idPaciente);
                        pacienteNecesidadEspecialServicio.borradoLogicoPacienteNecesidadEspecial(pacienteNecesidadEspecial.getIdNecesidadEspecial());

                    }
                    PacienteAlergiaServicioImpl pacienteAlergiaServicio = new PacienteAlergiaServicioImpl();
                    if (pacienteAlergiaServicio.mostrarPacienteAlergiaIdPaciente(idPaciente) != null) {
                        PacienteAlergia pacienteAlergia = pacienteAlergiaServicio.mostrarPacienteAlergiaIdPaciente(idPaciente);
                        pacienteAlergiaServicio.borradoLogicoPacienteAlergia(pacienteAlergia.getIdPacienteAlergia());
                    }

                    DocumentoEstudioServicioImpl documentoEstudioServicio = new DocumentoEstudioServicioImpl();
                    if (documentoEstudioServicio.mostrarDocumentoEstudioIdEspecifico(idPaciente) != null) {
                        List<DocumentoEstudio> docuemntoEstudios = new ArrayList<>();
                        docuemntoEstudios = documentoEstudioServicio.mostrarDocumentoEstudioIdEspecifico(idPaciente);
                        int documentosTotales = docuemntoEstudios.size() - 1;
                        int idDocumento = 0;
                        while (documentosTotales > -1) {
                            idDocumento = docuemntoEstudios.get(documentosTotales).getIdDocumentoEstudio();
                            documentoEstudioServicio.borradoLogicoDocumentoEstudio(idDocumento);
                            documentosTotales = documentosTotales - 1;
                        }
                    }

                    PacienteSeguroServicioImpl pacienteSeguroServicio = new PacienteSeguroServicioImpl();
                    if (pacienteSeguroServicio.mostrarPacienteSeguroIdEspecifico(idPaciente) != null) {
                        List<PacienteSeguro> seguros = new ArrayList<>();
                        seguros = pacienteSeguroServicio.mostrarPacienteSeguroIdEspecifico(idPaciente);
                        int segurosTotales = seguros.size() - 1;
                        int idSeguro = 0;
                        while (segurosTotales > -1) {
                            idSeguro = seguros.get(segurosTotales).getIdPacienteSeguro();
                            pacienteSeguroServicio.borradoLogicoPacienteSeguro(idSeguro);
                            segurosTotales = segurosTotales - 1;
                        }

                    }

                    BiopsiaServicioImpl biopsiaServicio = new BiopsiaServicioImpl();
                    if (biopsiaServicio.mostrarAllBiopsiaIdEspecifico(idPaciente) != null) {
                        List<Biopsia> biopsias = new ArrayList<>();
                        biopsias = biopsiaServicio.mostrarAllBiopsiaIdEspecifico(idPaciente);
                        int biopsiasTotales = biopsias.size() - 1;
                        int idBiopsia = 0;
                        while (biopsiasTotales > -1) {
                            idBiopsia = biopsias.get(biopsiasTotales).getIdBiopsia();
                            OtroResultadoPatologiaServicioImpl otroResultadoPatologiaServicio = new OtroResultadoPatologiaServicioImpl();
                            if (otroResultadoPatologiaServicio.mostrarOtroResultadoPatologiaIdBiopsia(idBiopsia) != null) {
                                OtroResultadoPatologia otroResultadoPatologia = otroResultadoPatologiaServicio.mostrarOtroResultadoPatologiaIdBiopsia(idBiopsia);
                                otroResultadoPatologiaServicio.borradoLogicoOtroResultadoPatologia(otroResultadoPatologia.getIdOtroResultadoPatologia());

                            }
                            biopsiaServicio.borradoLogicoBiopsia(idBiopsia);
                            biopsiasTotales = biopsiasTotales - 1;
                        }

                    }

                    TratamientoPacienteServiceImpl tratamientoPacienteServicio = new TratamientoPacienteServiceImpl();
                    if (tratamientoPacienteServicio.mostrarTratamientoPacienteIdEspecifico(idPaciente) != null) {
                        List<TratamientoPaciente> tratamientos = new ArrayList<>();
                        tratamientos = tratamientoPacienteServicio.mostrarTratamientoPacienteIdEspecifico(idPaciente);
                        int tratamientosTotales = tratamientos.size() - 1;
                        int idTratamiento = 0;
                        while (tratamientosTotales > -1) {
                            idTratamiento = tratamientos.get(idTratamiento).getIdTipoTratamiento();
                            AuditoriaTratamientoPacienteServiceImpl auditoriaTratamientoPacienteServicio = new AuditoriaTratamientoPacienteServiceImpl();

                            if (auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPacienteIdTratamiento(idTratamiento) != null) {
                                AuditoriaTratamientoPaciente auditoriaTratamientoPaciente = auditoriaTratamientoPacienteServicio.mostrarAuditoriaTratamientoPacienteIdTratamiento(idTratamiento);
                                auditoriaTratamientoPacienteServicio.borradoLogicoAuditoriaTratamientoPaciente(auditoriaTratamientoPaciente.getIdAuditoriaTratamientoPaciente());

                            }
                            tratamientoPacienteServicio.borradoLogicoTratamientoPaciente(idTratamiento);
                            tratamientosTotales = tratamientosTotales - 1;
                        }

                    }

                    ProgramaPacienteServicioImpl programaPacienteServicio = new ProgramaPacienteServicioImpl();
                    if (programaPacienteServicio.mostrarProgramaPacienteIdPaciente(idPaciente) != null) {
                        List<ProgramaPaciente> programas = new ArrayList<>();
                        programas = programaPacienteServicio.mostrarProgramaPacienteSeguroIdEspecifico(idPaciente);
                        int programasTotales = programas.size() - 1;
                        int idPrograma = 0;
                        while (programasTotales > -1) {
                            idPrograma = programas.get(programasTotales).getIdProgramaPaciente();
                            programaPacienteServicio.borradoLogicoProgramaPaciente(idPrograma);
                            programasTotales = programasTotales - 1;
                        }
                    }

                    PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServicio = new PacienteTratamientoPrevioServiceImpl();
                    if (pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevioIdPaciente(idPaciente) != null) {
                        List<PacienteTratamientoPrevio> tratamientos = new ArrayList<>();
                        tratamientos = pacienteTratamientoPrevioServicio.mostrarPacienteTratamientoPrevioIdEspecifico(idPaciente);
                        int tratamientosTotales = tratamientos.size() - 1;
                        int idTratamiento = 0;
                        while (tratamientosTotales > - 1) {
                            idTratamiento = tratamientos.get(tratamientosTotales).getIdPacienteTratamientoPrevio();
                            pacienteTratamientoPrevioServicio.borradoLogicoPacienteTratamientoPrevio(idTratamiento);
                            tratamientosTotales = tratamientosTotales - 1;
                        }
                    }

                    AlergiaPacienteFarmacoServiceImpl alergiaPacienteFarmacoServicio = new AlergiaPacienteFarmacoServiceImpl();
                    if (alergiaPacienteFarmacoServicio.mostrarAlergiaPacienteFarmacoIdPaciente(idPaciente) != null) {
                        List< AlergiaPacienteFarmaco> alergias = new ArrayList<>();
                        alergias = alergiaPacienteFarmacoServicio.mostrarAlergiaPacienteFarmacoIdEspecifico(idPaciente);
                        int alergiasTotales = alergias.size() - 1;
                        int idAlergias = 0;
                        while (alergiasTotales > - 1) {
                            idAlergias = alergias.get(alergiasTotales).getIdAlergiaPacienteFarmaco();
                            alergiaPacienteFarmacoServicio.borradoLogicoAlergiaPacienteFarmaco(idAlergias);
                            alergiasTotales = alergiasTotales - 1;
                        }
                    }

                    RegistroDiagnosticoServiceImpl registroDiagnosticoServicio = new RegistroDiagnosticoServiceImpl();
                    if (registroDiagnosticoServicio.mostrarRegistroDiagnosticoPaciente(idPaciente) != null) {
                        List< RegistroDiagnostico> registros = new ArrayList<>();
                        registros = registroDiagnosticoServicio.mostrarRegistroDiagnosticoIdEspecifico(idPaciente);
                        int registrosTotales = registros.size() - 1;
                        int idRegistro = 0, idEstadiaje = 0;
                        while (registrosTotales > - 1) {
                            idRegistro = registros.get(registrosTotales).getIdRegistroDiagnostico();
                            idEstadiaje = registros.get(registrosTotales).getIdRegistroTNM();

                            EstadiajeTNMServiceImpl estadiajeTNMServicio = new EstadiajeTNMServiceImpl();
                            if (estadiajeTNMServicio.mostrarEstadiajeTNM(idEstadiaje) != null) {
                                estadiajeTNMServicio.borradoLogicoEstadiajeTNM(idEstadiaje);

                            }

                            AuditoriaRegistroDiagnosticoServiceImpl auditoriaRegistroDiagnosticoServicio = new AuditoriaRegistroDiagnosticoServiceImpl();
                            if (auditoriaRegistroDiagnosticoServicio.mostrarAuditoriaRegistroDiagnosticoIdRegistro(idRegistro) != null) {
                                AuditoriaRegistroDiagnostico auditoriaRegistro = auditoriaRegistroDiagnosticoServicio.mostrarAuditoriaRegistroDiagnosticoIdRegistro(idRegistro);
                                auditoriaRegistroDiagnosticoServicio.borradoLogicoAuditoriaRegistroDiagnostico(auditoriaRegistro.getIdAuditoriaRegistroDiagnostico());
                            }

                            registroDiagnosticoServicio.borradoLogicoRegistroDiagnostico(idRegistro);
                            registrosTotales = registrosTotales - 1;
                        }
                    }

                    if (cuentaServicio.mostrarCuenta(idCuenta) != null) {
                        Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                        cuentaServicio.borradoLogicoCuenta(cuenta.getIdCuenta());
                    }

                    break;

                }
                case "setIdSesion": {
                   
                    int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));
                    int idPersona = (int) sesion.getAttribute("idPersona");

                    Empleado empleado;
                    EmpleadoServicioImpl empleadoServicio = new EmpleadoServicioImpl();
                    empleado = empleadoServicio.mostrarEmpleadoPersona(idPersona);

                    int idEmpleado = empleado.getIdEmpleado();

                    sesion.setAttribute("idPaciente", idPaciente);
                    sesion.setAttribute("idEmpleado", idEmpleado);
                    
                    break;
                }

            }

        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
