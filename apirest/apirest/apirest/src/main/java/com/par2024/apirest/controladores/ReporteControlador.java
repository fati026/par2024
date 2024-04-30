package com.par2024.apirest.controladores;

import com.par2024.apirest.modelos.Reporte;
import com.par2024.apirest.servicios.ReporteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class ReporteControlador {

	@Autowired
	ReporteServicioImpl reporteServicio;

	@GetMapping("/reportes")
	public List<Reporte> obtenerReportes(){
		return reporteServicio.obtenerTodo();
	}

	@PostMapping("/reportes")
	public ResponseEntity<Reporte> guardarReporte(@RequestBody Reporte reporte){
		Reporte nuevoReporte = reporteServicio.guardar(reporte);
		return new ResponseEntity<>(nuevoReporte, HttpStatus.CREATED);
	}

	@GetMapping("/reportes/{id}")
	public ResponseEntity<Reporte> obtenerReporteId(@PathVariable long id){
		Reporte reportePorId = reporteServicio.obtenerPorId(id);
		return ResponseEntity.ok(reportePorId);
	}

	@PutMapping("/reportes/{id}")
	public ResponseEntity<Reporte> actualizarReporte(@PathVariable long id, @RequestBody Reporte reporte){
		Reporte reportePorId = reporteServicio.obtenerPorId(id);
		reportePorId.setDescripcion(reporte.getDescripcion());
		reportePorId.setDescripcion(reporte.getDescripcion());

		Reporte reporteActualizado = reporteServicio.guardar(reportePorId);
		return new ResponseEntity<>(reporteActualizado, HttpStatus.CREATED);
	}

	@DeleteMapping("/reportes/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarReporte(@PathVariable long id){
		reporteServicio.eliminar(id);

		HashMap<String, Boolean> estadoReporteEliminado = new HashMap<>();
		estadoReporteEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoReporteEliminado);
	}
}
