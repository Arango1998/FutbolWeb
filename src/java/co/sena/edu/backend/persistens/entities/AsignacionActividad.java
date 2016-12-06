/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "asignacion_actividades")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AsignacionActividad.findAll", query = "SELECT a FROM AsignacionActividad a"),
    @NamedQuery(name = "AsignacionActividad.findByIdAsignacionActividad", query = "SELECT a FROM AsignacionActividad a WHERE a.idAsignacionActividad = :idAsignacionActividad")})
public class AsignacionActividad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_asignacion_actividad")
    private Integer idAsignacionActividad;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fkIdUsuario;
    @JoinColumn(name = "fk_id_actividad", referencedColumnName = "id_actividad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Actividad fkIdActividad;

    public AsignacionActividad() {
    }

    public AsignacionActividad(Integer idAsignacionActividad) {
        this.idAsignacionActividad = idAsignacionActividad;
    }

    public Integer getIdAsignacionActividad() {
        return idAsignacionActividad;
    }

    public void setIdAsignacionActividad(Integer idAsignacionActividad) {
        this.idAsignacionActividad = idAsignacionActividad;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Actividad getFkIdActividad() {
        return fkIdActividad;
    }

    public void setFkIdActividad(Actividad fkIdActividad) {
        this.fkIdActividad = fkIdActividad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignacionActividad != null ? idAsignacionActividad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsignacionActividad)) {
            return false;
        }
        AsignacionActividad other = (AsignacionActividad) object;
        if ((this.idAsignacionActividad == null && other.idAsignacionActividad != null) || (this.idAsignacionActividad != null && !this.idAsignacionActividad.equals(other.idAsignacionActividad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.AsignacionActividad[ idAsignacionActividad=" + idAsignacionActividad + " ]";
    }
    
}
