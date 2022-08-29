package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IDoctorFunction<R,T> {

	R plicar (T arg1);
	
}
