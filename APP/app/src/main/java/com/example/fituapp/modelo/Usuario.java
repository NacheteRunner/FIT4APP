package com.example.fituapp.modelo;


public class Usuario {
    private int id_usuario;
    private String nombre_usuario;
    private String login_usuario;
    private int telefono;
    private String email;
    private int edad;
    private String foto;
    private int entrenamiento;
    private int  dieta;
    private int activo;

    public Usuario(int id_usuario, String nombre_usuario, String login_usuario, int telefono, String email,  int edad, String foto, int entrenamiento, int dieta, int activo) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.login_usuario = login_usuario;
        this.telefono = telefono;
        this.email = email;
        this.edad = edad;
        this.foto = foto;
        this.entrenamiento = entrenamiento;
        this.dieta = dieta;
        this.activo = activo;
    }

    public Usuario(){

    }

    public Usuario(String nombre_usuario, String login_usuario, String telefono) {
        this.nombre_usuario = nombre_usuario;
        this.login_usuario = login_usuario;
        this.telefono = Integer.valueOf(telefono);
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getLogin_usuario() {
        return login_usuario;
    }

    public void setLogin_usuario(String login_usuario) {
        this.login_usuario = login_usuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(int entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public int getDieta() {
        return dieta;
    }

    public void setDieta(int dieta) {
        this.dieta = dieta;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id_usuario=" + id_usuario +
                ", nombre_usuario='" + nombre_usuario + '\'' +
                ", login_usuario='" + login_usuario + '\'' +
                ", telefono=" + telefono +
                ", edad=" + edad +
                ", foto='" + foto + '\'' +
                ", entrenamiento=" + entrenamiento +
                ", dieta=" + dieta +
                '}';
    }
}

