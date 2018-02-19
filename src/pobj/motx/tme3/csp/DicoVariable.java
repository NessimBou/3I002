package pobj.motx.tme3.csp;

import java.util.List;


import pobj.motx.tme2.*;

public class DicoVariable implements IVariable {
	
	private int indice;
	private GrillePotentiel gp;

	
	public DicoVariable(int index, GrillePotentiel gp){
		this.indice = index;
		this.gp = gp;
		
	}
	@Override
	public List<String> getDomain() {
		return gp.getMotsPot().get(indice).getMots();
	}
	
	
	//J'ai pas de String lisible en tete 
	public String toString(){
		return "";
	}

}
