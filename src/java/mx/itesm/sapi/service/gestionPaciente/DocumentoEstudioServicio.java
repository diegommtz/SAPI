/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.sql.Date;
import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.DocumentoEstudio;

/**
 *
 * @author Oscar Miranda
 */
public interface DocumentoEstudioServicio {

    public DocumentoEstudio mostrarDocumentoEstudio(int idDocumentoEstudio);

    public DocumentoEstudio mostrarDocumentoEstudioIdPaciente(int idPaciente);

    public List<DocumentoEstudio> mostrarDocumentoEstudio();

    public List<DocumentoEstudio> mostrarDocumentoEstudioIdEspecifico(int idPaciente);

    public int agregarDocumentoEstudio(DocumentoEstudio documentoEstudio);

    public boolean borradoLogicoDocumentoEstudio(int idDocumentoEstudio);

    public boolean actualizarDocumentoEstudio(DocumentoEstudio documentoEstudio);

    public DocumentoEstudio mostrarDocumentoEstudioPacienteEstudio(int idpaciente, int idEstudio);

    public DocumentoEstudio mostrarDocumentoEstudioPacienteEstudioPrevio(int idPaciente, int idEstudio, int previo);

    public DocumentoEstudio mostrarDocumentoEstudioMasRecientePaciente(int idTipoEstudio, int idPaciente);

    public int agregarDocumentoEstudioMastoAntesPreconsulta(DocumentoEstudio documentoEstudio);

    public int agregarDocumentoEstudioEstudioPrevio(DocumentoEstudio documentoEstudio);

    public boolean actualizarDocumentoEstudioEstudioPrevio(DocumentoEstudio documentoEstudio);

    public boolean actualizarDocumentoEstudioMastoAntesPreconsulta(DocumentoEstudio documentoEstudio);

    public DocumentoEstudio mostrarDocumentoEstudioMastoAntesPreconsulta(int idpaciente, int idEstudio);

}
