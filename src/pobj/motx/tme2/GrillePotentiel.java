package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.Grille;
import pobj.motx.tme1.GrillePlaces;

/** Classe permettant d'instancier une grille potentiel
 * 
 * @author NessimFabien
 *
 */

public class GrillePotentiel 
{
	/** stocke la grille actuelle (partiellement remplie) **/
	private GrillePlaces g1;
	/** stocke le dictionnaire français complet **/
	private Dictionnaire d1;
	/** stocke le domaine de chaque emplacement de la grille, dans le même ordre que la grille **/
	private List<Dictionnaire> motsPot = new ArrayList<Dictionnaire>();
	/** stocke la liste des contraintes, dans le même ordre que la grille **/
	private List<IContrainte> contraintes = new ArrayList<IContrainte>();

	//Version codé en TME
//	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet)
//	{
//		g1=grille;
//		d1=dicoComplet;
//		Dictionnaire dcopy;
//		
//		for(Emplacement i : g1.getPlaces()){
//			int taillemot=i.size();
//			dcopy= d1.copy();
//			dcopy.filtreLongueur(taillemot);
//			motsPot.add(dcopy);
//		}
//		
//	}
	
	/**
	 * Initialise les attributs aux valeurs données et le domaine des emplacements
	 * tout en respectant les lettres déjà placées
	 * @param grille où les mots seront placés
	 * @param dicoComplet où les mots seront piochés
	 */
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet)
	{
		g1=grille;
		d1=dicoComplet;
		
		//Grossomodo là on parcourt la liste des emplacements possibles
		for(Emplacement e1 : g1.getPlaces())
		{
			int cpt=0;
			Dictionnaire dcopy=d1.copy();
			//On recup la taille de l'emplacement afin de filtrer le dico avec des mots de la longueur de l'emplacement
			int taillemot=e1.size();
			dcopy.filtreLongueur(taillemot);
			
			//On recup la liste de case et si une case contient une lettre, on filtre le dico avec des mots dont la i-ème lettre correspond.
			for (Case c : e1.getCase())
			{
				if ((!c.isVide()) && (!c.isPleine()))
				{
					dcopy.filtreParLettre(c.getChar(),cpt);
				}
				cpt++;
			}
			//On rajoute notre dico à la liste de dico
			motsPot.add(dcopy);
		}
		
		//Détection des contraintes de croisement entre deux mots (2.4.3)
		//il faut recup les emplacements verticaux
		//il faut recup les emplacements verticaux
		//tester l'egalité entre case (=croisement)
		//Si c'est le cas, créer une nouvelle contrainte sauf si la case en question contient une lettre
		//List<Emplacement> pl=g1.getPlaces();
		//for (Emplacement e : pl)
		//{
		//	List<Case> c=e.getCase();
		//}
	}
	
	
	
	/**
	 * rend vrai si et seulement si au moins un emplacement a un domaine potentiel vide
	 * @return true/false
	 */
	public boolean isDead()
	{
		if(motsPot.size()!=g1.getPlaces().size())
			return true;
		return false;
	}
	
	
	/**
	 * Accesseur de la liste de dictionnaire
	 * @return la liste de dictionnaire
	 */
	public List<Dictionnaire> getMotsPot()
	{
		return motsPot;
	}
	
	/**
	 * Accesseur de GrillePlaces
	 * @return la Grille et de la liste de ses emplacements
	 */
	public GrillePlaces getGrillePlaces()
	{
		return g1;
	}
	
	/**
	 * Initialise une nouvelle GrillePotentiel avec la grille résultante de l’affectation
	 * @return gp la grille resultante
	 */	
	public GrillePotentiel fixer(int m, String soluce)
	{
		GrillePotentiel gp=new GrillePotentiel(g1.fixer(m, soluce),d1);
		//System.out.println(this.getGrillePlaces().getGrille());
		return gp;
	}
	
	/**
	 * Accesseur de la liste des contraintes
	 * @return contraintes, la liste des contraintes
	 */
	public List<IContrainte> getContraintes()
	{
		return contraintes;
	}

}
