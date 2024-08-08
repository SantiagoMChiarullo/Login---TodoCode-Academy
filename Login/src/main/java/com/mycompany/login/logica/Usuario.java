package com.mycompany.login.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/*import javax.persistence.OneToOne;*/

/**
 *
 * @author Santiago
 */

@Entity
public class Usuario implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id;
    private String nombreUsuario;
    private String Contrasenia;
    @ManyToOne
    @JoinColumn(name="fk_rol")    
    private Rol unRol;

    public Usuario() {
    }

    public Usuario(int id, String nombreUsuario, String Contrasenia, Rol unRol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.Contrasenia = Contrasenia;
        this.unRol = unRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasenia() {
        return Contrasenia;
    }

    public void setContrasenia(String Contrasenia) {
        this.Contrasenia = Contrasenia;
    }

    public Rol getUnRol() {
        return unRol;
    }

    public void setUnRol(Rol unRol) {
        this.unRol = unRol;
    }
    
    
    
    
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", contrase\u00f1a=" + Contrasenia + '}';
    }

    
}
