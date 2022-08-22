package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Factura;

@Repository
@Transactional
public class FacturaRepositoryImpl implements IFacturaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public Factura buscarNumero(String numero) {
		// TODO Auto-generated method stub
		TypedQuery<Factura> myTypedQuery = this.entityManager
				.createQuery("SELECT f FROM Factura f WHERE f.numero = :numero", Factura.class);
		myTypedQuery.setParameter("numero", numero);
		return myTypedQuery.getSingleResult();

	}

}
