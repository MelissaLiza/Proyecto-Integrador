package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cibertec.entidad.Boleta;
import com.cibertec.entidad.Propietario;

import com.cibertec.repository.BoletaRepository;

@Controller
public class BoletaServiceImp implements BoletaService{
	@Autowired
	private BoletaRepository repository;

	@Override
	public Boleta insertaActualizaBoleta(Boleta obj) {
		return repository.save(obj);
	}

	@Override
	public List<Boleta> listarBoleta() {
		return repository.findAll();
	}
	
	

}
