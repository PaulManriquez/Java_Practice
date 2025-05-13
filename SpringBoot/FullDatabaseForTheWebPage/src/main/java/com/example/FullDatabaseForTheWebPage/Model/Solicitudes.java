package com.example.FullDatabaseForTheWebPage.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "solicitudes")
public class Solicitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date fecha;
    private String archivo;
    private String comentarios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vacante_id")  // Foreign key for Vacantes
    private Vacantes vacante;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")  // Foreign key for Usuarios
    private Usuarios usuario;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Vacantes getVacante() {
        return vacante;
    }

    public void setVacante(Vacantes vacante) {
        this.vacante = vacante;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
