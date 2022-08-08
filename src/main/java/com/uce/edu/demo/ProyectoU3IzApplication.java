package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Factura;
import com.uce.edu.demo.service.IFacturaService;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	@Autowired
	private IFacturaService facturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		// Inner
		LOG.info("INNER JOIN");
		List<Factura> listafacturas = this.facturaService.buscarFacturaInnerJoin(6);
		for (Factura f : listafacturas) {
			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
		}

		List<Factura> listaFactura1 = this.facturaService.FacturaInnerJoin();
		for (Factura f : listaFactura1) {
			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
		}

		// Left
		LOG.info("JOIN LEFT");
		List<Factura> listaFacturaLeft = this.facturaService.buscarFacturaOuterJoinLeft(6);
		for (Factura f : listaFacturaLeft) {
			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
		}

		List<Factura> listaFacturaLeft1 = this.facturaService.buscarFacturaOuterJoinLeft();
		for (Factura f : listaFacturaLeft1) {
			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
		}

		// Right
		LOG.info("JOIN RIGTH");
		List<Factura> listaFacturaRigth = this.facturaService.buscarFacturaOuterJoinRight(6);
		for (Factura f : listaFacturaRigth) {
			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
		}

		
//		LOG.info("RELACIONAMIENTO WHERE");
//		List<Factura> listaFacturas = this.facturaService.buscarFacturaJoinWhere(6);
//		for (Factura f : listaFacturas) {
//			LOG.info("Factura: " + f.getFecha() + " " + f.getNumero());
//		}
//
//		LOG.info("INNER JOIN EAGER/LAZY");
//		List<Factura> listaFacturas2 = this.facturaService.buscarFacturaInnerJoin2(6);
//		for (Factura f : listaFacturas2) {
//			LOG.info("Factura2: " + f.getFecha() + " " + f.getNumero());
//			for (DetalleFactura d : f.getDetalles()) {
//				LOG.info("Detalle2: " + d);
//			}
//
//		}
//
//		LOG.info("JOIN FETCH");
//		List<Factura> listaFacturas3 = this.facturaService.buscarFacturaJoinFetch(6);
//		for (Factura f : listaFacturas3) {
//			LOG.info("Factura3: " + f.getFecha() + " " + f.getNumero());
//			for (DetalleFactura d : f.getDetalles()) {
//				LOG.info("Detalle3: " + d);
//			}
//
//		}

	}

}
