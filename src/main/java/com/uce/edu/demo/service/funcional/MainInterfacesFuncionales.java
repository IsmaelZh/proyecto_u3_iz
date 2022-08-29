package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MetodoHighOrderDoctor metodosHO = new MetodoHighOrderDoctor();

		// SUPLIER

		// Lambda
		IDoctorSupplier<String> supplierLambda = () -> "Pediatra";
		LOG.info("Supplier Lambda: " + supplierLambda.getEspecialidad());

		// Metodos High Order
		String valorHO = metodosHO.consumirSupplier(() -> {
			String valorConsultado = " Medico pediatra";
			return valorConsultado;
		});
		LOG.info("HO Supplier" + valorHO);

		// CONSUMER

		// Lambdas
		IDoctorConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");

		// Metodos High Order
		metodosHO.consumirConsumer(valor -> System.out.println(valor), 10);

		// PREDICATE

		// Lambdas
		IDoctorPredicate<Integer> predicateLambda = edad -> edad > 40;
		LOG.info("Perdicate Lambda: " + predicateLambda.evaluar(39));

		// Metodos High Order
		boolean respuesta = metodosHO.consumirPredicate(edad -> edad > 40, 50);
		LOG.info("HO Predicate: " + respuesta);

		// FUNCTION

		// Lambdas
		IDoctorFunction<Double, String> functionLambda = cadena -> {
			Double consulta = Double.parseDouble(cadena);
			Double valorFinal = consulta - 5.50;
			return valorFinal;
		};
		LOG.info("Precio consulta Function Lambda: " + functionLambda.plicar("30.80"));

		// Metodos High Order
		String valorFinalHO = metodosHO.consumirFunction(valor -> {
			String retorno = valor.toString() + " am";
			return retorno;
		}, 9);
		LOG.info("Hora consulta HO Function: " + valorFinalHO);

		// UNARY OPERATOR (FUNCTION)

		// Lambdas
		IDoctorUnaryOperator<String> unaryLambda = cadena -> {
			String valorFinal = cadena.concat(" Psiquiatra");
			return valorFinal;
		};

		LOG.info("Unary Operator Lambda: " + unaryLambda.apply("Dr. Antonio"));

		// Metodos High Order
		String cadenaFinalHO = metodosHO.consumirUnaryOperator(cadena -> {
			String retorno = cadena.toString() + " Forence";
			return retorno;
		}, "Medico");
		LOG.info("Especialidad doctor HO Unany Operator: " + cadenaFinalHO);

	}

}
