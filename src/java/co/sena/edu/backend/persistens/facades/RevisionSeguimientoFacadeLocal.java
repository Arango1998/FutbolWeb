/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.RevisionSeguimiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface RevisionSeguimientoFacadeLocal {

    void create(RevisionSeguimiento revisionSeguimiento);

    void edit(RevisionSeguimiento revisionSeguimiento);

    void remove(RevisionSeguimiento revisionSeguimiento);

    RevisionSeguimiento find(Object id);

    List<RevisionSeguimiento> findAll();

    List<RevisionSeguimiento> findRange(int[] range);

    int count();
    
}
