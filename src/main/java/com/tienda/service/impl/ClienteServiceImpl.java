package com.tienda.service.impl;

import com.tienda.dao.ClienteDAO;
import com.tienda.dao.CreditoDAO;
import com.tienda.domain.Cliente;
import com.tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tienda.service.ClientesServices;

/**
 *
 * @author sebas
 */
@Service
public class ClienteServiceImpl implements ClientesServices{

    //Esto crea una unica copia de un objeto
    @Autowired
    private ClienteDAO clienteDao;
    @Autowired
    private CreditoDAO creditoDao;
    
    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        clienteDao.save(cliente);
        cliente.setCredito(credito);
    } 
}