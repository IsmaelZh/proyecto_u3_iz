package com.uce.edu.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Transferencia;

@Repository
@Transactional
public class TransferenciaRepositoryImpl implements ITransferenciaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Transferencia transferencia) {
		this.entityManager.persist(transferencia);
	}

	
	
}
