/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.Participacion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface ParticipacionFacadeLocal {

    void create(Participacion participacion);

    void edit(Participacion participacion);

    void remove(Participacion participacion);

    Participacion find(Object id);

    List<Participacion> findAll();

    List<Participacion> findRange(int[] range);

    int count();
    
}
