package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Boleta;





public interface BoletaService {
	public abstract Boleta insertaActualizaBoleta(Boleta obj);
	public List<Boleta> listarBoleta();
	
}
