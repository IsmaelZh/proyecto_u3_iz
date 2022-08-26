package com.uce.edu.demo.supermaxi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IFacturaRepository facturaRepository;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public BigDecimal procesarFactura(String cedula, String numeroFactura, List<String> listaCodigo) {
		// TODO Auto-generated method stub

		BigDecimal totalPagar = BigDecimal.ZERO;

		Cliente cliente = this.clienteRepository.buscarCedula(cedula);

		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setFecha(LocalDateTime.now());
		factura.setNumero(numeroFactura);

		List<DetalleFactura> detalles = new ArrayList<>();

		for (String codigoProducto : listaCodigo) {
			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1);
			detalle.setFactura(factura);
			Producto producto = this.productoRepository.buscarCodigoBarras(codigoProducto);
			detalle.setProducto(producto);
			detalle.setSubtotal(detalle.getProducto().getPrecio());
			totalPagar.add(detalle.getSubtotal());
			producto.setStock(producto.getStock() - detalle.getCantidad());
			this.productoRepository.actualizar(producto);
			detalles.add(detalle);
		}
		factura.setDetalles(detalles);
		
		this.facturaRepository.insertar(factura);

		return totalPagar;
	}

}
