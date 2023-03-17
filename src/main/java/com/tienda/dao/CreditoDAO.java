package com.tienda.dao;

import com.tienda.domain.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author sebas
 */
public interface CreditoDAO extends JpaRepository<Credito, Long>{
    
}