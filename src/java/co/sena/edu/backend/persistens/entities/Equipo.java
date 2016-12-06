/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sena.edu.backend.persistens.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "equipos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Equipo.findAll", query = "SELECT e FROM Equipo e"),
    @NamedQuery(name = "Equipo.findByIdEquipo", query = "SELECT e FROM Equipo e WHERE e.idEquipo = :idEquipo"),
    @NamedQuery(name = "Equipo.findByNombreEquipo", query = "SELECT e FROM Equipo e WHERE e.nombreEquipo = :nombreEquipo"),
    @NamedQuery(name = "Equipo.findByNJugadores", query = "SELECT e FROM Equipo e WHERE e.nJugadores = :nJugadores")})
public class Equipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_equipo")
    private Integer idEquipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_equipo")
    private String nombreEquipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n\u00b0_jugadores")
    private int nJugadores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEquipo", fetch = FetchType.EAGER)
    private List<AsignacionEquipo> asignacionEquipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdEquipo", fetch = FetchType.EAGER)
    private List<Participacion> participacionList;
    @JoinColumn(name = "fk_id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Categoria fkIdCategoria;

    public Equipo() {
    }

    public Equipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public Equipo(Integer idEquipo, String nombreEquipo, int nJugadores) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.nJugadores = nJugadores;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getNJugadores() {
        return nJugadores;
    }

    public void setNJugadores(int nJugadores) {
        this.nJugadores = nJugadores;
    }

    @XmlTransient
    public List<AsignacionEquipo> getAsignacionEquipoList() {
        return asignacionEquipoList;
    }

    public void setAsignacionEquipoList(List<AsignacionEquipo> asignacionEquipoList) {
        this.asignacionEquipoList = asignacionEquipoList;
    }

    @XmlTransient
    public List<Participacion> getParticipacionList() {
        return participacionList;
    }

    public void setParticipacionList(List<Participacion> participacionList) {
        this.participacionList = participacionList;
    }

    public Categoria getFkIdCategoria() {
        return fkIdCategoria;
    }

    public void setFkIdCategoria(Categoria fkIdCategoria) {
        this.fkIdCategoria = fkIdCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEquipo != null ? idEquipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.idEquipo == null && other.idEquipo != null) || (this.idEquipo != null && !this.idEquipo.equals(other.idEquipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Equipo[ idEquipo=" + idEquipo + " ]";
    }
    
}
