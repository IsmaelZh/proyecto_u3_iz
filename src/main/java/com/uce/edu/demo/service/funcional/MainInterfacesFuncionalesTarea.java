package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionalesTarea {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {

		// SUPLIER
		// JAVA
		LOG.info(" JAVA Supplier");
		Stream<Double> test = Stream.generate(() -> 5.25).limit(4);
		test.forEach(valor -> System.out.println(valor));

		// CONSUMER
		// JAVA
		LOG.info(" JAVA Consumer");
		List<String> listaProductos = Arrays.asList("Leche", "Pan", "Queso", "Tomate", "Cereal");
		listaProductos.forEach(cadena -> System.out.println(cadena));

		// PREDICATE
		// JAVA
		LOG.info(" JAVA Predicate");
		Stream<String> listaFiltrada = listaProductos.stream().filter(cadena -> cadena.contains("e"));
		listaFiltrada.forEach(cadena -> System.out.println(cadena));

		// FUNCTION
		// JAVA
		LOG.info("JAVA function");
		List<Integer> listaNumeros = Arrays.asList(2, 4, 6, 8, 10);
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			Integer valor = numero / 2;
			String cadena = "num: " + valor.toString();
			return cadena;
		});
		listaCambiada.forEach(valor -> System.out.println(valor));

	}

}
