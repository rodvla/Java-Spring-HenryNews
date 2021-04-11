package com.henry.news.base.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity

public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //@NotBlank(message = "Nombre is mandatory")
    private String nombre;
    //@NotBlank(message = "Apellido is mandatory")
    private String apellido;
    //@NotNull
    private String dni;

}
