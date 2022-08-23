package com.uce.edu.demo.service.funcional;

@FunctionalInterface
public interface IPersonaFunction<R,T> {

	R plicar (T arg1);
	
}
