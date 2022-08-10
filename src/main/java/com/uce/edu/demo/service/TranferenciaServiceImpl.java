package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICuentaBancariaRepository;
import com.uce.edu.demo.repository.ITransferenciaRepository;
import com.uce.edu.demo.repository.modelo.CuentaBancaria;
import com.uce.edu.demo.repository.modelo.Transferencia;

@Service
public class TranferenciaServiceImpl implements ITranferenciaServise{

	@Autowired
	private ICuentaBancariaRepository bancariaRepository;
	
	@Autowired
	private ITransferenciaRepository iTransferenciaRepository;
	
	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String NumeroCtaOrigen, String NumeroCtaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		
		CuentaBancaria ctaOrigen = this.bancariaRepository.buscarPorNumero(NumeroCtaOrigen);
		
		BigDecimal saldoOrigen = ctaOrigen.getSaldo();
		BigDecimal saldoFinal = saldoOrigen.subtract(monto);
		ctaOrigen.setSaldo(saldoFinal);
		this.bancariaRepository.actualizar(ctaOrigen);
		
		CuentaBancaria ctaDestino = this.bancariaRepository.buscarPorNumero(NumeroCtaDestino);
		ctaDestino.setSaldo(ctaDestino.getSaldo().add(monto));
		this.bancariaRepository.actualizar(ctaDestino);
		
		Transferencia trans = new Transferencia();
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
        trans.setCuentaOrigen(ctaOrigen);
        trans.setCuentaDestino(ctaDestino);
        this.iTransferenciaRepository.insertar(trans);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String ctaOrigen, String ctaDestino, BigDecimal monto) {
		// TODO Auto-generated method stub
		this.realizarTransferencia(ctaOrigen, ctaDestino, monto);
		
	}

}
