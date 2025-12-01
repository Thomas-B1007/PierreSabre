package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "thé", argent);
	}
	
	public int seFaireExtorquer() {
		int montant = getArgent();
		perdreArgent(montant);
		parler("J’ai tout perdu! Le monde est trop injuste...\n");
		return montant;
	}

	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent + " sous ! Je te remercie généreux donateur !\n");
	}
}
