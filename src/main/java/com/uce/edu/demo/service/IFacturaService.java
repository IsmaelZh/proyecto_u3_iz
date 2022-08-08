package com.uce.edu.demo.service;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Factura;

public interface IFacturaService {

	public List<Factura> buscarFacturaInnerJoin(Integer cantidadDetalle);
	public List<Factura> FacturaInnerJoin();
	public List<Factura> buscarFacturaInnerJoin2(Integer cantidadDetalle);
	public List<Factura> buscarFacturaOuterJoinLeft(Integer cantidadDetalle);
	public List<Factura> buscarFacturaOuterJoinLeft();
	public List<Factura> buscarFacturaOuterJoinRight(Integer cantidadDetalle);
	public List<Factura> buscarFacturaJoinWhere(Integer cantidadDetalle);
	public List<Factura> buscarFacturaJoinFetch(Integer cantidadDetalle);

}
