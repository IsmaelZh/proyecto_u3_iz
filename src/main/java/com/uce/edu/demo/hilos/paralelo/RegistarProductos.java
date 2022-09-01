package com.uce.edu.demo.hilos.paralelo;

import java.util.concurrent.TimeUnit;

public class RegistarProductos extends Thread{

	private PC pc;

	public RegistarProductos(PC pc) {
		this.pc = pc;
	}

	// Disparar el metodo a paralelizar
	public void run() {
		this.procesar(this.pc);
	}

	long tiempoInicial = System.currentTimeMillis();

	public void procesar(PC cajero) {
		System.out.println("Nombre Hilo procesar: " + Thread.currentThread().getName());
		System.out.println("Procesando pc: " + pc.getNumero());
		for (String producto : pc.getProductos()) {
			this.registrarProducto(producto);
		}

		long tiempoFinal = System.currentTimeMillis();
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;
		System.out.println("terminó " + pc.getNumero() + " en: " + tiempoTranscurrido + "seg");

	}

	private void registrarProducto(String producto) {
		System.out.println("Se registro: " + producto);
		// Demorar el metodo 5 seg
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
}