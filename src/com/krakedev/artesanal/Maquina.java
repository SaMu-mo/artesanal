package com.krakedev.artesanal;

public class Maquina {

	private String codigo; // NUEVO ATRIBUTO
	private String nombreCerveza;
	private String descripcion;
	private double precioPorM1;
	private double capacidadMaxima;
	private double cantidadActual;

	
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorM1, double capacidadMaxima) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorM1 = precioPorM1;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;
	}

	
	public Maquina(String codigo, String nombreCerveza, String descripcion, double precioPorM1) {
		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorM1 = precioPorM1;
		this.capacidadMaxima = 1000;
		this.cantidadActual = 0;
	}

	
	public String getCodigo() {
		return codigo;
	}

	public String getNombreCerveza() {
		return nombreCerveza;
	}

	public void setNombreCerveza(String nombreCerveza) {
		this.nombreCerveza = nombreCerveza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioPorM1() {
		return precioPorM1;
	}

	public void setPrecioPorM1(double precioPorM1) {
		this.precioPorM1 = precioPorM1;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(double capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public void imprimir() {
		String mensaje;

		mensaje = "Codigo: " + codigo +
				", Nombre Cerveza: " + nombreCerveza +
				", Descripcion: " + descripcion +
				", Precio por M1: " + precioPorM1 +
				", Cantidad Maxima: " + capacidadMaxima +
				", Cantidad Actual: " + cantidadActual;

		System.out.print(mensaje);
	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima - 200;
	}

	public boolean recargarCerveza(double cantidad) {
		double limitePermitido = capacidadMaxima - 200;

		if (cantidadActual + cantidad <= limitePermitido) {
			cantidadActual = cantidadActual + cantidad;
			return true;
		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {
		if (cantidadActual >= cantidad) {
			cantidadActual = cantidadActual - cantidad;
			double valor = cantidad * precioPorM1;
			return valor;
		} else {
			return 0;
		}
	}
}