package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom, String boissonFavorite, String clan, int argent) {
		super(nom, boissonFavorite, argent);
		this.clan = clan;
	}
	
	public void extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom() + ", si tu tiens à la vie donne moi ta bourse !");
		int montant = victime.seFaireExtorquer();
		gagnerArgent(montant);
		parler("J’ai piqué les " + montant + " sous de " + victime.getNom() + 
				", ce qui me fait " + this.getArgent() + " sous dans ma poche. Hi ! Hi !");
		reputation ++;
	}

	public int getReputation() {
		return reputation;
	}
	
	public void gagner(int gain) {
		gagnerArgent(gain);
		parler("Ce ronin pensait vraiment battre " + this.getNom() + "du clan de " + clan +" ? Je l'ai dépouillé de ses " + gain + " sous.");
	}
	
	public void perdre() {
		parler("J’ai perdu mon duel et mes " + this.getArgent() + " sous, snif... J'ai déshonoré le clan de " + clan + ".");
		perdreArgent(this.getArgent());
		if (reputation > 0) {
			reputation--;
		}
	}
}
