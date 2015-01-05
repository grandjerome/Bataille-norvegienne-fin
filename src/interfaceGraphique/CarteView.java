package interfaceGraphique;

import java.awt.Image;

import javax.swing.JPanel;

import moteur.Carte;
import moteur.Partie;

public class CarteView extends BackgroundPanel{
	private Carte carte;
	private boolean etat;
	
	public CarteView(Image image,Carte carte) {
		super(image);
		this.carte=carte;
		this.etat=false;
		this.addMouseListener(Partie.partie.getController().getCarteListener());
		this.setOpaque(false);
		
		
	}
	public void setEtat(boolean selectionne){
		if (selectionne){
			this.etat=true;
		}else{
			this.etat=false;
		}
	}
	public boolean getEtat(){
		return(this.etat);
	}
	public Carte getCarte(){
		return(this.carte);
	}
	

}
