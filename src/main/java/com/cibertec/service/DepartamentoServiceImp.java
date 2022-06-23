package com.cibertec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entidad.Departamento;
import com.cibertec.repository.DepartamentoRepository;
@Service
public class DepartamentoServiceImp implements DepartamentoService {

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public List<Departamento> listaDepartamento() {
		return repository.findAll() ;
	}
	@Override
	public Departamento insertaActualizaDepartamento(Departamento obj) {
		return repository.save(obj);
	}
	@Override
	public List<Departamento> listaDepartamentoPorId(int id) {
		return repository.listaDepartamentoPorId(id);
	}
	

}
