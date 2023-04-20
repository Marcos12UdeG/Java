package org.example.models;

public class Producto {

    private String nombre;
    private Long id;
    private Double price;
    private Long stock;
    private String brand;
    Boolean status;

    public Producto(String nombre, Long id, Double price, Long stock, String brand, Boolean status) {
        this.nombre = nombre;
        this.id = id;
        this.price = price;
        this.stock = stock;
        this.brand = brand;
        this.status = status;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
