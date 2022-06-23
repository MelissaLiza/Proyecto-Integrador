package com.cibertec.service;

import java.util.List;


import com.cibertec.entidad.Departamento;

public interface DepartamentoService  {
	
	public abstract List<Departamento> listaDepartamento();
	public abstract List<Departamento> listaDepartamentoPorId(int id); 
	public abstract Departamento insertaActualizaDepartamento(Departamento obj);
}
