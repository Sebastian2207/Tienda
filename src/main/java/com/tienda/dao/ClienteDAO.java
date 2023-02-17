package com.tienda.dao;

import com.tienda.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface ClienteDAO extends JpaRepository<Cliente, Long>{
    
}