package com.uce.edu.demo.supermaxi.service;

import java.util.List;

public interface IGestorFacturaService {

	public void compraProcductos (String cedulaCliente, String numeroFactura, List<String> codigos);
	
}
