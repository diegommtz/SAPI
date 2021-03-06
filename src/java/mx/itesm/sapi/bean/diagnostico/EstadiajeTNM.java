/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.diagnostico;

import java.io.Serializable;

/**
 *
 * @author Diego
 */
public class EstadiajeTNM implements Serializable{
    int idRegistroTNM;
    int idTCodificado;
    int idNCodificado;
    int idMCodificado;
    int idTipoHistologico;
    double tClinico;
    double tImagen;
    int Metastasis;
    int estatus;

    @Override
    public String toString() {
        return "EstadiajeTNM{" + "idRegistroTNM=" + idRegistroTNM + ", idTCodificado=" + idTCodificado + ", idNCodificado=" + idNCodificado + ", idMCodificado=" + idMCodificado 
                + "idTipoHistologico" + idTipoHistologico + ", tClinico=" + tClinico + ", tImagen=" + tImagen + ", Metastasis=" + Metastasis + ", estatus=" + estatus + '}';
    }
    
    public int getIdRegistroTNM() {
        return idRegistroTNM;
    }

    public void setIdRegistroTNM(int idRegistroTNM) {
        this.idRegistroTNM = idRegistroTNM;
    }

    public int getIdTCodificado() {
        return idTCodificado;
    }

    public void setIdTCodificado(int idTCodificado) {
        this.idTCodificado = idTCodificado;
    }

    public int getIdNCodificado() {
        return idNCodificado;
    }

    public void setIdNCodificado(int idNCodificado) {
        this.idNCodificado = idNCodificado;
    }

    public int getIdMCodificado() {
        return idMCodificado;
    }

    public void setIdMCodificado(int idMCodificado) {
        this.idMCodificado = idMCodificado;
    }

    public double gettClinico() {
        return tClinico;
    }

    public void settClinico(double tClinico) {
        this.tClinico = tClinico;
    }

    public double gettImagen() {
        return tImagen;
    }

    public void settImagen(double tImagen) {
        this.tImagen = tImagen;
    }

    public int getMetastasis() {
        return Metastasis;
    }

    public void setMetastasis(int Metastasis) {
        this.Metastasis = Metastasis;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public int getIdTipoHistologico() {
        return idTipoHistologico;
    }

    public void setIdTipoHistologico(int idTipoHistologico) {
        this.idTipoHistologico = idTipoHistologico;
    }
    
    
}
