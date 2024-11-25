/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;


import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import com.tienda.services.CategoriaService;
import com.tienda.services.ProductoService;
import com.tienda.services.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author usuario
 */
@Controller
@RequestMapping ("/pruebas")
public class PruebasController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);
        
        var categorias = categoriaService.getCategoria(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }
    

    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria, Model model) {
        
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("productos", categoria.getProductos());
        
        var categorias = categoriaService.getCategoria(false);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado2")
    public String listado2(Model model) {
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/consultaAmpliada")
    public String consultasAmpliadas(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaAmpliada(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/consultaJPQL")
    public String consultasJPQL(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaJPQL(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/consultaSQL")
    public String consultasSQL(
            @RequestParam(value="precioInf") double precioInf,
            @RequestParam(value="precioSup") double precioSup,
            Model model) {
        var productos = productoService.consultaSQL(precioInf, precioSup);
        model.addAttribute("productos",productos);
        model.addAttribute("precioInf",precioInf);
        model.addAttribute("precioSup",precioSup);
        return "/pruebas/listado2";
    }
    
    //practica
    @PostMapping("/consultaJPQLExistencias")
    public String consultasJPQLExistencias(
            @RequestParam(value = "existencias") int limite,
            Model model) {
        var productos = productoService.consultaJPQLExistencias(limite);
        model.addAttribute("productos", productos);
        model.addAttribute("existencias", limite);
        return "/pruebas/listado2";
    }
}
