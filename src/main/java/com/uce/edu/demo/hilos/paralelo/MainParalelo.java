package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class MainParalelo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();

		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		
		CajeroParalelo cajero = new CajeroParalelo("Ismael", Arrays.asList("Pepito"));
		CajeroParalelo cajero2 = new CajeroParalelo("Jonas", Arrays.asList("Pepito2"));
		CajeroParalelo cajero3 = new CajeroParalelo("Victor", Arrays.asList("Pepito3"));

		CajeroParalelo cajero4 = new CajeroParalelo("Pedro", Arrays.asList("Mateo"));
		CajeroParalelo cajero5 = new CajeroParalelo("Ana", Arrays.asList("Mateo2"));
		CajeroParalelo cajero6 = new CajeroParalelo("Jose", Arrays.asList("Mateo3"));
		
		
		PCCajeroParalelo gestorAtencion = new PCCajeroParalelo(cajero);
		gestorAtencion.start();//procesar
		
		PCCajeroParalelo gestorAtencion2 = new PCCajeroParalelo(cajero2);
		gestorAtencion2.start();//procesar
	  
		PCCajeroParalelo gestorAtencion3 = new PCCajeroParalelo(cajero3);
		gestorAtencion3.start();//procesar
		
		PCCajeroParalelo gestorAtencion4 = new PCCajeroParalelo(cajero4);
		gestorAtencion4.start();//procesar
		
		PCCajeroParalelo gestorAtencion5 = new PCCajeroParalelo(cajero5);
		gestorAtencion5.start();//procesar
		
		PCCajeroParalelo gestorAtencion6 = new PCCajeroParalelo(cajero6);
		gestorAtencion6.start();//procesar

		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
	}

}
