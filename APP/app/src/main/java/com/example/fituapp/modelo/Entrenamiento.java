package com.example.fituapp.modelo;

import java.util.Arrays;

public class Entrenamiento {

    private int id_entrenamiento;
    private int id_usuario;
    private String semana;
    private String [] entrenos;
    private String mensual;

    public Entrenamiento(int id_entrenamiento, int id_usuario, String semana, String[] entrenos, String mensual) {
        this.id_entrenamiento = id_entrenamiento;
        this.id_usuario = id_usuario;
        this.semana = semana;
        this.entrenos = entrenos;
        this.mensual = mensual;
    }

    public Entrenamiento(){

    }

    public int getId_entrenamiento() {
        return id_entrenamiento;
    }

    public void setId_entrenamiento(int id_entrenamiento) {
        this.id_entrenamiento = id_entrenamiento;
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

    public String[] getEntrenos() {
        return entrenos;
    }

    public void setEntrenos(String[] entrenos) {
        this.entrenos = entrenos;
    }

    public String getMensual() {
        return mensual;
    }

    public void setMensual(String mensual) {
        this.mensual = mensual;
    }

    @Override
    public String toString() {
        return "Entrenamiento{" +
                "id_entrenamiento=" + id_entrenamiento +
                ", id_usuario=" + id_usuario +
                ", semana='" + semana + '\'' +
                ", entrenos=" + Arrays.toString(entrenos) +
                ", mensual='" + mensual + '\'' +
                '}';
    }
}

