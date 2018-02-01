package pobj.motx.tme1;

import java.util.List;

public class Emplacement
{
	private List<Case> lettres;
	
	
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
}