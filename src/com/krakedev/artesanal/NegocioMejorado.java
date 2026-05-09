package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {

	private ArrayList<Maquina> maquinas;
	private ArrayList<Cliente> clientes = new ArrayList<>();

	public NegocioMejorado() {
		this.maquinas = new ArrayList<>();
	}

	public ArrayList<Maquina> getMaquinas() {
		return maquinas;
	}

	public void setMaquinas(ArrayList<Maquina> maquinas) {
		this.maquinas = maquinas;
	}

	public int generarCodigo() {
		int numero = (int) (Math.random() * 100) + 1;
		return numero;
	}
	
	public String generarCodigoTexto(int codigo) {
	    return "M-" + codigo;
	}

	public boolean agregarMaquina(String nombre, String descripcion, double precioPorMl) {

	    int codigo;

	    do {
	        codigo = generarCodigo();
	    } while (recuperarMaquina(codigo) != null);

	    Maquina maquina = new Maquina(codigo, nombre, descripcion, precioPorMl);

	    maquinas.add(maquina);

	    return true;
	}

	public void cargarMaquinas() {
		for (Maquina m : maquinas) {
			m.llenarMaquina();
		}
	}

	public Maquina recuperarMaquina(int codigo) {

		for (Maquina m : maquinas) {
			if (m.getCodigo() == codigo) {
				return m;
			}
		}

		return null;
	}

	private int ultimoCodigo = 0;

	public void registrarCliente(String nombre, String cedula) {

		ultimoCodigo++;

		int codigo = ultimoCodigo;

		Cliente cliente = new Cliente(nombre, cedula);

		clientes.add(cliente);
	}

	public Cliente buscarClientePorCedula(String cedula) {

		for (Cliente c : clientes) {
			if (c.getCedula().equals(cedula)) {
				return c;
			}
		}

		return null;
	}

	public Cliente buscarClientePorCodigo(int codigo) {

		for (Cliente c : clientes) {
			if (c.getCodigo() == codigo) {
				return c;
			}
		}

		return null;
	}

	public void consumirCerveza(int codCliente, int codMaquina, double cantidad) {

	    Maquina maquina = recuperarMaquina(codMaquina);
	    Cliente cliente = buscarClientePorCodigo(codCliente);

	    if (maquina == null || cliente == null) {
	        return;
	    }

	    double valor = maquina.servirCerveza(cantidad);

	    if (valor > 0) {
	        registrarConsumo(codCliente, valor);
	    }
	}

	public void registrarConsumo(int codigo, double valor) {

	    Cliente cliente = buscarClientePorCodigo(codigo);

	    if (cliente != null) {
	        cliente.setTotalConsumido(
	            cliente.getTotalConsumido() + valor
	        );
	    }
	}

	public double consultarValorVendido() {

	    double total = 0;

	    for (Cliente c : clientes) {
	        total += c.getTotalConsumido();
	    }

	    return total;
	}

}