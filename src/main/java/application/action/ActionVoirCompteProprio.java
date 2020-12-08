package application.action;

import banque.AgenceBancaire;
import banque.Compte;

import java.util.Scanner;


public class ActionVoirCompteProprio implements Action<AgenceBancaire>{
    private String message ;
    private String code ;

    /**
     * Constructeur
     * @param code
     */
    public ActionVoirCompteProprio(String code) {
        this.message = "Voir les comptes d'un Propriétaire";
        this.code = code ;
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
        // Saisie
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir un nom de proprio --> ");
        String proprioCompte = scanner.nextLine();

        Compte[] c = ag.getComptesDe(proprioCompte) ;
        if (c==null || c.length == 0) {
            System.out.println("\nCompte inexistant ...\n");
        } else {
            for (Compte cpt : c){
                cpt.afficher();
            }
        }

        System.out.println("\n");
    }
}
