package com.proyecto.fabricacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.fabricacion.model.Fabricacion;
import com.proyecto.fabricacion.service.FabricacionServiceImpl;

@RestController
public class FabricacionController {
    
    @Autowired
    FabricacionServiceImpl servicio;

    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabricacion> obtenerFabricaciones() {
        return servicio.fabricaciones();
    }

    @GetMapping (value = "/coste/{idFabricacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double presupuesto(@PathVariable("idFabricacion") int idFabricacion) {
        return servicio.consultarCostePorId(idFabricacion);
    }

    @GetMapping (value = "/filtrar/{costeMinimo}/{costeMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabricacion> filtrarPorCoste(@PathVariable("costeMinimo") double costeMinimo, @PathVariable("costeMaximo") double costeMaximo) {
        return servicio.filtrarPorCoste(costeMinimo, costeMaximo);
    }
    @PostMapping (value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void nuevaFabricacion(@RequestBody Fabricacion fabricacion) {
        servicio.nuevaFabricacion(fabricacion);
    }
}
