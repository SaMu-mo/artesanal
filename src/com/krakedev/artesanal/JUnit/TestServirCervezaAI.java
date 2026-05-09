package com.krakedev.artesanal.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	private static final double DELTA = 0.0001;

    // ✅ Caso 1: Sirve correctamente cuando hay suficiente cerveza
    @Test
    public void testServirConCantidadSuficiente() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 1000);

        maquina.recargarCerveza(500); // dejamos 500 ml disponibles

        double valor = maquina.servirCerveza(200);

        // valida el valor a pagar
        assertEquals(200 * 0.05, valor, DELTA);

        // valida que la cantidad disminuyó correctamente
        assertEquals(300, maquina.getCantidadActual(), DELTA);
    }

    // ✅ Caso 2: No sirve nada cuando no hay suficiente cerveza
    @Test
    public void testServirSinCantidadSuficiente() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 1000);

        maquina.recargarCerveza(100); // solo 100 ml

        double valor = maquina.servirCerveza(200);

        // no debe cobrar nada
        assertEquals(0, valor, DELTA);

        // no debe modificar la cantidad
        assertEquals(100, maquina.getCantidadActual(), DELTA);
    }

    // ✅ Caso 3: Sirve exactamente toda la cerveza disponible
    @Test
    public void testServirCantidadExacta() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", 0.05, 1000);

        maquina.recargarCerveza(300);

        double valor = maquina.servirCerveza(300);

        // valor correcto
        assertEquals(300 * 0.05, valor, DELTA);

        // debe quedar en 0
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }

    // ✅ Caso 4: Usando el segundo constructor (capacidad por defecto)
    @Test
    public void testServirConConstructorAlternativo() {
        Maquina maquina = new Maquina("Club", "Negra", 0.1);

        maquina.recargarCerveza(500);

        double valor = maquina.servirCerveza(100);

        assertEquals(100 * 0.1, valor, DELTA);
        assertEquals(400, maquina.getCantidadActual(), DELTA);
    }

    // ✅ Caso 5: Intentar servir 0 ml
    @Test
    public void testServirCero() {
        Maquina maquina = new Maquina("Club", "Negra", 0.1);

        maquina.recargarCerveza(200);

        double valor = maquina.servirCerveza(0);

        // no debería cobrar nada
        assertEquals(0, valor, DELTA);

        // la cantidad no cambia
        assertEquals(200, maquina.getCantidadActual(), DELTA);
    }

    // ✅ Caso 6: Máquina sin cerveza
    @Test
    public void testServirSinNadaEnMaquina() {
        Maquina maquina = new Maquina("Club", "Negra", 0.1);

        double valor = maquina.servirCerveza(100);

        // no cobra
        assertEquals(0, valor, DELTA);

        // sigue en 0
        assertEquals(0, maquina.getCantidadActual(), DELTA);
    }

}