package com.uce.edu.demo.service.funcional;

public class MetodoHighOrderDoctor {

	public String consumirSupplier(IDoctorSupplier<String> funcion) {

		return funcion.getEspecialidad() + " Dato HO";
	}

	public void consumirConsumer(IDoctorConsumer<Integer> funcion, Integer valor) {

		funcion.accept(valor);
	}

	public boolean consumirPredicate(IDoctorPredicate<Integer> funcion, Integer valor) {
		return funcion.evaluar(valor);

	}

	public String consumirFunction(IDoctorFunction<String, Integer> funcion, Integer valor) {
		return funcion.plicar(valor);
	}
	
	public String consumirUnaryOperator (IDoctorUnaryOperator<String> funcion, String valor) {
		return funcion.apply(valor);
	}
	
}