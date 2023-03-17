package com.tienda.dao;

import com.tienda.domain.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface ArticuloDAO extends JpaRepository<Articulo, Long>{
    
}