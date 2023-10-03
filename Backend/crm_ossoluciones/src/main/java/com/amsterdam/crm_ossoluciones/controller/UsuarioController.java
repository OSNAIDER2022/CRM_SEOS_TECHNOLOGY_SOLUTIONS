package com.amsterdam.crm_ossoluciones.controller;

import com.amsterdam.crm_ossoluciones.model.Usuario;
import com.amsterdam.crm_ossoluciones.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioService usuarioService;

    //CONSTRUCTOR:
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //METODOS:
    //POST
    @PostMapping
    public ResponseEntity<Usuario> guardarUsuario(@RequestBody Usuario usuario){
        return ResponseEntity.ok(usuarioService.guardarUsuario(usuario));
    }
    //GET
    @GetMapping("{usuarios}")
    public ResponseEntity<List<Usuario>> mostrarTodosLosUsuarios(@PathVariable String usuarios){
        return ResponseEntity.ok(usuarioService.buscarTodosLosUsuarios(usuarios));
    }
    @GetMapping("/buscar_id/{tipo}={id}")
    public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable String tipo, @PathVariable Integer id){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(tipo,id));
    }
    @GetMapping("/buscar_nombre/{nombreCompleto}")
    public ResponseEntity<String> mostrarPerfilDelRoll(@PathVariable String nombreCompleto){
        return ResponseEntity.ok(usuarioService.mostrarPerfilDeRoll(nombreCompleto));
    }
    @GetMapping("/buscarEmail/{email}")
    public ResponseEntity<Usuario> buscarUsuarioPorEmail(@PathVariable String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
    //DELETE
    @DeleteMapping("/eliminar_id/{tipo}={id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable String tipo, @PathVariable Integer id){
        usuarioService.eliminarUsuarioPorId(tipo,id);
        return ResponseEntity.ok("Se ha eliminado el usuario");
    }
    //PUT
    @PutMapping
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario){
        usuarioService.actualizarUsuario(usuario);
        return ResponseEntity.ok(usuario);
    }
}
