/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.UsuarioLogin;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author camila
 */
@Local
public interface UsuarioLoginFacadeLocal {

    void create(UsuarioLogin usuarioLogin);

    void edit(UsuarioLogin usuarioLogin);

    void remove(UsuarioLogin usuarioLogin);

    UsuarioLogin find(Object id);

    List<UsuarioLogin> findAll();

    List<UsuarioLogin> findRange(int[] range);

    int count();
    
}
