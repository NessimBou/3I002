package pobj.motx.tme1;

public class Grille {
	private int hauteur;
	private int largeur;
	private Case[][] grille;

	public Grille (int hauteur, int largeur){
		this.hauteur=hauteur;
		this.largeur=largeur;
		grille= new Case[hauteur][largeur];
		for (int i=0;i<hauteur;i++){
			for (int j=0;j<largeur;j++){
				grille[i][j]= new Case(i,j,' ');
			} 
		}
	}
	
	public Case getCase(int lig,int col){
		return grille[lig][col];
	}
	
	@Override
	public String toString(){
		return GrilleLoader.serialize(this,false);
	}
	
	public int nbLig(){
		return hauteur;
	}
	
	public int nbCol(){
		return largeur;
	}
	
//	public Grille copy()
//	{
//		Grille Z = new Grille(hauteur,largeur)
//		Case [][] grilleC;
//		grilleC=new Case[hauteur][largeur];
//		for (int i=0;i<hauteur;i++){
//			for (int j=0;j<largeur;j++){
//				z = grille[i][j];
//			} 
//		}
//	}
	
	public Grille copy()
	{
		Grille z = new Grille(hauteur,largeur);
		for (int i=0;i<hauteur;i++){
			for (int j=0;j<largeur;j++){
				z.grille[i][j]=new Case(i,j,this.grille[i][j].getChar());
			} 
		}
		return z;
	}	
}
