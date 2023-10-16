package com.amsterdam.crm_ossoluciones.model;

import java.time.LocalDate;
import java.util.Objects;

public class RegistroContable {
    //ATRIBUTOS:
    private Integer id;
    private LocalDate fecha;
    private String tipoDeRegistro;
    private String descripcion;
    private Double valor;
    private String evidencia;
    private Integer reportadorId;

    //CONSTRUCTORES:
    //con id:
    public RegistroContable(Integer id, LocalDate fecha, String tipoDeRegistro, String descripcion, Double valor, String evidencia, Integer reportadorId) {
        this.id = id;
        this.fecha = fecha;
        this.tipoDeRegistro = tipoDeRegistro;
        this.descripcion = descripcion;
        this.valor = valor;
        this.evidencia = evidencia;
        this.reportadorId = reportadorId;
    }

    //sin id:
    public RegistroContable(LocalDate fecha, String tipoDeRegistro, String descripcion, Double valor, String evidencia, Integer reportadorId) {
        this.fecha = fecha;
        this.tipoDeRegistro = tipoDeRegistro;
        this.descripcion = descripcion;
        this.valor = valor;
        this.evidencia = evidencia;
        this.reportadorId = reportadorId;
    }

    //default:
    public RegistroContable() {
    }


    //GETTERS AND SETTERS:
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeRegistro() {
        return tipoDeRegistro;
    }

    public void setTipoDeRegistro(String tipoDeRegistro) {
        this.tipoDeRegistro = tipoDeRegistro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public Integer getReportadorId() {
        return reportadorId;
    }

    public void setReportadorId(Integer reportadorId) {
        this.reportadorId = reportadorId;
    }

    //HASHCODE AND EQUALS:
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroContable that = (RegistroContable) o;
        return Objects.equals(id, that.id) && Objects.equals(fecha, that.fecha) && Objects.equals(tipoDeRegistro, that.tipoDeRegistro) && Objects.equals(descripcion, that.descripcion) && Objects.equals(valor, that.valor) && Objects.equals(evidencia, that.evidencia) && Objects.equals(reportadorId, that.reportadorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fecha, tipoDeRegistro, descripcion, valor, evidencia, reportadorId);
    }
}
