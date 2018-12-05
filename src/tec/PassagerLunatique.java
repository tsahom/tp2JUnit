package tec;

public final class PassagerLunatique extends PassagerAbstrait{

	public PassagerLunatique(String nom,int arret) {
		super(nom, arret);
	}
	
	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
		b.demanderPlaceDebout(this);
	}
	
	public void choixChangerPlace(Bus b, int arret) throws UsagerInvalideException {
		if(this.arret == arret) {
			b.demanderSortie(this);
		}
		if(this.estAssis()) {
			b.demanderChangerEnDebout(this);
		}else if(this.estDebout()) {
			b.demanderChangerEnAssis(this);
		}
	}
}