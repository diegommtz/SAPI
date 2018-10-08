/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Biopsia;

/**
 *
 * @author urieldiaz
 */
public interface BiopsiaService {
    public Biopsia getBiopsia(int idBiopsia);
    public List<Biopsia> getAllBiopsia();
    public boolean saveBiopsia(Biopsia biopsia);
    public boolean deleteBiopsia (int idBiopsia);
    public boolean updateBiopsia(Biopsia biopsia);        
}
