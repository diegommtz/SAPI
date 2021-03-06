/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.bean.gestionPaciente;

import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class DocumentoInicialTipoDocumento implements Serializable {
    
   private int idDocumentoInicial;
   private int idTipoDocumento;
   private String nombreTipo;
   private String tipo;
   private InputStream archivo;
   private int idPaciente;
   private String comentario;
   private int aprobado; 
   private String nombreDocumento;
    
   public DocumentoInicialTipoDocumento() {
    }

    public int getIdDocumentoInicial() {
        return idDocumentoInicial;
    }

    public void setIdDocumentoInicial(int idDocumentoInicial) {
        this.idDocumentoInicial = idDocumentoInicial;
    }

    public int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(int idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNombreTipo() {
        return nombreTipo;
    }

    public void setNombreTipo(String nombreTipo) {
        this.nombreTipo = nombreTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public InputStream getArchivo() {
        return archivo;
    }

    public void setArchivo(InputStream archivo) {
        this.archivo = archivo;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAprobado() {
        return aprobado;
    }

    public void setAprobado(int aprobado) {
        this.aprobado = aprobado;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    

}

