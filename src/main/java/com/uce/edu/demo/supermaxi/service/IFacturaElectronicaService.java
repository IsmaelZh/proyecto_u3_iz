package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;

public interface IFacturaElectronicaService {

	public void registarSRI(String numero, Integer cantidadItems, BigDecimal monto);
	
}
