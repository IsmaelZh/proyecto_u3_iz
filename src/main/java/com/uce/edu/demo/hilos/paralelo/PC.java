package com.uce.edu.demo.hilos.paralelo;

import java.util.List;

public class PC {

	private String numero;
	private List<String> productos;

	public PC(String numero, List<String> productos) {
		super();
		this.numero = numero;
		this.productos = productos;
	}

	//Set y Get 
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<String> getProductos() {
		return productos;
	}

	public void setProductos(List<String> productos) {
		this.productos = productos;
	}

}
