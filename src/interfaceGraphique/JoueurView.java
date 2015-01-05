package interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import moteur.Carte;
import moteur.Joueur;
import moteur.JoueurVirtuel;
import moteur.Partie;
import moteur.StrategieAleatoire;
import net.miginfocom.swing.MigLayout;


public class JoueurView extends JComponent{

	
	private JPanel ligneCarteVisible;
	private JPanel ligneMain;
	

	private JPanel ligneJoueur;
	private moteur.Joueur joueur;
	private Image imageJoueur;
	private static int conteurAfficheur=0;
	
	public JoueurView(moteur.Joueur joueur){
		ligneCarteVisible=new JPanel();
		//ligneCarteVisible.setLayout(new BoxLayout(ligneCarteVisible, BoxLayout.LINE_AXIS));
		ligneCarteVisible.setLayout(new MigLayout("insets 0"));
		ligneCarteVisible.setOpaque(false);
		
		
		
		
		
		//ligneCarteVisible.setBorder(new BevelBorder(BevelBorder.RAISED));
		ligneMain=new JPanel();
		
		//ligneMain.setLayout(new BoxLayout(ligneMain, BoxLayout.LINE_AXIS));
		//ligneMain.setBorder(new BevelBorder(BevelBorder.RAISED));
		ligneMain.setOpaque(false);
		//ligneMain.setLayout(new BoxLayout(ligneMain, BoxLayout.LINE_AXIS));
		ligneMain.setLayout(new MigLayout("insets 0"));
		
		
		
		ligneJoueur=new JPanel();
		//ligneJoueur.setLayout(new BorderLayout());
		//ligneJoueur.setLayout(new MigLayout("insets 0"));
		ligneJoueur.setLayout(new MigLayout("insets 0 20 5 0"));
		ligneJoueur.setOpaque(false);
		//ligneJoueur.setLayout(new BoxLayout(ligneJoueur, BoxLayout.LINE_AXIS));
		//ligneJoueur.setBorder(new BevelBorder(BevelBorder.RAISED));
		this.joueur=joueur;
		
		
	}

	public JPanel getLigneCarteVisible() {
		return ligneCarteVisible;
	}

	

	public JPanel getLigneMain() {
		return ligneMain;
	}
	

	

	public JPanel getLigneJoueur() {
		return ligneJoueur;
	}
	public void setImageJoueur(int i){
		if(i==1){
			imageJoueur =Toolkit.getDefaultToolkit().getImage("images/joueurpetite.jpg");
			
			BackgroundPanel imagePanel = new BackgroundPanel(imageJoueur,2);
			JLabel nomjoueur=new JLabel(this.joueur.getNomJoueur());
			nomjoueur.setFont(new Font("Dragon is Coming",Font.PLAIN,60));
			imagePanel.setOpaque(false);
			ligneJoueur.add(nomjoueur,BorderLayout.CENTER);
			ligneJoueur.add(imagePanel,BorderLayout.WEST);
			
			ligneJoueur.validate();
			ligneJoueur.repaint();
			//System.out.println("joueurview : "+joueur.getNomJoueur());
			
		}else{
			imageJoueur =Toolkit.getDefaultToolkit().getImage("images/ordipetite.png");
			BackgroundPanel imagePanel = new BackgroundPanel(imageJoueur,2);
			imagePanel.setOpaque(false);
			//System.out.println("joueurview : "+this.joueur.getNomJoueur());
			String intelligence;
			if(((JoueurVirtuel) joueur).getStrat() instanceof StrategieAleatoire){
				intelligence="- novice";
			}else{
				intelligence="- normal";
			}
			JLabel nomjoueur=new JLabel(this.joueur.getNomJoueur()+" "+intelligence);
			nomjoueur.setFont(new Font("Dragon is Coming",Font.PLAIN,60));
			ligneJoueur.add(nomjoueur,BorderLayout.CENTER);
			ligneJoueur.add(imagePanel,BorderLayout.WEST);
			
			
			ligneJoueur.validate();
			ligneJoueur.repaint();
		}
	}
	public void afficherCarteMain(CarteView carte){
		if((ligneMain.getComponentCount()%3)==0 && ligneMain.getComponentCount()!=0){
		ligneMain.add(carte,"wrap");
		//carte.addMouseListener(Partie.partie.getController().getCarteListener());
		if(Partie.partie.getController().getFenetreUniverselle() instanceof JeuDeCarteUniverselView){
			Partie.partie.getController().getFenetreUniverselle().revalidate();
			}
//if(Partie.partie.getController().getFenetreUniverselle() instanceof JeuDeCarteUniverselView){
//			
//			Partie.partie.getController().getFenetreUniverselle().repaint();
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Partie.partie.getController().getFenetreUniverselle().setSize(1100,600);
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			Partie.partie.getController().getFenetreUniverselle().setExtendedState(Partie.partie.getController().getFenetreUniverselle().MAXIMIZED_BOTH);
//		}
		//System.out.println(ligneMain.getComponentCount());
		}
		else{
			ligneMain.add(carte);
		//	carte.addMouseListener(Partie.partie.getController().getCarteListener());
			if(Partie.partie.getController().getFenetreUniverselle() instanceof JeuDeCarteUniverselView){
			Partie.partie.getController().getFenetreUniverselle().revalidate();
			}
		}
			//			if(Partie.partie.getController().getFenetreUniverselle() instanceof JeuDeCarteUniverselView){
//				
//				Partie.partie.getController().getFenetreUniverselle().repaint();
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Partie.partie.getController().getFenetreUniverselle().setSize(1100,600);
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Partie.partie.getController().getFenetreUniverselle().setExtendedState(Partie.partie.getController().getFenetreUniverselle().MAXIMIZED_BOTH);
//			}
//			System.out.println(ligneMain.getComponentCount());
//			
//		}
	//	moteur.Partie.partie.getController().getFenetreUniverselle().getContentPane().validate();
	//	moteur.Partie.partie.getController().getFenetreUniverselle().getContentPane().repaint();

		
	}
	public void afficherCarteVisible(CarteView carte){
		//carte.setOpaque(true);
		ligneCarteVisible.add(carte);
		//carte.addMouseListener(Partie.partie.getController().getCarteListener());
		//ligneCarteVisible.validate();
		ligneCarteVisible.repaint();
		//ligneMain.validate();
		ligneMain.repaint();
		
		//Partie.partie.getController().getFenetreUniverselle().repaint();
	//	moteur.Partie.partie.getController().getFenetreUniverselle().getContentPane().validate();
	//	moteur.Partie.partie.getController().getFenetreUniverselle().getContentPane().repaint();
		
	}
	public void enleverCarteMain(CarteView carte){
		ligneMain.remove(carte);
		//carte.removeMouseListener(Partie.partie.getController().getCarteListener());
	}
	public Joueur getJoueur(){
		return(this.joueur);
	}
	public void repaint() 
	{ 
//		repaint le component courant 
	super.repaint(); 
//		repaint tous les components qu'il possède 
	for(int i = 0; i < this.getComponentCount(); i++) 
	this.getComponent(i).repaint(); 
	} 
	public void echangerCarte(ArrayList<Carte> cartesMain,ArrayList<Carte> cartesVisible){
		this.joueur.echangerCarte(cartesMain, cartesVisible);
		this.ligneMain.remove(cartesMain.get(0).getCarteView());
		this.ligneCarteVisible.remove(cartesVisible.get(0).getCarteView());
		this.ligneMain.add(cartesVisible.get(0).getCarteView());
		this.ligneCarteVisible.add(cartesMain.get(0).getCarteView());
		this.repaint();
		this.validate();
		this.ligneMain.repaint();
		this.ligneMain.validate();
		this.ligneCarteVisible.repaint();
		this.ligneCarteVisible.validate();
	}
	public boolean jouerCarte(ArrayList<CarteView> carteAJouer){
		ArrayList<Carte> listCarte = new ArrayList<Carte>();
		boolean carteJouee=false;
		int i;
		for(i=0;i<carteAJouer.size();i++){
			listCarte.add(carteAJouer.get(i).getCarte());
		}
		//System.out.println("coco :"+carteAJouer);
		Boolean test=joueur.verifierCarteIdentique(listCarte);
		if(!(test)){
			FenetreErreurCartesNonIdentiques();
		}else{
			carteJouee=this.joueur.poserCarte(listCarte);
		}
		//System.out.println(carteJouee);
		return(carteJouee);
	}
	public void FenetreErreurCartesNonIdentiques(){
		JDialog erreurFenetre = new JDialog();
		erreurFenetre.setPreferredSize(new Dimension(200, 200));
		erreurFenetre.setSize(400,200);
		erreurFenetre.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JLabel message = new JLabel("Veuillez selectionner les mêmes cartes à jouer");
		panel.add(message);
		erreurFenetre.add(panel);
		erreurFenetre.setVisible(true);
	}
	public void poserCarte(CarteView carte){
		carte.setOpaque(false);
		Partie.partie.getController().getFenetreUniverselle().getTalon().removeAll();
		Partie.partie.getController().getFenetreUniverselle().getTalon().add(carte);
		ligneMain.remove(carte);
		if(Partie.partie.getController().getFenetreUniverselle() instanceof JeuDeCarteUniverselView){
			Partie.partie.getController().getFenetreUniverselle().revalidate();
			}
		
		
	}
	public int getNbCarteSelectionne(){
		int nbselec=0;
		int i;
		for(i=0;i<ligneMain.getComponentCount();i++){
			if(((CarteView) ligneMain.getComponent(i)).getEtat()){
				nbselec++;
			}
		}
		return(nbselec);
	}
	public void FenetreErreurCartesNonJouable(){
		JDialog erreurFenetre = new JDialog();
		erreurFenetre.setPreferredSize(new Dimension(200, 200));
		erreurFenetre.setSize(400,200);
		erreurFenetre.setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		JLabel message = new JLabel("Vous ne pouvez pas jouer ces cartes !");
		panel.add(message);
		erreurFenetre.add(panel);
		erreurFenetre.setVisible(true);
	}
	
	
	
	
}
