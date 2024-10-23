package com.tienda.services;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //se obtiene un arraylist con los registros de la 
    //tabla categoria
    //todos los registros o solo los archivos
    
    public List<Categoria> getCategoria(boolean activos);
}
