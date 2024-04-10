package edu.upc.dsa.models;

public class Producto {
    String id;
    String description;
    double precio;
    public Producto(String id, String description, double precio){
        this.id = id;
        this.description = description;
        this.precio = precio;
    }
    public Producto(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
