package com.mycompany.login.logica;

import com.mycompany.login.logica.Usuario;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-08-08T15:32:04", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Rol.class)
public class Rol_ { 

    public static volatile SingularAttribute<Rol, String> descripcion;
    public static volatile ListAttribute<Rol, Usuario> listaUsuarios;
    public static volatile SingularAttribute<Rol, String> nombreRol;
    public static volatile SingularAttribute<Rol, Integer> id;

}