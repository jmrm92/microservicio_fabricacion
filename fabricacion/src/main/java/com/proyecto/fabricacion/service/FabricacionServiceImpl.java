package com.proyecto.fabricacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.fabricacion.dao.FabricacionDao;
import com.proyecto.fabricacion.model.Fabricacion;

@Service
public class FabricacionServiceImpl implements FabricacionService{

    @Autowired
    FabricacionDao dao;

    @Override
    public List<Fabricacion> fabricaciones() {
        return dao.findAll();
    }

    @Override
    public void nuevaFabricacion(Fabricacion fabricacion) {
        dao.save(fabricacion);
    }

    @Override
    public double consultarCostePorId(int idFabricacion) {
        return dao.findById(idFabricacion).get().getCosteFabricacion();
    }

    @Override
    public List<Fabricacion> filtrarPorCoste(double costeMinimo, double costeMaximo) {
        return dao.filtrarPorCoste(costeMinimo, costeMaximo);
    }
    
}
