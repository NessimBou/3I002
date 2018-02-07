package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/** Classe Permettant l'identification des mots dans la grille
 * 
 * @author NessimFabien
 *
 */
public class Emplacement {
	/** Liste de case **/
	private List<Case> lettres;
	
	/** Initialisation de la liste de case
	 * 
	 */
	public Emplacement(){
		lettres = new ArrayList<Case>();
		
	}
	/** Affiche le mot de l'emplacement
	 * 
	 * @return mot le mot de l'emplacement à afficher
	 */
	public String toString(){
		String mot = "";
		for(int i = 0 ; i < lettres.size(); i++){
			mot += lettres.get(i);
		}
		
		return mot;
		
	}
	
	/**Renvoie la taille de l'emplacement du mot
	 * 
	 * @return lettres.size() la taille de l'emplacement du mot
	 */
	public int size(){
		return lettres.size();
	}
	
	
	/** Ajoute la valeur du parametre à la liste
	 * 
	 * @param c1 Valeur de la case à rajouter
	 */
	public void add(Case c1)
	{
		lettres.add(c1);
	}
	


}
