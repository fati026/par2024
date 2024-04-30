package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Reporte;

import java.util.List;

public interface IReporteServicio {
    public List<Reporte> obtenerTodo();
    public Reporte guardar(Reporte reporte);
    public Reporte obtenerPorId(long id);
    public void eliminar(long id);
}
