package com.henry.news.base.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity

@JsonTypeInfo(use= JsonTypeInfo.Id.NAME, visible = true, property = "noticiasEnum")
@JsonSubTypes({
        @JsonSubTypes.Type(value = NoticiasVideo.class, name = "VIDEO"),
        @JsonSubTypes.Type(value = NoticiasImagenes.class, name = "IMAGENES"),
        @JsonSubTypes.Type(value = NoticiasTexto.class, name = "TEXTO"),

})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // TABLE PER CLASS una tabla para cada entidad

public abstract class Noticias implements Serializable {

    @Id
    private Integer id;
    private String titulo;
    private String descripcion;

    @AccessType(AccessType.Type.PROPERTY)
    public abstract NoticiasEnum noticiasEnum();

    @ManyToOne(fetch = FetchType.EAGER) //trae toda la lista de vehiculos, contrario LAZY
    @JoinColumn(name = "writer_id")
    private Writer owner;

}
