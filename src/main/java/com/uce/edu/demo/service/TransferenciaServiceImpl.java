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
public class TransferenciaServiceImpl implements ITransferenciaService {

	@Autowired
	private ITransferenciaRepository transferenciaRepo;

	@Autowired
	private ICuentaBancariaRepository cuentaBancariaRepo;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferencia(String CtaOrigen, String CtaDestino, BigDecimal monto) {
		// encontramos las cuentas
		CuentaBancaria origen = this.cuentaBancariaRepo.buscarPorNumero(CtaOrigen);
		CuentaBancaria destino = this.cuentaBancariaRepo.buscarPorNumero(CtaDestino);
		// obtenemos los valores de los saldos
		BigDecimal saldoOrigen = origen.getSaldo();
		BigDecimal saldoDestino = destino.getSaldo();
		// sumamos en el destino y restamos en el origen
		BigDecimal saldoActualOrigen = saldoOrigen.subtract(monto);
		BigDecimal saldoActualDestino = saldoDestino.add(monto);
		// cambiamos los valores
		origen.setSaldo(saldoActualOrigen);
		destino.setSaldo(saldoActualDestino);
		// actualizamos en DB
		this.cuentaBancariaRepo.actualizar(origen);
		this.cuentaBancariaRepo.actualizar(destino);
		// seteamos la transferencia
		Transferencia trans = new Transferencia();
		trans.setCuentaOrigen(origen);
		trans.setCuentaDestino(destino);
		trans.setFecha(LocalDateTime.now());
		trans.setMonto(monto);
		// insertamos la transferencia
		this.transferenciaRepo.insertar(trans);

//		if (origen.getTipo().equals("Ahorros")) {
//			throw  new RuntimeException();
//		}
			if (monto.compareTo(saldoOrigen) > 0) {
				throw new RuntimeException();// ejecuta rollback
			}

	}// commit

	@Override
	public void insertarCuenta(CuentaBancaria bancaria) {
		this.cuentaBancariaRepo.insertar(bancaria);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarTransferenciaFachada(String CtaOrigen, String CtaDestino, BigDecimal monto) {
		this.realizarTransferencia(CtaOrigen, CtaDestino, monto);
	}

	@Override
	public CuentaBancaria buscarPorNumero(String numeroCuenta) {
		return this.cuentaBancariaRepo.buscarPorNumero(numeroCuenta);
	}

}
