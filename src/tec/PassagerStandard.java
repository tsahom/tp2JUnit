package tec;

import tec.Bus;
import tec.EtatPassager;
import tec.Passager;
import tec.Transport;
import tec.Usager;
import tec.UsagerInvalideException;
import tec.EtatPassager.Etat;

public class PassagerStandard extends PassagerAbstrait implements Passager, Usager{

	public PassagerStandard(String nom,int arret) {
		super(nom,arret);
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

}
