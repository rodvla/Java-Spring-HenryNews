package com.henry.news.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "NoticiasTexto")

public class NoticiasTexto extends Noticias{

    private String texto;

    @Override
    public NoticiasEnum noticiasEnum() {
        return NoticiasEnum.TEXTO;
    }
}
