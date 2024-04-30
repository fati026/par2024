package com.par2024.apirest.repositorios;

import com.par2024.apirest.modelos.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepositorio extends JpaRepository< Reporte, Long>{

}
