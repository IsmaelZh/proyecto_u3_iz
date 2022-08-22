package com.uce.edu.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IFacturaRepositoryTaller;
import com.uce.edu.demo.repository.modelo.FacturaTaller;

@Service
public class FacturaServiceImplTaller implements IFacturaServiceTaller {
	
	@Autowired
	private IFacturaRepositoryTaller facturaRepository;

	@Override
	public List<FacturaTaller> buscarFacturaInnerJoin(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin(cantidadDetalle);
	}

	@Override
	public List<FacturaTaller> FacturaInnerJoin() {
		// TODO Auto-generated method stub
		return this.facturaRepository.FacturaInnerJoin();
	}

	@Override
	public List<FacturaTaller> buscarFacturaInnerJoin2(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaInnerJoin2(cantidadDetalle);
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinLeft(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft(cantidadDetalle);
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinLeft() {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinLeft();
	}

	@Override
	public List<FacturaTaller> buscarFacturaOuterJoinRight(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaOuterJoinRight(cantidadDetalle);
	}

	@Override
	public List<FacturaTaller> buscarFacturaJoinWhere(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinWhere(cantidadDetalle);
	}

	@Override
	public List<FacturaTaller> buscarFacturaJoinFetch(Integer cantidadDetalle) {
		// TODO Auto-generated method stub
		return this.facturaRepository.buscarFacturaJoinFetch(cantidadDetalle);
	}

}
