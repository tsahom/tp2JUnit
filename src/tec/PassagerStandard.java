package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Passager, Usager{
	
	private String nom;
	private int arret;
	private EtatPassager et;

	public PassagerStandard(String nom,int arret) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		this.arret=arret;
		et = new EtatPassager(Etat.DEHORS);
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
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
	public void nouvelArret(Bus bus, int numeroArret) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		// TODO Auto-generated method stub
		
	}
	
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
