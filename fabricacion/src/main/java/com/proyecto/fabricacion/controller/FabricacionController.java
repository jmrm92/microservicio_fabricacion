package com.proyecto.fabricacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.fabricacion.model.Fabricacion;
import com.proyecto.fabricacion.service.FabricacionServiceImpl;

@RestController
public class FabricacionController {
    
    @Autowired
    FabricacionServiceImpl servicio;

    /**
     * La función anterior es un mapeo de solicitud GET que devuelve una lista de objetos de
     * Fabricación en formato JSON.
     * 
     * @return Se devuelve una Lista de objetos de Fabricación.
     */
    @GetMapping (value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabricacion> obtenerFabricaciones() {
        return servicio.fabricaciones();
    }

    /**
     * La función "presupuesto" devuelve el coste de un proceso de fabricación dado su ID.
     * 
     * @param idFabricacion El parámetro "idFabricacion" es un valor entero que representa el ID de una
     * fabricación.
     * @return El método devuelve un valor doble, que representa el costo o presupuesto de un ID de
     * fabricación específico.
     */
    @GetMapping (value = "/coste/{idFabricacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public double presupuesto(@PathVariable("idFabricacion") int idFabricacion) {
        return servicio.consultarCosteMonetarioPorId(idFabricacion);
    }

    /**
     * Esta función Java filtra una lista de objetos de "Fabricación" en función de un costo mínimo y
     * máximo.
     * 
     * @param costeMinimo El valor de costo mínimo para el filtrado.
     * @param costeMaximo El parámetro costeMaximo representa el valor de costo máximo para filtrar los
     * objetos de Fabricación.
     * @return El método devuelve una Lista de objetos de Fabricación.
     */
    @GetMapping (value = "/filtro/{costeMinimo}/{costeMaximo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Fabricacion> filtrarPorCoste(@PathVariable("costeMinimo") double costeMinimo, @PathVariable("costeMaximo") double costeMaximo) {
        return servicio.filtrarPorCoste(costeMinimo, costeMaximo);
    }


    /**
     * La función "nuevaFabricacion" toma dos parámetros, "idModelo" y "cantidadModelos", y llama al
     * método "nuevaFabricacion" desde el objeto "servicio" con estos parámetros.
     * 
     * @param idModelo La identificación del modelo para el cual se está creando la fabricación.
     * @param cantidadModelos El parámetro "cantidadModelos" representa la cantidad de modelos a
     * fabricar.
     */
    @PostMapping (value = "/{idModelo}/{cantidadModelos}")
    public void nuevaFabricacion(@PathVariable("idModelo") int idModelo, @PathVariable("cantidadModelos") int cantidadModelos) {
        servicio.nuevaFabricacion(idModelo, cantidadModelos);
    }
}
