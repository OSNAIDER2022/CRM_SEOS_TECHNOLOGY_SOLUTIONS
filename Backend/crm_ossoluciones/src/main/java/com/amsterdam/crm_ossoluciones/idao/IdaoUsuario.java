package com.amsterdam.crm_ossoluciones.idao;

import java.util.List;

public interface IdaoUsuario<T> {
    T guardar(T t);
    List<T> buscarTodos(String usuarios);
    T buscarPorId(String tipo, Integer id);
    void eliminarPorId(String tipo, Integer id);
    void actualizar(T t);
    String mostrarPerfilDeRoll(String nombreCompleto);
    T buscarPorEmail(String email);
}
