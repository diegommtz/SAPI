/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoInicialTipoDocumento;

/**
 *
 * @author Admin
 */
public interface DocumentoInicialTipoDocumentoServicio {
    
    public List<DocumentoInicialTipoDocumento> mostrarDocumentoInicialTipoDocumento(int idPaciente);
    public DocumentoInicialTipoDocumento descargarArchivo(int idArchivo);
    
    
}
