package pobj.motx.tme2.test;

import java.util.ArrayList;
import java.util.List;

import pobj.motx.tme2.EnsembleLettre;

public class Maintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Character> fr = new ArrayList<Character>();
		fr.add('a');
		fr.add('d');
		fr.add('e');
		fr.add('c');
		fr.add('r');
		fr.add('q');

		
		List<Character> fz = new ArrayList<Character>();
		fz.add('v');
		fz.add('d');
		fz.add('e');
		fz.add('r');
		fz.add('g');
		
		EnsembleLettre fe = new EnsembleLettre(fr);
		EnsembleLettre fa = new EnsembleLettre(fz);
		
		EnsembleLettre fq = fe.intersection(fa);
		
		System.out.print(fq.getEnsemble());
		
		
		
	}

}
