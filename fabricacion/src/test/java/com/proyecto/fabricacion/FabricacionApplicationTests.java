package com.proyecto.fabricacion;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.proyecto.fabricacion.dao.FabricacionDao;
import com.proyecto.fabricacion.model.Fabrica;
import com.proyecto.fabricacion.model.Fabricacion;
import com.proyecto.fabricacion.model.Modelo;
import com.proyecto.fabricacion.service.FabricacionService;

@SpringBootTest
class FabricacionApplicationTests {

	@Mock
	private FabricacionDao dao;

	@Mock
	private RestTemplate template;

	@InjectMocks
	private FabricacionService service;

	@Test
	void testNuevaFabricacion() {
        // Preparar
        int idModelo = 1;
        int cantidadModelos = 10;
        Modelo modelo = new Modelo( /*otros campos según tu modelo*/);
        Fabrica fabrica = new Fabrica(/*... campos según tu modelo de Fabrica ...*/);
        Fabricacion fabricacion = new Fabricacion();

        when(template.getForObject(anyString(), eq(Modelo[].class)))
            .thenReturn(new Modelo[]{modelo});
        when(template.getForObject(anyString(), eq(Fabrica[].class)))
            .thenReturn(new Fabrica[]{fabrica});

        // Ejecutar
        service.nuevaFabricacion(idModelo, cantidadModelos);

        // Verificar
        verify(template, times(2)).put(anyString(), any());
        verify(dao).save(any(Fabricacion.class));
    }

}
