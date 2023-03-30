package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
	public void acheterProduit(String nomAcheteur) {
		System.out.println("Quel produit voulez-vous acheter ?");
		String produit = scan.next();
		String marchandProduit = controlAcheterProduit.AfficherEtalProduit(produit);
		if (marchandProduit.length() == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.");
		} else {
			int numeroMarchand = Clavier .entrerEntier("Chez quel commercant voulez-vous acheter des " + produit + " ?\n" + marchandProduit);
			String nomVendeur = controlAcheterProduit.nomVendeur(produit, numeroMarchand);
			System.out.println(nomAcheteur + " se deplace jusqu a l'étal du vendeur " + nomVendeur);
			int nbProduit = Clavier.entrerEntier("Bonjour " + nomAcheteur + "\nCombien de " + produit + " voulez-vous acheter ?\n");
			String resultat = controlAcheterProduit.AcheterProduit(produit, numeroMarchand,nbProduit,nomAcheteur);
			System.out.println(resultat);
		}

	}
}
