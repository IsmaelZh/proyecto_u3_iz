package com.uce.edu.demo.service.funcional;

import org.apache.log4j.Logger;

public class MainInterfacesFuncionales {

	private static Logger LOG = Logger.getLogger(MainInterfacesFuncionales.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//SUPLIER
		//Clases
		IPersonaSupplier<String> supplier = new PersonaSupplierImpl();
		LOG.info("Supplier Clase: " + supplier.getNombre());
		
		IPersonaSupplier<String> supplierTE = new PersonaSupplierTEImpl();
		LOG.info("Supplier Clase: " + supplierTE.getNombre());
		
		//Lambdas
		IPersonaSupplier<String> supplierLambda = ()-> "Ismael 2";
		LOG.info("Supplier Lambda: " + supplierLambda.getNombre());
		
		IPersonaSupplier<String> supplierLambdaTE = ()-> "Eddy TE2";
		LOG.info("Supplier Lambda: " + supplierLambdaTE.getNombre());
		
		//JAVA
		
		//CONSUMER
		//Clases
		IPersonaConsumer<String> consumerClase = new PersonaConsumerImpl();
		consumerClase.accept("Prueba Consumer");
		
		//Lambdas
		IPersonaConsumer<String> consumerLambda = cadena -> System.out.println(cadena);
		consumerLambda.accept("Prueba Consumer Lambda");
		
		//PREDICATE
		//Clases
		//Lambdas
		
		//FUNCTION
		//Clases
		//Lambdas
		
		//UNARY OPERATOR (FUNCTION)
		//Clases
		//Lambdas
		}
	
}

