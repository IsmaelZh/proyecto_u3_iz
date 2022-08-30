package com.uce.edu.demo.hilos.tradicional;

import java.util.Arrays;

import org.hibernate.internal.build.AllowSysOut;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long tiempoInicial = System.currentTimeMillis();
		
		Cajero cajero = new Cajero("Ismael", Arrays.asList("Pepito", "Mateo", "Manolo", "Maria"));
		Cajero cajero2 = new Cajero("Jonas", Arrays.asList("Pepito2", "Mateo2", "Manolo2"));
		Cajero cajero3= new Cajero("Victor", Arrays.asList("Pepito3", "Mateo3"));
		
		PCCajero gestorAtencion = new PCCajero();
		gestorAtencion.procesar(cajero);
		gestorAtencion.procesar(cajero2);
		gestorAtencion.procesar(cajero3);
		
		long tiempoFinal = System.currentTimeMillis();
		
		long tiempoTranscurrido = (tiempoFinal - tiempoInicial)/1000;
		
		System.out.println(tiempoTranscurrido + "seg");
	}

}
