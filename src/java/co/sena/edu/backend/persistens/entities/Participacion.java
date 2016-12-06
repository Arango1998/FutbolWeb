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
@Table(name = "participaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Participacion.findAll", query = "SELECT p FROM Participacion p"),
    @NamedQuery(name = "Participacion.findByIdParticipacion", query = "SELECT p FROM Participacion p WHERE p.idParticipacion = :idParticipacion")})
public class Participacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_participacion")
    private Integer idParticipacion;
    @JoinColumn(name = "fk_codigo_torneo", referencedColumnName = "codigo_torneo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Torneo fkCodigoTorneo;
    @JoinColumn(name = "fk_id_equipo", referencedColumnName = "id_equipo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Equipo fkIdEquipo;

    public Participacion() {
    }

    public Participacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Integer getIdParticipacion() {
        return idParticipacion;
    }

    public void setIdParticipacion(Integer idParticipacion) {
        this.idParticipacion = idParticipacion;
    }

    public Torneo getFkCodigoTorneo() {
        return fkCodigoTorneo;
    }

    public void setFkCodigoTorneo(Torneo fkCodigoTorneo) {
        this.fkCodigoTorneo = fkCodigoTorneo;
    }

    public Equipo getFkIdEquipo() {
        return fkIdEquipo;
    }

    public void setFkIdEquipo(Equipo fkIdEquipo) {
        this.fkIdEquipo = fkIdEquipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipacion != null ? idParticipacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participacion)) {
            return false;
        }
        Participacion other = (Participacion) object;
        if ((this.idParticipacion == null && other.idParticipacion != null) || (this.idParticipacion != null && !this.idParticipacion.equals(other.idParticipacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Participacion[ idParticipacion=" + idParticipacion + " ]";
    }
    
}
