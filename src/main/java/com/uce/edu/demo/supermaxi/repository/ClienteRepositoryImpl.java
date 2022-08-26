package com.uce.edu.demo.supermaxi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.supermaxi.repository.modelo.Cliente;

@Repository
@Transactional
public class ClienteRepositoryImpl implements IClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente buscarCedula(String numeroCedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myTypedQuery = this.entityManager
				.createQuery("SELECT c FROM Cliente c  WHERE c.numeroCedula = :datoCedula", Cliente.class);
		myTypedQuery.setParameter("datoCedula", numeroCedula);
		return myTypedQuery.getSingleResult();
	}

}
