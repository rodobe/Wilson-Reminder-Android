package com.example.jesus.wilsonreminder;

import java.util.Date;

/**
 * Created by jesus on 18/12/2017.
 */

public class Usuario {
    private int ID;
    private String Correo;
    private String Nombre;
    private String Apellido;
    private Date FechaNacimiento;
    private boolean Activo;
    private String ClaveAcceso;
    private Date FechaRegistro;
    private String FormaRegistro;

    public int getID(){
        return ID;
    }
    public String getCorreo(){
        return Correo;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getApellido(){
        return Apellido;
    }
    public Date getFechaNacimiento(){
        return FechaNacimiento;
    }
    public boolean getActivo(){
        return Activo;
    }
    public String getClaveAcceso(){
        return ClaveAcceso;
    }
    public Date getFechaRegistro(){
        return FechaRegistro;
    }
    public String getFormaRegistro(){
        return FormaRegistro;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setCorreo(String Correo){
        this.Correo = Correo;
    }
    public void setNombre(String Nombre){
        this.Nombre = Nombre;
    }
    public void setApellido(String Apellido){
        this.Apellido = Apellido;
    }
    public void setFechaNacimiento(Date FechaNacimiento){
        this.FechaNacimiento = FechaNacimiento;
    }
    public void setActivo(boolean Activo){
        this.Activo = Activo;
    }
    public void setClaveAcceso(String ClaveAcceso){
        this.ClaveAcceso = ClaveAcceso;
    }
    public void setFechaRegistro(Date FechaRegistro){
        this.FechaRegistro = FechaRegistro;
    }

    public void setFormaRegistro(String formaRegistro) {
        this.FormaRegistro = formaRegistro;
    }
}
