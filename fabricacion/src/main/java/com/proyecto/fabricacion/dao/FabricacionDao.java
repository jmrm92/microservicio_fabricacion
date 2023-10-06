package com.proyecto.fabricacion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.fabricacion.model.Fabricacion;

public interface FabricacionDao extends JpaRepository <Fabricacion, Integer> {
    
    @Query("SELECT f FROM Fabricacion f WHERE f.costeMonetario BETWEEN :costeMinimo AND :costeMaximo")
    List<Fabricacion> filtrarPorCoste(@Param("costeMinimo") double costeMinimo, 
                                          @Param("costeMaximo") double costeMaximo);
}
