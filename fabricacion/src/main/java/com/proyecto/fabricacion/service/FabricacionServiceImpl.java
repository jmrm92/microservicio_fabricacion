package com.proyecto.fabricacion.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.fabricacion.dao.FabricacionDao;
import com.proyecto.fabricacion.model.Fabrica;
import com.proyecto.fabricacion.model.Fabricacion;
import com.proyecto.fabricacion.model.Modelo;

@Service
public class FabricacionServiceImpl implements FabricacionService{

    @Autowired
    FabricacionDao dao;

    @Autowired
    RestTemplate template;

    private String urlFabrica = "http://localhost:9091/";
    private String urlModelo = "http://localhost:8080/";

    /**
     * La función devuelve una lista de todas las fabricaciones.
     * 
     * @return Se devuelve una Lista de objetos de Fabricación.
     */
    @Override
    public List<Fabricacion> fabricaciones() {
        return dao.findAll();
    }

   /**
    * La función "nuevaFabricacion" crea un nuevo registro de fabricación, calcula el costo de las
    * piezas requeridas y el costo monetario, selecciona la fábrica con mayor presupuesto, actualiza el
    * stock de piezas y presupuesto de la fábrica seleccionada y guarda el registro de fabricación en
    * la base de datos. .
    * 
    * @param idModelo La identificación del modelo para la nueva fabricación.
    * @param cantidadModelos El parámetro "cantidadModelos" representa la cantidad de modelos a
    * fabricar.
    */
    @Override
    public void nuevaFabricacion(int idModelo, int cantidadModelos) {
        Fabricacion fabricacion = new Fabricacion();
        fabricacion.setIdModelo(idModelo);
        fabricacion.setCantidadModelos(cantidadModelos);
        List<Modelo> modelos = Arrays.asList(template.getForObject(urlModelo, Modelo[].class));
        List<Fabrica> fabricas = Arrays.asList(template.getForObject(urlFabrica, Fabrica[].class));
        for (Modelo modelo : modelos) {
            if (modelo.getIdModelo() == idModelo) {
                fabricacion.setCostePiezas(modelo.getPiezasNecesarias()*cantidadModelos);
                fabricacion.setCosteMonetario(modelo.getCoste()*cantidadModelos);

                Fabrica fabricaMayorPresupuesto = fabricas.get(0);
                for (Fabrica fabrica : fabricas) {
                    if (fabrica.getPresupuesto() > fabricaMayorPresupuesto.getPresupuesto()) {
                        fabricaMayorPresupuesto = fabrica;
                    }
                }
                fabricacion.setIdFabrica(fabricaMayorPresupuesto.getIdFabrica());

                for (Fabrica fabrica : fabricas) {
                    if (fabrica.getIdFabrica() == fabricacion.getIdFabrica()) {
                        template.put(urlFabrica + "actualizar-stock-piezas/" + fabricacion.getIdFabrica() 
                                                + "/" + (fabrica.getStockPiezas() - fabricacion.getCostePiezas()), fabrica);
                        template.put(urlFabrica + "actualizar-presupuesto/" + fabricacion.getIdFabrica() 
                                                + "/" + (fabrica.getPresupuesto() - fabricacion.getCosteMonetario()), fabrica);
                    }
                }  
            }
        }
        fabricacion.setFechaFabricacion(LocalDateTime.now());
        dao.save(fabricacion);
    }

    /**
     * La función "consultarCosteMonetarioPorId" recupera el costo en valor monetario para un ID de
     * fabricación determinado.
     * 
     * @param idFabricacion El parámetro "idFabricacion" es un número entero que representa el ID de
     * una fabricación.
     * @return El método devuelve el costeMonetario (costo monetario) de un objeto de fabricación con
     * la identificación especificada.
     */
    @Override
    public double consultarCosteMonetarioPorId(int idFabricacion) {
        return dao.findById(idFabricacion).get().getCosteMonetario();
    }

    /**
     * La función filtra una lista de objetos de Fabricación según su costo dentro de un rango
     * específico.
     * 
     * @param costeMinimo El valor de costo mínimo por el que filtrar.
     * @param costeMaximo El valor de costo máximo por el que filtrar.
     * @return El método devuelve una Lista de objetos de tipo "Fabricación".
     */
    @Override
    public List<Fabricacion> filtrarPorCoste(double costeMinimo, double costeMaximo) {
        return dao.filtrarPorCoste(costeMinimo, costeMaximo);
    }

    @Override
    public int consultarCostePiezasPorId(int idFabricacion) {
        return dao.findById(idFabricacion).get().getCostePiezas();
    }
    
}
