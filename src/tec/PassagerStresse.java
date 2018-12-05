package tec;

public final class PassagerStresse extends PassagerAbstrait{

	public PassagerStresse(String nom,int arret) {
		super(nom, arret);
	}

	@Override
	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
		b.demanderPlaceAssise(this);
	}

	@Override
	public void choixChangerPlace(Bus b, int arret) throws UsagerInvalideException {
		if(!estAssis()) {
			if(this.arret>=arret-3) {
				b.demanderChangerEnAssis(this);
			}
		}
		if(this.arret == arret) {
			b.demanderSortie(this);
		}
	}
}
