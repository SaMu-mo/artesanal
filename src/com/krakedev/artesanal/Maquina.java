package com.krakedev.artesanal;

public class Maquina {

	private String nombreCerveza;
	private String descripcion;
	private double precioPorMl;
	private double capacidadMaxima;
	private double cantidadActual;
	private int codigo;

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl, double capacidadMaxima) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = capacidadMaxima;
		this.cantidadActual = 0;

	}

	public Maquina(String nombreCerveza, String descripcion, double precioPorMl) {

		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;

	}

	public Maquina(int codigo, String nombreCerveza, String descripcion, double precioPorMl) {

		this.codigo = codigo;
		this.nombreCerveza = nombreCerveza;
		this.descripcion = descripcion;
		this.precioPorMl = precioPorMl;
		this.capacidadMaxima = 10000;
		this.cantidadActual = 0;

	}

	public int getCodigo() {
		return codigo;
	}

	public String getCodigoTexto() {
		return "M-" + codigo;
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

	public double getPrecioPorMl() {
		return precioPorMl;
	}

	public void setPrecioPorMl(double precioPorMl) {
		this.precioPorMl = precioPorMl;
	}

	public double getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public double getCantidadActual() {
		return cantidadActual;
	}

	public void imprimir() {
		String mensaje;

		mensaje = "Código: " + getCodigoTexto() + ", Nombre cerveza: " + nombreCerveza + ", Descripción: " + descripcion
				+ ", Precio por Ml: " + precioPorMl + ", Capacidad Máxima: " + capacidadMaxima + ", Cantidad Actual: "
				+ cantidadActual;

		System.out.println(mensaje);
	}

	public void llenarMaquina() {
		this.cantidadActual = this.capacidadMaxima;
	}

	public boolean recargarCerveza(double cantidad) {

		double limitePermitido;
		limitePermitido = capacidadMaxima - 200;

		if (cantidadActual + cantidad <= limitePermitido) {

			cantidadActual = cantidadActual + cantidad;
			return true;

		} else {
			return false;
		}
	}

	public double servirCerveza(double cantidad) {

	    double reduccion = 200;

	    if (cantidadActual >= reduccion) {
	        cantidadActual = cantidadActual - reduccion;

	        double valor = cantidad * precioPorMl;
	        return valor;

	    } else {
	        return 0;
	    }
	}
}