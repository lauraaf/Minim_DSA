package edu.upc.dsa.models;

public class Juego {
    String id;
    int N_Equipos;
    int P_personas;
    String estado = "NO_INICIADO";
    public Juego(String id, int N_Equipos, int P_personas){
        this.id = id;
        this.N_Equipos = N_Equipos;
        this.P_personas = P_personas;
    }
    public Juego(){};
    public String getId(){
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getN_Equipos() {
        return this.N_Equipos;
    }

    public void setN_Equipos(int n_Equipos) {
        N_Equipos = n_Equipos;
    }

    public int getP_personas() {
        return P_personas;
    }

    public void setP_personas(int p_personas) {
        P_personas = p_personas;
    }

    @Override
    public String toString() {
        return "Juego: "+id+" [Número de equipos="+N_Equipos+", número de personas="+P_personas+"]";
    }
}
