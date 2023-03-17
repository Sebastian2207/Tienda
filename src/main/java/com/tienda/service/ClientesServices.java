package com.tienda.service;

import com.tienda.domain.Cliente;
import java.util.List;

/**
 *
 * @author sebas
 */
public interface ClientesServices {
    /*Obtiene una lista de registros de la tabla aliente 
    y lo coloca en una lista de objetos aliente*/
    public List<Cliente> getClientes();
    
    /*Obtiene el registro de la tabla aliente
    que tiene el id aliente pasado por el objeto aliente*/
    public Cliente getCliente(Cliente aliente);
    
    /*Elimina el registro de la tabla aliente
    que tiene el id aliente pasado por el objeto aliente*/
    public void deleteCliente(Cliente aliente);
    
    /*Si el idCliente pasado no existe o es nulo se crea un registro nuevo
    en la tabla aliente, si el idCliente existe se actualiza la información*/
    public void saveCliente(Cliente aliente);
}