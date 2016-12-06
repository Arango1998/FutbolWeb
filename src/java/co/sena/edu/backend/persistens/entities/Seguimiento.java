/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "seguimientos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByCodigoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.codigoSeguimiento = :codigoSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByFechaInicio", query = "SELECT s FROM Seguimiento s WHERE s.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "Seguimiento.findByFechaFin", query = "SELECT s FROM Seguimiento s WHERE s.fechaFin = :fechaFin"),
    @NamedQuery(name = "Seguimiento.findByResultadoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.resultadoSeguimiento = :resultadoSeguimiento")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_seguimiento")
    private Integer codigoSeguimiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "resultado_seguimiento")
    private String resultadoSeguimiento;
    @JoinColumn(name = "fk_id_jugador", referencedColumnName = "id_jugador")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jugador fkIdJugador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCodigoSeguimiento", fetch = FetchType.EAGER)
    private List<RevisionSeguimiento> revisionSeguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCodigoSeguimiento", fetch = FetchType.EAGER)
    private List<Evaluacion> evaluacionList;

    public Seguimiento() {
    }

    public Seguimiento(Integer codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public Seguimiento(Integer codigoSeguimiento, Date fechaInicio, Date fechaFin, String resultadoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.resultadoSeguimiento = resultadoSeguimiento;
    }

    public Integer getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(Integer codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getResultadoSeguimiento() {
        return resultadoSeguimiento;
    }

    public void setResultadoSeguimiento(String resultadoSeguimiento) {
        this.resultadoSeguimiento = resultadoSeguimiento;
    }

    public Jugador getFkIdJugador() {
        return fkIdJugador;
    }

    public void setFkIdJugador(Jugador fkIdJugador) {
        this.fkIdJugador = fkIdJugador;
    }

    @XmlTransient
    public List<RevisionSeguimiento> getRevisionSeguimientoList() {
        return revisionSeguimientoList;
    }

    public void setRevisionSeguimientoList(List<RevisionSeguimiento> revisionSeguimientoList) {
        this.revisionSeguimientoList = revisionSeguimientoList;
    }

    @XmlTransient
    public List<Evaluacion> getEvaluacionList() {
        return evaluacionList;
    }

    public void setEvaluacionList(List<Evaluacion> evaluacionList) {
        this.evaluacionList = evaluacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSeguimiento != null ? codigoSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codigoSeguimiento == null && other.codigoSeguimiento != null) || (this.codigoSeguimiento != null && !this.codigoSeguimiento.equals(other.codigoSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Seguimiento[ codigoSeguimiento=" + codigoSeguimiento + " ]";
    }
    
}
