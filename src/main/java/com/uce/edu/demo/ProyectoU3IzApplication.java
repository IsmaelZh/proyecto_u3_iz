package com.uce.edu.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.repository.IClienteRepository;
import com.uce.edu.demo.supermaxi.repository.IProductoRepository;
import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;
import com.uce.edu.demo.supermaxi.repository.modelo.Producto;
import com.uce.edu.demo.supermaxi.service.IGestorFacturaService;

@SpringBootApplication
public class ProyectoU3IzApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3IzApplication.class);
	
	@Autowired
	private IGestorFacturaService gestorFacturaService;
	
	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setNumeroCedula("1796963256");
		//this.clienteRepository.insertar(cliente);
		
		Producto producto = new Producto();
		producto.setNombre("Mantequilla");
		producto.setCodigoBarras("0-001");
		producto.setPrecio(new BigDecimal(2.75));
		producto.setStock(90);
		//this.iProductoRepository.insertar(producto);
		
		Producto producto2 = new Producto();
		producto2.setNombre("Queso");
		producto2.setCodigoBarras("0-002");
		producto2.setPrecio(new BigDecimal(3.30));
		producto2.setStock(44);
		//this.iProductoRepository.insertar(producto2);
		
		Producto producto3 = new Producto();
		producto3.setNombre("Gelatina");
		producto3.setCodigoBarras("0-003");
		producto3.setPrecio(new BigDecimal(0.99));
		producto3.setStock(90);
		//this.iProductoRepository.insertar(producto3);
		
		List<String> detalles = new ArrayList<String>();
        detalles.add(producto.getCodigoBarras());
        detalles.add(producto2.getCodigoBarras());
        detalles.add(producto3.getCodigoBarras());
        
        this.gestorFacturaService.compraProcductos("1796963256", "1266", detalles);


	}

}
