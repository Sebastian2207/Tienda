package com.tienda.service;

import com.tienda.domain.Articulo;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface ArticuloServices {
    /*Obtiene una lista de registros de la tabla articulo 
    y lo coloca en una lista de objetos articulo*/
    public List<Articulo> getArticulos(boolean activos);
    
    /*Obtiene el registro de la tabla articulo
    que tiene el id articulo pasado por el objeto articulo*/
    public Articulo getArticulo(Articulo articulo);
    
    /*Elimina el registro de la tabla articulo
    que tiene el id articulo pasado por el objeto articulo*/
    public void deleteArticulo(Articulo articulo);
    
    /*Si el idArticulo pasado no existe o es nulo se crea un registro nuevo
    en la tabla articulo, si el idArticulo existe se actualiza la información*/
    public void saveArticulo(Articulo articulo);
}