package edu.upc.dsa;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.Test;

public class GameManagerTest {

    GameManager gm;
    //gm = new GameManagerImpl();
    @Test
    public void addUsuarioTest(){
        gm.addUsuario("1","Laura","Fernandez",0);
        gm.addUsuario("2","Lidia","Esquius", 0);
        Assert.assertEquals(2,gm.numUsuarios());;
    }

    @Test
    public void addProductoTest(){
        gm.addProducto("1","Pócima",15);
        gm.addProducto("2","Espada",70);
        Assert.assertEquals(2,gm.numProductos());
    }
    @Test
    public void consultarEstadoTest(){
        gm.consultarEstado("1");
        Assert.assertEquals("INICIADO_EN_FUNCIONAMIENTO",gm.consultarEstado("1"));

    }
}
