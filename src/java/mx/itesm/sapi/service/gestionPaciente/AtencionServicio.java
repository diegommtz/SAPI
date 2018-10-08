/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Atencion;

/**
 *
 * @author urieldiaz
 */
public interface AtencionServicio {
    public Atencion getAtencionServicio(int idAtencionServicio);
    public List<Atencion> getAllAtencionServicio();
    public boolean saveAtencion(Atencion atencion);
    public boolean deleteAtencion(int idAtencion);
    public boolean updateAtencion(Atencion atencion);
    
}
