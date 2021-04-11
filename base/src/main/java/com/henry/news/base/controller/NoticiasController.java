package com.henry.news.base.controller;

import com.henry.news.base.model.Noticias;
import com.henry.news.base.model.PaginationResponse;
import com.henry.news.base.service.NoticiasService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/noticias")
public class NoticiasController {

    @Autowired
    private NoticiasService noticiasService;

    @PostMapping
    public String addNoticia(@RequestBody Noticias noticia) {
        Noticias postnoticia = noticiasService.addNoticia(noticia);
        return ("Noticia Creada: " + postnoticia);
    }

    @PutMapping("/{id}/writer/{writerID}")
    private String addWriter(@PathVariable Integer id, @PathVariable Integer writerID) {
        noticiasService.addWriter(id, writerID);
        return ("Agregado writer con id: " + writerID);
    }

    @GetMapping
    public PaginationResponse<Noticias> getAll(@RequestParam(value = "size", defaultValue = "20") Integer size,
                                               @RequestParam(value = "page", defaultValue = "0") Integer page) {
        return noticiasService.getAll(page, size);
    }

    @DeleteMapping("/{id}")
    public String deleteNoticia(@PathVariable Integer id){
        noticiasService.deletewriteByid(id);
        return ("Noticia Borrada con id: " + id);
    }


}