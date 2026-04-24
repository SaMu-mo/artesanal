package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestRecargar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean resultado;

		Maquina rubia = new Maquina("Pilsener", "La mas pequena", "JAJAJ", 0.05);

		System.out.println("-----ESTADO ACTUAL---------");

		rubia.imprimir();

		System.out.println("-------RECARGA 1 -------");

		resultado = rubia.recargarCerveza(500);

		System.out.println("Se recargo como debe: " + resultado);

		rubia.imprimir();
		
		System.out.println("-------RECARGA 2 -------");

		resultado = rubia.recargarCerveza(5000);

		System.out.println("Se recargo como debe: " + resultado);

		rubia.imprimir();
		
		

	}

}
