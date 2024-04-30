package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Proveedor;

import java.util.List;

public interface IProveedorServicio {
    public List<Proveedor> obtenerTodo();
    public Proveedor guardar(Proveedor proveedor);
    public Proveedor obtenerPorId(long id);
    public void eliminar(long id);
}
