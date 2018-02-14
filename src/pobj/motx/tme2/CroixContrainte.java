package pobj.motx.tme2;

import java.util.List;

import pobj.motx.tme1.Emplacement;

import java.util.ArrayList;

public class CroixContrainte implements IContrainte {

	private int m1,c1,m2,c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2){
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
		
	}
	
	
	
	@Override
	public int reduce(GrillePotentiel grille) {
		List<Dictionnaire> dico = grille.getMotsPot();
		EnsembleLettre l1 = new EnsembleLettre();
		EnsembleLettre l2 = new EnsembleLettre();
		List<Character> s =new ArrayList<Character>();
		int compteur = 0;
		//  si le premier emplacement est dans la liste des emplacements croisés
		if(grille.getGrille().getPlaces().get(m1) == grille.getGrille().croisement(grille.getGrille()).get(m1)){
			
			//si les deux tests passent ça veux dire que les deux emplacements sont croisés.
			if(grille.getGrille().getPlaces().get(m2) == grille.getGrille().croisement(grille.getGrille()).get(m2)){
			
				//il faut verifié ensuite qu'ils se croisent ensemble
				if (grille.getGrille().getPlaces().get(m1).getCaseV2(c1) == grille.getGrille().getPlaces().get(m2).getCaseV2(c2)){
				
					//on est dans le cas où les deux emplacements se croisent(Je sais pas si c'est necessaire)
					for(int i = 0; i < dico.size();i++){
						l1.add(dico.get(m1).get(i).charAt(c1));
						l2.add(dico.get(m2).get(i).charAt(c2));
					}
				
					
					// calcul de l'intersection
					s = ((EnsembleLettre) l1.getEnsemble()).intersection(l2);
					//si l1 est plus grand que s
					if(l1.size() > s.size()){
						compteur = ((Dictionnaire) dico).filtreParLettre(l1,c1);
					}
					if( l2.size() > s.size()){
						compteur +=((Dictionnaire)dico).filtreParLettre(l2, c2);
					}
				}
				
			}
		}
		
		return compteur;
	}
	
	public int getM1(){
		return m1;
	}

	public int getC1(){
		return c1;
	}
	public int getM2(){
		return m2;
	}
	public int getC2(){
		return c2;
	}	
	
	
	public boolean equals(Object other)
	{
		if (other==this)
			return true;
		if (!(other instanceof CroixContrainte))
			return false;
		CroixContrainte c = (CroixContrainte) other;
		return(c.m1==m1 && c.c1==c1 && c.m2==m2 && c.c2==c2);
	}

			
		
}
