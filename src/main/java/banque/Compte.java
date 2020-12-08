package banque;


import banque.exception.CompteException;

/************************************************************
 * Classe Compte permettant de gérer des comptes simples.<BR>
 * Un Compte a un numéro, appartient à un propriétaire et on peut y faire des
 * versements (crédits) et des retraits (débits).<BR>
 * Seuls des contrôles de montants des opérations >=0 sont réalisés.<BR>
 * 
 * @author André Péninou.
 * @version 3.01
 *****************************/


public class Compte extends Object
{

	private String proprietaire;

	private String numCompte;

	private double debits, credits;

	private int nbDebits, nbCredits;

	public Compte() {
		this("Pas de numéro", "Pas de propriétaire");
	}


	public Compte(String pNumCompte, String pNomProp) {
		this.numCompte = pNumCompte;
		this.proprietaire = pNomProp;
		this.debits = 0;
		this.credits = 0;
		this.nbCredits = 0;
		this.nbDebits = 0;
	}

	public double soldeCompte() {
		return this.credits - this.debits;
	}

	public String getProprietaire() {
		return this.proprietaire;
	}

	public String getNumCompte() {
		return this.numCompte;
	}

	public void afficher() {
		System.out.println(this.toString());
	}

	public String toString() {
		return "  Num. : " + this.numCompte + " - Prop. : " + this.proprietaire
				+ " - Debit " + this.debits + " E / Credit " + this.credits
				+ " E / NbOps " + (this.nbCredits + this.nbDebits);
	}

	public void retirer(double pSomme) throws CompteException {
		if (pSomme < 0) {
			throw new CompteException(
					"Erreur de somme négative lors d'un retrait sur " + this.numCompte);
		}
		this.debits = this.debits + pSomme;
		this.nbDebits++;
	}


	public void deposer(double pSomme) throws CompteException {
		if (pSomme < 0) {
			throw new CompteException(
					"Erreur de somme négative lors d'un dépot sur " + this.numCompte);
		}
		this.credits = this.credits + pSomme;
		this.nbCredits++;
	}


	public void setProprietaire(String pNomProp) {
		this.proprietaire = pNomProp;
	}

}
