
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")

public class Producto implements Serializable{
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;
   // private Long idCategoria;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn (name = "id_Categoria")
    private Categoria categoria;
}

/*
create table categoria (
  id_categoria INT NOT NULL AUTO_INCREMENT,
  descripcion VARCHAR(30) NOT NULL,
  ruta_imagen varchar(1024),
  activo bool,
  PRIMARY KEY (id_categoria))
*/