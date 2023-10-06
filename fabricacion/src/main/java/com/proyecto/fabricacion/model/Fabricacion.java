package com.proyecto.fabricacion.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fabricaciones")
public class Fabricacion {

    @Id
    @Column(name = "id_fabricacion")
    private int idFabricacion;
    @Column(name = "id_fabrica")
    private int idFabrica;
    @Column(name = "id_modelo")
    private int idModelo;
    @Column(name = "fecha_fabricacion")
    private LocalDateTime fechaFabricacion;
    @Column(name = "coste_monetario")
    private double costeMonetario;
    @Column(name = "coste_piezas")
    private int costePiezas;
    @Column(name = "cantidad_modelos")
    private int cantidadModelos;

    public Fabricacion() {
    }

    public Fabricacion(int idFabrica, int idModelo, LocalDateTime fechaFabricacion,
            double costeMonetario, int costePiezas, int cantidadModelos) {
        this.idFabrica = idFabrica;
        this.idModelo = idModelo;
        this.fechaFabricacion = fechaFabricacion;
        this.costeMonetario = costeMonetario;
        this.costePiezas = costePiezas;
        this.cantidadModelos = cantidadModelos;
    }

    /**
     * Obtiene el ID de fabricación.
     *
     * @return El ID de fabricación.
     */
    public int getIdFabricacion() {
        return idFabricacion;
    }

    /**
     * Establece el ID de fabricación.
     *
     * @param idFabricacion El nuevo ID de fabricación.
     */
    public void setIdFabricacion(int idFabricacion) {
        this.idFabricacion = idFabricacion;
    }

    /**
     * Obtiene el ID de la fábrica.
     *
     * @return El ID de la fábrica.
     */
    public int getIdFabrica() {
        return idFabrica;
    }

    /**
     * Establece el ID de la fábrica.
     *
     * @param idFabrica El nuevo ID de la fábrica.
     */
    public void setIdFabrica(int idFabrica) {
        this.idFabrica = idFabrica;
    }

    /**
     * Obtiene el ID del modelo.
     *
     * @return El ID del modelo.
     */
    public int getIdModelo() {
        return idModelo;
    }

    /**
     * Establece el ID del modelo.
     *
     * @param idModelo El nuevo ID del modelo.
     */
    public void setIdModelo(int idModelo) {
        this.idModelo = idModelo;
    }

    /**
     * Obtiene la fecha de fabricación.
     *
     * @return La fecha de fabricación.
     */
    public LocalDateTime getFechaFabricacion() {
        return fechaFabricacion;
    }

    /**
     * Establece la fecha de fabricación.
     *
     * @param fechaFabricacion La nueva fecha de fabricación.
     */
    public void setFechaFabricacion(LocalDateTime fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    /**
     * Obtiene el costo monetario.
     *
     * @return El costo monetario.
     */
    public double getCosteMonetario() {
        return costeMonetario;
    }

    /**
     * Establece el costo monetario.
     *
     * @param costeMonetario El nuevo costo monetario.
     */
    public void setCosteMonetario(double costeMonetario) {
        this.costeMonetario = costeMonetario;
    }

    /**
     * Obtiene el costo en piezas.
     *
     * @return El costo en piezas.
     */
    public int getCostePiezas() {
        return costePiezas;
    }

    /**
     * Establece el costo en piezas.
     *
     * @param costePiezas El nuevo costo en piezas.
     */
    public void setCostePiezas(int costePiezas) {
        this.costePiezas = costePiezas;
    }

    /**
     * Obtiene la cantidad de modelos.
     *
     * @return La cantidad de modelos.
     */
    public int getCantidadModelos() {
        return cantidadModelos;
    }

    /**
     * Establece la cantidad de modelos.
     *
     * @param cantidadModelos La nueva cantidad de modelos.
     */
    public void setCantidadModelos(int cantidadModelos) {
        this.cantidadModelos = cantidadModelos;
    }

}
