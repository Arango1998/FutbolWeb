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
@Table(name = "usuario_horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioHorario.findAll", query = "SELECT u FROM UsuarioHorario u"),
    @NamedQuery(name = "UsuarioHorario.findByIdConsulta", query = "SELECT u FROM UsuarioHorario u WHERE u.idConsulta = :idConsulta")})
public class UsuarioHorario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_consulta")
    private Integer idConsulta;
    @JoinColumn(name = "fk_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario fkIdUsuario;
    @JoinColumn(name = "fk_id_entrenamiento", referencedColumnName = "id_entrenamiento")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Horario fkIdEntrenamiento;

    public UsuarioHorario() {
    }

    public UsuarioHorario(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public Usuario getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(Usuario fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public Horario getFkIdEntrenamiento() {
        return fkIdEntrenamiento;
    }

    public void setFkIdEntrenamiento(Horario fkIdEntrenamiento) {
        this.fkIdEntrenamiento = fkIdEntrenamiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConsulta != null ? idConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHorario)) {
            return false;
        }
        UsuarioHorario other = (UsuarioHorario) object;
        if ((this.idConsulta == null && other.idConsulta != null) || (this.idConsulta != null && !this.idConsulta.equals(other.idConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.UsuarioHorario[ idConsulta=" + idConsulta + " ]";
    }
    
}
