package com.cibertec.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cibertec.entidad.Departamento;
import com.cibertec.service.DepartamentoService;


//
@RestController
@RequestMapping("/rest/departamento")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {
	@Autowired
	private DepartamentoService service;
	
	
	//LISTADO DE DEPARTAMENTOS
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Departamento>> listaDepartamento(){
		List<Departamento> lista = service.listaDepartamento();
		return ResponseEntity.ok(lista);
	}
	
	//REGISTRO DE DEPARTAMENTOS
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarDepartamento(@RequestBody Departamento obj){
		Map<String, Object> salida = new HashMap<>();
		try {
			Departamento objSalida = service.insertaActualizaDepartamento(obj);
			if (objSalida == null) {
				salida.put("mensaje","ERROR");
			}else {
				salida.put("mensaje","REGISTRADO");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje","ERROR");
		}
		return ResponseEntity.ok(salida);
	}
}
