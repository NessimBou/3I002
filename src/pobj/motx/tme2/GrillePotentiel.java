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
	private List<Dictionnaire> motsPot = new ArrayList<Dictionnaire>();
	private List<IContrainte> contraintes = new ArrayList<IContrainte>();
/*	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet)
	{
		g1=grille;
		d1=dicoComplet;
		Dictionnaire dcopy;
		
			+
		for(Emplacement i : g1.getPlaces()){
			int taillemot=i.size();
			dcopy= d1.copy();
			dcopy.filtreLongueur(taillemot);
			motsPot.add(dcopy);
		}
	}
*/
	
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet){
		g1 = grille;
		d1= dicoComplet;
		Dictionnaire dcopy;
			
		for(Emplacement i : g1.getPlaces()){
			int cpt = 0;
			int taillemot=i.size();
			dcopy= d1.copy();
			dcopy.filtreLongueur(taillemot);
			motsPot.add(dcopy);
			for(Case c : i.getCase() ){
				if(!c.isVide() && !c.isPleine()){
					dcopy.filtreParLettre(c.getChar(),cpt);
				}
				cpt++;
			}
		}
		//Gestion des contraintes
		
		// il ajoute bien les contraintes le probleme est qu'il implemente deux fois chaque contrante mais avec des identifiants different
		//
		int n=0;
		
		for (int a=0;a<g1.getNbHorizontal();a++){
			Emplacement e1=g1.getPlaces().get(a);
			int m = 0; 
			for(Emplacement e2 :g1.getPlaces()){
				if(e1 != e2){
					for(int i =0; i < e1.size(); i++){
						for(int j=0;j<e2.size();j++){
							
							if(e1.getCaseV2(i) == e2.getCaseV2(j)){
								
								CroixContrainte croisement = new CroixContrainte(n,i,m,j);
								
								if(!contraintes.contains(croisement)){
									
										contraintes.add(croisement);
									
		
								}
							}
						}
					}
				}
				m++;
			}
			n++;
		}
	}
	
	public boolean isDead()
	{
		if(motsPot.size()!=g1.getPlaces().size())
			return true;
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

}
