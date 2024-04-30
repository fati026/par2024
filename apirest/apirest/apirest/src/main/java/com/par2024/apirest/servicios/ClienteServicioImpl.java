package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Cliente;
import com.par2024.apirest.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements IClienteServicio {

	@Autowired
	ClienteRepositorio clienteRepositorio;

	@Override
	public List<Cliente> obtenerTodo() {
		return clienteRepositorio.findAll();
	}

	@Override
	public Cliente guardar(Cliente cliente) {
		return clienteRepositorio.save(cliente);
	}

	@Override
	public Cliente obtenerPorId(long id) {
		return clienteRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		clienteRepositorio.deleteById(id);
	}
}
