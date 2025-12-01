package personnages;

public class Samourai extends Humain{
	private String seigneur;
	
	public Samourai(String nom, String boissonFavorite, int argent, String seigneur) {
		super(nom, boissonFavorite, argent);
		this.seigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + seigneur + ".\n");
	}

	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens, je vais prendre du " + boisson + ".\n");
	}
}
