package com.cibertec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cibertec.entidad.Boleta;
import com.cibertec.entidad.Propietario;

public interface BoletaRepository extends JpaRepository<Boleta, Integer> {
	
	

}
