/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import mx.itesm.sapi.bean.diagnostico.EstadiajeTNM;
import mx.itesm.sapi.bean.diagnostico.RegistroDiagnostico;
import mx.itesm.sapi.bean.gestionPaciente.Alergia;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;
import mx.itesm.sapi.bean.gestionPaciente.BloqueParafina;
import mx.itesm.sapi.bean.gestionPaciente.CategoriaEstudio;
import mx.itesm.sapi.bean.gestionPaciente.Cita;
import mx.itesm.sapi.bean.gestionPaciente.ComentarioCita;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicial;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;
import mx.itesm.sapi.bean.gestionPaciente.Escolaridad;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPaciente;
import mx.itesm.sapi.bean.gestionPaciente.EstadoPacientePaciente;
import mx.itesm.sapi.bean.gestionPaciente.Estudio;
import mx.itesm.sapi.bean.gestionPaciente.Laminilla;
import mx.itesm.sapi.bean.gestionPaciente.LlamadaCita;
import mx.itesm.sapi.bean.gestionPaciente.LugarDelCuerpo;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAlergia;
import mx.itesm.sapi.bean.gestionPaciente.PacienteMedicoTitular;
import mx.itesm.sapi.bean.gestionPaciente.PacienteSeguro;
import mx.itesm.sapi.bean.gestionPaciente.ProgramaPaciente;
import mx.itesm.sapi.bean.gestionPaciente.Seguro;
import mx.itesm.sapi.bean.gestionPaciente.TipoHistologico;
import mx.itesm.sapi.bean.gestionTratamiento.PacienteTratamientoPrevio;
import mx.itesm.sapi.bean.gestionTratamiento.TipoTratamiento;
import mx.itesm.sapi.bean.gestionTratamiento.Tratamiento;
import mx.itesm.sapi.bean.moduloGestionMedico.Empleado;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.bean.persona.Persona;
import mx.itesm.sapi.bean.persona.Pic;
import mx.itesm.sapi.service.diagnostico.EstadiajeTNMServiceImpl;
import mx.itesm.sapi.service.diagnostico.RegistroDiagnosticoServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.AlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BiopsiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.BloqueParafinaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CategoriaEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.CitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ComentarioCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoEstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.DocumentoInicialTipoDocumentoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EscolaridadServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacientePacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.EstadoPacienteServiceImpl;
import mx.itesm.sapi.service.gestionPaciente.EstudioServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LaminillaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LlamadaCitaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.LugarDelCuerpoServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteAlergiaServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteMedicoTitularServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteSeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.PacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaPacienteServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.ProgramaServicio;
import mx.itesm.sapi.service.gestionPaciente.SeguroServicioImpl;
import mx.itesm.sapi.service.gestionPaciente.TipoHistologicoServicioImpl;
import mx.itesm.sapi.service.gestionTratamiento.PacienteTratamientoPrevioServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TipoTratamientoServiceImpl;
import mx.itesm.sapi.service.gestionTratamiento.TratamientoServiceImpl;
import mx.itesm.sapi.service.moduloGestionMedico.EmpleadoServicioImpl;
import mx.itesm.sapi.service.persona.CuentaServicioImpl;
import mx.itesm.sapi.service.persona.PersonaServicioImpl;
import mx.itesm.sapi.service.persona.PicServicioImpl;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Admin
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)

@WebServlet(name = "NavegadoraController", urlPatterns = {"/NavegadoraController"})
public class NavegadoraController extends HttpServlet {

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

        response.setContentType("text/html;charset=UTF-8");
        String key = request.getParameter("key");

        HttpSession sesion = request.getSession(true);

        if (sesion.getAttribute("idCuenta") == null) { //no tiene sesion iniciada
            // request.setAttribute("status", "");
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response); //Lo redirecciono al login
            System.out.println("estoy en el if");
            return;
        } else {

            int keyRol = (int) sesion.getAttribute("idRol");

            switch (keyRol) {

                case 4: {

                    switch (key) {

                        case "cambiarDatos": {

                            String correo = request.getParameter("correo");
                            String telefono = request.getParameter("telefono");

                            Part part = request.getPart("file-image");

                            //No se valida el telefono ni el correo aquí? Lo validamos nosotros o el front?
                            PersonaServicioImpl personaServicioImpl = new PersonaServicioImpl();
                            Persona persona = personaServicioImpl.mostrarPersona((int) sesion.getAttribute("idPersona"));

                            if ((int) part.getSize() > 0) {
                                PicServicioImpl picServiceImpl = new PicServicioImpl();
                                Pic pic = new Pic();

                                pic.setIdPersona((int) sesion.getAttribute("idPersona"));
                                pic.setContenido(part.getInputStream());
                                pic.setTamano((int) part.getSize());
                                pic.setTipo(part.getContentType());

                                picServiceImpl.agregarPic(pic);

                                InputStream imagen = pic.getContenido();
                                byte[] bytes = IOUtils.toByteArray(imagen);
                                String base64String = Base64.getEncoder().encodeToString(bytes);

                                sesion.setAttribute("base64Img", base64String);
                                System.out.println("Debió actualizar la imagen en la sesión");
                            }

                            System.out.println("Ya pase registro");

                            persona.setCorreo(correo);
                            persona.setTelefono(telefono);

                            personaServicioImpl.actualizarPersona(persona);

                            sesion.setAttribute("correo", persona.getCorreo());
                            sesion.setAttribute("telefono", persona.getTelefono());

                            request.setAttribute("correo", sesion.getAttribute("correo"));
                            request.setAttribute("telefono", sesion.getAttribute("telefono"));

                            request.getRequestDispatcher("/WEB-INF/potencial/cuentaPaciente.jsp").forward(request, response);

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

                                if (contrasena.equals(contrasena2)) {

                                    CuentaServicioImpl cuentaServicio = new CuentaServicioImpl();

                                    Cuenta cuenta = cuentaServicio.mostrarCuenta(idCuenta);

                                    cuenta.setPassword(contrasena);

                                    cuentaServicio.actualizarCuenta(cuenta);
                                }

                            }
                            break;
                        }

                        case "descargarArchivo": {

                            int idDocumento = Integer.parseInt(request.getParameter("idDocumento"));

                            System.out.println("El documento del id es: " + idDocumento);

                            DocumentoInicialServicioImpl documentoInicialServicioImpl = new DocumentoInicialServicioImpl();
                            DocumentoInicial documentoInicial = documentoInicialServicioImpl.mostrarDocumentoInicial(idDocumento);
                            OutputStream out = response.getOutputStream();

                            if (documentoInicial.getArchivo() == null) {
                                System.out.println("valio madre");
                            } else {
                                System.out.println("si hay algo");
                            }

                            response.setContentType(documentoInicial.getTipo());

                            System.out.println(documentoInicial.getTipo());
                            response.setHeader("Content-Disposition", "attachment;filename=".concat(documentoInicial.getNombre())); //Forzar descarga

                            out.write(IOUtils.toByteArray(documentoInicial.getArchivo()));
                            out.flush();

                            break;
                        }
                        case "btn-save": {

                            /* 
                            Para jalar un valor NORMAL
                            System.out.println("NavegadoraController, case: guardarP2");
                            String prz = request.getParameter("prz-expediente");
                            String tiene = request.getParameter("nivelEducativo");
                            String alergias = request.getParameter("alergias");
                            System.out.println("prz: "+ prz + ", tiene: "+ tiene+ " alergias: " +alergias);
                            break;                        
                            
                       
                            Para jalar contenido DINAMICO (se usa la key) y se recibe en un arreglo :D 
                            String[] Biopsia = request.getParameterValues("tipo-BiopsiaAdded");
                            String[] fechaBiopsia = request.getParameterValues("fecha-BipsiAdded");
                           
                            for(int i =0 ; i< Biopsia.length;i++){
                                System.out.println(Biopsia[i]);
                            }
                            */
                            int idPaciente = (int) sesion.getAttribute("idPaciente");
                            
                            PacienteServicioImpl pacienteServicioImpl = new PacienteServicioImpl();
                            Paciente paciente = pacienteServicioImpl.mostrarPaciente(idPaciente);
                            
                            if(request.getParameter("prz-expediente") != null){
                                 String prz = request.getParameter("prz-expediente");
                                 paciente.setPrz(prz);
                            }
                            if(request.getParameter("nivelEducativo") != null){
                                String nivelE = request.getParameter("nivelEducativo");
                                paciente.setIdEscolaridad(Integer.parseInt(nivelE));
                                
                            }
                            if(request.getParameter("estadoHormonal")!=null){
                                String estadoHormonal=request.getParameter("estadoHormonal"); 
                                paciente.setPosMenopausia(Integer.parseInt(estadoHormonal));
                            }
                            if(request.getParameter("nivelSocioeconomico")!=null){
                                String nivelSocioeconomico = request.getParameter("nivelSocioeconomico");
                                //paciente.setIdNivelSocioEconomico(nivelSocioeconomico);
                            }
                             pacienteServicioImpl.actualizarPaciente(paciente);
                            
                            System.out.println("PRZ->" + paciente.getPrz());
                            System.out.println("NivelEducativo->"+ paciente.getIdEscolaridad());
                            System.out.println("Estado Hormonal->"+ paciente.getPosMenopausia());
                            System.out.println("Nivel socioeconómico->" + paciente.getIdNivelSocioEconomico());
                            /*
                            Aquí le vamos a meter lista de inputs:
                            
                                PRZ
                                NivelEducativo
                                Estado Hormonal
                                Nivel socioeconómico

                            
                             */

                            PacienteMedicoTitularServicioImpl pacienteMedicoTitularServicioImpl = new PacienteMedicoTitularServicioImpl();
                            PacienteMedicoTitular pacienteMedicoTitular = pacienteMedicoTitularServicioImpl.mostrarPacienteMedicoTitular(1);
                            
                            if(request.getParameter("medico-adscrito")!=null){
                                String medicoAdscrito = request.getParameter("medico-adscrito");
                                pacienteMedicoTitular.setIdEmpleado(Integer.parseInt(medicoAdscrito));
                            }
                         
                            if(request.getParameter("medico-radiologo")!=null){
                                String medicoRadiologo = request.getParameter("medico-radiologo");
                                //pacienteMedicoTitular.set
                            }
                            if(request.getParameter("medico-residente")!=null){
                                String medicoResidente= request.getParameter("medico-residente");
                            }
                            pacienteMedicoTitularServicioImpl.agregarPacienteMedicoTitular(pacienteMedicoTitular);
                            
                            System.out.println("Medico Adscrito-->");
                            System.out.println("Medico Radiologo-->");
                            System.out.println("Medico Residente-->");
                            /*
                            
                                Medico Adscrito
                                Medico Radiologo
                                Medico Residente
                            
                            
                            */
                            EstadoPacientePacienteServiceImpl estadoPacientePacienteServicioImpl = new EstadoPacientePacienteServiceImpl();
                            EstadoPacientePaciente estadoPacientePaciente = new EstadoPacientePaciente();
                            
                            if(request.getParameter("tipoPaciente")!=null){
                               String tipoPaciente = request.getParameter("tipoPaciente"); 
                            }
                            if(request.getParameter("resultadosCheckbox")!=null){
                                String resultadosCheckbox= request.getParameter("resultadosCheckbox");
                            }
                            if(request.getParameter("decisionPreconsulta")!=null){
                                String descicionPreconsulta = request.getParameter("decisionPreconsulta");
                            }
                            if(request.getParameter("fecha-decisionPreconsulta")!=null){
                                String fechaDesicionPreconsulta= request.getParameter("fecha-decisionPreconsulta");
                            }
                            estadoPacientePaciente.setIdPaciente(idPaciente);
                            
                            estadoPacientePacienteServicioImpl.agregarEstadoPacientePaciente(estadoPacientePaciente);
                            
                            System.out.println("Tipo de Paciente-->");
                            System.out.println("Resultados (checkbox)-->");
                            System.out.println("Decisión preconsulta-->");
                            /*
                            
                            Tipo de Paciente
                            Resultados (checkbox)
                            Decisión preconsulta
                            Fecha desicion preconsulta :D 
                            
                            */
                            
                          
                           
                            CitaServicioImpl citaServicioImpl = new CitaServicioImpl();
                            Cita cita = new Cita();
                            
                            if(request.getParameterValues("tipo-BiopsiaAdded") != null){
                               String[] tipoBiopsias = request.getParameterValues("tipo-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("fecha-BiopsiaAdded") != null){
                               String[] fechasBiopsias = request.getParameterValues("fecha-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("parte-BiopsiaAdded") != null){
                               String[] parteBiopsias = request.getParameterValues("parte-BiopsiaAdded"); 
                            }
                            if(request.getParameterValues("tipo-RayosXAdded") != null){
                               String[] tipoRayosX = request.getParameterValues("tipo-RayosXAdded"); 
                            }
                            if(request.getParameterValues("fecha-RayosXAdded") != null){
                               String[] fechaRayosX = request.getParameterValues("fecha-RayosXAdded"); 
                            }
                            
                            if(request.getParameterValues("parteCuerpo-USGAdded") != null){
                               String[] parteUSG = request.getParameterValues("parteCuerpo-USGAdded"); 
                            }
                            if(request.getParameterValues("fecha-USGAdded") != null){
                               String[] fechaUSG = request.getParameterValues("fecha-USGAdded"); 
                            }
                            
                            if(request.getParameterValues("mNuclear") != null){
                               String[] mNuclear = request.getParameterValues("mNuclear"); 
                            }
                            if(request.getParameterValues("fecha-mNuclearAdded") != null){
                               String[] fechamNuclear = request.getParameterValues("fecha-mNuclearAdded"); 
                            }
                            
                            if(request.getParameterValues("fecha-LaboAdded") != null){
                               String[] fechaLabo = request.getParameterValues("fecha-LaboAdded"); 
                            } 
                            
                            if(request.getParameterValues("valoracionAdded") != null){
                               String[] valoracion = request.getParameterValues("valoracionAdded"); 
                            }
                            if(request.getParameterValues("fecha-valoracionAdded") != null){
                               String[] fechaValoracion = request.getParameterValues("fecha-valoracionAdded"); 
                            }
                            
                            if(request.getParameterValues("fecha-espirometriaAdded") != null){
                               String[] fechaEspirometria = request.getParameterValues("fecha-espirometriaAdded"); 
                            }
                            if(request.getParameterValues("fecha-ECGAdded") != null){
                               String[] fechaECG = request.getParameterValues("fecha-ECGAdded"); 
                            }
                            if(request.getParameterValues("fecha-ecoAddded") != null){
                               String[] fechaECO = request.getParameterValues("fecha-ecoAddded"); 
                            }
                            if(request.getParameterValues("fecha-tSocialAdded") != null){
                               String[] fechaTSocial = request.getParameterValues("fecha-tSocialAdded"); 
                            }

                            cita.setIdPaciente(idPaciente);
                            citaServicioImpl.agregarCita(cita);
                            
                            System.out.println("Fecha de navegacion-->");
                            System.out.println("Fecha de consulta-->");
                            
                            System.out.println("Biopsia-->");
                            System.out.println("Rayos x-->");
                            System.out.println("Ultrasonido-->");
                            System.out.println("Medicina Nuclear-->");
                            System.out.println("Laboratorio-->");
                            System.out.println("Valoracion-->");
                            System.out.println("Espirometria-->");
                            System.out.println("Electrocardiograma-->");
                            System.out.println("Ecocardiograma-->");
                            System.out.println("TrabajoSocial-->");
                            /*
                            Fecha de navegacion
                            Fecha de consulta
                            
                            ESTUDIOS PRECONSULTA-->
                            Biopsia [tipo, fecha, parte de cuerpo]
                            Rayos x [tipo, fecha]
                            Ultrasonido [parteCuerpo, fecha]
                            Medicina Nuclear [mNuclear, fecha-mNuclear]
                            Laboratorio [fecha-LaboAdded]
                            Valoracion [valoracionAdded, fecha-valoracionAdded]
                            Espirometria [fecha-espirometriaAdded]
                            Electrocardiograma [fecha-ECGAdded]
                            Ecocardiograma [fecha-ecoAddded]
                            TrabajoSocial [fecha-tSocialAdded]
                            */

                            
                            PacienteAlergiaServicioImpl pacienteAlergiaServicioImpl = new PacienteAlergiaServicioImpl();
                            PacienteAlergia pacienteAlergia = new PacienteAlergia();
                            
                            if(request.getParameter("alergias") != null){
                                String alergias = request.getParameter("alergias");
                            }
                             pacienteAlergia.setIdPaciente(idPaciente);
                            
                            pacienteAlergiaServicioImpl.agregarPacienteAlergia(pacienteAlergia);
                            
                            System.out.println("Alergias-->");
                            /*
                            Alergias [alergias]
                            */

                         
                            PacienteSeguroServicioImpl pacienteSeguroServicioImpl = new PacienteSeguroServicioImpl();
                            PacienteSeguro pacienteSeguro = new PacienteSeguro(); 


                            if(request.getParameterValues("tieneSeguroPopular") != null){
                               String tieneSeguroPopular = request.getParameter("tieneSeguroPopular"); 
                            }

                            pacienteSeguro.setIdPaciente(idPaciente);
                            pacienteSeguroServicioImpl.agregarPacienteSeguro(pacienteSeguro);
                            
                            System.out.println("Cuentas con algún seguro?-->");
                            /*
                            Cuentas con algún seguro? [tieneSeguroPopular] [on/null]
                            */

                            DocumentoEstudioServicioImpl documentoEstudioServicioImpl = new DocumentoEstudioServicioImpl();
                            DocumentoEstudio documentoEstudio = new DocumentoEstudio();
                            
                            if(request.getParameterValues("tipoMastografiaEP") != null){
                               String tipoMastografiaEP = request.getParameter("tipoMastografiaEP"); 
                            }
                            if(request.getParameterValues("fechaPreMastoEP") != null){
                               String fechaPreMastoEP = request.getParameter("fechaPreMastoEP"); 
                            }
                            
                            if(request.getParameterValues("tipoUltrasonidoMama") != null){
                               String tipoUltrasonido = request.getParameter("tipoUltrasonidoMama"); 
                            }
                            if(request.getParameterValues("fechaPreUsg") != null){
                               String fechaPreUSG = request.getParameter("fechaPreUsg"); 
                            }
                            
                            if(request.getParameterValues("tipoMastografia") != null){
                               String tipoMastografia = request.getParameter("tipoMastografia"); 
                            }
                            if(request.getParameterValues("tipoUSG") != null){
                               String fechaPreMasto = request.getParameter("tipoUSG"); 
                            }
                            
                            documentoEstudio.setIdPaciente(idPaciente);
                            
                            documentoEstudioServicioImpl.agregarDocumentoEstudio(documentoEstudio);
                            
                            System.out.println("Mastografia-->");
                            System.out.println("Ultrasonido de mama-->");
                            System.out.println("Resultados de mastografía-->");
                            System.out.println("Resultados del ultrasonido-->");

                            /*
                            Mastografia [tipoMastografiaEP, fechaPreMastoEP]
                            Ultrasonido de mama [tipoUltrasonidoMama, fechaPreUsg] 
                            Resultados de mastografía  [tipoMastografia]  
                            Resultados del ultrasonido [tipoUSG]
                            
                            
                            
                            */

                            PacienteTratamientoPrevioServiceImpl pacienteTratamientoPrevioServiceImpl = new PacienteTratamientoPrevioServiceImpl();
                            PacienteTratamientoPrevio pacienteTratamientoPrevio = new PacienteTratamientoPrevio();
                            
                            if(request.getParameterValues("fecha-cirugia") != null){
                               String fechaCirugia = request.getParameter("fecha-cirugia"); 
                            }
                            if(request.getParameterValues("cirugia") != null){
                               String cirugia = request.getParameter("cirugia"); 
                            }
                            if(request.getParameterValues("detalle-cirugia") != null){
                               String detalleCirugia = request.getParameter("detalle-cirugia"); 
                            }
                            
                            if(request.getParameterValues("fecha-quimioterapia") != null){
                               String fechaQuimioterapia = request.getParameter("fecha-quimioterapia"); 
                            }
                            if(request.getParameterValues("quimioterapia") != null){
                               String quimioterapia = request.getParameter("quimioterapia"); 
                            }
                            if(request.getParameterValues("detalle-quimioterapia") != null){
                               String detalleQuimioterapia = request.getParameter("detalle-quimioterapia"); 
                            }
                            
                            if(request.getParameterValues("fecha-radioterapia") != null){
                               String fechaRadioterapia = request.getParameter("fecha-radioterapia"); 
                            }
                            if(request.getParameterValues("radioterapia") != null){
                               String radioterapia = request.getParameter("radioterapia"); 
                            }
                            if(request.getParameterValues("detalle-radioterapia") != null){
                               String detalleRadioterapia = request.getParameter("detalle-radioterapia"); 
                            }

                            pacienteTratamientoPrevio.setIdPaciente(idPaciente);
                            
                            pacienteTratamientoPrevioServiceImpl.agregarPacienteTratamientoPrevio(pacienteTratamientoPrevio);
                            
                            System.out.println("Cirugía-->");
                            System.out.println("Quimioterapia-->");
                            System.out.println("Radioterapia-->");
                            /*
                            Cirugía [fecha-cirugia, cirugia, detalle-cirugia]
                            Quimioterapia[fecha-quimioterapia,quimioterapia, detalle-quimioterapia ]
                            Radioterapia[fecha-radioterapia, radioterapia, detalle-radioterapia]
                            */
                            BiopsiaServicioImpl biopsiaServicioImpl = new BiopsiaServicioImpl();
                            Biopsia biopsia = new Biopsia();

                            if(request.getParameterValues("resultadoAnterior-patologia") != null){
                               String resultAnteriorPatologia = request.getParameter("resultadoAnterior-patologia"); 
                            }
                            
                            if(request.getParameterValues("numLaminillas") != null){
                               String numLaminillas = request.getParameter("numLaminillas"); 
                            }
                            if(request.getParameterValues("serieLaminillas") != null){
                               String serieLaminillas = request.getParameter("serieLaminillas"); 
                            }
                            if(request.getParameterValues("numBloques") != null){
                               String numLaminillas = request.getParameter("numBloques"); 
                            }
                            if(request.getParameterValues("serieBloques") != null){
                               String serieLaminillas = request.getParameter("serieBloques"); 
                            }
                            if(request.getParameterValues("resultado-patologia") != null){
                               String resultadoPatologia = request.getParameter("resultado-patologia"); 
                            }
                            if(request.getParameterValues("grado-histologico") != null){
                               String gradoHistologico = request.getParameter("grado-histologico"); 
                            }
                            if(request.getParameterValues("receptor-her2") != null){
                               String receptorHer2 = request.getParameter("receptor-her2"); 
                            }    
                            
                            if(request.getParameterValues("receptor-fish") != null){
                               String  receptorFish= request.getParameter("receptor-fish"); 
                            }
                            
                            if(request.getParameterValues("receptor-re") != null){
                               String  receptorRe= request.getParameter("receptor-re"); 
                            }
                            if(request.getParameterValues("receptor-rp") != null){
                               String receptorRP = request.getParameter("receptor-rp"); 
                            }
                            if(request.getParameterValues("ki67") != null){
                               String ki67 = request.getParameter("ki67"); 
                            }

                            biopsia.setIdPaciente(idPaciente);
                            
                            biopsiaServicioImpl.agregarBiopsia(biopsia);
                            
                            System.out.println("Resultado o reporte de patologia-->");
                            System.out.println("Laminillas-->");
                            System.out.println("Bloques de parafina-->");
                            System.out.println("Resultado Patologia-->");
                            System.out.println("Grado Histológico-->");
                            System.out.println("Her2-->");
                            System.out.println("Fish-->");
                            System.out.println("RE-->");
                            System.out.println("RP-->");
                            System.out.println("Ki67-->");

                            /*
                            Resultado o reporte de patologia[resultadoAnterior-patologia]
                            Laminillas [numLaminillas, serieLaminillas]
                            Bloques de parafina [numBloques, serieBloques]
                            Resultado Patologia [resultado-patologia]
                            Grado Histológico [grado-histologico]
                            Her2 [receptor-her2]
                            Fish [receptor-fish]
                            RE [receptor-re]
                            RP [receptor-rp]
                            Ki67 [ki67]

                            */
                            
                            ProgramaPacienteServicioImpl programaPacienteServicioImpl = new ProgramaPacienteServicioImpl();
                            ProgramaPaciente programaPaciente = new ProgramaPaciente();

                            if(request.getParameterValues("programaAdded") != null){
                               String[] programa = request.getParameterValues("programaAdded"); 
                            }
                            if(request.getParameterValues("fecha-programaAdded") != null){
                               String[] fechaPrograma = request.getParameterValues("fecha-programaAdded"); 
                            }

                            programaPaciente.setIdPaciente(idPaciente);
                            programaPacienteServicioImpl.agregarProgramaPaciente(programaPaciente);
                            
                            System.out.println("Programa-->");
                            /*
                            ESTUDIOS PRECONSULTA-->
                            Programa [programaAdded, fecha-programaAdded]
                            */
                            
                            
                            LlamadaCitaServicioImpl LlamadaCitaServicioImpl = new LlamadaCitaServicioImpl();
                            LlamadaCita llamadaCita =new LlamadaCita();
                            
                            if(request.getParameterValues("fecha-seLlamo") != null){
                               String[] fechaSeLlamo = request.getParameterValues("fecha-seLlamo"); 
                            }
                            if(request.getParameterValues("motivoLlamada") != null){
                               String[] motivoLlamada = request.getParameterValues("motivoLlamada"); 
                            }

                            llamadaCita.setIdCita(cita.getIdCita());
                            
                            LlamadaCitaServicioImpl.agregarLlamadaCita(llamadaCita);
                            
                            System.out.println("Llamada al paciente-->");

                            /*
                            
                            Llamada al paciente[fecha-seLlamo,motivoLlamada]

                            */
                            
                            ComentarioCitaServicioImpl comentarioCitaServicioImpl=new ComentarioCitaServicioImpl();
                            ComentarioCita comentarioCita = new ComentarioCita();

                            if(request.getParameterValues("comentarios") != null){
                               String  comentarios = request.getParameter("comentarios"); 
                            }
                            if(request.getParameterValues("comentariosAdicionales") != null){
                               String comentariosAdicionales = request.getParameter("comentariosAdicionales"); 
                            }

                            comentarioCita.setIdCita(cita.getIdCita());
                            
                            comentarioCitaServicioImpl.agregarComentarioCita(comentarioCita);
                            
                            System.out.println("Comentarios y reporte de incidencias-->");
                            System.out.println("Comentarios adicionales del médico-->");
                            /*
                            Comentarios y reporte de incidencias [comentarios]
                            Comentarios adicionales del médico [comentariosAdicionales]
                            */
                            
                            RegistroDiagnosticoServiceImpl registroDiagnosticoServiceImpl =new RegistroDiagnosticoServiceImpl();
                            RegistroDiagnostico registroDiagnostico = new RegistroDiagnostico();

                            if(request.getParameterValues("etapaClinica") != null){
                               String etapaClinica = request.getParameter("etapaClinica"); 
                            }

                            registroDiagnostico.setIdPaciente(idPaciente);
                            registroDiagnosticoServiceImpl.agregarRegistroDiagnostico(registroDiagnostico);
                            
                            System.out.println("EtapaClinica-->");
                            /*
                            EtapaClinica [etapaClinica]
                            */
                                  
                            EstadiajeTNMServiceImpl estadiajeTNMServiceImpl=new EstadiajeTNMServiceImpl();
                            EstadiajeTNM estadiajeTNM = new EstadiajeTNM();
                            
                            if(request.getParameterValues("tumorPrimarioT") != null){
                               String tumorPrimarioT = request.getParameter("tumorPrimarioT"); 
                            }
                            
                            if(request.getParameterValues("gangliosN") != null){
                               String gangliosN = request.getParameter("gangliosN"); 
                            }
                            if(request.getParameterValues("metastasisM") != null){
                               String metastasisM = request.getParameter("metastasisM"); 
                            }
                            estadiajeTNMServiceImpl.agregarEstadiajeTNM(estadiajeTNM);
                            
                            System.out.println("T-->");
                            System.out.println("N-->");
                            System.out.println("M-->");
                            /*
                            T [tumorPrimarioT]
                            N [gangliosN]
                            M [metastasisM]
                            */
                            
                            //EmpleadoServicioImpl empleadoServicioImpl = new EmpleadoServicioImpl();
                            //Empleado empleado = empleadoServicioImpl.mostrarEmpleado(1);


                            break;
                        }

                    }

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
