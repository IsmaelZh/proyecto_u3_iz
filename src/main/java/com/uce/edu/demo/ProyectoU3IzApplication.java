package com.uce.edu.demo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Habitacion;
import com.uce.edu.demo.repository.modelo.Hotel;
import com.uce.edu.demo.service.IHotelService;

@SpringBootApplication
public class ProyectoU3IzApplication implements CommandLineRunner{

	private static final Logger LOG = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IHotelService hotelService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoU3IzApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		//Inner
//		LOG.info("INNER JOIN");
//		List<Hotel> listaHotel = this.hotelService.buscarHotelInnerJoin("Individual");
//		for(Hotel h : listaHotel) {
//			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
//		} 
//		
//		List<Hotel> listaHotel1 = this.hotelService.HotelInnerJoin();
//		for(Hotel h : listaHotel1) {
//			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
//		} 
//		
//		//Left
//		LOG.info("JOIN LEFT");
//		List<Hotel> listaHotelLeft = this.hotelService.buscarHotelOuterJoinLeft("Individual");
//		for(Hotel h : listaHotelLeft) {
//			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
//		}
//		
//		List<Hotel> listaHotelLeft1 = this.hotelService.buscarHotelOuterJoinLeft();
//		for(Hotel h : listaHotelLeft1) {
//			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
//		}
//		
//		//Rigth
//		LOG.info("JOIN RIGTH");
//		List<Hotel> listaHotelRigth = this.hotelService.buscarHotelOuterJoinRigth("Individual");
//		for(Hotel h : listaHotelRigth) {
//			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
//		}
		
		LOG.info("RELACIONAMIENTO WHERE");
		List<Hotel> listaHoteles = this.hotelService.buscarHotelJoinWhere("Individual");
		for(Hotel h : listaHoteles) {
			LOG.info("Hotel: " + h.getNombre()+ " " + h.getDireccion());
		}
		
		//Inner
		LOG.info("INNER JOIN EAGER/LAZY");
		List<Hotel> listaHoteles2 = this.hotelService.buscarHotelInnerJoin("Individual");
		for(Hotel h : listaHoteles2) {
			LOG.info("Hotel2: " + h.getNombre()+ " " + h.getDireccion());
			for(Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitacion2: " + ha);
			}
			
		} 
		
		LOG.info("JOIN FETCH");
		List<Hotel> listaHoteles3 = this.hotelService.buscarHotelJoinFetch("Individual");
		for(Hotel h : listaHoteles3) {
			LOG.info("Hotel3: " + h.getNombre()+ " " + h.getDireccion());
			for(Habitacion ha : h.getHabitaciones()) {
				LOG.info("Habitacion3: " + ha);
			}
			
		}
		
	}

}
