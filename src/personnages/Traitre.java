package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private int niveauTraitrise = 0;
	private Random random = new Random();

	public Traitre(String nom, String boissonFavorite, int argent, String seigneur) {
		super(nom, boissonFavorite, argent, seigneur);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !\n");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentRanconner = commercant.getArgent() / 5;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne moi "
				+ argentRanconner + " sous ou gare à toi !\n");
			commercant.parler("Tout de suite grand " + getNom() + ".\n");
			niveauTraitrise++;
		} else {
			parler("Mince je ne peux plus ranconner personne ou un samouraï  risque de me démasquer !\n");
		}
	}
	
	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler("Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.\n");
		} else {
			Humain ami = memoire[random.nextInt(nbConnaissance)];
			int don = getArgent() / 20;
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + ami.getNom() + ".\n");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnat " + don + " sous.\n");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci " + getNom() + " vous êtes quelqu'un de bien.\n");
			if (niveauTraitrise > 0) {
				niveauTraitrise--;
			}
		}
	}
}
