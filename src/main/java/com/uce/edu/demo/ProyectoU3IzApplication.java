package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.service.IGestorFacturaService;

@SpringBootApplication
public class ProyectoU3IzApplication implements CommandLineRunner {

	private static Logger LOG = Logger.getLogger(ProyectoU3IzApplication.class);
	
	@Autowired
	private IGestorFacturaService gestorFacturaService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<String> codigos = new ArrayList<String>();
        codigos.add("0001");
        codigos.add("0002");
        codigos.add("0003");
        
        this.gestorFacturaService.compraProcductos("0302325963", "1266", codigos);


	}

}
