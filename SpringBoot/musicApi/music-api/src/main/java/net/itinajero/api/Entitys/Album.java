package net.itinajero.api.Entitys;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="albums")
public class Album {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private Date lanzado;
    private Double precio;
    private String genero;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titutlo) {
        this.titulo = titutlo;
    }

    public Date getLanzado() {
        return lanzado;
    }

    public void setLanzado(Date lanzado) {
        this.lanzado = lanzado;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", titutlo='" + titulo + '\'' +
                ", lanzado=" + lanzado +
                ", genero='" + genero + '\'' +
                ", precio=" + precio +
                '}';
    }
}
