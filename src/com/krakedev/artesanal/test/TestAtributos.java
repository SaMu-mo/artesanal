package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Maquina rubia = new Maquina("Pilsener", "Cerveza Sabrosa", "JAJAJ", 0.05);

		rubia.imprimir();

		rubia.setNombreCerveza("Club");
		rubia.setDescripcion("Esta es mas cara");

		rubia.imprimir();
	}

}
