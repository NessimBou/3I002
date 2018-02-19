package pobj.motx.tme3.csp;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.*;
import pobj.motx.tme2.*;

public class MotX implements ICSP {

	private List<DicoVariable> dicoliste = new ArrayList<DicoVariable>();
	
	private GrillePotentiel gp;
	
	public MotX(GrillePotentiel gp){
		this.gp = gp;
		
		//initialisation de la liste de DicoVariable
		for(int i=0; i < gp.getGrille().getPlaces().size(); i++){
			//On parcourt chaque case de l'emplacement pour tcherker si une case est vide
			for(int j = 0; j< gp.getGrille().getPlaces().get(i).getlettres().size() ; j++){
				if(gp.getGrille().getPlaces().get(i).getlettres().get(j).isVide()){
					DicoVariable dicova = new DicoVariable(i,gp);
					//si la liste ne contient pas la dicova
					if(!dicoliste.contains(dicova)){
						dicoliste.add(dicova);
					}
				}
			}
			
		}
		
		
	}
	
	@Override
	public List<IVariable> getVars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConsistent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ICSP assign(IVariable vi, String val) {
		// TODO Auto-generated method stub
		return null;
	}

}
