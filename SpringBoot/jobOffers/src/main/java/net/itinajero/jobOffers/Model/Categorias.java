package net.itinajero.jobOffers.Model;

import jakarta.persistence.*;

import java.util.List;
import net.itinajero.jobOffers.Model.Vacantes;

@Entity
@Table(name = "categorias")
public class Categorias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;

    private String descripcion;

//    @OneToMany(mappedBy="university",fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Student> students;
    @OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY)
    private List<Vacantes> vacantes;

    public List<Vacantes> getVacantes() {
        return vacantes;
    }

    public void setVacantes(List<Vacantes> vacantes) {
        this.vacantes = vacantes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
