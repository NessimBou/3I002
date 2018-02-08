package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme1.Emplacement;
import pobj.motx.tme1.GrillePlaces;

public class GrillePotentiel 
{
	private GrillePlaces g1;
	private Dictionnaire d1;
	private List<Dictionnaire> motsPot = new ArrayList<Dictionnaire>();
	
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet)
	{
		g1=grille;
		d1=dicoComplet;
		Dictionnaire dcopy;
		
				
		for(Emplacement i : g1.getPlaces()){
			int taillemot=i.size();
			dcopy= d1.copy();
			dcopy.filtreLongueur(taillemot);
			motsPot.add(dcopy);
		}
	}
	
	public boolean isDead()
	{
		if(motsPot.size()!=g1.getPlaces().size())
			return true;
		return false;
	}
	
	public List<Dictionnaire> getMotsPot()
	{
		return motsPot;
	}
	
	
}
