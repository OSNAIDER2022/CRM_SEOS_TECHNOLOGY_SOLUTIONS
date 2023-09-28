package com.amsterdam.crm_ossoluciones.idao;

import java.util.List;

public interface IdaoUsuario<T> {
    T guardar(T t);
    List<T> buscarTodos();
    T buscarPorId(Integer id);
    void eliminarPorId(Integer id);
    void actualizar(T t);
    String mostrarPerfilDeRoll(String nombreCompleto);
    T buscarPorEmail(String email);
}
