package com.tienda.service.impl;

import com.tienda.dao.ArticuloDAO;
import com.tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.service.ArticuloServices;

/**
 *
 * @author sebas
 */
@Service
public class ArticuloServiceImpl implements ArticuloServices{

    //Esto crea una unica copia de un objeto
    @Autowired
    private ArticuloDAO articuloDao;
    
    @Override
    public List<Articulo> getArticulos(boolean activos) {
        var lista=(List<Articulo>) articuloDao.findAll();
        
        if(activos){
            lista.removeIf(e -> !e.isActivo());
        }
        
        return lista;
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    public void deleteArticulo(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    public void saveArticulo(Articulo articulo) {
        articuloDao.save(articulo);
    }
}