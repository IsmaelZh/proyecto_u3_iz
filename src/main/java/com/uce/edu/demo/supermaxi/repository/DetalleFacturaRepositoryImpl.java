package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.DetalleFactura;

@Repository
@Transactional
public class DetalleFacturaRepositoryImpl implements IDetalleFacturaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(DetalleFactura detalleFactura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(detalleFactura);
	}

}
