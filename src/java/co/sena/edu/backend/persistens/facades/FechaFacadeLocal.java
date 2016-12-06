/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.Fecha;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface FechaFacadeLocal {

    void create(Fecha fecha);

    void edit(Fecha fecha);

    void remove(Fecha fecha);

    Fecha find(Object id);

    List<Fecha> findAll();

    List<Fecha> findRange(int[] range);

    int count();
    
}
