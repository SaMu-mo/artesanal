package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "La mas pequena", "JAJAJ", 0.05);
		
		Maquina negra = new Maquina("Club", "La mas grande", "JAJAJ", 0.08, 8500);

		rubia.llenarMaquina();
		
		negra.llenarMaquina();
		
		negra.imprimir();

		rubia.imprimir();

	}

}
