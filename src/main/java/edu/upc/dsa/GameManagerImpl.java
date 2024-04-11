package edu.upc.dsa;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import edu.upc.dsa.models.*;

public class GameManagerImpl implements GameManager {
    private static GameManager instance;
    protected HashMap<String,Usuario> usuario;
    //HashMap<String, String> userPurse = new HashMap<>();
    HashMap<String, String> Juegos = new HashMap<String, String>();
    LinkedList<String> listaJuegos = new LinkedList<String>();
    LinkedList<Usuario> listaUsuarios = new LinkedList<Usuario>();
    LinkedList<Producto> listaProductos = new LinkedList<Producto>();
    final static Logger logger = Logger.getLogger(GameManagerImpl.class);

    //Perque es private?
    private GameManagerImpl(){
        this.usuario = new HashMap<>();
    }
    public static GameManager getInstance() {
        if (instance==null) instance = new GameManagerImpl();
        return instance;
    }
    public int size() {
        int ret = this.usuario.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public String crearJuego(String id, int N_Equipos, int P_personas) {
        String estado = new Partida().getEstado();
        //Mirem si ja hi ha una partida iniciada amb aquest id
        if (listaJuegos.contains(id)){
            logger.error("Ya hay un juwgo creado con este id: "+id);
            estado = "NO_INICIADO";
        }
        else {
            Juego juegoNuevo = new Juego(id,N_Equipos,P_personas);
            listaJuegos.add(id);
            logger.info("Juego creado con: "+ N_Equipos+ "equipos de: "+ P_personas+" personas.");
            estado = "INICIADO_EN_PREPARACIÓN";
        }
        return estado;
    }
    @Override
    public void addUsuario(String idUsuario, String nombre, String apellido, double DSA_coins) {
        Usuario user;
        //Regalo de 25 dsa coins
        int dsaCoins = 25;
        //Creamos el "monedero del ususario"
        String userCoins = idUsuario+"/"+ dsaCoins;
        logger.info("Comprovamos la existencia del usuario con id: "+idUsuario);
        if(listaUsuarios.contains(idUsuario)) {
            logger.error("Este usuario ya existe");
        }
        else{
            logger.info("Añadimos usuario con id: "+idUsuario+", ya que no existe");
            user = new Usuario(idUsuario, nombre, apellido, DSA_coins);
            //userPurse.put(idUsuario,userCoins);
            //Afegim el usuari a la llista, com a ultim element
            listaUsuarios.addLast(user);
        }
    }


    @Override
    public void addProducto(String idProducto, String descripcion, double precio) {
        Producto producto;
        logger.info("Comprovamos existencia del producto con id: " + idProducto);
        if (listaUsuarios.contains(idProducto)) {
            logger.error("Este Producto ya existe");
        } else {
            logger.info("Añadimos producto con id: " + idProducto + ", ya que no existe");
            producto = new Producto(idProducto, descripcion, precio);
            //Afegim el producte a la llista, com a ultim element
            listaProductos.addLast(producto);
        }
    }

    @Override
    public void comprarProducto(String idProducto, String idUsuario) {
        logger.info("Comprobamos si el producto con id: "+idProducto+", y el usuario con id: "+idUsuario+", existen");
        if(listaUsuarios.contains(idUsuario) && listaProductos.contains(idProducto)){

            logger.info("Producto comprado");
        }
        else{
            logger.error("El usuario o el producto no existen");
        }
    }

    @Override
    public String iniciarPartida(String idJuego, String idUsuario) {
        String estado = new Partida().getEstado();
        boolean inicio = false;
        if(listaJuegos.contains(idJuego) && listaUsuarios.contains(idUsuario)) {
            logger.info("ya existe un juego con id: " + idJuego + ", creado por el usuario con id: " + idUsuario);
            //Comporvar que el usuari no estigui en un altre partida
            if (Juegos.containsValue(idJuego) && idJuego.equals(Juegos.get(idUsuario))) {
                logger.error("El usuario ya se encuantra en otra partida");
            }
            else{
                estado = "INICIADO_EN_FUNCIONAMIENTO";
                inicio = true;
            }
        }
        else {
            logger.error("No existe el juego o el usuario");
        }
        if (inicio){
            logger.info("Iniciamos la partida");
            Juegos.put(idJuego, idUsuario);
        }
        return estado;
    }

    @Override
    public String consultarEstado(String idJuego) {
        String res = null;
        String estado = new Partida().getEstado();
        if (listaJuegos.contains(idJuego)){
            logger.info("Existe un juego con id: "+idJuego);
            res = estado;
        }
        else {
            logger.error("La partida no existe");
        }
        return res;
    }

    @Override
    public int consultarVida(String idUsuario) {
        int res = 0;
        if(listaUsuarios.contains(idUsuario) && Juegos.containsKey(idUsuario)){
            logger.info("El usuario con id: "+idUsuario+", esta un una partida");
            int vida = new Partida().getVida();
            res = vida;
        }
        else{
            logger.info("El usuario no existe o no se encuantra en ninguna partida");
            res = -1;
        }
        return res;
    }

    @Override
    public String finalizarJuego(String idJuego) {
        String estado = new Partida().getEstado();
        //comprobamos que el juego existe i que esta en curso
        if(listaJuegos.contains(idJuego) && Juegos.containsKey(idJuego)){
            logger.info("Hay una partida en marxa con id: "+idJuego);
            for(Map.Entry<String, String> entry : Juegos.entrySet()){
                if(entry.getKey().equals(idJuego)){
                    Juegos.remove(idJuego);
                    logger.info("Se ha finalizado la partida");
                    estado = "FINALIZADO";
                    break;
                }
            }

        }
        else{
            logger.error("No existe ninguna partida activa con este id: "+idJuego);
        }
        return estado;
    }

    @Override
    public int numProductos() {
        return this.listaProductos.size();
    }

    @Override
    public int numUsuarios() {
        return this.listaUsuarios.size();
    }
}

