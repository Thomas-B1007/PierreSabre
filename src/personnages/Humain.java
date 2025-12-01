package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	private int tailleMemoire = 30;
	protected Humain[] memoire = new Humain[tailleMemoire];
	protected int nbConnaissance = 0;
	
	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}
	
	public int getArgent() {
		return argent;
	}
	
	protected void parler(String texte) {
		System.out.print("(" + nom + ") - " + texte);
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m'appelle " + nom + " et j'aime boire du " + boissonFavorite + ".\n");
	}
	
	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !\n");
	}
	
	protected void gagnerArgent(int montant) {
		argent += montant;
	}
	
	protected void perdreArgent(int montant) {
		if (argent > montant) {
			argent -= montant;
		} else {
			argent = 0;
		}
	}
	
	public void acheter(String bien, int prix) {
		if (argent >= prix) {
			 parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.\n");
			 perdreArgent(prix);
		} else {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.\n");
		}
	}
	
	private void memoriser(Humain humain) {
		boolean dejaConnu = false;
		for (int i = 0; i < nbConnaissance - 1; i++) {
			if ((dejaConnu) || (tailleMemoire == nbConnaissance)) {
				memoire[i] = memoire[i + 1];
			} else {
				dejaConnu = ((humain != null) && (humain.equals(memoire[i])));
			}
		}
		if ((dejaConnu) || (tailleMemoire == nbConnaissance)) {
			memoire[nbConnaissance - 1] = humain;
		} else {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
		}
	}
	
	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		parler("Je connais beaucoup de monde dont :");
		for (int i = 0; i < nbConnaissance - 1; i++) {
			System.out.print(" " + memoire[i].getNom() + ",");
		}
		System.out.println(" " + memoire[nbConnaissance - 1].getNom() + ".");
	}
}
