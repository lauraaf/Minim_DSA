package edu.upc.dsa.models;

public class Usuario {
    String id;
    String nombre;
    String apellido;
    double DSA_coins;
    public Usuario(String id, String nombre, String apellido, double DSA_coins){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.DSA_coins = DSA_coins;
    }
    public Usuario(){};

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getDSA_coins() {
        return DSA_coins;
    }

    public void setDSA_coins(double DSA_coins) {
        this.DSA_coins = DSA_coins;
    }
}
