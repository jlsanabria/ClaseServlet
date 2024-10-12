package tech.icei.model;

import jakarta.persistence.*;

@Entity
@Table(name = "icei_libro", schema = "core")
public class Libro {
    @Id
    @Column(name = "codigo_libro")
    private String codLibro;

    @Column(length = 100, nullable = false)
    private String titulo;

    @Column(name = "numero_paginas")
    private Integer numeroPaginas;

    @ManyToOne
    @JoinColumn(name = "id_autor", nullable = false, foreignKey = @ForeignKey(name = "fk_libro_autor"))
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "id_editorial", foreignKey = @ForeignKey(name = "fk_libro_editorial"))
    private Editorial editorial;

    public Libro() {
    }

    public Libro(String codLibro, String titulo, Integer numeroPaginas, Autor autor, Editorial editorial) {
        this.codLibro = codLibro;
        this.titulo = titulo;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
        this.editorial = editorial;
    }

    public String getCodLibro() {
        return codLibro;
    }

    public void setCodLibro(String codLibro) {
        this.codLibro = codLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "codLibro='" + codLibro + '\'' +
                ", titulo='" + titulo + '\'' +
                ", numeroPaginas=" + numeroPaginas +
                ", autor=" + autor +
                ", editorial=" + editorial +
                '}';
    }
}
