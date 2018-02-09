package pobj.motx.tme2;

import java.util.List;
import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

/** Classe CroixContraint, implémentant IContrainte
 * 
 * @author NessimFabien
 *
 */
public class CroixContrainte implements IContrainte 
{
	
	/** stocke l'indice m1 **/
	private int m1;
	/** stocke l'indice m2 **/
	private int m2;
	/** stocke l'indice c1 **/
	private int c1;
	/** stocke l'indice c2 **/
	private int c2;
	
	/**
	 * Initialise les attributs aux valeurs données
	 * @param m1, l'indice m1
	 * @param c1, l'indice c1
	 * @param m2, l'indice m2
	 * @param c2, l'indice c2
	 */
	public CroixContrainte (int m1,int c1,int m2,int c2) 
	{
		this.m1=m1;
		this.m2=m2;
		this.c1=c1;
		this.c2=c2;
	}
	
	/**
	 * To do
	 * @param grille,
	 */
	@Override
	public int reduce(GrillePotentiel grille) 
	{
		//calcul de l'ensemble des lettres l1 pouvant figurer dans la case c1 de l'emplacement m1 d'apres les mots potentiels pour cet emplacement
		EnsembleLettre l1=grille.getMotsPot().get(m1).charAt(c1);

		//calcul de l'ensemble des lettres l2 pouvant figurer dans la case c2 de l'emplacement m2 d'apres les mots potentiels pour cet emplacement
		EnsembleLettre l2=grille.getMotsPot().get(m2).charAt(c2);
		
		//Calculer l’ensemble s=l1∩l2, l’intersection des lettres possibles.
		List<Character> inter=l1.intersection(l2);
		EnsembleLettre s=new EnsembleLettre(inter);
			
		//Si l1 est plus grand que s, nous filtrons les mots potentiels pour l’emplacement m1 afin de ne garder que ceux dont la
		//c1-ième lettre est dans s.
		
		int op1=0;
		int op2=0;
		for (Character c: s.getel())
		{
			if (l1.size()>s.size())
			{
				op1=grille.getMotsPot().get(m1).filtreParLettre(c, c1);
			}
			
			//Si l2 est plus grand que s, nous filtrons les mots potentiels pour l’emplacement m2 afin de ne garder que ceux dont la
			//c2-ième lettre est dans s.
		
			if (l2.size()>s.size())
			{
				op2=grille.getMotsPot().get(m2).filtreParLettre(c, c2);
			}
		}
		//Pour finir, nous renvoyons le nombre de mots filtrés par ces deux opérations.
		return op1+op2;
	}
	
	/**
	 * Test l'égalité des indices avec l'objet other
	 * @param other, l'objet à tester
	 * @return true/false
	 */
	public boolean equals(Object other)
	{
		if (other==this)
			return true;
		if (!(other instanceof CroixContrainte))
			return false;
		CroixContrainte c = (CroixContrainte) other;
		return(c.m1==m1 && c.m2==m2 && c.c1==c1 && c.c2==c2);
	}
}
