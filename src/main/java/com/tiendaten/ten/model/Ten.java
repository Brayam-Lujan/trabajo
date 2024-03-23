package com.tiendaten.ten.model;

public class Ten {
    private Long id;
    private String marca;
    private Integer talla;
    private Long precio;
    
    public Ten() {
    }

    public Ten(Long id, String marca, Integer talla, Long precio) {
        this.id = id;
        this.marca = marca;
        this.talla = talla;
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getTalla() {
        return talla;
    }

    public void setTalla(Integer talla) {
        this.talla = talla;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    
}
