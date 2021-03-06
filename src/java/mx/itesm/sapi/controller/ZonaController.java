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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import mx.itesm.sapi.bean.persona.CodigoPostal;
import mx.itesm.sapi.bean.persona.Estado;
import mx.itesm.sapi.bean.persona.EstadoCivil;
import mx.itesm.sapi.bean.persona.Municipio;
import mx.itesm.sapi.service.ZonaServicioImpl;

/**
 *
 * @author Fernanda Orduña & Pablo Lugo
 */
@WebServlet(name = "ZonaController", urlPatterns = {"/ZonaController"})
public class ZonaController extends HttpServlet {

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

        /////////////////////////////////////////////////////        
        String key;
        HttpSession sesion = request.getSession(true);
        try
        {
            key = request.getParameter("key");            
            sesion.setAttribute("KeyZonaController", key);
        }catch (Exception ex)
        {
             key = (String) sesion.getAttribute("KeyZonaController");
        }

        switch (key) {

            case "getByEstado": {

                /** Fernanda Orduña y Pablo Lugo
                 * 
                 * El case getByEstado se encarga de obtener la lista de municipios a partir de
                 * que el usuario selecciona un estado
                 * 
                 */
                int idEstado = Integer.parseInt(request.getParameter("idEstado"));
                Estado estado = new Estado();

                estado.setIdEstado(idEstado);

                ZonaServicioImpl psi = new ZonaServicioImpl();

                List<Municipio> municipios = psi.getMunicipios(estado);

                request.setAttribute("municipios", municipios);

                PrintWriter out = response.getWriter();

                Gson json = new Gson();
                out.print(json.toJson(municipios));
                

                break;

            }

            case "getRegistro": {
                /** 
                 * El case getRegistro se encarga de cargar los modales de Estado y Estado Civil
                 * en cuanto el paciente ingresa al registro
                 */
                ZonaServicioImpl zsi = new ZonaServicioImpl();
                
                List<Estado> allEstados = zsi.getEstados();
                List<EstadoCivil> estados = zsi.getEstadoCivil();
                
                request.setAttribute("estadoCivil", estados);
                request.setAttribute("estados", allEstados);
                request.getRequestDispatcher("/WEB-INF/registro.jsp").forward(request, response);
                break;
            }
            case "getEstadoyMunicipio": {
                
                /**
                 * El case getEstadoyMunicipio me devuelve el estado y municipio dependiendo del 
                 * codigo postal que el usuario ingresó
                 */
               String numeroCP = request.getParameter("numeroCP");
                CodigoPostal CP = new CodigoPostal();

                CP.setNumero(numeroCP);
                ZonaServicioImpl zsi = new ZonaServicioImpl();
                List<String> estadoyMunicipio = zsi.getEstadoyMunicipio(CP);
                
                PrintWriter out = response.getWriter();
                
                if(estadoyMunicipio.size()==0)
                {
                    out.print("postalCodeDoesntExist");
                }else{
                

                Gson json = new Gson();
                out.print(json.toJson(estadoyMunicipio));
                }
                break;
            }
            
            case "getEstados": {
                
                ZonaServicioImpl zonaServicio = new ZonaServicioImpl();
                List<Estado> estados = zonaServicio.getEstados();
                
                Gson json = new Gson();      
                
                PrintWriter out = response.getWriter();
                out.print(json.toJson(estados));
            
                break;
                
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
