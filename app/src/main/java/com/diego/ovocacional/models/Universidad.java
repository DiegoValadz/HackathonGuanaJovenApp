package com.diego.ovocacional.models;


import java.util.ArrayList;

import io.realm.RealmList;


public class Universidad{

    private String id;
    private String nombre;
    private String tipo;
    private String siglas;
    private String ciudad;
    private String costo;
    private String link;
    private String linkpromo;

    private ArrayList<Carrera> carreras;

    public Universidad() {
    }

    public Universidad(String id,String nombre, String tipo, String siglas, String ciudad, String link, String costo,String linkpromo,ArrayList<Carrera> carreras ) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.siglas = siglas;
        this.ciudad = ciudad;
        this.costo = costo;
        this.link = link;
        this.linkpromo = linkpromo;
        this.carreras = carreras;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getLinkpromo() {
        return linkpromo;
    }

    public void setLinkpromo(String linkpromo) {
        this.linkpromo = linkpromo;
    }

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }
}
