package com.par2024.apirest.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Reporte implements Serializable{
    private static final long serialVersionUID= 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descripcion;

    //Constructor vacío
    public Reporte(){

    }

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id= id;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion= descripcion;
    }

    public static long getSerialversionuid(){
        return serialVersionUID;
    }

}
