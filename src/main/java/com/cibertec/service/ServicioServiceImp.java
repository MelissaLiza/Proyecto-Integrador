package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Servicio;
import com.cibertec.repository.ServicioRepository;

@Service
public class ServicioServiceImp implements ServicioService {
	
	@Autowired
	private ServicioRepository repository;

	@Override
	public List<Servicio> listaServicioPorId(int id) {
		return repository.listaServicioPorId(id);
		
	}

	@Override
	public List<Servicio> listaServicio() {
		return repository.findAll() ;
	}

}
