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
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand !");
		if (2 * honneur < adversaire.getReputation()) {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
			adversaire.gagner(this.getArgent());
			perdreArgent(this.getArgent());
			if (honneur > 0) {
				honneur--;
			}
		} else {
			parler("Je t'ai eu petit yakuza !");
			gagnerArgent(adversaire.getArgent());
			honneur++;
			adversaire.perdre();
		}
	}
}
