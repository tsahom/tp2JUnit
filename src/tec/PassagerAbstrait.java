package tec;

import tec.EtatPassager.Etat;

public abstract class PassagerAbstrait implements Passager, Usager {

	private String nom;
	protected int arret;
	protected EtatPassager et;
	 
	
	public PassagerAbstrait(String nom,int arret) {
		this.nom=nom;
		this.arret=arret;
		et = new EtatPassager(Etat.DEHORS);
	}

	@Override
	public final String nom() {	
		return nom;
	}

	@Override
	public final boolean estDehors() {	
		return et.estExterieur();
	}

	@Override
	public final boolean estAssis() {
		return et.estAssis();
	}

	@Override
	public final boolean estDebout() {
		return et.estDebout();
	}

	@Override
	public final void accepterSortie() {
		et = new EtatPassager(Etat.DEHORS);
	}

	@Override
	public final void accepterPlaceAssise() {
		et = new EtatPassager(Etat.ASSIS);
	}

	@Override
	public final void accepterPlaceDebout() {
		et = new EtatPassager(Etat.DEBOUT);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
		if(arret<numeroArret){
			throw new UsagerInvalideException("Le transport a depasser l'arret de l'usager",(Usager)this,(Transport)bus);
		}
		choixChangerPlace(bus, numeroArret);
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if(!this.estDehors()) {
			throw new IllegalStateException();
		}
		Bus b = (Bus) t;
		EtatPassager current = et;
		choixPlaceMontee(b);
		if(et.toString().equals(current.toString())) {
			throw new UsagerInvalideException("L'usager n'a pu rentrer dans le transport",(Usager)this,t	);
		}
		
	}
	
	public abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;
	
	public abstract void choixChangerPlace(Bus b, int arret) throws UsagerInvalideException;
	
	@Override
	public final String toString() {
		String etat ="";
		
		if(et.estAssis()) {
			etat = "assis";
		}
		if(et.estDebout()) {
			etat = "debout";
		}
		if(et.estExterieur()) {
			etat = "dehors";
		}
		return nom+" "+etat;
	}
	
}
