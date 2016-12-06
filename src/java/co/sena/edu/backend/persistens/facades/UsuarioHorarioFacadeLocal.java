/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.UsuarioHorario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface UsuarioHorarioFacadeLocal {

    void create(UsuarioHorario usuarioHorario);

    void edit(UsuarioHorario usuarioHorario);

    void remove(UsuarioHorario usuarioHorario);

    UsuarioHorario find(Object id);

    List<UsuarioHorario> findAll();

    List<UsuarioHorario> findRange(int[] range);

    int count();
    
}
