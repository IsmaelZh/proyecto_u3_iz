package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.FacturaTaller;

@Repository
@Transactional
public class FacturaRepositoryImplTaller implements IFacturaRepositoryTaller {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<FacturaTaller> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
			TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
					"SELECT f FROM Factura f JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", FacturaTaller.class);
			myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaTaller> FacturaInnerJoin() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d",
				FacturaTaller.class);
		return myQuery.getResultList();
		
	}

	@Override
	public List<FacturaTaller> buscarFacturaInnerJoin2(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", FacturaTaller.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);

		List<FacturaTaller> facturas = myQuery.getResultList();
		for (FacturaTaller f : facturas) {
			f.getDetalles().size();
		}

		return facturas;
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", FacturaTaller.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d",
				FacturaTaller.class);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f RIGHT JOIN f.detalles d WHERE d.cantidad = :cantidadDetalle", FacturaTaller.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaTaller> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f, DetalleFactura d WHERE f = d.factura AND d.cantidad = :cantidadDetalle", FacturaTaller.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

	@Override
	public List<FacturaTaller> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		TypedQuery<FacturaTaller> myQuery = this.entityManager.createQuery(
				"SELECT f FROM Factura f JOIN FETCH f.detalles d WHERE d.cantidad = :cantidadDetalle", FacturaTaller.class);
		myQuery.setParameter("cantidadDetalle", cantidadDetalle);
		return myQuery.getResultList();
	}

}
