package application.action;

import banque.AgenceBancaire;
import banque.Compte;

import java.util.Scanner;

public class ActionDepotCompte implements Action<AgenceBancaire>{
    private String message ;
    private String code ;

    /**
     * Constructeur
     * @param code
     */
    public ActionDepotCompte(String code) {
        this.message = "Déposer de l'argent sur un compte";
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
        // Saisie
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le numéro du compte --> ");
        String numCompte = scanner.nextLine();

        Compte c = ag.getCompte(numCompte) ;
        if (c==null) {
            System.out.println("\nCompte inexistant ...\n");
            return;
        } else {
            c.afficher();
        }

        System.out.println("\nVeuillez saisir le montant du depot --> ");
        int montant = (int) scanner.nextDouble();

        ag.getCompte(numCompte).deposer(montant);
    }
}
