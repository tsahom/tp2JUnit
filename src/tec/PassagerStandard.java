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

	
	
	public void choixChangerPlace(Bus b, int arret) throws UsagerInvalideException {
			
		if(arret<arret){
			throw new UsagerInvalideException("Le transport a depasser l'arret de l'usager",(Usager)this,(Transport)b);
		}
		if(arret == arret) {
			b.demanderSortie(this);
		}
	}

	public void choixPlaceMontee(Bus b) throws UsagerInvalideException {
		EtatPassager current = et;
		b.demanderPlaceAssise(this);
		if(et.toString().equals(current.toString())) {
			b.demanderPlaceDebout(this);
			if(et.toString().equals(current.toString())) {
				throw new UsagerInvalideException("L'usager n'a pu rentrer dans le transport",(Usager)this,(Transport)b);
			}
		}
	}

}
