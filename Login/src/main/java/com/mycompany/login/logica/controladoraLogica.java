/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.login.logica;

import com.mycompany.login.persistencia.controladoraPersistencia;
import java.util.List;

/**
 *
 * @author Santiago
 */
public class controladoraLogica {

   

    controladoraPersistencia controlPersis;// = new controladoraPersistencia();

    public controladoraLogica() {
        controlPersis = new controladoraPersistencia();
    }

    public Usuario validarUsuario(String usuario, String contrasenia) {

        // boolean ok = false;
//  String mensaje = "";
        Usuario usr = null;

        List<Usuario> listaUsuarios = controlPersis.traerUsuarios();
        for (Usuario usu : listaUsuarios) {
            if (usu.getNombreUsuario().equals(usuario)) {
                if (usu.getContrasenia().equals(contrasenia)) {
                    //                mensaje ="Usuario y contraseña correctos. Bienvenidos!";
                    usr = usu;
                    return usr;
                } else {
                    //              mensaje = "Usuario o contraseña incorrectos";
                    usr = null;
                    return usr;
                }
            } else {

                usr = null;
                //return usr;
                //mensaje = "Usuario o contraseña incorrectos";
            }

        }
        return usr;

    }
 
    
    public List<Usuario> traerUsuarios() {
           return controlPersis.traerUsuarios();
    }
  
    public List<Rol> traerRoles(){
        return controlPersis.traerRoles();
    }
    
    public void crearUsuario(String usuario, String contrasenia, String rolRecibido)
    {
        Usuario usu = new Usuario();
        usu.setNombreUsuario(usuario);
        usu.setContrasenia(contrasenia);
        
        
        Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado!=null){
        usu.setUnRol(rolEncontrado);
        }
        
        int id = this.buscarUltimaIdUsuario();
        usu.setId(id+1);
        
        
        controlPersis.crearUsuario(usu);
    }

    private Rol traerRol(String rolRecibido) {
        List<Rol> listaRoles = controlPersis.traerRoles();
        
        for (Rol rol:listaRoles){
            if (rol.getNombreRol().equals(rolRecibido)){
                return rol;
            }
        }
        return null;
    }

    private int buscarUltimaIdUsuario() {
        List<Usuario> listaUsuarios = this.traerUsuarios();
        Usuario usu = listaUsuarios.get(listaUsuarios.size()-1);
        return usu.getId();
        
    }

    public void borrarUsuario(int id_usuario) {
        
        controlPersis.borrarUsuario(id_usuario);
        
       
    }

    public Usuario traerUsuario(int id_usuario) {
        return controlPersis.traerUsuario(id_usuario);
        
    }

    public void editarUsuario(Usuario usu, String usuario, String contrasenia, String rol, String rolRecibido) {
       usu.setNombreUsuario(usuario);
       usu.setContrasenia(contrasenia);
       
               Rol rolEncontrado = new Rol();
        rolEncontrado = this.traerRol(rolRecibido);
        if(rolEncontrado!=null){
        usu.setUnRol(rolEncontrado);
        }
    controlPersis.editarUsuario(usu);
    
    }
}
