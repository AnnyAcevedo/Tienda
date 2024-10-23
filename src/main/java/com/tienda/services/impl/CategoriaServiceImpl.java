package com.tienda.services.impl;

import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import com.tienda.services.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl 
        implements CategoriaService {
    
@Autowired
private CategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly=true)
    
    public List<Categoria> getCategoria(boolean activos) {
      var lista = categoriaDao.findAll();
      if (activos) {
          //se deben eliminar de la lista..
          lista.removeIf(c -> !c.isActivo());
      }
      return lista;
    }
    
}
