package com.amsterdam.crm_ossoluciones.service;

import com.amsterdam.crm_ossoluciones.idao.IdaoGeneral;
import com.amsterdam.crm_ossoluciones.model.General;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GeneralService {
    private IdaoGeneral<General> generalIdaoGeneral;

    //CONSTRUCTOR:
    public GeneralService(IdaoGeneral<General> generalIdaoGeneral) {
        this.generalIdaoGeneral = generalIdaoGeneral;
    }

    //METODOS:
    public General guardarGeneral(String tipo,General general){ return generalIdaoGeneral.guardar(tipo,general); }
    public List<General> listarTodosGenerales(String generales){ return generalIdaoGeneral.buscarTodos(generales); }
    public General buscarGeneralPorId(String tipo, Integer id){ return generalIdaoGeneral.buscarPorId(tipo,id); }
    public void eliminarGeneralPorId(String tipo, Integer id){ generalIdaoGeneral.eliminarPorId(tipo,id); }
    public void actualizarGeneral(String tipo, General general){ generalIdaoGeneral.actualizar(tipo,general); }
}
