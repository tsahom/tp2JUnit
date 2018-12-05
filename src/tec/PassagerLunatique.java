package tec;

public final class PassagerLunatique extends PassagerAbstrait{

	public PassagerLunatique(String nom,int arret) {
		super(nom, arret);
	}
	
	
	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
		
	}

	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		
	}

}
