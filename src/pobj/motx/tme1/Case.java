package pobj.motx.tme1;

/** Classe permettant d'instancier les Cases de la grille
 * 
 * @author NessimFabien
 *
 */
public class Case {
	
	/** abscisse de la Case **/
	private int lig;
	
	/** ordonnée de la Case **/
	private int col;
	/** valeur de la Case **/
	private char c;
	
	/** Initialise les attributs de la Case aux valeurs données
	 * 
	 * @param lig abscisse de la case
	 * @param col ordonnée de la case
	 * @param c valeur de la case
	 */
	public Case(int lig,int col, char c){
		this.lig = lig;
		this.col = col;
		this.c = c;
	}
	
	/** Accède à l'abscisse de la case
	 * 
	 * @return lig l'abscisse de la case
	 */
	public int getLig(){
		return lig;
	}
	
	/** Accède à l'ordonnée de la case
	 * 
	 * @return col l'ordonnée de la case
	 */
	public int getCol(){
		return col;
	}
	
	/** Accède à la valeur de la case
	 * 
	 * @return c la valeur de la case
	 */
	public char getChar(){
		return c;
	}
	
	/** Modifie la valeur de la case
	 * 
	 * @param c la nouvelle valeur de la case
	 */
	public void setChar(char c){
		this.c = c;
	}
	
	/** Regarde si la case n'a pas de valeur 
	 * 
	 * @return True si n'a pas de valeur  sinon false
	 */
	public boolean isVide()
	{
		if (c==' ')
			return true;
		return false;
	}
	
	/**Regarde si la case à une valeur
	 * 
	 * @return True la si case à une valeur sinon false
	 */
	public boolean isPleine()
	{
		if (c=='*')
			return true;
		return false;
	}
}
