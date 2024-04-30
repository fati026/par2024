package com.par2024.apirest.servicios;

import com.par2024.apirest.modelos.Reporte;
import com.par2024.apirest.repositorios.ReporteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteServicioImpl implements IReporteServicio {

	@Autowired
	ReporteRepositorio reporteRepositorio;

	@Override
	public List<Reporte> obtenerTodo() {
		return reporteRepositorio.findAll();
	}

	@Override
	public Reporte guardar(Reporte reporte) {
		return reporteRepositorio.save(reporte);
	}

	@Override
	public Reporte obtenerPorId(long id) {
		return reporteRepositorio.findById(id).orElse(null);
	}

	@Override
	public void eliminar(long id) {
		reporteRepositorio.deleteById(id);
	}
}
