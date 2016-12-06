/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.facade;

import co.sena.edu.backend.persistens.entities.Desempeño;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camila
 */
@Stateless
public class DesempeñoFacade extends AbstractFacade<Desempeño> {

    @PersistenceContext(unitName = "Futbol_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DesempeñoFacade() {
        super(Desempeño.class);
    }
    
}
