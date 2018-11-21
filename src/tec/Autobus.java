package tec;

import java.util.List;

import java.util.ArrayList;

public class Autobus implements Bus, Transport{
	
	private JaugeNaturel plcAss;
	private JaugeNaturel plcDeb;
	private List<Passager> passagers;
	int numArret;
	
	public Autobus(int plcAss,int plcDeb) {
		this.plcAss = new JaugeNaturel(0, plcAss, 0);
		this.plcDeb = new JaugeNaturel(0, plcDeb, 0);
		this.passagers = new ArrayList<Passager>(plcAss+plcDeb);
		this.numArret =0;
	}

	@Override
	public boolean aPlaceAssise() {
		return !this.plcAss.estRouge();
	}

	@Override
	public boolean aPlaceDebout() {
		return !this.plcDeb.estRouge();
	}

	@Override
	public void demanderPlaceAssise(Passager p) {
		if(this.aPlaceAssise()) {
			this.plcAss.incrementer();
			p.accepterPlaceAssise();
			passagers.add(p);
			
		}
	}

	@Override
	public void demanderPlaceDebout(Passager p) {
		if(this.aPlaceDebout()) {
			this.plcDeb.incrementer();
			p.accepterPlaceDebout();
			passagers.add(p);
			
		}
	}

	@Override
	public void demanderChangerEnDebout(Passager p) {
		if(this.aPlaceDebout()) {
			this.plcDeb.incrementer();
			this.plcAss.decrementer();
			p.accepterPlaceDebout();
		}

	}

	@Override
	public void demanderChangerEnAssis(Passager p){
		if(this.aPlaceAssise()) {
			this.plcAss.incrementer();
			this.plcDeb.decrementer();
			p.accepterPlaceAssise();
		}
	}

	@Override
	public void demanderSortie(Passager p) throws UsagerInvalideException {
		if(!this.passagers.contains(p)) {
			throw new UsagerInvalideException("L'usager n'est pas présent dans le bus");
		}
		if(p.estAssis()) {
			this.plcAss.decrementer();
		}else {
			this.plcDeb.decrementer();
		}
		p.accepterSortie();
		passagers.remove(p);
	
	}

	@Override
	public void allerArretSuivant() throws UsagerInvalideException {
		this.numArret++;
		int previousSize;
		do {
			 previousSize = this.passagers.size(); 
			for(int i = 0; i< this.passagers.size();i++) {
				this.passagers.get(i).nouvelArret(this, this.numArret);
			}
		}while(previousSize != this.passagers.size());
	}
	
	@Override
	public String toString() {
		return "[arret:"+this.numArret+",assis:" + this.plcAss.getValeur() + ",debout:" + this.plcDeb.getValeur()+"]";
	}

}
