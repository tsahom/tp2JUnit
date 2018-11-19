package tec;

import tec.Bus;
import tec.EtatPassager;
import tec.Passager;
import tec.Transport;
import tec.Usager;
import tec.UsagerInvalideException;
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
		EtatPassager currentState = et;
		
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
