/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Connection;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import mx.itesm.sapi.bean.gestionPaciente.PacientePotencial;
import mx.itesm.sapi.bean.gestionPaciente.Paciente;
import mx.itesm.sapi.bean.gestionPaciente.PacienteAdmin;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Uriel Díaz
 */
public class PacienteServiceImpl implements PacienteService {

    @Override
    public Paciente mostrarPaciente(int idPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        String stProcedure = "CALL mostrarPaciente(?)";
        Paciente paciente = null;

        try {
            conn = Conexion.getConnection();
            paciente = new Paciente();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();

            rs.next();

            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setIdCuenta(rs.getInt("idCuenta"));
            paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
            paciente.setPrz(rs.getString("prz"));
            paciente.setExpediente(rs.getString("expediente"));
            paciente.setPeso(rs.getDouble("peso"));
            paciente.setAltura(rs.getDouble("altura"));
            paciente.setPosMenopausia(rs.getInt("posMenopausia"));
            paciente.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            paciente = null;
        }
        return paciente;
    }

    /*
    @Override
    public Paciente mostrarPaciente(String przPaciente) {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        Paciente paciente = new Paciente();
<<<<<<< HEAD

        String stProcedure = "";
        try {
||||||| merged common ancestors
        
        String stProcedure ="";
        try{
=======
        
        String stProcedure ="CALL mostrarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
>>>>>>> origin/Develop
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            rs.next();

            paciente.setIdPaciente(rs.getInt("idPaciente"));
            paciente.setIdCuenta(rs.getInt("idCuenta"));
            paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
            paciente.setPrz(rs.getString("prz"));
            paciente.setExpediente(rs.getString("expediente"));
            paciente.setPeso(rs.getDouble("peso"));
            paciente.setAltura(rs.getDouble("altura"));
            paciente.setPosMenopausia(rs.getInt("posMenopausia"));
            paciente.setEstatus(rs.getInt("estatus"));

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            paciente = null;
        }
        return paciente;
    }
     */
    @Override
    public List<Paciente> mostrarPaciente() {
        Connection conn;
        List<Paciente> pacientes = new ArrayList<>();
        CallableStatement cstmt;
        String stProcedure = "CALL mostrarListaPaciente(?) ";

        ResultSet rs;

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();
            Paciente paciente;

            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setIdCuenta(rs.getInt("idCuenta"));
                paciente.setIdEscolaridad(rs.getInt("idEscolaridad"));
                paciente.setPrz(rs.getString("prz"));
                paciente.setExpediente(rs.getString("expediente"));
                paciente.setPeso(rs.getDouble("peso"));
                paciente.setAltura(rs.getDouble("altura"));
                paciente.setPosMenopausia(rs.getInt("posMenopausia"));
                paciente.setEstatus(rs.getInt("estatus"));

                pacientes.add(paciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public int agregarPaciente(Paciente paciente) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;

        String stPrcedure = "CALL agregarPaciente(?,?,?,?,?,?,?)";
        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, paciente.getIdCuenta());
            cstmt.setInt(2, 1);
            cstmt.setString(3, paciente.getPrz());
            cstmt.setString(4, paciente.getExpediente());
            cstmt.setDouble(5, paciente.getPeso());
            cstmt.setDouble(6, paciente.getAltura());
            cstmt.setInt(7, paciente.getPosMenopausia());

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }

        return id;
    }

    @Override
    public boolean actualizarPaciente(Paciente paciente
    ) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL actualizarPaciente(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, paciente.getIdPaciente());
            cstmt.setInt(2, paciente.getIdCuenta());
            cstmt.setInt(3, paciente.getIdEscolaridad());
            cstmt.setString(4, paciente.getPrz());
            cstmt.setString(5, paciente.getExpediente());
            cstmt.setDouble(6, paciente.getPeso());
            cstmt.setDouble(7, paciente.getAltura());
            cstmt.setInt(8, paciente.getPosMenopausia());
            cstmt.setInt(9, paciente.getEstatus());

            rs = cstmt.executeQuery();

            exito = rs.getBoolean(1);

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public boolean borradoLogicoPaciente(int idPaciente
    ) {
        Connection conn;
        CallableStatement cstmt;
        String stProcedure = "CALL borradoLogicoPaciente(?)";
        boolean exito = false;
        ResultSet rs;
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();

            exito = rs.getBoolean(1);

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public int agregarPacienteRegistro(int idCuenta
    ) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;

        String stPrcedure = "CALL agregarPacienteRegistro(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, idCuenta);

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }     
               
        return id;
    }

    @Override
    public List<PacientePotencial> mostrarPacientesPotenciales() {
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<PacientePotencial> pacientes = null;

        String stProcedure = "CALL mostrarPotenciales()";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            pacientes = new ArrayList<>();
            PacientePotencial paciente;

            while (rs.next()) {
                paciente = new PacientePotencial();

                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPrimerApellido(rs.getString("primerApellido"));
                paciente.setSegundoApellido(rs.getString("segundoApellido"));
                paciente.setEstadoPaciente(rs.getString("estado"));
                paciente.setFechaRegistro(rs.getDate("fecha"));
                paciente.setCurp(rs.getString("curp"));
                paciente.setTelefono(rs.getString("telefono"));

                pacientes.add(paciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;
    }

    @Override
    public List<PacientePotencial> mostrarPacientesPotencialesAprobados() {

        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<PacientePotencial> pacientes = null;

        String stProcedure = "CALL mostrarPacientesAprobados()";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            pacientes = new ArrayList<>();
            PacientePotencial paciente;

            while (rs.next()) {
                paciente = new PacientePotencial();

                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setPrz(rs.getString("prz"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPrimerApellido(rs.getString("primerApellido"));
                paciente.setSegundoApellido(rs.getString("segundoApellido"));
                paciente.setTipoPaciente(rs.getInt("segundaOpinion"));
                paciente.setTieneResultados(rs.getInt("resultados"));
                paciente.setFechaRegistro(rs.getDate("fechaProgramada"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setNombreEstadoCita(rs.getString("nombreEstadoCita"));

                pacientes.add(paciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;

    }

    @Override
    public int mostrarColor(int idPaciente
    ) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;

        String stPrcedure = "CALL getColor(?)";
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }

        return id;
    }

    @Override
    public int obtenerCuenta(int idPaciente) {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;

        String stPrcedure = "CALL obtenerCuenta(?)";
        
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, idPaciente);

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }

        return id;
        
    }

    @Override
    public int obtenerPersona(int idCuenta) {
        
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        int id = -1;

        String stPrcedure = "CALL obtenerPersona(?)";
        
        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stPrcedure);

            cstmt.setInt(1, idCuenta);

            rs = cstmt.executeQuery();
            rs.next();
            id = rs.getInt(1);

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;
        }

        return id;
        
    }

    @Override
    public List<PacienteAdmin> mostrarPacientesAdmin() {
        
        Connection conn;
        CallableStatement cstmt;
        ResultSet rs;

        List<PacienteAdmin> pacientes = null;

        String stProcedure = "CALL mostrarPacientesAdmin()";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            rs = cstmt.executeQuery();

            pacientes = new ArrayList<>();
            PacienteAdmin paciente;

            while (rs.next()) {
                paciente = new PacienteAdmin();

                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setPrz(rs.getString("prz"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setPrimerApellido(rs.getString("primerApellido"));
                paciente.setSegundoApellido(rs.getString("segundoApellido"));
                paciente.setTratamiento(rs.getString("tratamiento"));
                paciente.setEtapaClinica(rs.getString("etapaClinica"));
                paciente.setTelefono(rs.getString("telefono"));
                paciente.setEstado(rs.getString("estado"));
                paciente.setMedNombre(rs.getString("medNombre"));
                paciente.setMedPrimerApellido(rs.getString("medPrimerApellido"));
                paciente.setMedSegundoApellido(rs.getString("medSegundoApellido"));                

                pacientes.add(paciente);
            }

            rs.close();
            cstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            pacientes = null;
        }
        return pacientes;
    }
}
