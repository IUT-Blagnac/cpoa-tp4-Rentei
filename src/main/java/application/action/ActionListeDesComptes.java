package application.action;

import banque.AgenceBancaire;
import banque.Compte;

public class ActionListeDesComptes implements Action<AgenceBancaire>{
    private String message ;
    private String code ;

    /**
     * Constructeur
     * @param code
     */
    public ActionListeDesComptes(String code) {
        this.message = "Liste des comptes de l'agence" ;
        this.code = code;
    }

    @Override
    public String actionMessage() {
        return this.message;
    }

    @Override
    public String actionCode() {
        return this.code;
    }

    @Override
    public void execute(AgenceBancaire ag) throws Exception {
        ag.afficher(); // Affiche tous les comptes d'une agence bancaire
    }
}
