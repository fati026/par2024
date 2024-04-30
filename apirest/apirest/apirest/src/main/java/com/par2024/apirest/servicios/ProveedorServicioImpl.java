package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Proveedor;
import com.par2024.apirest.repositorios.ProveedorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServicioImpl implements IProveedorServicio {

	@Autowired
	ProveedorRepositorio proveedorRepositorio;

	@Override
	public List<Proveedor> obtenerTodo() {
		return proveedorRepositorio.findAll();
	}

	@Override
	public Proveedor guardar(Proveedor proveedor) {
		return proveedorRepositorio.save(proveedor);
	}

	@Override
	public Proveedor obtenerPorId(long id) {
		return proveedorRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		proveedorRepositorio.deleteById(id);
	}
}
