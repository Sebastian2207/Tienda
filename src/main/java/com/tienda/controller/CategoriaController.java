package com.tienda.controller;

import com.tienda.domain.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.service.CategoriaServices;

/**
 *
 * @author sebas
 */

@Controller
@RequestMapping("/categoria")
public class CategoriaController { //Esta clase controla todos los aspectos de categoria
    
    @Autowired
    private CategoriaServices categoriaService;
    
    //Mapeo de una ruta
    @GetMapping("/listado")
    public String inicio(Model model) {
        var categoria = categoriaService.getCategorias(false);
        
        model.addAttribute("categoria", categoria);
        model.addAttribute("totalCategoria", categoria.size());
        
        return "/categoria/listado";
    }
    
    //Mapeo de una ruta 
    @GetMapping("/eliminar/{idCategoria}")
    public String eliminaCategoria(Categoria categoria){
        categoriaService.deleteCategoria(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.saveCategoria(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/modificar/{idCategoria}")
    public String modificaCategoria(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
        return "/categoria/modifica";
    }
}