package com.amsterdam.crm_ossoluciones.controller;

import com.amsterdam.crm_ossoluciones.model.General;
import com.amsterdam.crm_ossoluciones.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/general")
public class GeneralController {
    private GeneralService generalService;

    //CONSTRUCTOR:
    @Autowired
    public GeneralController(GeneralService generalService) {
        this.generalService = generalService;
    }

    //METODOS:
    @PostMapping("{tipo}")
    public ResponseEntity<General> guardarGeneral(@PathVariable String tipo, @RequestBody General general){
        return ResponseEntity.ok(generalService.guardarGeneral(tipo,general));
    }

    @GetMapping("{generales}")
    public ResponseEntity<List<General>> mostrarTodosLosGenerales(@PathVariable String generales){
        return ResponseEntity.ok(generalService.listarTodosGenerales(generales));
    }

    @GetMapping("/buscar_id/{tipo}={id}")
    public ResponseEntity<General> buscarGeneralPorId(@PathVariable String tipo, @PathVariable Integer id){
        return ResponseEntity.ok(generalService.buscarGeneralPorId(tipo,id));
    }

    @DeleteMapping("/eliminar_id/{tipo}={id}")
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable String tipo, @PathVariable Integer id){
        generalService.eliminarGeneralPorId(tipo,id);
        return ResponseEntity.ok("Se ha eliminado un GENERAL");
    }

    @PutMapping("/actualizar/{tipo}")
    public ResponseEntity<General> actualizarGeneral(@PathVariable String tipo, @RequestBody General general){
        generalService.actualizarGeneral(tipo,general);
        return ResponseEntity.ok(general);
    }

}
