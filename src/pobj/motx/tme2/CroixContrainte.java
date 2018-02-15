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
	
	
	
//	@Override
//	public int reduce(GrillePotentiel grille) {
//		List<Dictionnaire> dico = grille.getMotsPot();
//		EnsembleLettre l1 = new EnsembleLettre();
//		EnsembleLettre l2 = new EnsembleLettre();
//		List<Character> s =new ArrayList<Character>();
//		int compteur = 0;
//		//  si le premier emplacement est dans la liste des emplacements croisés
//		if(grille.getGrille().getPlaces().get(m1) == grille.getGrille().croisement(grille.getGrille()).get(m1)){
//			//si les deux tests passent ça veux dire que les deux emplacements sont croisés.
//			if(grille.getGrille().getPlaces().get(m2) == grille.getGrille().croisement(grille.getGrille()).get(m2)){
//				//il faut verifié ensuite qu'ils se croisent ensemble
//				if (grille.getGrille().getPlaces().get(m1).getCaseV2(c1) == grille.getGrille().getPlaces().get(m2).getCaseV2(c2)){
					//on est dans le cas où les deux emplacements se croisent(Je sais pas si c'est necessaire)
//					for(int i = 0; i < dico.size();i++){
//						l1.add(dico.get(m1).get(i).charAt(c1));
//						l2.add(dico.get(m2).get(i).charAt(c2));
//					}
//					
//					// calcul de l'intersection
//					s = l1.intersection(l2);
//					
//					
//					System.out.println("zzzzzz");
//					System.out.println(l1.getEnsemble());
//					System.out.println(l2.getEnsemble());
//					
//					//s = ((EnsembleLettre) l1.getEnsemble()).intersection(l2);
//					//si l1 est plus grand que s
//					if(l1.size() > s.size()){
//						compteur = dico.get(m1).filtreParLettre(l1,c1);
//						System.out.println(compteur);
//						//compteur = ((Dictionnaire) dico).filtreParLettre(l1,c1);
//					}
//					if( l2.size() > s.size()){
//						compteur = compteur + dico.get(m2).filtreParLettre(l2,c2);
//						//compteur +=((Dictionnaire)dico).filtreParLettre(l2, c2);
//					}
//				}
//				
//			}
//		}
//		
//		return compteur;
//	}
	

	
	public int reduce(GrillePotentiel grille) 
	{
//		//calcul de l'ensemble des lettres l1 pouvant figurer dans la case c1 de l'emplacement m1 d'apres les mots potentiels pour cet emplacement
//		EnsembleLettre l1=grille.getMotsPot().get(m1).charAt(c1);
//		//calcul de l'ensemble des lettres l2 pouvant figurer dans la case c2 de l'emplacement m2 d'apres les mots potentiels pour cet emplacement
//		EnsembleLettre l2=grille.getMotsPot().get(m2).charAt(c2);
//
		List<Dictionnaire> dico = grille.getMotsPot();
		EnsembleLettre l1 = new EnsembleLettre();
		EnsembleLettre l2 = new EnsembleLettre();
		List<Character> s =new ArrayList<Character>();
		int compteur = 0;
		int op1=0;
		int op2=0;
		//  si le premier emplacement est dans la liste des emplacements croisés
		if(grille.getGrille().getPlaces().get(m1) == grille.getGrille().croisement(grille.getGrille()).get(m1)){
			//si les deux tests passent ça veux dire que les deux emplacements sont croisés.
			if(grille.getGrille().getPlaces().get(m2) == grille.getGrille().croisement(grille.getGrille()).get(m2)){
				//il faut verifié ensuite qu'ils se croisent ensemble
				if (grille.getGrille().getPlaces().get(m1).getCaseV2(c1) == grille.getGrille().getPlaces().get(m2).getCaseV2(c2)){
					//Calculer l’ensemble s=l1∩l2, l’intersection des lettres possibles.
					EnsembleLettre inter=l1.intersection(l2);
				
					//Si l1 est plus grand que s, nous filtrons les mots potentiels pour l’emplacement m1 afin de ne garder que ceux dont la
					//c1-ième lettre est dans s.

					for (Character c: inter.getEnsemble())
					{
						if (l1.size()>inter.size())
						{
							op1=grille.getMotsPot().get(m1).filtreParLettre(c, c1);
						}
			
						//Si l2 est plus grand que s, nous filtrons les mots potentiels pour l’emplacement m2 afin de ne garder que ceux dont la
						//c2-ième lettre est dans s.
		
						if (l2.size()>inter.size())
						{
							op2=grille.getMotsPot().get(m2).filtreParLettre(c, c2);
						}
					}
				
				}
			}
		}
		
	System.out.println(op1+op2);
	return op1+op2;//Pour finir, nous renvoyons le nombre de mots filtrés par ces deux opérations.
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
	
	
			
    public boolean equals(Object other){
        if(this == other){
            return true;
        }
        if(this.getClass()!=other.getClass()){

            return false;
        }
        CroixContrainte obj = (CroixContrainte) other;
        if((obj.m1 == this.m1)&&(obj.c1 == this.c1)&&(obj.m2 == this.m2)&&(obj.c2 == this.c2)){
            return true;
        }
        else {
            return false;
        }
    }




}
