package tec;

import tec.EtatPassager.Etat;

public class PassagerStandard implements Passager, Usager{
	
	private String nom;
	private int arret;
	private EtatPassager.Etat et;

	public PassagerStandard(String nom,int arret) {
		// TODO Auto-generated constructor stub
		this.nom=nom;
		this.arret=arret;
		et = Etat.DEHORS;
	}

	@Override
	public String nom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public boolean estDehors() {
		if(et==Etat.DEHORS) {
			return true;
		}
		return false;
	}

	@Override
	public boolean estAssis() {
		if(et==Etat.ASSIS) {
			return true;
		}
		return false;
	}

	@Override
	public boolean estDebout() {
		if(et==Etat.DEBOUT) {
			return true;
		}
		return false;
	}

	@Override
	public void accepterSortie() {
		et=Etat.DEHORS;
	}

	@Override
	public void accepterPlaceAssise() {
		et=Etat.ASSIS;
	}

	@Override
	public void accepterPlaceDebout() {
		et=Etat.DEBOUT;
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
		switch(et) {
		case ASSIS :
			etat = "assis";
			break;
		case DEBOUT :
			etat = "debout";
			break;
		case DEHORS :
			etat = "dehors";
			break;
		}
		return nom+" "+etat;
	}
	

}
