package com.uce.edu.demo.supermaxi.repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

public interface IProductoRepository {

public void insertar(Producto producto);
public Producto buscarCodigoBarras(String codigoBarras);
public void actualizar (Producto producto);
	
}
