
package com.tienda.dao;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

@EnableJpaRepositories
public interface ProductoDao extends 
        JpaRepository<Producto,Long>{
    
    //Recupera los productos que esta en un rango de precios, que estan ordenados por un precio
    public List<Producto> findByPrecioBetweenOrderByDescripcion(
            double precioInf, double precioSup);
    
    //jpql
   @Query(value = "SELECT a FROM Producto a "
           + "WHERE a.precio "
           + "BETWEEN :precioInf AND :precioSup "
           + "ORDER BY a.descripcion ASC")
   public List<Producto> consultaJPQL (@Param("precioInf") double precioInf,
                    @Param("precioSup") double precioSup);
           
    //sql
    @Query(nativeQuery=true, value="SELECT * FROM producto a "
           + "WHERE a.precio "
           + "BETWEEN :precioInf AND :precioSup "
           + "ORDER BY a.descripcion ASC")
    public List<Producto> consultaSQL (@Param("precioInf") double precioInf,
            @Param("precioSup") double precioSup);
    
    //practica
    @Query("SELECT p FROM Producto p WHERE p.existencias <= ?1")
    List<Producto> consultaJPQLExistencias(int cantidad);
}
