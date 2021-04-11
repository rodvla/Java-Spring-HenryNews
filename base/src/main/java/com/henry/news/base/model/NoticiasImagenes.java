package com.henry.news.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "NoticiasImagenes")

public class NoticiasImagenes extends Noticias{

    @ElementCollection
    private List<String> urlImagenes;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.IMAGENES;
    }
}

