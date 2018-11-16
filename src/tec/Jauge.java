package tec;
/**
 * Interface d'une jauge : Un objet Jauge définit un niveau et un intervalle ouvert ]vigieMin, vigieMax[. Le niveau d'une jauge n'est pas limité aux valeurs dans l'intervalle.

L'état d'une jauge correspond à la position de son niveau par rapport à l'intervalle ]vigieMin, vigieMax[. Une jauge définit trois etats :

vert niveau dans l'intervalle,
rouge niveau supérieur à l'intervalle,
bleu niveau inférieur à l'intervalle.

 */
public interface Jauge {	
	public boolean estRouge();
	
	public boolean estVert();
	
	public boolean estBleu();
	
	public void incrementer();
	
	public void decrementer();
}
