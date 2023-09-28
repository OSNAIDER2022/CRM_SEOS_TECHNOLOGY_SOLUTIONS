package com.amsterdam.crm_ossoluciones.model;

import java.util.Objects;

public class Usuario {
    //ATRIBUTOS:
    private Integer id;
    private String nombreCompleto;
    private String email;
    private String password;
    private String celular;
    private String identificacion;
    private String foto;
    private Integer roll_id;

    //CONSTRUCTORES:
    //con id:
    public Usuario(Integer id, String nombreCompleto, String email, String password, String celular, String identificacion, String foto, Integer roll_id) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.identificacion = identificacion;
        this.foto = foto;
        this.roll_id = roll_id;
    }

    //sin id:
    public Usuario(String nombreCompleto, String email, String password, String celular, String identificacion, String foto, Integer roll_id) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.password = password;
        this.celular = celular;
        this.identificacion = identificacion;
        this.foto = foto;
        this.roll_id = roll_id;
    }

    //vacio:
    public Usuario() {
    }

    //METODOS:
    //GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Integer getRoll_id() {
        return roll_id;
    }

    public void setRoll_id(Integer roll_id) {
        this.roll_id = roll_id;
    }


    //HASHCODE AND EQUALS
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) && Objects.equals(nombreCompleto, usuario.nombreCompleto) && Objects.equals(email, usuario.email) && Objects.equals(password, usuario.password) && Objects.equals(celular, usuario.celular) && Objects.equals(identificacion, usuario.identificacion) && Objects.equals(foto, usuario.foto) && Objects.equals(roll_id, usuario.roll_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreCompleto, email, password, celular, identificacion, foto, roll_id);
    }

    //USER DETAILS:(hasta implementar seguridad)

}
