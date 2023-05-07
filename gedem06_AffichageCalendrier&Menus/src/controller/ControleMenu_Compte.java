package controller;

import view.App;
import view.VuePage_MonCompte;

public class ControleMenu_Compte {
	
	// Constructeur pour Afficher page Mon_Compte
	// qd on clique sur le menu Mon_Compte
	public ControleMenu_Compte(App app) {

		app.getContentPane().removeAll();
		app.getContentPane().add(new VuePage_MonCompte());	
		app.getContentPane().repaint();		
		app.getContentPane().revalidate();
		
		
	
	}
	
	

}
