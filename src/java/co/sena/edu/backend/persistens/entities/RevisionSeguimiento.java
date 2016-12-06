/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "revisiones_seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RevisionSeguimiento.findAll", query = "SELECT r FROM RevisionSeguimiento r"),
    @NamedQuery(name = "RevisionSeguimiento.findByIdRevision", query = "SELECT r FROM RevisionSeguimiento r WHERE r.idRevision = :idRevision"),
    @NamedQuery(name = "RevisionSeguimiento.findByFechaRevision", query = "SELECT r FROM RevisionSeguimiento r WHERE r.fechaRevision = :fechaRevision")})
public class RevisionSeguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_revision")
    private Long idRevision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_revision")
    @Temporal(TemporalType.DATE)
    private Date fechaRevision;
    @Lob
    @Size(max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "fk_codigo_seguimiento", referencedColumnName = "codigo_seguimiento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seguimiento fkCodigoSeguimiento;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fkIdUsuario;

    public RevisionSeguimiento() {
    }

    public RevisionSeguimiento(Long idRevision) {
        this.idRevision = idRevision;
    }

    public RevisionSeguimiento(Long idRevision, Date fechaRevision) {
        this.idRevision = idRevision;
        this.fechaRevision = fechaRevision;
    }

    public Long getIdRevision() {
        return idRevision;
    }

    public void setIdRevision(Long idRevision) {
        this.idRevision = idRevision;
    }

    public Date getFechaRevision() {
        return fechaRevision;
    }

    public void setFechaRevision(Date fechaRevision) {
        this.fechaRevision = fechaRevision;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Seguimiento getFkCodigoSeguimiento() {
        return fkCodigoSeguimiento;
    }

    public void setFkCodigoSeguimiento(Seguimiento fkCodigoSeguimiento) {
        this.fkCodigoSeguimiento = fkCodigoSeguimiento;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRevision != null ? idRevision.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RevisionSeguimiento)) {
            return false;
        }
        RevisionSeguimiento other = (RevisionSeguimiento) object;
        if ((this.idRevision == null && other.idRevision != null) || (this.idRevision != null && !this.idRevision.equals(other.idRevision))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.RevisionSeguimiento[ idRevision=" + idRevision + " ]";
    }
    
}
