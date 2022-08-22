package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.FacturaTaller;

public interface IFacturaServiceTaller {

	public List<FacturaTaller> buscarFacturaInnerJoin(Integer cantidadDetalle);
	public List<FacturaTaller> FacturaInnerJoin();
	public List<FacturaTaller> buscarFacturaInnerJoin2(Integer cantidadDetalle);
	public List<FacturaTaller> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);
	public List<FacturaTaller> buscarFacturaOuterJoinLeft();
	public List<FacturaTaller> buscarFacturaOuterJoinRight(Integer cantidadDetalle);
	public List<FacturaTaller> buscarFacturaJoinWhere(Integer cantidadDetalle);
	public List<FacturaTaller> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
