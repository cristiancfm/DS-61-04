package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GunslingerTest {



    Gunslinger g1 = new Gunslinger();
   int loads=0;
   int rivalloads=0;
   Behavior behavior = new Offensive();



    @Test
    void getLoads() {

        assertEquals(0,g1.getLoads());

    }


    @Test
    void setLoads() {

        assertEquals(0,g1.getLoads());
    }

    @Test
    void setRivalloads() {

        assertEquals(0,g1.getRivalLoads());
    }

    @Test
    void action() {


        assertEquals(GunslingerAction.RELOAD,g1.action());




    }

    @Test
    void rivalAction() {


    }
    

    @Test
    void getRivalLoads() {

        assertEquals(0,g1.getRivalLoads());
    }

}