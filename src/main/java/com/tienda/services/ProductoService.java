
package com.tienda.services;

import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoService {
    //se obtiene un arraylist con los registros de la 
    //tabla producto
    //todos los registros o solo los archivos
    
    public List<Producto> getProducto(boolean activos);
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
    //Recupera los productos que esta en un rango de precios, que estan ordenados por una descripcion
    public List<Producto> consultaAmpliada(double precioInf, double precioSup);
  
    public List<Producto> consultaJPQL(double precioInf, double precioSup);
           
    public List<Producto> consultaSQL(double precioInf, double precioSup);
}

