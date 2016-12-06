package co.sena.edu.frontend.controller;

import co.sena.edu.backend.persistens.entities.Torneo;
import co.sena.edu.frontend.controller.util.JsfUtil;
import co.sena.edu.frontend.controller.util.JsfUtil.PersistAction;
import co.sena.edu.facade.TorneoFacadeLocal;

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

@Named("torneoManagedBean")
@SessionScoped
public class TorneoManagedBean implements Serializable {

    @EJB
    private TorneoFacadeLocal torneofl;
    private List<Torneo> tablaTorneo = null;
    private Torneo torneo;

    public TorneoManagedBean() {
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

  

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private TorneoFacadeLocal getFacade() {
        return torneofl;
    }

    public Torneo prepareCreate() {
        torneo = new Torneo();
        initializeEmbeddableKey();
        return torneo;
    }

    public void registrarTorneo() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("TorneoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            tablaTorneo = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void modificarRegistro() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("TorneoUpdated"));
    }

    public void eliminarRegistro() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("TorneoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            torneo = null; // Remove selection
            tablaTorneo = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Torneo> getItems() {
        if (tablaTorneo == null) {
            tablaTorneo = getFacade().findAll();
        }
        return tablaTorneo;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (torneo != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(torneo);
                } else {
                    getFacade().remove(torneo);
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

    public Torneo getTorneo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Torneo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Torneo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Torneo.class)
    public static class TorneoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            TorneoManagedBean controller = (TorneoManagedBean) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "torneoController");
            return controller.getTorneo(getKey(value));
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
            if (object instanceof Torneo) {
                Torneo o = (Torneo) object;
                return getStringKey(o.getCodigoTorneo());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Torneo.class.getName()});
                return null;
            }
        }

    }

}
