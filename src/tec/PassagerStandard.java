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
		if(arret<1) {
			throw new IllegalArgumentException();
		}
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
	public void nouvelArret(Bus bus, int numeroArret) throws UsagerInvalideException {
		if(arret<numeroArret){
			throw new UsagerInvalideException("Le transport a depasser l'arret de l'usager",(Usager)this,(Transport)bus);
		}
		if(arret == numeroArret) {
			bus.demanderSortie(this);
		}
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		if(!this.estDehors()) {
			throw new IllegalStateException();
		}
		Bus b = (Bus) t;
		EtatPassager current = et;
		b.demanderPlaceAssise(this);
		if(et.toString().equals(current.toString())) {
			b.demanderPlaceDebout(this);
			if(et.toString().equals(current.toString())) {
				throw new UsagerInvalideException("L'usager n'a pu rentrer dans le transport",(Usager)this,t);
			}
		}
		
		
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
