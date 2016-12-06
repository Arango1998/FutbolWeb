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
@Table(name = "evaluaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evaluacion.findAll", query = "SELECT e FROM Evaluacion e"),
    @NamedQuery(name = "Evaluacion.findByIdEvaluacion", query = "SELECT e FROM Evaluacion e WHERE e.idEvaluacion = :idEvaluacion"),
    @NamedQuery(name = "Evaluacion.findByValoracionNota", query = "SELECT e FROM Evaluacion e WHERE e.valoracionNota = :valoracionNota")})
public class Evaluacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_evaluacion")
    private Integer idEvaluacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valoracion_nota")
    private int valoracionNota;
    @JoinColumn(name = "fk_id_desempe\u00f1o", referencedColumnName = "id_desempe\u00f1o")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Desempeño fkIdDesempeño;
    @JoinColumn(name = "fk_codigo_seguimiento", referencedColumnName = "codigo_seguimiento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Seguimiento fkCodigoSeguimiento;

    public Evaluacion() {
    }

    public Evaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public Evaluacion(Integer idEvaluacion, int valoracionNota) {
        this.idEvaluacion = idEvaluacion;
        this.valoracionNota = valoracionNota;
    }

    public Integer getIdEvaluacion() {
        return idEvaluacion;
    }

    public void setIdEvaluacion(Integer idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public int getValoracionNota() {
        return valoracionNota;
    }

    public void setValoracionNota(int valoracionNota) {
        this.valoracionNota = valoracionNota;
    }

    public Desempeño getFkIdDesempeño() {
        return fkIdDesempeño;
    }

    public void setFkIdDesempeño(Desempeño fkIdDesempeño) {
        this.fkIdDesempeño = fkIdDesempeño;
    }

    public Seguimiento getFkCodigoSeguimiento() {
        return fkCodigoSeguimiento;
    }

    public void setFkCodigoSeguimiento(Seguimiento fkCodigoSeguimiento) {
        this.fkCodigoSeguimiento = fkCodigoSeguimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEvaluacion != null ? idEvaluacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evaluacion)) {
            return false;
        }
        Evaluacion other = (Evaluacion) object;
        if ((this.idEvaluacion == null && other.idEvaluacion != null) || (this.idEvaluacion != null && !this.idEvaluacion.equals(other.idEvaluacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Evaluacion[ idEvaluacion=" + idEvaluacion + " ]";
    }
    
}
