package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

public class EnsembleLettre {
	
	private List<Character> c1 = new ArrayList<Character>();
	
	public EnsembleLettre(){
	}
	
	public EnsembleLettre(List<Character> c1){
		this.c1 = c1;
		
	}
	
	public void add(char c){
		if(!c1.contains(c)){
			c1.add(c);			
		}
	}
	
	public int size(){
		return c1.size();
		
	}
	/**Calcul l'intersection de deux ensembles
	 * 
	 * @param c2 Un ensemble lettre
	 * @return La liste des characteres de l'intersection
	 */
	
	public EnsembleLettre intersection(EnsembleLettre e2){
		List<Character> inter = new ArrayList<Character>();
		
		for(Character c1: this.getEnsemble()){
			if(e2.contains(c1)){
				inter.add(c1);
			}
		}
		return new EnsembleLettre(inter);
	}

	
	public List<Character> getEnsemble(){
		return c1;
	}
	
	public boolean contains(char c){
		if(c1.contains(c)){
			return true;
		}else{
			return false;
		}
	}
	

}