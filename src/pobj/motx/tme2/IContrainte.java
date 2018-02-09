package pobj.motx.tme2;

/** Classe abstraite permettant d'instancier une interface de Contrainte
 * 
 * @author NessimFabien
 *
 */
public abstract interface IContrainte {
	
	/**
	 * Agit en modifiant la grille passée en argument, et rend le nombre total de mots filtrés par son action 
	 * (donc potentiellement 0 si elle n’a aucun effet) tout en respectant les lettres déjà placées.
	 * @param grille
	 */
	int reduce(GrillePotentiel grille);

}
