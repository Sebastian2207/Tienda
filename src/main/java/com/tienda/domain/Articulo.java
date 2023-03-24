package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author sebas
 */
@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_articulo")
    private Long idArticulo;
    
    private String descripcion;
    private String detalle; 
    private int precio;
    private int existencias;
    private String imagen;
    private boolean activo;
    
    //Relacion credito
    @JoinColumn(name="id_categoria", referencedColumnName="id_categoria")
    @ManyToOne
    private Categoria categoria;

    public Articulo() {
    }

    public Articulo(String descripcion, String detalle, int precio, int existencias, String imagen, boolean activo, Categoria categoria) {
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.imagen = imagen;
        this.activo = activo;
        this.categoria = categoria;
    }
}