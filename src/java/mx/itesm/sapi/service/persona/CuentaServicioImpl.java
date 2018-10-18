/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.persona;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itesm.sapi.bean.persona.Cuenta;
import mx.itesm.sapi.util.Conexion;

/**
 *
 * @author Angel GTZ
 */
public class CuentaServicioImpl implements CuentaServicio {

    @Override
    public boolean borradoLogicoCuenta(int idCuenta) {
        Connection conn;
        ResultSet rs;
        boolean exito = false;
        CallableStatement cstmt;

        //Call del store procedure
        String stProcedure = "borradoLogicoCuenta";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            cstmt.setInt(1, idCuenta);

            rs = cstmt.executeQuery();

            rs.next();
            exito = rs.getBoolean(1);
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

    @Override
    public Cuenta mostrarCuenta(int idCuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        Cuenta cuenta = null;

        //Call del store procedure
        String stProcedure = "mostrarCuenta(?)";

        try {
            cuenta = new Cuenta();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, idCuenta);

            rs = cstmt.executeQuery();

            rs.next();
            cuenta.setIdCuenta(rs.getInt("idCuenta"));
            cuenta.setIdPersona(rs.getInt("idPersona"));
            cuenta.setIdRol(rs.getInt("idRol"));
            cuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
            cuenta.setUsuario(rs.getString("usario"));
            cuenta.setPassword(rs.getString("password"));
            cuenta.setToken(rs.getString("token"));
            cuenta.setEstatus(rs.getInt("estatus"));

            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            cuenta = null;
        }
        return cuenta;
    }

    @Override
    public List<Cuenta> mostrarCuenta() {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        List<Cuenta> cuentas = null;

        try {
            cuentas = new ArrayList<>();
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(" mostrarListaCuenta()");
            rs = cstmt.executeQuery();
            Cuenta cuenta;

            while (rs.next()) {

                cuenta = new Cuenta();
                cuenta.setIdCuenta(rs.getInt("idCuenta"));
                cuenta.setIdPersona(rs.getInt("idPersona"));
                cuenta.setIdRol(rs.getInt("idRol"));
                cuenta.setIdEstadoCuenta(rs.getInt("idEstadoCuenta"));
                cuenta.setUsuario(rs.getString("usario"));
                cuenta.setPassword(rs.getString("password"));
                cuenta.setToken(rs.getString("token"));
                cuenta.setEstatus(rs.getInt("estatus"));

                cuentas.add(cuenta);

            }

            rs.close();
            cstmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            cuentas = null;
        }

        return cuentas;
    }

    @Override
    public int agregarCuenta(Cuenta cuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;

        int id = -1;
        //Aquí va el call del procedure
        String stProcedure = "agregarCuenta(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);

            //Aquí van los sets 
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setInt(2, cuenta.getIdPersona());
            cstmt.setInt(3, cuenta.getIdRol());
            cstmt.setInt(4, cuenta.getIdEstadoCuenta());
            cstmt.setString(5, cuenta.getUsuario());
            cstmt.setString(6, cuenta.getPassword());
            cstmt.setString(7, cuenta.getToken());
            cstmt.setInt(8, cuenta.getEstatus());

            //Aquí va el registerOutParameter
            //cstmt.registerOutParameter(12,Types.INTEGER);
            cstmt.executeUpdate();

            rs = cstmt.getGeneratedKeys();

            rs.next();

            id = rs.getInt(1);
            conn.close();
            rs.close();
            cstmt.close();

        } catch (SQLException ex) {

            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            id = -1;

        }

        return id;
    }

    @Override
    public boolean actualizarCuenta(Cuenta cuenta) {
        Connection conn;
        ResultSet rs;
        CallableStatement cstmt;
        boolean exito = false;

        //Call del store procedure
        String stProcedure = "actualizarCuenta(?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn = Conexion.getConnection();
            cstmt = conn.prepareCall(stProcedure);
            cstmt.setInt(1, cuenta.getIdCuenta());
            cstmt.setInt(2, cuenta.getIdPersona());
            cstmt.setInt(3, cuenta.getIdRol());
            cstmt.setInt(4, cuenta.getIdEstadoCuenta());
            cstmt.setString(5, cuenta.getUsuario());
            cstmt.setString(6, cuenta.getPassword());
            cstmt.setString(7, cuenta.getToken());
            cstmt.setInt(8, cuenta.getEstatus());

            rs = cstmt.executeQuery();

            rs.next();
            conn.close();
            rs.close();
            cstmt.close();

            return rs.getBoolean(1);

        } catch (SQLException ex) {
            System.out.println(this.getClass().toString().concat(Thread.currentThread().getStackTrace()[1].getMethodName())
                    .concat(ex.getMessage()));
            exito = false;
        }
        return exito;
    }

}