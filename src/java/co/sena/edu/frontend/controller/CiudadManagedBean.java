package co.sena.edu.frontend.controller;

import co.sena.edu.backend.persistens.entities.Ciudad;
import co.sena.edu.frontend.controller.util.JsfUtil;
import co.sena.edu.frontend.controller.util.JsfUtil.PersistAction;
import co.sena.edu.facade.CiudadFacadeLocal;

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

@Named("ciudadManagedBean")
@SessionScoped
public class CiudadManagedBean implements Serializable {

    @EJB
    private CiudadFacadeLocal ciudadfl;
    private List<Ciudad> tablaCiudad = null;
    private Ciudad ciudad;

    public CiudadManagedBean() {
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

   
    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CiudadFacadeLocal getFacade() {
        return ciudadfl;
    }

    public Ciudad prepareCreate() {
        ciudad = new Ciudad();
        initializeEmbeddableKey();
        return ciudad;
    }

    public void registrarCiudad() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CiudadCreated"));
        if (!JsfUtil.isValidationFailed()) {
            tablaCiudad = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CiudadUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CiudadDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            ciudad = null; // Remove selection
            tablaCiudad = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Ciudad> getItems() {
        if (tablaCiudad == null) {
            tablaCiudad = getFacade().findAll();
        }
        return tablaCiudad;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (ciudad != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(ciudad);
                } else {
                    getFacade().remove(ciudad);
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

    public Ciudad getCiudad(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Ciudad> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Ciudad> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Ciudad.class)
    public static class CiudadControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CiudadManagedBean controller = (CiudadManagedBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "ciudadController");
            return controller.getCiudad(getKey(value));
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
            if (object instanceof Ciudad) {
                Ciudad o = (Ciudad) object;
                return getStringKey(o.getIdCiudad());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Ciudad.class.getName()});
                return null;
            }
        }

    }

}
