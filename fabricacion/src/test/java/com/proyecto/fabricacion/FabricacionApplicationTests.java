package com.proyecto.fabricacion;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyecto.fabricacion.dao.FabricacionDao;
import com.proyecto.fabricacion.model.Fabricacion;
import com.proyecto.fabricacion.service.FabricacionServiceImpl;

@SpringBootTest
class FabricacionApplicationTests {

    @Mock
    private FabricacionDao dao;

    @InjectMocks
    private FabricacionServiceImpl service;

    @Test
    public void testFiltrarPorCoste() {
        // Paso 1
        Fabricacion fabricacion1 = new Fabricacion();
        fabricacion1.setCosteMonetario(10.0);

        Fabricacion fabricacion2 = new Fabricacion();
        fabricacion2.setCosteMonetario(20.0);

        Fabricacion fabricacion3 = new Fabricacion();
        fabricacion3.setCosteMonetario(30.0);


        when(dao.filtrarPorCoste(15.0, 25.0)).thenReturn(Arrays.asList(fabricacion2));

        List<Fabricacion> resultado = service.filtrarPorCoste(15.0, 25.0);

        Assertions.assertEquals(1, resultado.size());
        Assertions.assertEquals(fabricacion2, resultado.get(0));

        verify(dao).filtrarPorCoste(15.0, 25.0);
        verifyNoMoreInteractions(dao);
    }

}
