package com.diego.ovocacional.models;

public class Carrera {

    private String nombre;
    private String area;
    private String duracion;

    public Carrera() {

    }

    public Carrera(String nombre, String area, String duracion) {
        this.nombre = nombre;
        this.area = area;
        this.duracion = duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
}
