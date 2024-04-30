package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Cliente;

import java.util.List;

public interface IClienteServicio {
    public List<Cliente> obtenerTodo();
    public Cliente guardar(Cliente cliente);
    public Cliente obtenerPorId(long id);
    public void eliminar(long id);
}
