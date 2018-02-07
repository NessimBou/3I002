package pobj.motx.tme1;

/**  Classe permettant de créer la grille 
 * 
 * @author NessimFabien 
 *
 */
public class Grille {
	
	/** le nombre de colonne de la grille **/
	private int hauteur;
	
	/** le nombre de ligne de la grille **/
	private int largeur;
	
	/** une matrice de case (la grille) **/ 
	private Case[][] grille;

	/** Construit et initialise une grille
	 * 
	 * @param hauteur la hauteur initiale de la grille
	 * @param largeur la largeur initiale de la grille
	 */
	public Grille (int hauteur, int largeur){
		this.hauteur=hauteur;
		this.largeur=largeur;
		grille= new Case[hauteur][largeur];
		for (int i=0;i<hauteur;i++){
			for (int j=0;j<largeur;j++){
				grille[i][j]= new Case(i,j,' ');
			} 
		}
	}
	
	/** Accede à la case de la grille
	 * 
	 * @param lig l'abscisse de la case
	 * @param col l'ordonnée de la case
	 * @return grille[lig][col] rend la case à la position lig col
	 */
	public Case getCase(int lig,int col){
		return grille[lig][col];
	}
	
	@Override
	public String toString(){
		return GrilleLoader.serialize(this,false);
	}
	
	/** Rend le nombre de ligne
	 * 
	 * @return hauteur le nombre de ligne
	 */
	public int nbLig(){
		return hauteur; /* ou largeur */
	}
	
	
	/** Rend le nombre de colonne
	 * 
	 * @return largeur le nombre de colonne 
	 */
	public int nbCol(){
		return largeur; /* hauteur */ 
	}
	
	/** Rend une copie de la grille 
	 * 
	 * @return z la copie de la grille
	 */
	public Grille copy()
	{
		Grille z = new Grille(hauteur,largeur);
		for (int i=0;i<hauteur;i++){
			for (int j=0;j<largeur;j++){
				z.grille[i][j]=new Case(i,j,this.grille[i][j].getChar());
			} 
		}
		return z;
	}	
}
