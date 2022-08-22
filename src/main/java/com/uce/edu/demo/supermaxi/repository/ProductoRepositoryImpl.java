package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Producto;

@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Producto buscarCodigoBarras(String codigoBarras) {
		// TODO Auto-generated method stub
		TypedQuery<Producto> myTypedQuery = this.entityManager
				.createQuery("SELECT p FROM Producto p WHERE p.codigoBarras = :codigoBarras", Producto.class);
		myTypedQuery.setParameter("codigoBarras", codigoBarras);
		return myTypedQuery.getSingleResult();
	}

	@Override
	public void actualizar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

}
