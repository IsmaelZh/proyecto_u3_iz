package com.uce.edu.demo.service;

import java.math.BigDecimal;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

public interface ITransferenciaService {

	public void insertarCuenta(CuentaBancaria bancaria); 
	
	public void realizarTransferencia(String CtaOrigen,String CtaDestino,BigDecimal monto);

	public void realizarTransferenciaFachada(String CtaOrigen, String CtaDestino, BigDecimal monto);
	
	public CuentaBancaria buscarPorNumero(String numeroCuenta);
}