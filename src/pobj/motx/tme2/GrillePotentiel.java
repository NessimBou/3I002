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

		
		// n = identifiant m1
		int n=0;
		//Parcourt des emplacements horizontaux
		for (int a=0;a<g1.getNbHorizontal();a++){
			Emplacement e1=g1.getPlaces().get(a);
			// m = identifiant m2
			int m = 0; 
			//on parcourt tous les emplacements
			for(Emplacement e2 :g1.getPlaces()){
				//on verifie que c'est pas les mêmes
				if(e1 != e2){
					// i = identifiant c1
					//Si ce n'est pas les mêmes on parcourt toute les cases 
					for(int i =0; i < e1.size(); i++){
						//e1.getcase(i) n'est pas vide
						if (!e1.getCaseV2(i).isVide())
							continue;
						// j = identifiant c2
						for(int j=0;j<e2.size();j++){
							// si c'est les mêmes cases on crée une nouvelle croix contrainte
							if(e1.getCaseV2(i) == e2.getCaseV2(j)){
								
								CroixContrainte croisement = new CroixContrainte(n,i,m,j);
								//On verifie juste que contrainte ne contient pas croisement
								if(!contraintes.contains(croisement)){
										
										contraintes.add(croisement);
										croisement.reduce(this);
										
									
		
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
	
	/**Renvoie vrai si le mot croisé est pas possible
	 * 
	 * @return True/false
	 */
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
