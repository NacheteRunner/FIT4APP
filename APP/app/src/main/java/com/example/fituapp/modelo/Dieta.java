package com.example.fituapp.modelo;

public class Dieta {
    private int id_dieta;
    private int id_usuario;
    private String semana;
    private String ruta;

    public Dieta(int id_dieta, int id_usuario, String semana, String ruta) {
        this.id_dieta = id_dieta;
        this.id_usuario = id_usuario;
        this.semana = semana;
        this.ruta = ruta;
    }

    public int getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(int id_dieta) {
        this.id_dieta = id_dieta;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Dietas{" +
                "id_dieta=" + id_dieta +
                ", id_usuario=" + id_usuario +
                ", semana='" + semana + '\'' +
                ", ruta='" + ruta + '\'' +
                '}';
    }
}
