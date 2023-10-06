package com.proyecto.fabricacion.service;

import java.util.List;

import com.proyecto.fabricacion.model.Fabricacion;

public interface FabricacionService {
    List<Fabricacion> fabricaciones();
    void nuevaFabricacion (int idModelo, int cantidadModelos);
    double consultarCosteMonetarioPorId (int idFabricacion);
    int consultarCostePiezasPorId (int idFabricacion);
    List<Fabricacion> filtrarPorCoste (double costeMinimo, double costeMaximo);
}
