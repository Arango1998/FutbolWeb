package co.sena.edu.frontend.controller;

import co.sena.edu.backend.persistens.entities.AsignacionActividad;
import co.sena.edu.frontend.controller.util.JsfUtil;
import co.sena.edu.frontend.controller.util.JsfUtil.PersistAction;
import co.sena.edu.facade.AsignacionActividadFacade;

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

@Named("asignacionActividadController")
@SessionScoped
public class AsignacionActividadController implements Serializable {

    @EJB
    private co.sena.edu.facade.AsignacionActividadFacade ejbFacade;
    private List<AsignacionActividad> items = null;
    private AsignacionActividad selected;

    public AsignacionActividadController() {
    }

    public AsignacionActividad getSelected() {
        return selected;
    }

    public void setSelected(AsignacionActividad selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private AsignacionActividadFacade getFacade() {
        return ejbFacade;
    }

    public AsignacionActividad prepareCreate() {
        selected = new AsignacionActividad();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("AsignacionActividadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("AsignacionActividadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("AsignacionActividadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<AsignacionActividad> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
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

    public AsignacionActividad getAsignacionActividad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<AsignacionActividad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<AsignacionActividad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = AsignacionActividad.class)
    public static class AsignacionActividadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AsignacionActividadController controller = (AsignacionActividadController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "asignacionActividadController");
            return controller.getAsignacionActividad(getKey(value));
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
            if (object instanceof AsignacionActividad) {
                AsignacionActividad o = (AsignacionActividad) object;
                return getStringKey(o.getIdAsignacionActividad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), AsignacionActividad.class.getName()});
                return null;
            }
        }

    }

}
