package com.henry.news.base.controller;

import com.henry.news.base.converter.WriterToWriterDTOConverter;
import com.henry.news.base.model.Writer;
import com.henry.news.base.model.dto.WriterDTO;
import com.henry.news.base.service.WriterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/writer")
public class WriterController {

    @Autowired
    private WriterService writerService;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private WriterToWriterDTOConverter writerToWriterDTOConverter;

    @GetMapping
    @Operation(summary = "Lista de writers")
    public List<Writer> getWriters(){
        return writerService.getWriters();
    }

    @GetMapping("/writerDTO")
    @Operation(summary = "Lista de writers DTO (sin dni)")
    public List<WriterDTO> getAllPersonDTO(){
        return conversionService.convert(writerService.getWriters(), List.class);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consulta writer por id")
    public Writer getWriter(@PathVariable Integer id) {
        return writerService.getWriter(id);
    }

    @GetMapping("/writerDTO/{id}")
    @Operation(summary = "Consulta writer DTO por id")
    public WriterDTO getWriterDTOByID(@PathVariable Integer id){
        return conversionService.convert(writerService.getWriter(id), WriterDTO.class);
    }

    @PostMapping
    @Operation(summary = "Dar de alta un writer")
    public String addWriter(@RequestBody Writer writer) {
        Writer postwriter = writerService.addWriter(writer);
        return ("Persona creada: " + postwriter);
    }

    @PutMapping
    @Operation(summary = "Editar writer")
    public String editWriter(@RequestBody Writer writer){
        Writer putwriter = writerService.editPerson(writer);
        return ("Persona Editada " + putwriter);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Borrar writer por id")
    public String deleteWrite(@PathVariable Integer id){
        writerService.deletewriteByid(id);
        return ("Persona Borrada con id: " + id);
    }

}
