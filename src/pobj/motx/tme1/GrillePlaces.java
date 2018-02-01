package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class GrillePlaces {
	
	private Grille gr;
	private List<Emplacement> places;
	private int horiz;
	
	private List<Case> getLig(int lig)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbCol();i++)
		{
			c1.add(gr.getCase(lig,i));
		}
		return c1;
	}
	
	private List<Case> getCol(int col)
	{
		List<Case> c1=new ArrayList<Case>();
		for (int i=0;i<gr.nbLig();i++)
		{
			c1.add(gr.getCase(i,col));
		}
		return c1;
	}
	
	private void cherchePlaces(List<Case> cases)
	{
		Emplacement e1= new Emplacement();
		for (int i=0;i<cases.size();i++)
		{
			if (!cases.get(i).isPleine())
			{
				e1.add(cases.get(i));
			}
			else
			{
				if (e1.size()>=2)
				{
					places.add(e1);
				}
				e1=new Emplacement();
			}
		}
		if (e1.size()>=2)
		{
			places.add(e1);
		}
	}
	
	public GrillePlaces (Grille grille)
	{
		gr=grille;
		places=new ArrayList<Emplacement>();
		for (int i=0;i<grille.nbLig();i++)
		{
			cherchePlaces(getLig(i));
		}
		horiz=places.size();
		for (int i=0;i<grille.nbCol();i++)
		{
			cherchePlaces(getCol(i));
		}
		int verti=places.size()-horiz;
	}
	
	public List<Emplacement> getPlaces()
	{
		return places;
	}
	
	public int getNbHorizontal()
	{
		return horiz;
	}
	
	public String toString()
	{
		String s="";
		for (int i=0;i<places.size();i++)
		{
			s=s+places.get(i);
		}
		return s;
	}
}