package com.krakedev.artesanal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestServirCervezaAI {

    private static final double TOLERANCIA = 0.0001;

    /**
     * Caso: Servir cerveza cuando hay suficiente cantidad disponible.
     * Se espera:
     * - Retorna el valor correcto (cantidad * precio)
     */
    @Test
    public void testServirCervezaExitoso() {
        Maquina maquina = new Maquina("Pilsener", "Rubia", "JAJAJ", 0.05, 1000);
        maquina.llenarMaquina(); // deja disponible capacidadMaxima - 100

        double valor = maquina.servirCerveza(100);

        assertEquals(100 * 0.05, valor, TOLERANCIA);
    }

    /**
     * Caso: Servir exactamente toda la cerveza disponible.
     * Se espera:
     * - Retorna el valor correcto
     */
    @Test
    public void testServirCervezaExacta() {
        Maquina maquina = new Maquina("IPA", "Amarga", 0.10, 500);
        maquina.llenarMaquina(); // queda en 400

        double valor = maquina.servirCerveza(400);

        assertEquals(400 * 0.10, valor, TOLERANCIA);
    }

    /**
     * Caso: No hay suficiente cerveza.
     * Se espera:
     * - Retorna 0
     * - No sirve nada (comportamiento funcional)
     */
    @Test
    public void testNoHaySuficienteCerveza() {
        Maquina maquina = new Maquina("Stout", "Oscura", 0.08, 300);
        maquina.llenarMaquina(); // queda en 200

        double valor = maquina.servirCerveza(250);

        assertEquals(0, valor, TOLERANCIA);
    }

    /**
     * Caso: Intentar servir cuando la máquina está vacía.
     * Se espera:
     * - Retorna 0
     */
    @Test
    public void testMaquinaVacia() {
        Maquina maquina = new Maquina("Lager", "Suave", 0.06, 500);

        double valor = maquina.servirCerveza(100);

        assertEquals(0, valor, TOLERANCIA);
    }

    /**
     * Caso: Servir múltiples veces de forma consecutiva.
     * Se espera:
     * - Cada operación retorna el valor correcto
     */
    @Test
    public void testServirCervezaVariasVeces() {
        Maquina maquina = new Maquina("Porter", "Fuerte", 0.07, 600);
        maquina.llenarMaquina(); // queda en 500

        double valor1 = maquina.servirCerveza(100);
        double valor2 = maquina.servirCerveza(200);

        assertEquals(100 * 0.07, valor1, TOLERANCIA);
        assertEquals(200 * 0.07, valor2, TOLERANCIA);
    }

    /**
     * Caso: Uso del segundo constructor (capacidad por defecto).
     * Se espera:
     * - Funcione correctamente con capacidad 1000 por defecto
     */
    @Test
    public void testConstructorPorDefecto() {
        Maquina maquina = new Maquina("Blonde Ale", "Ligera", 0.09);
        maquina.llenarMaquina(); // queda en 900

        double valor = maquina.servirCerveza(300);

        assertEquals(300 * 0.09, valor, TOLERANCIA);
    }

    /**
     * Caso: Intentar servir 0 ml.
     * Se espera:
     * - Retorna 0 (no hay consumo)
     */
    @Test
    public void testServirCero() {
        Maquina maquina = new Maquina("Amber", "Media", 0.05, 400);
        maquina.llenarMaquina();

        double valor = maquina.servirCerveza(0);

        assertEquals(0, valor, TOLERANCIA);
    }
}
