package com.uce.edu.demo.supermaxi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
import com.uce.edu.demo.supermaxi.repository.IFacturaRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;
import com.uce.edu.demo.supermaxi.repository.modelo.Factura;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Service
public class GestorFacturaServiceImpl implements IGestorFacturaService {
	// TODO Auto-generated method stub

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IDetalleFacturaRepository detalleFacturaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IFacturaElectronicaRepository facturaElectronicaRepository;

	// A
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void compraProcductos(String cedulaCliente, String numeroFactura, List<String> codigos) {

		Cliente cliente = this.clienteRepository.buscarCedula(cedulaCliente);

		Factura fact = new Factura();
		fact.setCliente(cliente);
		fact.setFecha(LocalDateTime.now());
		fact.setNumero(numeroFactura);

		this.facturaRepository.insertar(fact);

		List<DetalleFactura> detalles = new ArrayList<DetalleFactura>();
		for (String codigoProducto : codigos) {

			DetalleFactura detalle = new DetalleFactura();
			detalle.setCantidad(1); 
			detalle.setFactura(fact);
			Producto producto = this.productoRepository.buscarCodigoBarras(codigoProducto);
			detalle.setProducto(producto);

			producto.setStock(producto.getStock() - 1);

			if (producto.getStock() > 0) {

				detalle.setSubtotal(producto.getPrecio());
				detalles.add(detalle);

				this.detalleFacturaRepository.insertar(detalle);
				this.productoRepository.actualizar(producto);

			} else {
				LOG.error("Stock insuficiente: " + producto.getNombre());
			}

		}
		fact.setDetalles(detalles);
	}

}
