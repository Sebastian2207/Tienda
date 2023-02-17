package com.tienda.controller;

import com.tienda.domain.Cliente;
import com.tienda.service.ClienteServices;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author sebas
 */

@Controller
public class ClienteController { //Esta clase controla todos los aspectos de clientes
    
    @Autowired
    private ClienteServices clienteService;
    
    //Mapeo de una ruta
    @GetMapping("/")
    public String inicio(Model model) {        
        var clientes = clienteService.getClientes();
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminaCliente(Cliente cliente){
        clienteService.deleteCliente(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "modificaCliente";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente){
        clienteService.saveCliente(cliente);
        return "redirect:/";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model){
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificaCliente";
    }
}
