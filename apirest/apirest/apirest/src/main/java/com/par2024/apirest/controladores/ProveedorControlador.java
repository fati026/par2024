package com.par2024.apirest.controladores;

import com.par2024.apirest.modelos.Proveedor;
import com.par2024.apirest.servicios.ProveedorServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/v2/")
public class ProveedorControlador {

	@Autowired
	ProveedorServicioImpl proveedorServicio;

	@GetMapping("/proveedores")
	public List<Proveedor> obtenerProveedores(){
		return proveedorServicio.obtenerTodo();
	}

	@PostMapping("/proveedores")
	public ResponseEntity<Proveedor> guardarProveedor(@RequestBody Proveedor proveedor){
		Proveedor nuevoProveedor = proveedorServicio.guardar(proveedor);
		return new ResponseEntity<>(nuevoProveedor, HttpStatus.CREATED);
	}

	@GetMapping("/proveedores/{id}")
	public ResponseEntity<Proveedor> obtenerProveedorId(@PathVariable long id){
		Proveedor proveedorPorId = proveedorServicio.obtenerPorId(id);
		return ResponseEntity.ok(proveedorPorId);
	}

	@PutMapping("/proveedores/{id}")
	public ResponseEntity<Proveedor> actualizarProveedor(@PathVariable long id, @RequestBody Proveedor proveedor){
		Proveedor proveedorPorId = proveedorServicio.obtenerPorId(id);
		proveedorPorId.setNombre(proveedor.getNombre());
		proveedorPorId.setApellido(proveedor.getApellido());
		proveedorPorId.setDescripcion(proveedor.getDescripcion());

		Proveedor proveedorActualizado = proveedorServicio.guardar(proveedorPorId);
		return new ResponseEntity<>(proveedorActualizado, HttpStatus.CREATED);
	}

	@DeleteMapping("/proveedores/{id}")
	public ResponseEntity<HashMap<String,Boolean>> eliminarProveedor(@PathVariable long id){
		proveedorServicio.eliminar(id);

		HashMap<String, Boolean> estadoProveedorEliminado = new HashMap<>();
		estadoProveedorEliminado.put("eliminado", true);
		return ResponseEntity.ok(estadoProveedorEliminado);
	}
}
