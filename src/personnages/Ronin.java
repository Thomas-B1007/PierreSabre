package personnages;

public class Ronin extends Humain {
	private int honneur = 1;

	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	}
	
	public void donner(Commercant beneficiaire) {
		int montant = this.getArgent() / 10;
		perdreArgent(montant);
		parler(beneficiaire.getNom() + ", prend ces " + montant + " sous.");
		beneficiaire.recevoir(montant);
	}
}
