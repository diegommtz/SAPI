/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.AuditoriaAtencion;

/**
 *
 * @author urieldiaz
 */
public interface AuditoriaAtencionServicio {
    public AuditoriaAtencion getAuditoriaAtencion(int idAuditoriaAtencion);
    public List<AuditoriaAtencion> getAllAuditoriaAtencion();
    public boolean saveAuditoriaAtencion(AuditoriaAtencion auditoriaAtencion);
    public boolean deleteAuditoriaAtencion(int idAuditoriaAtencion);    
    public boolean updateAuditoriaAtencion(AuditoriaAtencion auditoriaAtencion);
}
