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
	public String nom() {	
		return nom;
	}

	@Override
	public boolean estDehors() {	
		return et.estExterieur();
	}

	@Override
	public boolean estAssis() {
		return et.estAssis();
	}

	@Override
	public boolean estDebout() {
		return et.estDebout();
	}

	@Override
	public void accepterSortie() {
		et = new EtatPassager(Etat.DEHORS);
	}

	@Override
	public void accepterPlaceAssise() {
		et = new EtatPassager(Etat.ASSIS);
	}

	@Override
	public void accepterPlaceDebout() {
		et = new EtatPassager(Etat.DEBOUT);
	}

	@Override
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException{
		this.choixChangerPlace(bus, numeroArret);
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException{
		Bus b = (Bus) t;
		this.choixPlaceMontee(b);
	}
	
	public abstract void choixChangerPlace(Bus b, int arret) throws UsagerInvalideException;

	
	public abstract void choixPlaceMontee(Bus b) throws UsagerInvalideException;
	
	
	
	
	@Override
	public String toString() {
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
