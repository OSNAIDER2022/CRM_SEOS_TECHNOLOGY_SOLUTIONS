package com.amsterdam.crm_ossoluciones.model;

import java.util.Objects;

public class Roll {
    private Integer id;
    private String perfil;

    //CONSTRUCTORES:
    //con id:
    public Roll(Integer id, String perfil) {
        this.id = id;
        this.perfil = perfil;
    }

    //sin id:
    public Roll(String perfil) {
        this.perfil = perfil;
    }

    //vacio:
    public Roll() {
    }

    //METODOS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    //HASCODE AND EQUALS:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roll roll = (Roll) o;
        return Objects.equals(id, roll.id) && Objects.equals(perfil, roll.perfil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, perfil);
    }
}
