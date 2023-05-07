package controller;

import view.App;
import view.VueAdmin_ListeFormations;


public class ControleMenu_Formation {

	

	// Constructeur pour Afficher page Liste des formations
	// qd on clique sur le menu Formation
	public ControleMenu_Formation(App app) {
		app.getContentPane().removeAll();
		app.getContentPane().add(new VueAdmin_ListeFormations());	
		app.getContentPane().repaint();		
		app.getContentPane().revalidate();
	}
}
