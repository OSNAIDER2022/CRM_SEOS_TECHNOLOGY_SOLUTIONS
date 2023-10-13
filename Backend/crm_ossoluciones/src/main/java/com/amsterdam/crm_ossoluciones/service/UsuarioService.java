package com.amsterdam.crm_ossoluciones.service;

import com.amsterdam.crm_ossoluciones.idao.IdaoUsuario;
import com.amsterdam.crm_ossoluciones.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    private IdaoUsuario<Usuario> usuarioIdaoUsuario;

    //CONSTRUCTOR:
    public UsuarioService(IdaoUsuario<Usuario> usuarioIdaoUsuario) {
        this.usuarioIdaoUsuario = usuarioIdaoUsuario;
    }

    //METODOS:
    public Usuario guardarUsuario(Usuario usuario){ return usuarioIdaoUsuario.guardar(usuario);}
    public List<Usuario> buscarTodosLosUsuarios(String usuarios){ return usuarioIdaoUsuario.buscarTodos(usuarios); }
    public Usuario buscarUsuarioPorId(String tipo, Integer id){ return usuarioIdaoUsuario.buscarPorId(tipo,id); }
    public void eliminarUsuarioPorId(String tipo, Integer id){ usuarioIdaoUsuario.eliminarPorId(tipo,id); }
    public void actualizarUsuario(Usuario usuario){ usuarioIdaoUsuario.actualizar(usuario); }
    public String mostrarPerfilDeRoll(String tipo, String nombreCompleto) { return usuarioIdaoUsuario.mostrarPerfilDeRoll(tipo,nombreCompleto); }
    public Usuario buscarUsuarioPorEmail(String tipo, String email){ return usuarioIdaoUsuario.buscarPorEmail(tipo,email); }
}
