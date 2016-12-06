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
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdEntrenamiento", query = "SELECT h FROM Horario h WHERE h.idEntrenamiento = :idEntrenamiento"),
    @NamedQuery(name = "Horario.findByFecha", query = "SELECT h FROM Horario h WHERE h.fecha = :fecha"),
    @NamedQuery(name = "Horario.findByHoraDeInicio", query = "SELECT h FROM Horario h WHERE h.horaDeInicio = :horaDeInicio"),
    @NamedQuery(name = "Horario.findByHoraDeFin", query = "SELECT h FROM Horario h WHERE h.horaDeFin = :horaDeFin"),
    @NamedQuery(name = "Horario.findByTipoEntrenamiento", query = "SELECT h FROM Horario h WHERE h.tipoEntrenamiento = :tipoEntrenamiento")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entrenamiento")
    private Integer idEntrenamiento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_de_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaDeInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora_de_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaDeFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "tipo_entrenamiento")
    private String tipoEntrenamiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEntrenamiento", fetch = FetchType.EAGER)
    private List<UsuarioHorario> usuarioHorarioList;

    public Horario() {
    }

    public Horario(Integer idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }

    public Horario(Integer idEntrenamiento, Date fecha, Date horaDeInicio, Date horaDeFin, String tipoEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
        this.fecha = fecha;
        this.horaDeInicio = horaDeInicio;
        this.horaDeFin = horaDeFin;
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    public Integer getIdEntrenamiento() {
        return idEntrenamiento;
    }

    public void setIdEntrenamiento(Integer idEntrenamiento) {
        this.idEntrenamiento = idEntrenamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHoraDeInicio() {
        return horaDeInicio;
    }

    public void setHoraDeInicio(Date horaDeInicio) {
        this.horaDeInicio = horaDeInicio;
    }

    public Date getHoraDeFin() {
        return horaDeFin;
    }

    public void setHoraDeFin(Date horaDeFin) {
        this.horaDeFin = horaDeFin;
    }

    public String getTipoEntrenamiento() {
        return tipoEntrenamiento;
    }

    public void setTipoEntrenamiento(String tipoEntrenamiento) {
        this.tipoEntrenamiento = tipoEntrenamiento;
    }

    @XmlTransient
    public List<UsuarioHorario> getUsuarioHorarioList() {
        return usuarioHorarioList;
    }

    public void setUsuarioHorarioList(List<UsuarioHorario> usuarioHorarioList) {
        this.usuarioHorarioList = usuarioHorarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrenamiento != null ? idEntrenamiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idEntrenamiento == null && other.idEntrenamiento != null) || (this.idEntrenamiento != null && !this.idEntrenamiento.equals(other.idEntrenamiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Horario[ idEntrenamiento=" + idEntrenamiento + " ]";
    }
    
}
