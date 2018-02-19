package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Case;
import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel 
{
	private GrillePlaces g1;
	private Dictionnaire d1;
	private List<Dictionnaire> motsPot;
	private List<IContrainte> contraintes;

	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet){
		g1 = grille;
		d1 = dicoComplet;
		motsPot = new ArrayList<Dictionnaire>();
		contraintes = new ArrayList<IContrainte>();
		Dictionnaire copie;
		for(Emplacement e:g1.getPlaces())
		{
			copie=d1.copy();
			copie.filtreLongueur(e.size());
			for(int i=0;i<e.size();i++)
			{
				if(!(e.getCase(i).isPleine())&&!(e.getCase(i).isVide()))
				{
					copie.filtreParLettre(e.getCase(i).getChar(),i);
				}
			}
			motsPot.add(copie);
		}
		int m1=0;
		for(Emplacement e1:g1.getPlaces())
		{
			int m2=0;
			for(Emplacement e2:g1.getPlaces())
			{
				if(e1.isHorizontal()&& e2.isVertical())
				{
					for(int c1=0;c1<e1.size();c1++)
					{
						for(int c2=0;c2<e2.size();c2++)
						{
							if((e1.getCase(c1)==e2.getCase(c2))&&(e1.getCase(c1).isVide()))
							{
								contraintes.add(new CroixContrainte(m1,c1,m2,c2));
							}
						}
					}
				}
				m2++;
			}
			m1++;
		}
		propage();
	}

	
	/**Renvoie vrai si le mot croisé est pas possible
	 * 
	 * @return True/false
	 */
	
	public boolean isDead()
	{
		for(Dictionnaire d:motsPot)
		{
			if(d.size()==0)
				return true;
		}
		return false;
	}
	
	/**Retourne la liste de dictionnaire
	 * 
	 * @return la liste de dictionnaire
	 */
	public List<Dictionnaire> getMotsPot()
	{
		return motsPot;
	}
	
	public GrillePotentiel fixer(int m , String soluce){
		
		GrillePotentiel gr1 = new GrillePotentiel(g1.fixer(m, soluce),d1);
		return gr1;
	}
	
	public GrillePlaces getGrille(){
		return g1;
	}
	
	public Dictionnaire getDict(){
		Dictionnaire dcopy = d1.copy();
		return dcopy;
	}
	
	public List<IContrainte> getContraintes()
	{
		return contraintes;
	}
	
	private boolean propage()
	{
		while(true)
		{
			int cpt=0;
			for(IContrainte ic: contraintes)
			{
				cpt=cpt+ic.reduce(this);
			}
			if(this.isDead())
			{
				return false;
			}
			if(cpt==0)
			{
				return true;
			}
		}
	}
}
