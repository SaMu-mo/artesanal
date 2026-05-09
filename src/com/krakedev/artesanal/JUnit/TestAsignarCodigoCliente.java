package com.krakedev.artesanal.JUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsignarCodigoCliente {

    @Test
    public void asignarCodigo() {

        Negocio barDeMoe = new Negocio();

        Cliente mario = new Cliente("Mario", "123355663");
        Cliente luis = new Cliente("Luis", "123455663");

        barDeMoe.asignarCodigoCliente(mario);
        barDeMoe.asignarCodigoCliente(luis);

        assertEquals(100, mario.getCodigo());
        assertEquals(101, luis.getCodigo());
    }
}