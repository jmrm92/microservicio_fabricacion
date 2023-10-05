package com.proyecto.fabricacion.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fabricacion {
    
    @Id
    @Column (name ="id_fabricacion")
    private int idFabricacion;
    @Column (name ="id_fabrica")
    private int idFabrica;
    @Column (name ="id_modelo")
    private int idModelo;
    @Column (name ="fecha_fabricacion")
    private LocalDateTime fechaFabricacion;
    @Column (name ="coste_fabricacion")
    private double costeFabricacion;
    
    public Fabricacion() {
    }

    public Fabricacion(int idFabricacion, int idFabrica, int idModelo, LocalDateTime fechaFabricacion,
            double costeFabricacion) {
        this.idFabricacion = idFabricacion;
        this.idFabrica = idFabrica;
        this.idModelo = idModelo;
        this.fechaFabricacion = fechaFabricacion;
        this.costeFabricacion = costeFabricacion;
    }

    public int getIdFabricacion() {
        return idFabricacion;
    }

    public void setIdFabricacion(int idFabricacion) {
        this.idFabricacion = idFabricacion;
    }

    public int getIdFabrica() {
        return idFabrica;
    }

    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    public int getIdModelo() {
        return idModelo;
    }

    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    public LocalDateTime getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public double getCosteFabricacion() {
        return costeFabricacion;
    }

    public void setCosteFabricacion(double costeFabricacion) {
        this.costeFabricacion = costeFabricacion;
    }

    
    
}
