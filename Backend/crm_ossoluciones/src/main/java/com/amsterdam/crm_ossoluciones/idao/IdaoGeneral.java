package com.amsterdam.crm_ossoluciones.idao;

import java.util.List;

public interface IdaoGeneral<T> {
    T guardar(String tipo, T t);
    List<T> buscarTodos(String generales);
    T buscarPorId(String tipo, Integer id);
    void eliminarPorId(String tipo, Integer id);
    void actualizar(String tipo,T t);
}
