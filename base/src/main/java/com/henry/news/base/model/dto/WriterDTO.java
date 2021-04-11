package com.henry.news.base.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class WriterDTO {

    private Integer id;
    private String nombre;
    private String apellido;

}