package edu.upc.dsa.models;
import java.util.ArrayList;
import java.util.HashMap;

public class Partida {
    double dsaCoins = 0;
    int vida = 100;
    String estado=null;
    String idJuego;
    String idUsuario;
    ArrayList<Juego> Partidas = new ArrayList<Juego>();
    HashMap<String, String> usuarioCoins = new HashMap<>();
    public Partida (String idJuego, String idUser){
        this.idJuego = idJuego;
        this.idUsuario = idUser;
    }
    public Partida(){};
    public String getIdJuego(){return this.idJuego;}

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public double getdsaCoins() {
        return dsaCoins;
    }
    //
    public void setNivel(double nivel){this.dsaCoins += 0;}

    public ArrayList<Juego> getPartidas() {
        return Partidas;
    }

    public HashMap<String, String> getUsuarioCoins() {
        return usuarioCoins;
    }
}
