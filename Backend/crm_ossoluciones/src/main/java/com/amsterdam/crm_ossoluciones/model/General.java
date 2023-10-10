package com.amsterdam.crm_ossoluciones.model;

/*MODEL GENERAL:
 * Este model es la clase para la administracion de las tablas de la base de datos DATABASE_OSSOLUCIONES,
 * relacionadas a continuacion:
 * - ROLLES
 * - ESTADOS_DE_SERVICIOS
 * - ESTADOS_DE_PRODUCTOS
 * - TIEMPOS_GARANTIAS
 *
 * El objetivo de este model es la aplicacion de la metodología SOLID para las actuales y los futuros
 * implementamientos que puedan dar lugar.
 * El model maneja los siguientes atributos:
 * - id
 * - valor (con el objetivo de abstraer)
 * */

import java.util.Objects;

public class General {
    //ATRIBUTOS:
    private  Integer id;
    private String valor;

    //METODOS:
    //con id:
    public General(Integer id, String valor) {
        this.id = id;
        this.valor = valor;
    }

    //sin id:
    public General(String valor) {
        this.valor = valor;
    }

    //default:
    public General() {
    }


    //GETTERS AND SETTERS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    //HASCODE AND EQUALS:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        General general = (General) o;
        return Objects.equals(id, general.id) && Objects.equals(valor, general.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor);
    }
}
