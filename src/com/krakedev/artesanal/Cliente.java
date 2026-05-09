package com.krakedev.artesanal;

public class Cliente {
	private int codigo;
    private String nombre;
    private String cedula;
    private double totalConsumido;

    
    public Cliente(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    // Getters y Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

	public double getTotalConsumido() {
		return totalConsumido;
	}

	public void setTotalConsumido(double totalConsumido) {
		this.totalConsumido = totalConsumido;
	}
    
    
}