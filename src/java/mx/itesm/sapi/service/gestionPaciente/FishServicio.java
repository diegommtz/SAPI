/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itesm.sapi.service.gestionPaciente;

import java.util.List;
import mx.itesm.sapi.bean.gestionPaciente.Fish;

/**
 *
 * @author Alexis España
 */
public interface FishServicio {
    public Fish mostrarFish(int idFish);
    public List<Fish> mostrarFish();
}
