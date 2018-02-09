package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**
 * *Classe permettant de trouver tous les emplacements de mots d'une grille 
 *
 * @author NessimFabien
 *
 */
public class GrillePlaces {
	/** une Grille **/
	private Grille gr;
	
	/**Liste contenant les places des mots **/
	private List<Emplacement> places;
	
	/** **/
	private int horiz;
	
	
	/** Calcule les emplacements de mots que contient la grille
	 * 
	 * @param grille Une grille remplie de mots ou pas 
	 */
	public GrillePlaces (Grille grille)
	{
		gr=grille;
		places=new ArrayList<Emplacement>();
		for (int i=0;i<grille.nbLig();i++)
		{
			cherchePlaces(getLig(i));
		}
		horiz=places.size();
		for (int i=0;i<grille.nbCol();i++)
		{
			cherchePlaces(getCol(i));
		}
		int verti=places.size()-horiz;
	}
	
	/**	Rendent les cases qui constituent une ligne ou une colonne donnée 
	 * @param lig la ligne des cases que l'on veut recupérer
	 * @return c1 la liste des cases de la ligne
	 */
	private List<Case> getLig(int lig)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbCol();i++)
		{
			c1.add(gr.getCase(lig,i));
		}
		return c1;
	}
	
	/**	Rendent les cases qui constituent une ligne ou une colonne donnée 
	 * @param col la colonne des cases que l'on veut recupérer
	 * @return c1 la liste des cases de la colonne
	 */
	private List<Case> getCol(int col)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbLig();i++)
		{
			c1.add(gr.getCase(i,col));
		}
		return c1;
	}
	
	/**	Cherche les mots dans la liste de cases fournie (une ligne ou une colonne) et qui ajoute les emplacements de mot trouvés aux places de la grille.
	 * @param cases la liste de cases fournie
	 */
	
	private void cherchePlaces(List<Case> cases)
	{
		Emplacement e1= new Emplacement();
		for (int i=0;i<cases.size();i++)
		{
			if (!cases.get(i).isPleine())
			{
				e1.add(cases.get(i));
			}
			else
			{
				if (e1.size()>=2)
				{
					places.add(e1);
				}
				e1=new Emplacement();
			}
		}
		if (e1.size()>=2)
		{
			places.add(e1);
		}
	}

	
	/** Recupere une liste de d'emplacement
	 * 
	 * @return place la liste des emplacements de la grille
	 */
	public List<Emplacement> getPlaces()
	{
		return places;
	}
	
	/** Renvoie le nombre de mots horizontal
	 * 
	 * @return horiz Le nombre de mots horizontal
	 */
	public int getNbHorizontal()
	{
		return horiz;
	}
	
	
	/**	Affiche les emplacements de mots détécté
	 * 
	 * @return s un mot
	 */
	public String toString()
	{
		String s="";
		for (int i=0;i<places.size();i++)
		{
			s=s+places.get(i);
		}
		return s;
	}
	
	/**	
	 * @return grille
	 */
	public Grille getGrille()
	{
		return gr;
	}
	
	
	/**	Rend une nouvelle grille où les cases constituant l’emplacement de mot d’indice m 
	 * (dans la liste des emplacements de mots de la grille telle que retournée par getPlaces()) 
	 * ont pour contenu les lettres de soluce.
	 * @param m indice de l'emplacement où soluce doit être placé
	 * @param soluce le mot à placer
	 * @return grille avec soluce placé
	 */

	public GrillePlaces fixer (int m, String soluce)
	{
		Grille gr_copy=gr.copy();
		List<Case> l = this.getPlaces().get(m).getCase();
		int i=0;
		for (Case le : l){
			char lettre=soluce.charAt(i);
			gr_copy.getCase(le.getLig(), le.getCol()).setChar(lettre);
			i++;
		}
		GrillePlaces g1=new GrillePlaces (gr_copy);
		//System.out.println(g1.getGrille());
		return g1;
	}
	
	

}

