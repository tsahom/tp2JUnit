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
		if(arret == numeroArret) {
			bus.demanderSortie(this);
		}
	}
	
	@Override
	public void monterDans(Transport t) throws UsagerInvalideException {
		Bus b = (Bus) t;
		EtatPassager current = et;
		b.demanderPlaceAssise(this);
		if(et.toString().equals(current.toString())) {
			b.demanderPlaceDebout(this);
		}
		
		
	}

}
