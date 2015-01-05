package interfaceGraphique;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import moteur.Partie;


public class DemarrageListener implements ActionListener{

	private JeuDeCarteDemarrageView menuDemarrage;
	private JeuDeCarteUniverselView fenetreUniverselle;
	public DemarrageListener(JeuDeCarteDemarrageView menuDemarrage){
		this.menuDemarrage=menuDemarrage;
		//this.fenetreUniverselle=FenetreUniverselle;
	}
	public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().contains("Nom")){
		menuDemarrage.creerFenetreDemandeNom();
		menuDemarrage.addEnvoyerListener(this);
		
	}
	if(e.getActionCommand().contains("Envoyer")){
		menuDemarrage.setNom(menuDemarrage.getNomTape());
		Partie.partie.setNomJoueur(menuDemarrage.getNomTape());
		menuDemarrage.fermerDemandeNom();
	}
	if(e.getActionCommand().contains("Jouer")){
		menuDemarrage.creerFenetreDemandeNbJoueur();
		menuDemarrage.addCommencerListener(this);
	}
	if(e.getActionCommand().contains("Commencer")){
		Partie.partie.setNombreJoueurVirtuel(menuDemarrage.getNbJoueurEntre());
		menuDemarrage.fermerDemandeNbJoueur();
		menuDemarrage.dispose();
		Partie.partie.lancementPartie();
		
		fenetreUniverselle=JeuDeCarteUniverselView.getInstance();
		//Partie.partie.getController().creationListenerUniversel();
		//moteur.Partie.partie.getController().setfenetreUniverselle(fenetreUniverselle);
		fenetreUniverselle.getFenetrePrincipal().validate();
		fenetreUniverselle.revalidate();
	
		fenetreUniverselle.getContentPane().revalidate();
		fenetreUniverselle.getContentPane().repaint();
		fenetreUniverselle.repaint();
		//fenetreUniverselle = new JeuDeCarteUniverselView();
		
		//fenetreUniverselle.validate();
		
		
		//fenetreUniverselle.DemarrageFenetre();
		
		
		
		
	}
	
	if(e.getActionCommand().contains("Regles")){
		menuDemarrage.creerFenetreRegles();
	}
			
		
		
	}

}
