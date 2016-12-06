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
@Table(name = "fechas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fecha.findAll", query = "SELECT f FROM Fecha f"),
    @NamedQuery(name = "Fecha.findByIdFechaProgramada", query = "SELECT f FROM Fecha f WHERE f.idFechaProgramada = :idFechaProgramada"),
    @NamedQuery(name = "Fecha.findByHoraEncuentro", query = "SELECT f FROM Fecha f WHERE f.horaEncuentro = :horaEncuentro"),
    @NamedQuery(name = "Fecha.findByFechaEncuentro", query = "SELECT f FROM Fecha f WHERE f.fechaEncuentro = :fechaEncuentro")})
public class Fecha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fecha_programada")
    private Integer idFechaProgramada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_encuentro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEncuentro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_encuentro")
    @Temporal(TemporalType.DATE)
    private Date fechaEncuentro;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "encuentro")
    private String encuentro;
    @JoinColumn(name = "fk_codigo_torneo", referencedColumnName = "codigo_torneo")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Torneo fkCodigoTorneo;

    public Fecha() {
    }

    public Fecha(Integer idFechaProgramada) {
        this.idFechaProgramada = idFechaProgramada;
    }

    public Fecha(Integer idFechaProgramada, Date horaEncuentro, Date fechaEncuentro, String encuentro) {
        this.idFechaProgramada = idFechaProgramada;
        this.horaEncuentro = horaEncuentro;
        this.fechaEncuentro = fechaEncuentro;
        this.encuentro = encuentro;
    }

    public Integer getIdFechaProgramada() {
        return idFechaProgramada;
    }

    public void setIdFechaProgramada(Integer idFechaProgramada) {
        this.idFechaProgramada = idFechaProgramada;
    }

    public Date getHoraEncuentro() {
        return horaEncuentro;
    }

    public void setHoraEncuentro(Date horaEncuentro) {
        this.horaEncuentro = horaEncuentro;
    }

    public Date getFechaEncuentro() {
        return fechaEncuentro;
    }

    public void setFechaEncuentro(Date fechaEncuentro) {
        this.fechaEncuentro = fechaEncuentro;
    }

    public String getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(String encuentro) {
        this.encuentro = encuentro;
    }

    public Torneo getFkCodigoTorneo() {
        return fkCodigoTorneo;
    }

    public void setFkCodigoTorneo(Torneo fkCodigoTorneo) {
        this.fkCodigoTorneo = fkCodigoTorneo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFechaProgramada != null ? idFechaProgramada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fecha)) {
            return false;
        }
        Fecha other = (Fecha) object;
        if ((this.idFechaProgramada == null && other.idFechaProgramada != null) || (this.idFechaProgramada != null && !this.idFechaProgramada.equals(other.idFechaProgramada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Fecha[ idFechaProgramada=" + idFechaProgramada + " ]";
    }
    
}
