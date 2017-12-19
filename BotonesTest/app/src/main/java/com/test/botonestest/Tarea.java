package com.test.botonestest;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Tarea implements Serializable{
    private String nombre;
    private String categoria;
    private String descripcion;
    private String fecha_creacion;
    private String fecha_limite;


    public Tarea(String nombre, String categoria, String descripcion, String fecha_creacion, String fecha_limite) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.fecha_creacion = fecha_creacion;
        this.fecha_limite = fecha_limite;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
}
