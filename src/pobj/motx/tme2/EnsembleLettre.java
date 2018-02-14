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
	public List<Character> intersection(EnsembleLettre c2){
		List<Character> c3 = this.c1;
		c3.retainAll(c2.getEnsemble());
		return c3;
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
