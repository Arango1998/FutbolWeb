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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author camila
 */
@Entity
@Table(name = "usuarios_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioLogin.findAll", query = "SELECT u FROM UsuarioLogin u"),
    @NamedQuery(name = "UsuarioLogin.findByCod", query = "SELECT u FROM UsuarioLogin u WHERE u.cod = :cod"),
    @NamedQuery(name = "UsuarioLogin.findByUsuario", query = "SELECT u FROM UsuarioLogin u WHERE u.usuario = :usuario"),
    @NamedQuery(name = "UsuarioLogin.findByPassword", query = "SELECT u FROM UsuarioLogin u WHERE u.password = :password"),
    @NamedQuery(name = "UsuarioLogin.findByTipousuario", query = "SELECT u FROM UsuarioLogin u WHERE u.tipousuario = :tipousuario"),
    @NamedQuery(name = "UsuarioLogin.findByEstado", query = "SELECT u FROM UsuarioLogin u WHERE u.estado = :estado")})
public class UsuarioLogin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Cod")
    private Long cod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "Tipo_usuario")
    private String tipousuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Estado")
    private boolean estado;
    @JoinColumn(name = "Cod", referencedColumnName = "id_usuario", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuario1;

    public UsuarioLogin() {
    }

    public UsuarioLogin(Long cod) {
        this.cod = cod;
    }

    public UsuarioLogin(Long cod, String usuario, String password, String tipousuario, boolean estado) {
        this.cod = cod;
        this.usuario = usuario;
        this.password = password;
        this.tipousuario = tipousuario;
        this.estado = estado;
    }

    public Long getCod() {
        return cod;
    }

    public void setCod(Long cod) {
        this.cod = cod;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Usuario getUsuario1() {
        return usuario1;
    }

    public void setUsuario1(Usuario usuario1) {
        this.usuario1 = usuario1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cod != null ? cod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioLogin)) {
            return false;
        }
        UsuarioLogin other = (UsuarioLogin) object;
        if ((this.cod == null && other.cod != null) || (this.cod != null && !this.cod.equals(other.cod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.sena.edu.backend.persistens.entities.UsuarioLogin[ cod=" + cod + " ]";
    }
    
}
