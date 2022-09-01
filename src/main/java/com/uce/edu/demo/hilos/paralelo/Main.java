package com.uce.edu.demo.hilos.paralelo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		long tiempoInicial = System.currentTimeMillis();
		
		System.out.println("Nombre Hilo: " + Thread.currentThread().getName());
		
		PC pc = new PC("1",Arrays.asList("Cuaderno", "Esfero", "Borrador"));
		PC pc2 = new PC("2",Arrays.asList("Cartulina", "Pintura", "Forro plastico", "Marcador", "Acuarelas"));
		PC pc3 = new PC("3",Arrays.asList("Goma", "Saca punta"));
		PC pc4 = new PC("4",Arrays.asList("Carpeta", "Forro papel", "Papel brillante"));
		PC pc5 = new PC("5",Arrays.asList("Papel celofan", "Rapidografo", "Fomix", "Perforadora", "Cinta"));
		
		RegistarProductos gestorRegistro = new RegistarProductos(pc);
		gestorRegistro.start();
		RegistarProductos gestorRegistro2 = new RegistarProductos(pc2);
		gestorRegistro2.start();
		RegistarProductos gestorRegistro3 = new RegistarProductos(pc3);
		gestorRegistro3.start();
		RegistarProductos gestorRegistro4 = new RegistarProductos(pc4);
		gestorRegistro4.start();
		RegistarProductos gestorRegistro5 = new RegistarProductos(pc5);
		gestorRegistro5.start();
		
		long tiempoFinal = System.currentTimeMillis();

		long tiempoTranscurrido = (tiempoFinal - tiempoInicial) / 1000;

		System.out.println(tiempoTranscurrido + "seg");
	}
	
}
