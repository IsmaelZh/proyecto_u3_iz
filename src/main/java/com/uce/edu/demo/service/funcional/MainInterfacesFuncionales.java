package com.uce.edu.demo.service.funcional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void imprimir (String cadena) {
		LOG.info("Impresion" + cadena);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsumoMetodosHighOrder metodosHO = new ConsumoMetodosHighOrder();

		// SUPLIER
		// Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());

		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());

		// Lambdas
		IPersonaSupplier<String> supplierLambda = () -> "Ismael 2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());

		IPersonaSupplier<String> supplierLambdaTE = () -> "Eddy TE2";
		LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> "Hola mundo");
		LOG.info("HO Supplier" + valorHO);

		String valorHO1 = metodosHO.consumirSupplier(() -> {
			String valorConsultado = "1256522154";
			return valorConsultado;
		});
		LOG.info("HO Supplier" + valorHO1);

		// JAVA
		LOG.info("JAVA Supplier");
		Stream<String> test = Stream.generate(() -> "Ismael").limit(5);
		test.forEach(cadena -> System.out.println(cadena));

		// CONSUMER
		// Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");

		// Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 2);

		// JAVA
		LOG.info("JAVA Consumer");
		List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
		listaNumeros.forEach(numero -> System.out.println(numero));

		// PREDICATE (Para condiciones/Filtrar informacion)
		// Clases
		// Lambdas
		IPersonaPredicate<String> predicateLambda = cadena -> cadena.contains("Z");
		LOG.info("Perdicate Lambda: " + predicateLambda.evaluar("Zhindon"));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(cadena -> cadena.contains("Z"), "Zhindon");
		LOG.info("HO PREDICATE: " + respuesta);

		// JAVA
		LOG.info("JAVA Predicate");
		Stream<Integer> nuevaLista = listaNumeros.stream().filter(numero -> numero >= 3);
		nuevaLista.forEach(numero -> System.out.println(numero));

		// FUNCTION(Conversiones/cast)
		// Clases
		// Lambdas
		IPersonaFunction<Integer, String> functionLambda = cadena -> {
			Integer valor = Integer.parseInt(cadena);
			Integer valorFinal = valor - 2;
			return valorFinal;
		};
		LOG.info("Function Lambda: " + functionLambda.plicar("7"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + "A";
			return retorno;
		}, 1);
		LOG.info("HO Function: " + valorFinalHO);

		// JAVA
		LOG.info("JAVA function");
		Stream<String> listaCambiada = listaNumeros.stream().map(numero -> {
			Integer valor = numero + 1;
			String cadena = "num: " + valor.toString();
		return cadena;
		});
		//Declarativa: ideas/intenciones
		listaCambiada.forEach(valor -> imprimir(valor));

		//Imperativa: paso a paso 
//		for (String valor : ) {
//			imprimir (valor);
//		}
		
		// UNARY OPERATOR (FUNCTION)
		// Clases
		// Lambdas
		IPersonaUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat(" sufijo");
			return valorFinal;
		};

		LOG.info("Unary Operator Lambda: " + unaryLambda.apply("Dennis"));

	}

}
