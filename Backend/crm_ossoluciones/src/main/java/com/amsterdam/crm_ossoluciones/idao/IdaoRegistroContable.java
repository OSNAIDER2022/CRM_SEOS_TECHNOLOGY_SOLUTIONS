package com.amsterdam.crm_ossoluciones.idao;

import java.util.List;

public interface IdaoRegistroContable<T> {
    T guardar( T t);
    List<T> buscarTodos();
    T buscarPorId( Integer id);
    void eliminarPorId( Integer id);
    void actualizar( T t);
}
