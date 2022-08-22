package com.uce.edu.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.supermaxi.service.IGestorFacturaService;

@SpringBootApplication
public class ProyectoU3IzApplication implements CommandLineRunner {

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
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
        
        this.gestorFacturaService.compraProcductos("301166596", "1266", codigos);


	}

}
