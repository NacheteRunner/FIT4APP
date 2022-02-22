package com.example.fituapp.modelo;

import org.json.JSONObject;

import java.util.Date;

public class Marca {
    private int id_marca;
    private int id_usuario;
    private Date fecha_marca;
    private String carrera;
    private String distancia;
    private String marca;
    private int mejor_marca;

    public Marca(int id_marca, int id_usuario, Date fecha_marca, String carrera, String distancia, String marca, int mejor_marca) {
        this.id_marca = id_marca;
        this.id_usuario = id_usuario;
        this.fecha_marca = fecha_marca;
        this.carrera = carrera;
        this.distancia = distancia;
        this.marca = marca;
        this.mejor_marca = mejor_marca;
    }

    public Marca(){

    }

    public Marca(String carrera, String distancia, String marca){
        this.carrera = carrera;
        this.distancia = distancia;
        this.marca = marca;
    }

    public int getId_marca() {
        return id_marca;
    }

    public void setId_marca(int id_marca) {
        this.id_marca = id_marca;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha_marca() {
        return fecha_marca;
    }

    public void setFecha_marca(Date fecha_marca) {
        this.fecha_marca = fecha_marca;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getMejor_marca() {
        return mejor_marca;
    }

    public void setMejor_marca(int mejor_marca) {
        this.mejor_marca = mejor_marca;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id_marca=" + id_marca +
                ", id_usuario=" + id_usuario +
                ", fecha_marca=" + fecha_marca +
                ", carrera='" + carrera + '\'' +
                ", distancia='" + distancia + '\'' +
                ", marca='" + marca + '\'' +
                ", mejor_marca=" + mejor_marca +
                '}';
    }
}
