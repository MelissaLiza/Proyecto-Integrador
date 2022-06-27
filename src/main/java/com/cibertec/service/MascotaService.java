package com.cibertec.service;

import java.util.List;

import com.cibertec.entidad.Mascota;

public interface MascotaService {
	public abstract List<Mascota> listaMascota();
	public abstract Mascota insertaActualizaMascota(Mascota obj);
	public List<Mascota> listaMascotaConFiltro(String filtro);

}
