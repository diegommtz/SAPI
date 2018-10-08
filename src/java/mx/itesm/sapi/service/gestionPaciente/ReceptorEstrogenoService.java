/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.ReceptorEstrogeno;

/**
 *
 * @author urieldiaz
 */
public interface ReceptorEstrogenoService {
    public ReceptorEstrogeno mostrarReceptorEstrogeno(int idReceptorEstrogeno);
    public List<ReceptorEstrogeno> mostrarAllReceptorEstrogeno();
    public boolean agregarReceptorEstrogeno(ReceptorEstrogeno receptorEstrogeno);
    public boolean borrarReceptorEstrogeno(int idReceptorEstrogeno);
    public boolean actualizarReceptorEstrogeno(ReceptorEstrogeno receptorEstrogeno);
    
}
