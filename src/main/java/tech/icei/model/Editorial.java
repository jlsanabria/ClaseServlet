package tech.icei.model;

import jakarta.persistence.*;

@Entity
@Table(name = "icei_editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "editorial_id")
    private Integer editorialId;

    @Column(length = 80)
    private String nombre;

    public Editorial() {}

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEditorialId() {
        return editorialId;
    }

    public void setEditorialId(Integer editorialId) {
        this.editorialId = editorialId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Editorial{" +
                "editorialId=" + editorialId +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
