package com.proyecto.fabricacion.service;

import java.util.List;

import com.proyecto.fabricacion.model.Fabricacion;

public interface FabricacionService {
    List<Fabricacion> fabricaciones();
    void nuevaFabricacion (Fabricacion fabricacion);
    double consultarCostePorId (int idFabricacion);
    List<Fabricacion> filtrarPorCoste (double costeMinimo, double costeMaximo);
}
