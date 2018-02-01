package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement
{
	private List<Case> lettres;
	
	public Emplacement()
	{
		lettres=new ArrayList<Case>();
	}
	
	public String toString()
	{
		String s="";
		for (int i=0;i<lettres.size();i++)
		{
			s=s+lettres.get(i);
		}
		return s;
	}
	
	public int size()
	{
		return lettres.size(); 
	}
	
	public void add(Case c1)
	{
		lettres.add(c1);
	}
	
}