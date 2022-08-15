package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.uce.edu.demo.repository.modelo.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepositoryImpl implements ICuentaBancariaRepository{

	private static final Logger log =LoggerFactory.getLogger(CuentaBancariaRepositoryImpl.class);
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(CuentaBancaria cuentaBancaria) {
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		this.entityManager.merge(cuentaBancaria);
	}

	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED) 
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		
		log.info("Transaccion activa Repo: "
	+ TransactionSynchronizationManager.isActualTransactionActive());
		
		TypedQuery< CuentaBancaria> myQuery=this.entityManager.createQuery
				("select c from CuentaBancaria c where c.numero =:numCuenta",CuentaBancaria.class);
		myQuery.setParameter("numCuenta", numeroCuenta);
		return myQuery.getSingleResult();
	}
	
	
	
}
