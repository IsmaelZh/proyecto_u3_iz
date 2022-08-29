package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IDoctorPredicate<T> {

	public boolean evaluar (T arg1);
	
}
