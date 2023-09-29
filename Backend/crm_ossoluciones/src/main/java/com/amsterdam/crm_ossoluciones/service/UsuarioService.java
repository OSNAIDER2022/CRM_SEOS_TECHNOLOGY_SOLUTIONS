package com.amsterdam.crm_ossoluciones.service;

import com.amsterdam.crm_ossoluciones.idao.IdaoUsuario;
import com.amsterdam.crm_ossoluciones.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private IdaoUsuario<Usuario> usuarioIdaoUsuario;

    //CONSTRUCTOR:
    public UsuarioService(IdaoUsuario<Usuario> usuarioIdaoUsuario) {
        this.usuarioIdaoUsuario = usuarioIdaoUsuario;
    }

    //METODOS:
    public Usuario guardarUsuario(Usuario usuario){
        return usuarioIdaoUsuario.guardar(usuario);
    }
}
