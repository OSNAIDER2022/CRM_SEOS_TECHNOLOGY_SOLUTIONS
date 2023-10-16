package com.amsterdam.crm_ossoluciones.service;

import com.amsterdam.crm_ossoluciones.idao.IdaoRegistroContable;
import com.amsterdam.crm_ossoluciones.model.RegistroContable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroContableService {
    private IdaoRegistroContable<RegistroContable> registroContableIdaoRegistroContable;

    //CONSTRUCTOR:
    public RegistroContableService(IdaoRegistroContable<RegistroContable> registroContableIdaoRegistroContable) {
        this.registroContableIdaoRegistroContable = registroContableIdaoRegistroContable;
    }

    //METODOS:
    public RegistroContable guardarRegistroContable(RegistroContable registroContable){
        return registroContableIdaoRegistroContable.guardar(registroContable);
    }

    public List<RegistroContable> listarTodosLosRegistrosContables(){
        return registroContableIdaoRegistroContable.buscarTodos();
    }

    public RegistroContable buscarRegistroContablePorId(Integer id){
        return registroContableIdaoRegistroContable.buscarPorId(id);
    }

    public void eliminarRegistroContablePorId(Integer id){
        registroContableIdaoRegistroContable.eliminarPorId(id);
    }

    public void actualizarRegistroContable(RegistroContable registroContable){
        registroContableIdaoRegistroContable.actualizar(registroContable);
    }

}
