package pobj.motx.tme2;

public interface IContrainte {
	
	/**agit en modifiant la grille passée en argument, et rend le nombre total de mots filtrés
	 * 
	 * @param grille La grillePotentiel de mots
	 * @return Le nombre total de mots filtrés
	 */
	public int reduce(GrillePotentiel grille);
	public boolean equals(Object other);
	public int getM1();
	public int getC1();
	public int getM2();
	public int getC2();
}
