import application.action.*;
import application.actionList.ActionListAgenceBancaire;
import banque.AgenceBancaire;
import banque.Compte;
import banque.exception.ABCompteDejaExistantException;
import banque.exception.ABCompteNullException;

public class Main {
    public static void main(String[] args) {
        // Agence bancaire
        AgenceBancaire agenceBancaire = new AgenceBancaire("Banque Populaire","Blagnac");
        // Ajout des comptes
        try {
            agenceBancaire.addCompte(new Compte("00101", "AMIDALA"));
            agenceBancaire.addCompte(new Compte("00102","TANO"));
            agenceBancaire.addCompte(new Compte("00103","KENOBI"));
            agenceBancaire.addCompte(new Compte("00104","SKYWAlKER"));
        } catch (ABCompteNullException | ABCompteDejaExistantException e) {
            e.printStackTrace();
        }

        ActionListAgenceBancaire actionListAgenceBancaire = new ActionListAgenceBancaire("Liste des actions","-1", agenceBancaire.toString());
        // Ajout de toutes les actions
        actionListAgenceBancaire.addAction(new ActionVoirCompteNumero("v"));
        actionListAgenceBancaire.addAction(new ActionListeDesComptes("l"));
        actionListAgenceBancaire.addAction(new ActionVoirCompteProprio("p"));
        actionListAgenceBancaire.addAction(new ActionDepotCompte("d"));
        actionListAgenceBancaire.addAction(new ActionRetraitCompte("r"));

        try {
            actionListAgenceBancaire.execute(agenceBancaire);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
