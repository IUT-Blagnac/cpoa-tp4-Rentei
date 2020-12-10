package banque;

import banque.exception.CompteException;

import static org.junit.Assert.*;
import org.junit.Test;

public class CompteTest {

    @Test
    public void testDepot() throws CompteException {
        Compte c = new Compte("00606", "TEST");
        assertEquals(0,c.soldeCompte(),0);
        c.deposer(100);
        assertEquals(100,c.soldeCompte(),0);
    }

    @Test
    public void testRetirer() throws CompteException{
        Compte c = new Compte("00606", "TEST");
        assertEquals(0.0,c.soldeCompte(),0);
        c.retirer(100);
        assertEquals(-100,c.soldeCompte(),0);
    }

//    @Test
//    public void testSetProprio(){
//        Compte c = new Compte("00606", "TEST");
//        assertEquals("TEST",c.getProprietaire());
//        c.setProprietaire("TEST2");
//        assertEquals("TEST2",c.getProprietaire(),0);
//    }
}