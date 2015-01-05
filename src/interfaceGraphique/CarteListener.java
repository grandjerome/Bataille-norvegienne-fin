package interfaceGraphique;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import moteur.Partie;

public class CarteListener implements MouseListener{
	
	private JeuDeCarteUniverselView fenetrePrincipale;
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//if(e.getComponent().getBackground().equals(new Color(0x0000))){
		if( e.getComponent().isOpaque()){
			((CarteView) e.getComponent()).setOpaque(false);
			//e.getComponent().setBackground(null);
			((CarteView) e.getComponent()).setEtat(false);
			Partie.partie.getController().getFenetreUniverselle().repaint();
		}else{
		
		((CarteView) e.getComponent()).setOpaque(true);
		e.getComponent().setBackground(new Color(0x0000));
		((CarteView) e.getComponent()).setEtat(true);
		Partie.partie.getController().getFenetreUniverselle().repaint();
		
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public CarteListener(JeuDeCarteUniverselView fenetrePrincipale){
		this.fenetrePrincipale=fenetrePrincipale;
	}
	

}
