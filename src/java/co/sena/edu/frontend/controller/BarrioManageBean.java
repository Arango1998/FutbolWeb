package co.sena.edu.frontend.controller;

import co.sena.edu.backend.persistens.entities.Barrio;
import co.sena.edu.frontend.controller.util.JsfUtil;
import co.sena.edu.frontend.controller.util.JsfUtil.PersistAction;
import co.sena.edu.facade.BarrioFacadeLocal;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("barrioManageBean")
@SessionScoped
public class BarrioManageBean implements Serializable {

    @EJB
    private BarrioFacadeLocal barriofl;
    private List<Barrio> tablaBarrio = null;
    private Barrio barrio;

    public BarrioManageBean() {
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }

    

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private BarrioFacadeLocal getFacade() {
        return barriofl;
    }

    public Barrio prepareCreate() {
        barrio = new Barrio();
        initializeEmbeddableKey();
        return barrio;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BarrioCreated"));
        if (!JsfUtil.isValidationFailed()) {
            tablaBarrio = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BarrioUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BarrioDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            barrio = null; // Remove selection
            tablaBarrio = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Barrio> getItems() {
        if (tablaBarrio == null) {
            tablaBarrio = getFacade().findAll();
        }
        return tablaBarrio;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (barrio != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(barrio);
                } else {
                    getFacade().remove(barrio);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Barrio getBarrio(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Barrio> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Barrio> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Barrio.class)
    public static class BarrioControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BarrioManageBean controller = (BarrioManageBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "barrioController");
            return controller.getBarrio(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Barrio) {
                Barrio o = (Barrio) object;
                return getStringKey(o.getIdBarrio());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Barrio.class.getName()});
                return null;
            }
        }

    }

}
