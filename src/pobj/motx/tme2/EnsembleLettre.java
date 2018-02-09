package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;


/** Classe EnsembleLettre, représentant un ensemble de lettres
 * 
 * @author NessimFabien
 *
 */
public class EnsembleLettre 
{
	/** stocke l'ensemble de lettre actuelle **/
	private List<Character> el = new ArrayList<Character>();
	
	/**
	 * Initialise l'attribut el par une nouvelle liste de caractère
	 */
	public EnsembleLettre(){}
	
	/**
	 * Initialise l'attribut el par une liste de caractère donné
	 * @param el, liste de caractère donné
	 */
	public EnsembleLettre(List<Character> el)
	{
		this.el=el;
	}
	
	/**
	 * Ajoute une lettre (sans doublon) à la liste de caractère
	 * @param c, la lettre ajouté
	 */
	public void add (char c)
	{
		el.add(c);
	}
	
	/**
	 * Renvoie la taille de la liste de caractère
	 * @return el.size(), taille de la liste
	 */
	public int size ()
	{
		return el.size();
	}
	
	/**
	 * Accesseur de la liste de caractère
	 * @return el, liste de caractère
	 */
	public List<Character> getel()
	{
		return el;
	}
	
	/**
	 * Calcule l’intersection de deux EnsembleLettre
	 * @return iel, liste de caractère resultant de l'intersection
	 */
	public List<Character> intersection (EnsembleLettre el)
	{
		List<Character> iel=new ArrayList<Character>();
		for (int i=0;i<el.size();i++)
		{
			if (this.getel().get(i)==el.getel().get(i))
				iel.add(el.getel().get(i));
		}
		return iel;
	}
	
	/**
	 * Détermine la présence d’une lettre particulière
	 * @return true/false
	 */
	public boolean contains(char c)
	{
		for (char a : el)
		{
			if (a==c)
				return true;
		}
		return false;
	}	
}
