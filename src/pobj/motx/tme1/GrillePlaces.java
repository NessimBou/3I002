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
	
	
	
	private List<Case> getLig(int lig)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbCol();i++)
		{
			c1.add(gr.getCase(lig,i));
		}
		return c1;
	}
	
	private List<Case> getCol(int col)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbLig();i++)
		{
			c1.add(gr.getCase(i,col));
		}
		return c1;
	}
	
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
}

