package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

public interface IClienteRepository {

	public Cliente buscarCedula(String cedula);
	
}