package com.uce.edu.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.uce.edu.demo.repository.HotelRepositoryImpl;
import com.uce.edu.demo.repository.modelo.Hotel;

@SpringBootTest
@Rollback(true)
@AutoConfigureTestDatabase(replace = Replace.NONE)

public class Ejemplo4 {

	@Autowired
	private HotelRepositoryImpl hotelRepositoryImpl;

	@Test
	@Rollback(true)
	public void testActualizarHotel() {

		Hotel hotel = new Hotel();

		hotel.setNombre("Tambo Real");
		hotel.setDireccion("Av. Patria");

		this.hotelRepositoryImpl.insertar(hotel);

		Hotel hotelActualizado = new Hotel();
		hotelActualizado.setNombre("Oro verde");
		hotelActualizado.setDireccion("Av. Patria");
		hotelActualizado.setId(3);
		this.hotelRepositoryImpl.actualizar(hotelActualizado);

		Hotel hotel1 = this.hotelRepositoryImpl.buscarPorNombre("Oro verde");

		assertThat(hotel1.getNombre()).isEqualTo(hotelActualizado.getNombre());

	}
}
