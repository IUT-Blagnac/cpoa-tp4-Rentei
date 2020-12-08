package application.actionList;

import application.action.Action;
import application.action.ActionList;
import banque.AgenceBancaire;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ActionListAgenceBancaire implements ActionList<AgenceBancaire> {
    private String message ;
    private String code ;
    private String title ;
    private ArrayList<Action> alAction ;

    public ActionListAgenceBancaire(String message, String code, String title) {
        this.message = message;
        this.code = code;
        this.title = title;
        this.alAction = new ArrayList<>();
    }

    @Override
    public String actionMessage() {
        return message;
    }

    @Override
    public String actionCode() {
        return code;
    }

    @Override
    public void execute(AgenceBancaire ag) throws Exception {
        boolean continuer = true;
        // Boucle infinie
        while (continuer) {
            System.out.println("Menu (" + this.title +"\n");

            for (Action act : alAction){
                System.out.println(act.actionCode() + " - " + act.actionMessage());
            }
            System.out.println("q - Quitter");

            System.out.print("Choix -> ");

            // Saisie
            Scanner scanner = new Scanner ( System.in );
            scanner.useLocale(Locale.US);
            String choix = scanner.next();
            choix = choix.toLowerCase();

            // On cherche parmis toute les action si le choix correspond a l'une.
            boolean isFound = false ;
            for (Action action : alAction){
                if(action.actionCode().equals(choix)){
                    action.execute(ag);
                    isFound = true ;
                    break;
                }
            }

            if (choix.equals("q")){
                System.out.println("Fermeture ...");
                System.exit(0);
            }

            // Si on n'a toujours pas trouvé d'action, alors on l'indique
            if (!isFound){
                System.out.println("Aucun choix valide...");
            }
        }
    }

    @Override
    public String listTitle() {
        return title;
    }

    @Override
    public int size() {
        return alAction.size() ;
    }

    @Override
    public boolean addAction(Action ac) {
        // Si l'action existe deja on fait rien
        if (alAction.contains(ac)){
            return false;
        }else { // Sinon on l'insere
            alAction.add(ac);
            return true;
        }
    }
}
