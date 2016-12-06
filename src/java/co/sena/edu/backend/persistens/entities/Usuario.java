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
import javax.persistence.OneToOne;
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
@Table(name = "usuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByPrimerNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.primerNombreUsuario = :primerNombreUsuario"),
    @NamedQuery(name = "Usuario.findBySegundoNombreUsuario", query = "SELECT u FROM Usuario u WHERE u.segundoNombreUsuario = :segundoNombreUsuario"),
    @NamedQuery(name = "Usuario.findByPrimerApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.primerApellidoUsuario = :primerApellidoUsuario"),
    @NamedQuery(name = "Usuario.findBySegundoApellidoUsuario", query = "SELECT u FROM Usuario u WHERE u.segundoApellidoUsuario = :segundoApellidoUsuario"),
    @NamedQuery(name = "Usuario.findByContrase\u00f1a", query = "SELECT u FROM Usuario u WHERE u.contrase\u00f1a = :contrase\u00f1a"),
    @NamedQuery(name = "Usuario.findByFechaDeNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaDeNacimiento = :fechaDeNacimiento"),
    @NamedQuery(name = "Usuario.findByGenero", query = "SELECT u FROM Usuario u WHERE u.genero = :genero"),
    @NamedQuery(name = "Usuario.findByRh", query = "SELECT u FROM Usuario u WHERE u.rh = :rh"),
    @NamedQuery(name = "Usuario.findByEps", query = "SELECT u FROM Usuario u WHERE u.eps = :eps"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = :email"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "primer_nombre_usuario")
    private String primerNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "segundo_nombre_usuario")
    private String segundoNombreUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "primer_apellido_usuario")
    private String primerApellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "segundo_apellido_usuario")
    private String segundoApellidoUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_de_nacimiento")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "rh")
    private String rh;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "eps")
    private String eps;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private long telefono;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<AsignacionEquipo> asignacionEquipoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<UsuarioHorario> usuarioHorarioList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usuario1", fetch = FetchType.EAGER)
    private UsuarioLogin usuarioLogin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<Jugador> jugadorList;
    @JoinColumn(name = "fk_id_tipo_rol", referencedColumnName = "id_tipo_rol")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Rol fkIdTipoRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<Pago> pagoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<RevisionSeguimiento> revisionSeguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkIdUsuario", fetch = FetchType.EAGER)
    private List<AsignacionActividad> asignacionActividadList;

    public Usuario() {
    }

    public Usuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Long idUsuario, String primerNombreUsuario, String segundoNombreUsuario, String primerApellidoUsuario, String segundoApellidoUsuario, String contraseña, Date fechaDeNacimiento, String genero, String rh, String eps, long telefono, String email, String estado) {
        this.idUsuario = idUsuario;
        this.primerNombreUsuario = primerNombreUsuario;
        this.segundoNombreUsuario = segundoNombreUsuario;
        this.primerApellidoUsuario = primerApellidoUsuario;
        this.segundoApellidoUsuario = segundoApellidoUsuario;
        this.contraseña = contraseña;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.genero = genero;
        this.rh = rh;
        this.eps = eps;
        this.telefono = telefono;
        this.email = email;
        this.estado = estado;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombreUsuario() {
        return primerNombreUsuario;
    }

    public void setPrimerNombreUsuario(String primerNombreUsuario) {
        this.primerNombreUsuario = primerNombreUsuario;
    }

    public String getSegundoNombreUsuario() {
        return segundoNombreUsuario;
    }

    public void setSegundoNombreUsuario(String segundoNombreUsuario) {
        this.segundoNombreUsuario = segundoNombreUsuario;
    }

    public String getPrimerApellidoUsuario() {
        return primerApellidoUsuario;
    }

    public void setPrimerApellidoUsuario(String primerApellidoUsuario) {
        this.primerApellidoUsuario = primerApellidoUsuario;
    }

    public String getSegundoApellidoUsuario() {
        return segundoApellidoUsuario;
    }

    public void setSegundoApellidoUsuario(String segundoApellidoUsuario) {
        this.segundoApellidoUsuario = segundoApellidoUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRh() {
        return rh;
    }

    public void setRh(String rh) {
        this.rh = rh;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<AsignacionEquipo> getAsignacionEquipoList() {
        return asignacionEquipoList;
    }

    public void setAsignacionEquipoList(List<AsignacionEquipo> asignacionEquipoList) {
        this.asignacionEquipoList = asignacionEquipoList;
    }

    @XmlTransient
    public List<UsuarioHorario> getUsuarioHorarioList() {
        return usuarioHorarioList;
    }

    public void setUsuarioHorarioList(List<UsuarioHorario> usuarioHorarioList) {
        this.usuarioHorarioList = usuarioHorarioList;
    }

    public UsuarioLogin getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(UsuarioLogin usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    @XmlTransient
    public List<Jugador> getJugadorList() {
        return jugadorList;
    }

    public void setJugadorList(List<Jugador> jugadorList) {
        this.jugadorList = jugadorList;
    }

    public Rol getFkIdTipoRol() {
        return fkIdTipoRol;
    }

    public void setFkIdTipoRol(Rol fkIdTipoRol) {
        this.fkIdTipoRol = fkIdTipoRol;
    }

    @XmlTransient
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @XmlTransient
    public List<RevisionSeguimiento> getRevisionSeguimientoList() {
        return revisionSeguimientoList;
    }

    public void setRevisionSeguimientoList(List<RevisionSeguimiento> revisionSeguimientoList) {
        this.revisionSeguimientoList = revisionSeguimientoList;
    }

    @XmlTransient
    public List<AsignacionActividad> getAsignacionActividadList() {
        return asignacionActividadList;
    }

    public void setAsignacionActividadList(List<AsignacionActividad> asignacionActividadList) {
        this.asignacionActividadList = asignacionActividadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
