package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		
		boolean resultado;
		Maquina rubia = new Maquina("Pilsener", "Cerveza fría", 0.02, 8000);

		System.out.println("----ESTADO INICIAL----");
		rubia.imprimir();
		
		System.out.println("----PRIMERA REGARGA----");
		
		resultado = rubia.recargarCerveza(3000);
		System.out.println("¿Se recargo correctamente? " + resultado);
		rubia.imprimir();
		
		System.out.println("----SEGUNDA REGARGA----");
		
		resultado = rubia.recargarCerveza(2000);
		System.out.println("¿Se recargo correctamente? " + resultado);
		rubia.imprimir();
		
		System.out.println("----TERCERA REGARGA----");
		
		resultado = rubia.recargarCerveza(2900);
		System.out.println("¿Se recargo correctamente? " + resultado);
		rubia.imprimir();
	
	}

}