package edu.upc.dsa;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;

public class GameManagerTest {

    GameManager manager;
    //manager = new GameManagerImpl();
    @Test
    public void addUsuarioTest(){
        manager.addUsuario("1","Laura","Fernandez");
        manager.addUsuario("2","Lidia","Esquius");
        Assert.assertEquals(2,manager.numUsuarios());;
    }

    @Test
    public void addProductoTest(){
        manager.addProducto("1","Pócima",15);
        manager.addProducto("2","Espada",70);
        Assert.assertEquals(2,manager.numProductos());
    }
    @Test
    public void consultarEstadoTest(){
        manager.consultarEstado("1");
        Assert.assertEquals("INICIADO_EN_FUNCIONAMIENTO",manager.consultarEstado("1"));

    }
}
