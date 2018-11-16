package tec;

/**
 * Cette interface représente l'état d'un passager dans un transport.
 *  
 **/
public interface IEtatPassager {

	/**
	 * Le passager est-il à l'extérieur du transport ?
	 *
	 */
	public boolean estExterieur();

	/**
	 * Le passager est-il a l'intérieur du transport ?
	 *
	 */
	public boolean estInterieur();

	/**
	 * Le passager est-il assis à l'intérieur du transport ?
	 *
	 */
	public boolean estAssis();

	/**
	 * Le passager est-il debout à l'intérieur du transport ?
	 *
	 */
	public boolean estDebout();
}
