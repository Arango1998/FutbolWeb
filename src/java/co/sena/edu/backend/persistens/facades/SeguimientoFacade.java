/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.facades;

import co.sena.edu.backend.persistens.entities.Seguimiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camila
 */
@Stateless
public class SeguimientoFacade extends AbstractFacade<Seguimiento> implements SeguimientoFacadeLocal {

    @PersistenceContext(unitName = "Futbol_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SeguimientoFacade() {
        super(Seguimiento.class);
    }
    
}
