package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IDetalleFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaElectronicaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.FacturaElectronica;

@Service
public class GestorFacturaServiceImpl implements IGestorFacturaService {
	// TODO Auto-generated method stub

	@Autowired
	private IFacturaService facturaService;
	
	@Autowired
	private IFacturaElectronicaService electronicaService;
	

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProcductos(String cedulaCliente, String numeroFactura, List<String> codigos) {

		BigDecimal totalPagar = this.facturaService.procesarFactura(cedulaCliente, numeroFactura, codigos);
		
		this.electronicaService.registarSRI(numeroFactura, codigos.size(), totalPagar);
		
	}

}
