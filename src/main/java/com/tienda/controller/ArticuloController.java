package com.tienda.controller;

import com.tienda.domain.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.service.ArticuloServices;

/**
 *
 * @author sebas
 */

@Controller
@RequestMapping("/articulo")
public class ArticuloController { //Esta clase controla todos los aspectos de articulo
    
    @Autowired
    private ArticuloServices articuloService;
    //Mapeo de una ruta
    @GetMapping("/listado")
    public String inicio(Model model) {
        var articulo = articuloService.getArticulos(false);
        
        model.addAttribute("articulo", articulo);
        model.addAttribute("totalArticulo", articulo.size());
        
        return "/articulo/listado";
    }
    
    //Mapeo de una ruta 
    @GetMapping("/eliminar/{idArticulo}")
    public String eliminaArticulo(Articulo articulo){
        articuloService.deleteArticulo(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/nuevo")
    public String nuevoArticulo(Articulo articulo) {
        return "/articulo/modifica";
    }
    
    @PostMapping("/guardar")
    public String guardarArticulo(Articulo articulo){
        articuloService.saveArticulo(articulo);
        return "redirect:/articulo/listado";
    }
    
    @GetMapping("/modificar/{idArticulo}")
    public String modificaArticulo(Articulo articulo, Model model){
        articulo = articuloService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
    }
}