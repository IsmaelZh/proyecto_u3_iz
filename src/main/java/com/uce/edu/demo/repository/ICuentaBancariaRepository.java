package com.uce.edu.demo.repository;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ICuentaBancariaRepository {

	public void insertar(CuentaBancaria cuentaBancaria);
	
	public void actualizar(CuentaBancaria cuentaBancaria);
	
	public CuentaBancaria buscarPorNumero(String numeroCuenta);
	
}
