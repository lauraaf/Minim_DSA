package edu.upc.dsa;
import edu.upc.dsa.models.Partida;

public interface GameManager {
    String crearJuego(String id, int N_Equipos, int P_personas);
    //void addUsuario(String idUsuario, String nombre, String apellido);

    void addUsuario(String idUsuario, String nombre, String apellido, double DSA_coins);

    void addProducto(String idProducto, String descripcion, double precio);
    void comprarProducto(String idProducto, String idUsuario);
    String iniciarPartida(String idJuego, String idUsuario);
    String consultarEstado(String idUsuario);
    int consultarVida(String idUsuario);
    String finalizarJuego(String idJuego);
    int numUsuarios();
    int numProductos();

    int size();
}
