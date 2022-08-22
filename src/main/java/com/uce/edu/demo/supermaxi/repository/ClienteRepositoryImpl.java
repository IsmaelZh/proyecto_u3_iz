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
	public Cliente buscarCedula(String numeroCedula) {
		// TODO Auto-generated method stub
		TypedQuery<Cliente> myTypedQuery = this.entityManager
                .createQuery("SELECT c FROM Cliente c  WHERE c.numeroCedula = :numeroCedula  ", Cliente.class)
                .setParameter("numeroCedula", numeroCedula);
        return myTypedQuery.getSingleResult();
	}

}
