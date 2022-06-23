package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Servicio;


public interface ServicioService {
	public abstract List<Servicio> listaServicioPorId(int id); 
	public abstract List<Servicio> listaServicio();
}
