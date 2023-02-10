package com.tienda.controller;

import com.tienda.domain.Cliente;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author sebas
 */

@Controller
public class ClienteController { //Esta clase controla todos los aspectos de clientes
    
    //Mapeo de una ruta
    @GetMapping("/")
    
    public String inicio(Model model) {
        var saludo = "Saludos desde el Back End";
        model.addAttribute("mensaje", saludo);
        
        Cliente cliente1 = new Cliente("Sebastian", "Cerdas", "sebas@gmail.com", "72097414");
        Cliente cliente2 = new Cliente("Derek", "Cerdas", "derek@gmail.com", "72097414");
        Cliente cliente3 = new Cliente("Alejandro", "Cerdas", "alejandro@gmail.com", "72097414");
        
        var clientes = Arrays.asList(cliente1, cliente2, cliente3);
        
        model.addAttribute("clientes", clientes);
        
        return "index";
    }
    
}
