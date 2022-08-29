package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IDoctorUnaryOperator<T> {

	T apply(T arg1);
	
}
