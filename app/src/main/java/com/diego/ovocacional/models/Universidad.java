package com.diego.ovocacional.models;

import com.diego.ovocacional.App.MyApplication;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Universidad extends RealmObject{

    @PrimaryKey
    private int id;
    @Required
    private String nombre;
    @Required
    private String tipo;
    @Required
    private String siglas;
    @Required
    private String ciudad;
    @Required
    private String costo;
    @Required
    private String link;

    private RealmList<Carrera> carreras;

    public Universidad() {
    }

    public Universidad(String nombre, String tipo, String siglas, String ciudad, String costo, String link, RealmList<Carrera> carreras) {
        this.id = MyApplication.UniversidadID.incrementAndGet();
        this.nombre = nombre;
        this.tipo = tipo;
        this.siglas = siglas;
        this.ciudad = ciudad;
        this.costo = costo;
        this.link = link;
        this.carreras = carreras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RealmList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(RealmList<Carrera> carreras) {
        this.carreras = carreras;
    }


}
