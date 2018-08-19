package com.diego.ovocacional.models;

import com.diego.ovocacional.App.MyApplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Carrera extends RealmObject {

    @PrimaryKey
    private int id;
    @Required
    private String nombre;
    @Required
    private String area;
    @Required
    private String duracion;

    public Carrera() {

    }

    public Carrera(String nombre, String area, String duracion) {
        this.id = MyApplication.CarreraID.incrementAndGet();
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
