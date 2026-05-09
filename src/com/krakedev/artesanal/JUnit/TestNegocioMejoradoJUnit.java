package com.krakedev.artesanal.JUnit;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.NegocioMejorado;

public class TestNegocioMejoradoJUnit {

    @Test
    public void testAgregarMaquina() {
        NegocioMejorado n = new NegocioMejorado();

        boolean resultado = n.agregarMaquina("Pilsener", "Rubia", 0.05);

        assertTrue(resultado);
        assertEquals(1, n.getMaquinas().size());
    }
    
    @Test
    public void testCodigosUnicos() {
        NegocioMejorado n = new NegocioMejorado();

        n.agregarMaquina("A", "A", 0.1);
        n.agregarMaquina("B", "B", 0.1);

        int cod1 = n.getMaquinas().get(0).getCodigo();
        int cod2 = n.getMaquinas().get(1).getCodigo();

        assertNotEquals(cod1, cod2);
    }
    
    @Test
    public void testRegistrarCliente() {
        NegocioMejorado n = new NegocioMejorado();

        n.registrarCliente("Alex", "123");

        Cliente c = n.buscarClientePorCedula("123");

        assertNotNull(c);
        assertEquals("Alex", c.getNombre());
    }
    
    @Test
    public void testConsumirCerveza() {
        NegocioMejorado n = new NegocioMejorado();

        n.agregarMaquina("Pilsener", "Rubia", 0.05);
        n.getMaquinas().get(0).llenarMaquina();

        int codMaquina = n.getMaquinas().get(0).getCodigo();

        n.registrarCliente("Alex", "123");

        n.consumirCerveza(1, codMaquina, 1000);

        Cliente c = n.buscarClientePorCodigo(1);

        assertTrue(c.getTotalConsumido() > 0);
    }
    
    @Test
    public void testNoConsumirSinStock() {
        NegocioMejorado n = new NegocioMejorado();

        n.agregarMaquina("Pilsener", "Rubia", 0.05);

        int codMaquina = n.getMaquinas().get(0).getCodigo();

        n.registrarCliente("Alex", "123");

        n.consumirCerveza(1, codMaquina, 5000);

        Cliente c = n.buscarClientePorCodigo(1);

        assertEquals(0, c.getTotalConsumido());
    }
    
    @Test
    public void testConsultarValorVendido() {
        NegocioMejorado n = new NegocioMejorado();

        n.agregarMaquina("Pilsener", "Rubia", 0.05);
        n.getMaquinas().get(0).llenarMaquina();

        int codMaquina = n.getMaquinas().get(0).getCodigo();

        n.registrarCliente("Alex", "123");

        n.consumirCerveza(1, codMaquina, 1000);

        double total = n.consultarValorVendido();

        assertTrue(total > 0);
    }
}