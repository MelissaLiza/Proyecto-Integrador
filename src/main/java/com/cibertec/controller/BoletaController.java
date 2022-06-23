package com.cibertec.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.entidad.Boleta;

import com.cibertec.service.BoletaService;

import java.util.logging.Logger;
@RestController
@RequestMapping("/rest/boleta")
@CrossOrigin(origins = "http://localhost:4200")
public class BoletaController {
	@Autowired
	private BoletaService service;
	
	
	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.under.InternalSys");

	void im(String texto) {
		LOGGER.log(Level.WARNING, texto);
	};
	
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<Boleta>> listaBoleta(){
		List<Boleta> lista = service.listarBoleta();
		return ResponseEntity.ok(lista);
	}
	//REGISTRO DE DEPARTAMENTOS
	@PostMapping
	@ResponseBody
	public  ResponseEntity<Map<String, Object>> registrarBoleta(@RequestBody Boleta obj){
		Map<String, Object> salida = new HashMap<>();
		
		try {
			obj.setEstado_boleta(1);
			Boleta objSalida = service.insertaActualizaBoleta(obj);
		
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
	
	@PutMapping("/actualizaBoleta")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaSede(@RequestBody Boleta obj) {
		im("==> insertSede ==> CodigoPostal : " + obj.getEstado_boleta());
		im("==> insertSede ==> Direccion : " + obj.getFecha_pago_boleta());
		im("==> insertSede ==> Estado : " + obj.getUltimo_Dia_Pago());
		im("==> insertSede ==> FechaRegistro : " + obj.getDepartamento());
		im("==> insertSede ==> sede : " + obj.getServicio());
		
		Map<String, Object> salida = new HashMap<>();
		try {
			if (obj.getId_boleta() == 0) {
				salida.put("mensaje", "El ID de sede debe ser diferente cero");
				return ResponseEntity.ok(salida);
			}
			Boleta objSalida = service.insertaActualizaBoleta(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error");
			} else {
				salida.put("mensaje", "exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "error");
		}
		return ResponseEntity.ok(salida);
	}
	
	
}
