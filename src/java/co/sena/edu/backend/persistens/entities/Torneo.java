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
@Table(name = "torneos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Torneo.findAll", query = "SELECT t FROM Torneo t"),
    @NamedQuery(name = "Torneo.findByCodigoTorneo", query = "SELECT t FROM Torneo t WHERE t.codigoTorneo = :codigoTorneo"),
    @NamedQuery(name = "Torneo.findByNombreTorneo", query = "SELECT t FROM Torneo t WHERE t.nombreTorneo = :nombreTorneo"),
    @NamedQuery(name = "Torneo.findByOrganizador", query = "SELECT t FROM Torneo t WHERE t.organizador = :organizador")})
public class Torneo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_torneo")
    private Integer codigoTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "nombre_torneo")
    private String nombreTorneo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "organizador")
    private String organizador;
    @JoinColumn(name = "fk_id_barrio", referencedColumnName = "id_barrio")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Barrio fkIdBarrio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCodigoTorneo", fetch = FetchType.EAGER)
    private List<Participacion> participacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkCodigoTorneo", fetch = FetchType.EAGER)
    private List<Fecha> fechaList;

    public Torneo() {
    }

    public Torneo(Integer codigoTorneo) {
        this.codigoTorneo = codigoTorneo;
    }

    public Torneo(Integer codigoTorneo, String nombreTorneo, String organizador) {
        this.codigoTorneo = codigoTorneo;
        this.nombreTorneo = nombreTorneo;
        this.organizador = organizador;
    }

    public Integer getCodigoTorneo() {
        return codigoTorneo;
    }

    public void setCodigoTorneo(Integer codigoTorneo) {
        this.codigoTorneo = codigoTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getOrganizador() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador = organizador;
    }

    public Barrio getFkIdBarrio() {
        return fkIdBarrio;
    }

    public void setFkIdBarrio(Barrio fkIdBarrio) {
        this.fkIdBarrio = fkIdBarrio;
    }

    @XmlTransient
    public List<Participacion> getParticipacionList() {
        return participacionList;
    }

    public void setParticipacionList(List<Participacion> participacionList) {
        this.participacionList = participacionList;
    }

    @XmlTransient
    public List<Fecha> getFechaList() {
        return fechaList;
    }

    public void setFechaList(List<Fecha> fechaList) {
        this.fechaList = fechaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTorneo != null ? codigoTorneo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Torneo)) {
            return false;
        }
        Torneo other = (Torneo) object;
        if ((this.codigoTorneo == null && other.codigoTorneo != null) || (this.codigoTorneo != null && !this.codigoTorneo.equals(other.codigoTorneo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Torneo[ codigoTorneo=" + codigoTorneo + " ]";
    }
    
}
