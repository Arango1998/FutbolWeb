/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.AsignacionEquipo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface AsignacionEquipoFacadeLocal {

    void create(AsignacionEquipo asignacionEquipo);

    void edit(AsignacionEquipo asignacionEquipo);

    void remove(AsignacionEquipo asignacionEquipo);

    AsignacionEquipo find(Object id);

    List<AsignacionEquipo> findAll();

    List<AsignacionEquipo> findRange(int[] range);

    int count();
    
}
