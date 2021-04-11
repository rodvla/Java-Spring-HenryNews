package com.henry.news.base.model;

public enum NoticiasEnum {

    VIDEO("Video Noticia"),
    IMAGENES("Imagenes Noticia"),
    TEXTO("Texto Noticia");

    private String descripcion;

    NoticiasEnum(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static NoticiasEnum find(String value){
        for( NoticiasEnum v: values()){
            if(v.toString().equalsIgnoreCase(value)){
                return v;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid NoticiasType: %s", value));
    }
}
