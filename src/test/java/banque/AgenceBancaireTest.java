package banque;

import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteInexistantException;
import banque.exception.ABCompteNullException;

import static org.junit.Assert.*;
import org.junit.Test;

public class AgenceBancaireTest {

    @Test
    public void testAddCompte() throws ABCompteNullException, ABCompteDejaExistantException {
        AgenceBancaire ag = new AgenceBancaire("TEST","Blagnac");
        assertEquals(0,ag.getNbComptes(),0);
        Compte c = new Compte("00606", "TEST");
        ag.addCompte(c);
        assertEquals(1,ag.getNbComptes(),0);
    }

    @Test
    public void testRemoveCompte() throws ABCompteInexistantException, ABCompteNullException, ABCompteDejaExistantException {
        AgenceBancaire ag = new AgenceBancaire("TEST","Blagnac");
        Compte c = new Compte("00606", "TEST");
        ag.addCompte(c);
        assertEquals(1,ag.getNbComptes(),0);
        ag.removeCompte("00606");
        assertEquals(0,ag.getNbComptes(),0);
    }
}