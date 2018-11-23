/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.print.Printer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.moduloGestionMedico.Especialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.MedicoEspecialidad;
import mx.itesm.sapi.bean.moduloGestionMedico.Posicion;
import mx.itesm.sapi.bean.moduloGestionMedico.TablaMedicoAdministrador;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EspecialidadServicioImpl;
import mx.itesm.sapi.service.moduloGestionMedico.MedicoEspecialidadServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.service.moduloGestionMedico.PosicionServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;

/**
 *
 * @author urieldiaz
 */
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
        
        HttpSession sesion = request.getSession(true);
        
        if(sesion.getAttribute("idCuenta") == null)
        {
              request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
              System.out.println("Sin sesión");
        }else
        {
                switch(key)
                {
                    case "obtener-medico":
                    {
                        int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedicoAdministrador"));
                        
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador,3);//3 ES EL ROL DEL MÉDICO.
                                                                        
                        PrintWriter out = response.getWriter();
                        out.print(new Gson().toJson(medico));                        
                        break;
                    }
                    case "actualizar-medico":
                    {
                        System.out.println("Actualizar médico");
                        int idMedicoAdministrador = Integer.valueOf(request.getParameter("idMedico"));
                        String nombre = request.getParameter("nombre");
                        String primerApellido = request.getParameter("primerApellido");
                        String segundoApellido = request.getParameter("segundoApellido");
                        String correo = request.getParameter("correo");
                        String telefono = request.getParameter("telefono");
                        String noEmpleado = request.getParameter("noEmpleado");
                        String especialidad = request.getParameter("especialidad");
                        String usuario = request.getParameter("usuario");
                        String cedula = request.getParameter("cedula");
                         
                        System.out.println("idMEdico admin ".concat(String.valueOf(idMedicoAdministrador)));
                        System.out.println("nombre ".concat(nombre));
                        System.out.println("apellido 1 ".concat(primerApellido));
                        System.out.println("apellido 2 ".concat(segundoApellido));
                        System.out.println("correo  ".concat(correo));
                        System.out.println("telefeno ".concat(telefono) );
                        System.out.println("noEmpleado ".concat(noEmpleado));
                        System.out.println("especialidad ".concat(especialidad));
                        System.out.println("usuario ".concat(usuario));
                        System.out.println("cedula ".concat(cedula));
                        
                        
                        PrintWriter out = response.getWriter();
                        
                                                
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idMedicoAdministrador,3);//El 3 significa rol de médico
                                                
                        EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                        Especialidad especialidadMedicos = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);
                        
                        MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl ();
                        MedicoEspecialidad medicoEspecialidad = medicoEspecialidadServicioImpl.mostrarMedicoEspecialidadEmpleado(idMedicoAdministrador);
                        medicoEspecialidad.setCedulaProfesional(cedula);
                        medicoEspecialidad.setIdEspecialidad(especialidadMedicos.getIdEspecialidad());
                        System.out.println(" adminiController medicoEspecialidad ".concat(String.valueOf(medicoEspecialidad.getIdEmpleado())));
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
                                                                        
                        
                        if(medicoEspecialidadBoolean || personaBoolean || cuentaBoolean || empleadoBoolean)
                        {
                            System.out.println("Actualizado exitoso");
                        }
                        else
                        {
                            System.out.println("MedicoEspecialidad: " + medicoEspecialidadBoolean);
                            System.out.println("Persona: " + personaBoolean);
                            System.out.println("Cuenta: " + cuentaBoolean);
                            System.out.println("Empleado: " + empleadoBoolean);
                            System.out.println("Actualizado no exitoso o, no se cambió nada");
                        }                        
                    }
                    break;
                    case "obtener-navegadora":
                    {
                        int idNavegadora = Integer.valueOf(request.getParameter("idNavegadora"));
                        
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador navegadora = empleadoServicioImpl.mostrarMedicoAdministrador(idNavegadora,4);//4 ES EL ROL DE LA NAVEGADORA
                                                                        
                        PrintWriter out = response.getWriter();
                        out.print(new Gson().toJson(navegadora));                        
                        break;
                    }
                    case "actualiza-navegadora":
                    {
                        System.out.println("Actualizar navegadora");
                        int idNavegadora = Integer.valueOf(request.getParameter("idNavegadora"));
                        String nombre = request.getParameter("nombre");
                        String telefono = request.getParameter("telefono");
                        String primerApellido = request.getParameter("primerApellido");
                        String segundoApellido = request.getParameter("segundoApellido");
                        String correo = request.getParameter("correo");
                        String noEmpleado = request.getParameter("noEmpleado");
                        String especialidad = request.getParameter("especialidad");
                        String usuario = request.getParameter("usuario");
                        
                        System.out.println("Id navegadora ".concat(String.valueOf(idNavegadora)));
                        System.out.println("nombre ".concat(nombre));
                        System.out.println("telefono ".concat(telefono));
                        System.out.println("primer apellido ".concat(primerApellido));
                        System.out.println("segundo apellido ".concat(segundoApellido));
                        System.out.println("correo ".concat(correo));
                        System.out.println("no empleado ".concat(noEmpleado));
                        System.out.println("especiaidad ".concat(especialidad));
                        System.out.println("Usuario ".concat(usuario));
                                                
                        PrintWriter out = response.getWriter();                        
                                                
                        EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                        TablaMedicoAdministrador medico = empleadoServicioImpl.mostrarMedicoAdministrador(idNavegadora,4);//El 3 significa rol de médico
                                                
                        EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                        Especialidad especialidadMedicos = especialidadServicioImpl.mostrarEspecialidadPorNombre(especialidad);
                        
                        MedicoEspecialidadServicioImpl medicoEspecialidadServicioImpl = new MedicoEspecialidadServicioImpl ();
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
                                                                                                
                        if(medicoEspecialidadBoolean && personaBoolean && cuentaBoolean && empleadoBoolean)
                        {
                            out.print("1");
                        }
                        else
                        {
                            out.print("0");
                        }                        
                        break;
                    }
                    
                     case "ReportePoblacion": {
                /** Author Angel Gtz 
                 * 
                 * Toma datos de todos los pacientes para crear un estudio de la poblacion del INCAN
                 * Mostrando:
                 *  Nombre
Primer Apellido
Segundo apellido CURP Codigo postal Estado Municipio
Fecha de nacimiento Estado civil Sexo
Nivel educativo
Motivo de consulta
Medico adscrito
Adscrito presente
Medico radiologo
Radiologo presente
Compañia seguro

                 * 
                 */
                
                        PersonaServicioImpl personaServicio = new PersonaServicioImpl();
                        Persona persona = personaServicio.mostrarPersona(2);
                
                        break;
                    }
                     
                     case "autocompletarEspecialidades":
                     {
                         EspecialidadServicioImpl especialidadServicioImpl = new EspecialidadServicioImpl();
                         List<Especialidad> especialidades = especialidadServicioImpl.mostrarEspecialidad();
                         
                         PrintWriter out = response.getWriter();
                         
                         Gson json = new Gson();
                         out.print(json.toJson(especialidades));                         
                         break;
                     }
                     case "autocompletarPosiciones":
                     {
                         
                         PosicionServicioImpl posiciones = new PosicionServicioImpl();
                         List<Posicion> posicion = posiciones.mostrarPosicion();
                         
                         PrintWriter out = response.getWriter();
                         Gson json = new Gson();
                         out.print(json.toJson(posicion));
                                                  
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