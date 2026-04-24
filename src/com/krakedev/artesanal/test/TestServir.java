package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestServir {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maquina rubia = new Maquina("Pilsener", "Cerveza Sabrosa", "JAJAJ", 0.05);

		rubia.imprimir();
		
		System.out.println("--------");
		
		rubia.llenarMaquina();
		
		rubia.imprimir();
		
		System.out.println("---------");
		
		double valor = rubia.servirCerveza(500);
		
		System.out.println("cerveza servida; " + valor);
		
		rubia.imprimir();
		
	}

}
