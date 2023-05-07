package controller;

import view.App;
import view.VuePage_PlanningMensuel;

public class ControleMenu_Planning {
	
	// Constructeur pour Afficher page Planning (du mois en cours)
	// qd on clique sur le menu Planning
	public ControleMenu_Planning(App app) {		
		
		app.getContentPane().removeAll();
		app.getContentPane().add(new VuePage_PlanningMensuel());	
		app.getContentPane().repaint();		
		app.getContentPane().revalidate();
					
	}
			
}
	
